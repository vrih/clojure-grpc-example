(ns clojure-grpc-example.server
  (:require [mount.core :as mount :refer [defstate]])
  (:import [clojuregrpcexample.grpc
            GrpcExample
            GrpcExample$Person
            GrpcExample$Answer]
           [io.grpc Server ServerBuilder]))


(defn make-service []
  (proxy [clojuregrpcexample.grpc.HelloGrpc$HelloImplBase] []
    (sayHello [^GrpcExample$Person person
                        response]
      (let [name (.getName person)
            builder (-> (GrpcExample$Answer/newBuilder)
                               (.setGreeting (str "Hello " name)))]
        (.onNext response (.build builder))
        (.onCompleted response)))))

(def server-atom (atom nil))

(defstate grpc-server
  :start 
  (let [builder (ServerBuilder/forPort (read-string (or (System/getenv "PORT0") "35000")))
        service (make-service)
        _       (.addService builder service)
        server  (.build builder)]
    (.start server)
    (reset! server-atom server))
  :stop
  (.shutdown @server-atom)) 
