# Spring Boot 3 Observability with Grafana stack

## Run the project
### Prepare the environment
- IDE or Editor: [Intellij IDEA](https://www.jetbrains.com/idea/), Spring Tool Suite 4 or VSCode
- JDK: 21 or above
- Docker & Docker Compose: https://www.docker.com/products/docker-desktop/
- Postman for APIs testing: https://www.postman.com/
### Start project
- Clone project: `git clone https://github.com/Hypr2205/Spring-boot-3-observability-grafana.git`
- Run docker compose: `docker compose up -d`
- Run services:
  - `cd loans-service` && `./gradlew bootRun`
  - `cd fraud-detection-service` && `./gradlew bootRun`
- Access the services
  - Grafana: http://localhost:3000
  - Prometheus: http://localhost:9090
  - Tempo: http://localhost:3110
  - Loki: http://localhost:3100
- Make API request with Postman (details in service controller)
  - loans-service: http://localhost:8080/loans
  - fraud-detection-service: http://localhost:8081/frauds && http://localhost:8081/frauds/check
