# DistributedCounterClient
Simple client to connect to Distributed Counter

# Startup

`mvn clean install`

`java -jar .\target\distributedcounterclient-0.0.1-SNAPSHOT.jar IP PORT COMMAND`

IP: in format int.int.int.int
PORT: an Integer
COMMAND:
1. increment
2. decrement
3. getcount

#Example
java -jar .\target\distributedcounterclient-0.0.1-SNAPSHOT.jar 127.0.0.1 8080 increment

java -jar .\target\distributedcounterclient-0.0.1-SNAPSHOT.jar 127.0.0.1 8080 decrement

java -jar .\target\distributedcounterclient-0.0.1-SNAPSHOT.jar 127.0.0.1 8080 getcount
