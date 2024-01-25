FROM openjdk:latest
COPY ./target/DevOpsGroup3-1.0-SNAPSHOT-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "DevOpsGroup3-1.0-SNAPSHOT-jar-with-dependencies.jar"]