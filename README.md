# JPA JSON Converter / JPA JSON 변환기

[ENG](#eng) | [KR](#kr)

## ENG

### Project structure

```text
pom.xml
src/main/java/io/github/parkwoong/gateway/Application.java
src/main/java/io/github/parkwoong/gateway/backend/Backend.java
src/main/java/io/github/parkwoong/gateway/backend/BackendRepository.java
src/main/java/io/github/parkwoong/gateway/config/HashMapConverter.java
src/main/resources/application.properties
src/test/java/io/github/parkwoong/gateway/ConverterTest.java
```

### Code explanation

HashMapConverter implements JPA AttributeConverter. Backend uses @Convert on Map fields, so JPA writes them as JSON strings and reads them back as Maps. ConverterTest saves and reads a sample entity in H2.

### Run and test

Use JDK 8 and Maven 3.6.3+.

```sh
java -version
mvn clean verify
mvn spring-boot:run
```

Run mvn clean verify. This is a console application without an HTTP endpoint.

## KR

### 프로젝트 구조

```text
pom.xml
src/main/java/io/github/parkwoong/gateway/Application.java
src/main/java/io/github/parkwoong/gateway/backend/Backend.java
src/main/java/io/github/parkwoong/gateway/backend/BackendRepository.java
src/main/java/io/github/parkwoong/gateway/config/HashMapConverter.java
src/main/resources/application.properties
src/test/java/io/github/parkwoong/gateway/ConverterTest.java
```

### 코드 설명

HashMapConverter가 JPA AttributeConverter를 구현합니다. Backend의 Map 필드에 @Convert를 적용하여 JPA가 JSON 문자열로 저장하고 다시 Map으로 읽습니다. ConverterTest가 H2에서 샘플 엔티티 저장·조회를 확인합니다.

### 실행과 테스트

JDK 8과 Maven 3.6.3 이상을 사용합니다.

```sh
java -version
mvn clean verify
mvn spring-boot:run
```

mvn clean verify를 실행하세요. HTTP 엔드포인트가 없는 콘솔 애플리케이션입니다.
