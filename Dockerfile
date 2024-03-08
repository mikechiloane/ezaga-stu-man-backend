FROM maven:3.8.4-openjdk-17 as build

COPY src /usr/src/ezaga-service/src
COPY pom.xml /usr/src/ezaga-service
RUN mvn -f /usr/src/ezaga-service/pom.xml clean package -Dmaven.test.skip=true

FROM openjdk:17

COPY --from=build /usr/src/user-service/target/ezaga-stu-man-backend-0.0.1-SNAPSHOT.jar /usr/src/ezaga-service/app.jar
WORKDIR /usr/src/ezaga-service
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]