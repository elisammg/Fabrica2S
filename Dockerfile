FROM openjdk:8
EXPOSE 8080
ADD target/SistemaFabrica.jar SistemaFabrica.jar
ENTRYPOINT ["java", "-jar", /SistemaFabrica.jar]