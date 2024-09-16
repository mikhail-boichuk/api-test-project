## Megogo API test project

- Lang: Java 11
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
docker run -d -p 8080:8080 --rm --name runTest api-test-image
```
4. Navigate to http://localhost:8080 to observe Allure report

### View results from GitHub workflows

1. Navigate to [Actions](https://github.com/mikhail-boichuk/api-test-project/actions/workflows/run-with-github-actions.yaml) and find builds
2. Navigate to https://mikhail-boichuk.github.io/api-test-project/{buildNumber}/ to find a report for specific build number ([exmaple](https://mikhail-boichuk.github.io/api-test-project/9/))