# JPA JSON Converter / JPA JSON 변환기

[ENG](#eng) | [KR](#kr)

## ENG

### Project structure

```text
pom.xml
src/main/java/io/github/parkwoong/gateway/Application.java
src/main/java/io/github/parkwoong/gateway/BackendController.java
src/main/java/io/github/parkwoong/gateway/backend/Backend.java
src/main/java/io/github/parkwoong/gateway/backend/BackendRepository.java
src/main/java/io/github/parkwoong/gateway/config/HashMapConverter.java
src/main/resources/application.properties
src/test/java/io/github/parkwoong/gateway/ConverterTest.java
```

### Code explanation

HashMapConverter implements JPA AttributeConverter. Backend uses @Convert on Map fields, so JPA
writes them as JSON strings and reads them back as Maps. ConverterTest saves and reads a sample
entity in H2.

BackendController saves and reads Backend records so the Map fields pass through
HashMapConverter.

### Run and test

Use JDK 8 and Maven 3.6.3+.

```sh
java -version
mvn clean verify
mvn spring-boot:run
```

The app listens on localhost:8080 and uses an in-memory H2 database.

#### Postman API

##### 1. Save a backend

**Request**

- Method: POST
- URL: http://localhost:8080/api/backends
- Content-Type: application/json

~~~json
{
  "pattern": "sample",
  "url": "http://localhost:9090",
  "pathUrl": true,
  "defaultQueries": {
    "page": 1
  },
  "defaultHeaders": {
    "X-Sample": "yes"
  }
}
~~~

**Response**

- Status: 200 OK

~~~json
{
  "pattern": "sample",
  "url": "http://localhost:9090",
  "pathUrl": true,
  "timeoutSeconds": 30,
  "defaultQueries": {
    "page": 1
  },
  "defaultHeaders": {
    "X-Sample": "yes"
  }
}
~~~

##### 2. Read it back from H2

**Request**

- Method: GET
- URL: http://localhost:8080/api/backends/sample
- Body: none

**Response**

- Status: 200 OK

~~~json
{
  "pattern": "sample",
  "url": "http://localhost:9090",
  "pathUrl": true,
  "timeoutSeconds": 30,
  "defaultQueries": {
    "page": 1
  },
  "defaultHeaders": {
    "X-Sample": "yes"
  }
}
~~~

## KR

### 프로젝트 구조

```text
pom.xml
src/main/java/io/github/parkwoong/gateway/Application.java
src/main/java/io/github/parkwoong/gateway/BackendController.java
src/main/java/io/github/parkwoong/gateway/backend/Backend.java
src/main/java/io/github/parkwoong/gateway/backend/BackendRepository.java
src/main/java/io/github/parkwoong/gateway/config/HashMapConverter.java
src/main/resources/application.properties
src/test/java/io/github/parkwoong/gateway/ConverterTest.java
```

### 코드 설명

HashMapConverter가 JPA AttributeConverter를 구현한다. Backend의 Map 필드에
@Convert를 적용하여 JPA가 JSON 문자열로 저장하고 다시 Map으로 읽는다. ConverterTest가 H2에서
샘플 엔티티 저장·조회를 확인한다.

BackendController는 Backend를 저장하고 다시 읽어 Map 필드가 HashMapConverter를 거치는
과정을 보여줍니다.

### 실행과 테스트

JDK 8, Maven 3.6.3 이상 사용. 저장소 루트에서 실행.

```sh
java -version
mvn clean verify
mvn spring-boot:run
```

앱은 localhost:8080에서 실행되며 메모리 H2 데이터베이스를 사용한다.

#### Postman API

##### 1. Backend 저장

**요청**

- 메서드: POST
- URL: http://localhost:8080/api/backends
- Content-Type: application/json

~~~json
{
  "pattern": "sample",
  "url": "http://localhost:9090",
  "pathUrl": true,
  "defaultQueries": {
    "page": 1
  },
  "defaultHeaders": {
    "X-Sample": "yes"
  }
}
~~~

**응답**

- 상태: 200 OK

~~~json
{
  "pattern": "sample",
  "url": "http://localhost:9090",
  "pathUrl": true,
  "timeoutSeconds": 30,
  "defaultQueries": {
    "page": 1
  },
  "defaultHeaders": {
    "X-Sample": "yes"
  }
}
~~~

##### 2. H2에서 다시 조회

**요청**

- 메서드: GET
- URL: http://localhost:8080/api/backends/sample
- 본문: 없음

**응답**

- 상태: 200 OK

~~~json
{
  "pattern": "sample",
  "url": "http://localhost:9090",
  "pathUrl": true,
  "timeoutSeconds": 30,
  "defaultQueries": {
    "page": 1
  },
  "defaultHeaders": {
    "X-Sample": "yes"
  }
}
~~~
