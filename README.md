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

1. Navigate to [Actions](https://github.com/mikhail-boichuk/api-test-project/actions/workflows/run-with-github-actions.yaml)
2. Open latest workflow run, navigate to "TestNG report" ([example](https://github.com/mikhail-boichuk/api-test-project/actions/runs/10921537960/job/30313891082))
2. Navigate to https://mikhail-boichuk.github.io/api-test-project/{runNumber}/ to find Allure report for specific run ([exmaple](https://mikhail-boichuk.github.io/api-test-project/14/))