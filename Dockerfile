FROM openjdk:11
VOLUME "/tmp"
ADD target/backend_spring-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 7788
ENTRYPOINT [ "java","-jar", "/app.jar" ]
