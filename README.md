## Megogo API test project

- Lang: Java 17
- Build: Gradle 8.5
- Test: TestNG
- API client: OkHttp
- Reporting: Allure

### Run with Docker

1. Clone the repo
2. Build docker image
```shell
docker build -t "api-test-image" .
```
3. Run docker container
```shell
docker run -p 8080:8080 --rm --name runTest api-test-image
```
4. Navigate to http://localhost:8080 to observe Allure report