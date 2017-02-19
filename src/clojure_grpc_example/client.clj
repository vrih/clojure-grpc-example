(ns clojure-grpc-example.client
  (:import [clojuregrpcexample.grpc
            GrpcExample
            GrpcExample$Person
            GrpcExample$Answer]))

;;; client
(def client (clojuregrpcexample.grpc.HelloGrpc/newBlockingStub
               (-> (io.grpc.ManagedChannelBuilder/forAddress "localhost" (int 35000))
                   (.usePlaintext true)
                   .build)))
    

(defn say-hello [name]
  (println 
   (.getGreeting
    (.sayHello client (-> (clojuregrpcexample.grpc.GrpcExample$Person/newBuilder)
                                   (.setName name)
                                   .build)))))

