FROM openjdk:11
VOLUME /tmp
EXPOSE 8090
ADD ./target/microservicios-zuul-0.0.1-SNAPSHOT.jar zuul-server.jar
ENTRYPOINT ["sh", "-c", "java -jar /zuul-server.jar"]