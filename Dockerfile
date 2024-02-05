FROM openjdk:latest
COPY ./target/DevOpsGroup3-1.1-ALPHA-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "DevOpsGroup3-1.1-ALPHA-jar-with-dependencies.jar"]