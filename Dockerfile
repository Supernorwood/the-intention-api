FROM maven:3.8.7-openjdk-18-slim AS MAVEN_BUILD

MAINTAINER Software Shinobi "the.software.shinobi@gmail.com"

WORKDIR /

COPY ./ ./

RUN mvn install

FROM eclipse-temurin:18-jre-alpine

COPY --from=MAVEN_BUILD /target/the-intention-api-1.0.jar /the-intention-api-1.0.jar

COPY --from=MAVEN_BUILD /src/main/resources/application.properties /application.properties

CMD ["java", "-jar", "/the-intention-api-1.0.jar"] 
