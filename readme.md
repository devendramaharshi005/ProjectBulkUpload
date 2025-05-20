# 📁 ProjectBulkUpload

A Spring Boot web application that supports:

- ✅ Bulk data upload using REST APIs
- ✅ File system–based file storage
- ✅ Database BLOB-based file storage (MySQL)
- ✅ Swagger UI for interactive API documentation
- ✅ Dockerized setup using Docker Compose

---

## 🚀 Features

| Feature                  | Endpoint                        | Description                                  |
|--------------------------|----------------------------------|----------------------------------------------|
| Upload files (file system) | `POST /api/files/upload-fs`     | Upload files to local filesystem             |
| List uploaded (FS)        | `GET  /api/files/list-fs`        | Get metadata of all stored files (FS)        |
| Download file (FS)        | `GET  /api/files/download-fs/{filename}` | Download file by name (FS)       |
| Upload files (DB/BLOB)    | `POST /api/files/upload-db`      | Upload files as BLOBs into MySQL             |
| List uploaded (DB)        | `GET  /api/files/list-db`        | Get metadata of all stored BLOBs             |
| Download file (DB)        | `GET  /api/files/download-db/{filename}` | Download file stored in DB         |
| Swagger UI                | `GET  /swagger-ui.html`          | Interactive API documentation                |

---

## 📦 Tech Stack

- Java 17+
- Spring Boot 3.x
- MySQL 8 (Dockerized)
- Spring Data JPA
- Multipart file upload (FS & DB)
- Swagger (Springdoc)
- Docker + Docker Compose

---

## 🛠️ Project Setup & Run

### 1. 📥 Clone the Repository

```bash
git clone https://github.com/devendramaharshi005/ProjectBulkUpload.git
cd ProjectBulkUpload
```
##  2.🐳 Run with Docker Compose
```bash
docker-compose up --build
```

### This starts:

MySQL database (bulkdb)

Spring Boot app on localhost:8080

### 🧪 Try It Out
Access the API Documentation:
`http://localhost:8080/swagger-ui.html`

##  Use the Swagger UI to upload, list, and download files from both file system and database.

### 🧾 Notes
-   File uploads are limited by Spring Boot config (see application.properties)

-   Uploaded files (FS) are stored in /uploads folder inside the container

-   Uploaded files (DB) are stored as LONGBLOBs in bulkdb.file_blobs table

### ☁️ Run on Docker Playground
Go to: `https://labs.play-with-docker.com`

Create a new instance

Run:
```bash
git clone https://github.com/devendramaharshi005/ProjectBulkUpload.git
cd ProjectBulkUpload
docker-compose up --build
```

###  Access Swagger at:
`http://<your-instance-ip>:8080/swagger-ui.html`

📂 Folder Structure (Main)
```css
src/main/java/com/example/demo
|
├── BulkdataApplication.java
├── config
│   └── SwaggerConfig.java
├── controller
│   ├── FileBlobController.java
│   ├── FileController.java
│   ├── HomeController.java
│   └── UserController.java
├── model
│   ├── FileBlob.java
│   ├── FileMetadataFS.java
│   └── User.java
├── repository
│   ├── FileBlobRepository.java
│   ├── FileMetadataFsRepository.java
│   └── UserRepository.java
└── service
    ├── FileBlobService.java
    ├── FileService.java
    └── UserService.java
```

### 👨‍💻 Author
Devendra Maharshi

---------------------------------------------------------------

### Additional:

####    Running mysql container using docker compose
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