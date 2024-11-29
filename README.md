# About

This is a basic implementation of Apache Kafka in Java, demonstrating how to set up producers and consumers for serialized entities.

For a detailed walkthrough of this implementation, you can refer to my article:
[Event Driven Architecture with Apache Kafka](https://www.linkedin.com/pulse/event-driven-architecture-apache-kafka-mehmet-onal-9scwf/)

# How to Run

In order to run the project, you must:
- Ensure you have [Docker Engine](https://docs.docker.com/engine/install/) and [Docker Compose](https://docs.docker.com/compose/install/) installed
- Set up Kafka using Docker Compose
- Run Control Center (automatically set up through Docker Compose)
- Download the repo locally
- Install the Maven dependencies using the pom.xml file
- Run Consumer.java class in one terminal
- Run Producer.java class in another terminal

## Setting Up Kafka

This implementation requires a running instance of Kafka. You can easily set this up using the provided docker-compose.yaml file:

```bash
$ docker compose up -d
```

Verify the containers are running:

```bash
$ docker ps
```

You should see both the Kafka broker and Control Center containers running.

## Running the Project

### Running with IDE

If you have an IDE such as IntelliJ IDEA, you cleaning Maven dependencies and running the Java files should be easy to do via GUI - as usual. 

### Running manually

First, build the project using Maven:

```bash
$ mvn clean package
```

After building and setting up Kafka, you'll need two terminal windows:

Terminal 1 (Consumer):
```bash
$ mvn exec:java -Dexec.mainClass="org.example.Consumer"
```

Terminal 2 (Producer):
```bash
$ mvn exec:java -Dexec.mainClass="org.example.Producer"
```

# Expected Behaviour

If you have followed the steps correctly, you should have output similar to this:

Producer Terminal:
```
### Sending 1 ###
### Sending 2 ###
### Sending 3 ###
### Sending 4 ###
### Sending 5 ###
### Sending 6 ###
### Sending 7 ###
### Sending 8 ###
### Sending 9 ###
### Sending 10 ###
```

Consumer Terminal:
```
<Student John (1) >
<Student Jack (2) >
<Student Michael (3) >
<Student Mehmet (4) >
<Student Rick (5) >
<Student Susan (6) >
<Student Samantha (7) >
<Student John (8) >
<Student Bob (9) >
<Student Jack (10) >
```

# Using Control Center

The Control Center provides a neat dashboard to monitor your Kafka cluster. Once your Docker containers are running, you can access it at:

```
http://localhost:9021
```

Note: You must be sending events after having the Messages tab open in the topic.

![Control Center Topic](https://raw.githubusercontent.com/mehonal/apache-kafka-example-java/refs/heads/master/src/main/resources/screenshots/control-center-topic.png)
![Control Center Messages](https://raw.githubusercontent.com/mehonal/apache-kafka-example-java/refs/heads/master/src/main/resources/screenshots/control-center-messages.png)


# Useful Resources 
- [Confluent Platform Docker Compose](https://github.com/confluentinc/cp-all-in-one/blob/7.7.1-post/cp-all-in-one-kraft/docker-compose.yml)
- [Chris Searle's Kafka Java to Scala Examples](https://github.com/chrissearle/kafka-java-to-scala/blob/master/java-starter)
- [Kafka Maven Repository](https://mvnrepository.com/artifact/org.apache.kafka/kafka_2.13/3.9.0)
- [Sezarfen's Kafka Example with Class](https://github.com/sezarfen/videoExamples/tree/main/kafka_example_with_class)
