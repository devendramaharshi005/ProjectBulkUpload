# Running mysql container using docker compose
command : `docker-compose ps`

#### To verify it's running:
`docker ps`

#### Using MySQL CLI inside the container
`docker exec -it mysql-container mysql -u root -p`
### Enter password: *root*


## runinng test Query:
``` mysql
SHOW DATABASES;
USE bulkdb;
CREATE TABLE test (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255));
INSERT INTO test (name) VALUES ('Devendra'), ('Spring Boot');
SELECT * FROM test;
```


created spring boot application in floder 'bulkdata'.


created Dockerfile inside the project folder


Go inside bulkdata:
Run : for cleaning the package.

```bash
cd bulkdata
./mvnw clean package
```

Check for the generated JAR file inside:

```bash
target/bulkdata-0.0.1-SNAPSHOT.jar
```

## run this for skipping test cases
```cmd
mvnw.cmd clean package -DskipTests
```