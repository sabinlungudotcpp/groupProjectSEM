FROM openjdk:latest
COPY ./target/grouproject.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "grouproject.jar", "dbb:33060"]