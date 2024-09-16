FROM openjdk:11

COPY . /usr/src/api-test-project
WORKDIR /usr/src/api-test-project

EXPOSE 8080

ENTRYPOINT ["./runTestAndReport.sh"]