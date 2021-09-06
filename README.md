# Kafka Consumer

Kafka consumer Application built in Springboot that consumes from the employees topic and inserts records into In-Memory database (H2).

# Prerequisites
You will need to following tools in order to work with this project and code

* git (http://git-scm.com/)
* JDK 1.8+ (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* Maven 3.x+ (http://maven.apache.org/)
* Apache Kafka (https://kafka.apache.org/downloads)
* An IDE of your choice. (Eclipse, IntelliJ, Spring STS)

# Getting Started
To run this project locally, perform the following steps.
1. Clone project to your machine using git - "git clone https://github.com/GabrielLazar/kafka-producer.git"
2. Import the project to IDE
3. Start zookeeper server:
        "zookeeper-server-start.bat config\zookeeper.properties"
4. Start kafka server:
        "kafka-server-start.bat config\server.properties"
5. Create topic:
        "kafka-topics --bootstrap-server localhost:9092 --topic employees --create --partitions 4 --replication-factor 1"
6. Create producer or use my producer application:
        "kafka-console-producer --broker-list 127.0.0.1:9092 --topic employees --producer-property acks=all"
7. Input json: "{employeeId=1,
               firstName=Steven,
               lastName=King,
               email=steven.king@sqltutorial.org,
               phoneNumber=515.123.4567,
               hireDate=1987-06-17,
               jobId=4,
               salary=24000.00,
               managerId=null,
               departmentId=9
               }"

8. Run application and check if records are inserted in H2 db:
        "http://localhost:8182/h2-console/"

Created by @Gabriel Lazar Halitchi
