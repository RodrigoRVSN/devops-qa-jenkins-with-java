FROM openjdk:22-slim
WORKDIR /ac2
COPY target/*.jar /ac2/ac2-0.0.1-SNAPSHOT.jar
EXPOSE 9090
CMD java -XX:+UseContainerSupport -Xmx512m -Dserver.port=9090 -jar ac2-0.0.1-SNAPSHOT.jar
