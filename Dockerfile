FROM openjdk:11
EXPOSE 8070
ADD target/Proyecto-Arquitectura.jar Proyecto-Arquitectura.jar
ENTRYPOINT ["java", "-jar", "Proyecto-Arquitectura.jar"]