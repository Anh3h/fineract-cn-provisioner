FROM openjdk:8-jdk-alpine

ARG provisioner_port=2020

ENV server.max-http-header-size=16384 \
    cassandra.clusterName="Test Cluster" \
    spring.profiles.active=production \
    server.port=$provisioner_port \
    system.initialclientid=service-runner

WORKDIR /tmp
COPY provisioner-service-boot-0.1.0-BUILD-SNAPSHOT.jar .

CMD ["java", "-jar", "provisioner-service-boot-0.1.0-BUILD-SNAPSHOT.jar"]
