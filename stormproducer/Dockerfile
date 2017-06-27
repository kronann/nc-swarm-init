FROM openjdk:8
MAINTAINER zenika-nightclazz <@zenika.com>
ADD . /usr/src
#COPY target/stormproducer-0.0.1-SNAPSHOT.jar /usr/src/
WORKDIR /usr/src/
CMD ./mvnw install

CMD java -jar /usr/src/target/stormproducer-0.0.1-SNAPSHOT.jar

