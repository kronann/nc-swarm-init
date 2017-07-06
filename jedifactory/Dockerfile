FROM openjdk:8
MAINTAINER zenika-nightclazz <@zenika.com>
ADD . /usr/src
#COPY target/jedifactory-0.0.1-SNAPSHOT.jar /usr/src/
WORKDIR /usr/src/
RUN ./mvnw install

CMD java -jar /usr/src/target/jedifactory-0.0.1-SNAPSHOT.jar

