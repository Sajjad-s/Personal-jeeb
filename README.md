Jeeb personal accounting software
===========
Jeeb is a Persian personal accounting software which was launched as a SAAS startup in 2012 in Tehran and retired at May 2025. The project was outdated and could not be maintained anymore. The source code is published as open source with a docker to make it possible for old users and fans to run it.

### Warning
This code is outdated and not secure, do not use it if you concern about your data and safety.

### How to build
```
docker build
```

### How to run
```
docker compose up -d
```
After running the docker you must go to localhost to see the openjeeb web interface:
```
http://localhost
```
if you like you can set a host name for it, you should modify the hosts file of your operating system and add this line to it:
```
127.0.0.1 jeeb.local
```
after that you can access it like this:
```
http://jeeb.local
```

### How to stop
```
docker compose down
```
> To stop all containers AND kill all volumes `docker compose down --volumes`

### How to import the data
if you have a sql export, you should replace the export.sql file with your export file.

## License
[GNU General Public License v3.0](./LICENSE)

---

## Spring Boot backend (local dev)

This repository now includes a Spring Boot backend rewrite under `backend-spring/` for local development and testing.

### Prerequisites
- Java 21
- Maven 3.9+

### Run the backend
```bash
cd backend-spring
mvn clean test
mvn spring-boot:run
```

The backend starts on `http://localhost:8081`.

Optional environment overrides (see `.env.example`):
- `SERVER_PORT`
- `APP_CORS_ALLOWED_ORIGINS`

### H2 console
- URL: `http://localhost:8081/h2-console`
- JDBC URL: `jdbc:h2:mem:jeeb`
- Username: `sa`
- Password: _(empty)_

### CORS configuration
Allowed origins are configured via `app.cors.allowed-origins` in `backend-spring/src/main/resources/application.yml`.
Default: `http://localhost:3000,http://localhost`

If you need to point a frontend to this backend, use base URL:
```
http://localhost:8081/api
```

### Example API requests
```bash
# Login with the seeded user
curl -X POST http://localhost:8081/api/auth/login \\
  -H 'Content-Type: application/json' \\
  -d '{"email":"demo@jeeb.local","password":"password"}'

# Register a new user
curl -X POST http://localhost:8081/api/auth/register \\
  -H 'Content-Type: application/json' \\
  -d '{"email":"user@jeeb.local","password":"secret123"}'

# Fetch user profile
curl http://localhost:8081/api/users/1

# List incomes
curl http://localhost:8081/api/incomes?userId=1
```
