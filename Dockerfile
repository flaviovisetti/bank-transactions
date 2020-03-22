FROM openjdk:8
LABEL maintainer="Flavio Visetti"

RUN apt-get update && apt-get install -y vim postgresql-client

WORKDIR /srv/app
COPY . ./
RUN chmod +x ./mvnw \
  && ./mvnw dependency:go-offline -B \
  && ./mvnw package -DskipTests

CMD "java -jar ./target/routine-transactions-0.0.1.jar"
