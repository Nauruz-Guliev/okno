FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests


FROM openjdk:17-alpine
COPY --from=build /target/okno-0.0.1-SNAPSHOT.jar okno.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","okno.jar"]