(defproject clojure-grpc-example "0.1.0-SNAPSHOT"
  :description "Minimal implementation of a server and client for GRPC"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [mount "0.1.10"]
                 [io.grpc/grpc-netty "1.1.2"]
                 [io.grpc/grpc-protobuf "1.1.2"]
                 [io.grpc/grpc-stub "1.1.2"]]
  :java-source-paths ["generated"])
