FROM openjdk:8
VOLUME /tmp

ADD ./target/intellisense-job-test-0.0.1-SNAPSHOT.jar intellisense-test-service.jar  
ENTRYPOINT ["java", "-jar", "/intellisense-test-service.jar"]