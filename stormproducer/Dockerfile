FROM jimschubert/8-jdk-alpine-mvn
MAINTAINER marc&greg <@zenika.com>
COPY target/stormproducer-0.0.1-SNAPSHOT.jar /usr/src/
WORKDIR /usr/src/
EXPOSE 5672
CMD java -jar /usr/src/stormproducer-0.0.1-SNAPSHOT.jar

