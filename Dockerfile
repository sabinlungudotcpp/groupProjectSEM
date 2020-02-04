FROM openjdk:latest
COPY ./target/grouproject-1.0-SNAPSHOT-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "grouproject-1.0-SNAPSHOT-jar-with-dependencies.jar"]