FROM openjdk:latest
COPY ./target/DevOpsGroup3.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "DevOpsGroup3.jar", "db:3306", "30000"]