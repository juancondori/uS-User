FROM 519901771307.dkr.ecr.us-east-1.amazonaws.com/open-jdk-alpine
COPY target/us-user-0.0.1-SNAPSHOT.jar /usr/src/service/service.jar
COPY /devops/setup.sh /
RUN chmod 777 /setup.sh
EXPOSE 8080
CMD [ "/setup.sh" ]

