# clojure-grpc-example

This is a demonstration of how to make GRPC calls in Clojure. For now
this covers only the most basic use case.

This uses mount for starting the server.

# Usage
 
1. Run `gradle build` to generate the java classes from the proto file.
2. The server is started from the `(mount/start)` in `core.clj`
3. Run the client in `client.clj`.

# Note

Some of the helper code comes from Captial One https://github.com/capitalone/cqrs-manager-for-distributed-reactive-services.

## License

Copyright © 2017 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
