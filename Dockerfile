FROM java:8

VOLUME /tmp

EXPOSE 8080

ADD /build/libs/aldeas-1.0.jar aldeas-1.0.jar

ENTRYPOINT ["java","-jar","aldeas-1.0.jar"]