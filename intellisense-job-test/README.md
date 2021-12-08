This is the test project for a job application in [Intellisense ][intellisense] .

## Running docker image

Dockerfile to build the image, after generating jar file with *mvn package*.

```sh
cd intellisense-job-test
docker build -t intellisense-test-service:v1 .
```

Then to run up the microservice **intellisense-test-service** .

```sh
cd docker-compose
docker-compose up
```

To test the microservice in **postman** application, you must indicate the following url and parameters

```sh
http://localhost:8002/intellisense-test-service/listAvg
- Body in JSON raw manner:
- {"period": 1}
```


[intellisense]: https://www.intellisense.io/ "Intellisense"
