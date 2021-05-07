FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD ./target/microservicios-monitory-0.0.1-SNAPSHOT.jar microservicios-monitory.jar
ENTRYPOINT ["sh", "-c", "java -jar /microservicios-monitory.jar"]