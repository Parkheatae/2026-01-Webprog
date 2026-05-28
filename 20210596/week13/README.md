# Week 13 - Filter 실습

## 작성일

2026년 5월 27일

## 1차시 학습 내용 제목

서블릿 필터(Filter)를 이용한 한글 인코딩 처리

## 1차시 학습 내용 정리 및 요약

1. 이번 1차시에서는 서블릿에서 사용하는 Filter의 개념과 역할을 학습하였다.
2. Filter는 서블릿이 실행되기 전에 요청을 먼저 가로채서 공통 작업을 처리하는 기능이다.
3. 기존에는 서블릿의 `doGet()` 또는 `doPost()` 메서드 안에서 직접 한글 인코딩 처리를 하였다.
4. 하지만 여러 서블릿마다 같은 인코딩 코드를 반복해서 작성하면 코드가 중복되는 문제가 생긴다.
5. 이를 해결하기 위해 한글 처리 기능을 별도의 Filter 클래스로 분리하였다.
6. Filter에서는 `request.setCharacterEncoding("UTF-8")`을 사용하여 요청 데이터의 한글 깨짐을 방지하였다.
7. 또한 `response.setContentType("text/html; charset=UTF-8")`을 설정하여 출력되는 한글도 정상적으로 보이게 하였다.
8. Filter 클래스는 `@WebFilter` 어노테이션을 사용하여 등록하였다.
9. 처음에는 `/myf` 서블릿에만 Filter가 적용되도록 설정하였다.
10. 이후 `/newf` 패턴을 가진 서블릿을 추가로 작성하여 Filter 적용 여부를 확인하였다.
11. `/newf` 서블릿에서는 일부러 `doGet()`이나 `doPost()`에서 한글 처리를 하지 않도록 하였다.
12. 이를 통해 Filter가 실제로 한글 인코딩을 처리하는지 테스트할 수 있었다.
13. `/myf`와 `/newf`에 모두 Filter를 적용하기 위해 `/*` 패턴을 사용할 경우 모든 요청에 Filter가 적용되는 문제가 있다.
14. 따라서 필요한 서블릿에만 적용되도록 `@WebFilter(urlPatterns = {"/myf", "/newf"})` 형식으로 수정하는 것이 적절하다.
15. 이번 실습을 통해 공통 기능을 Filter로 분리하면 코드 중복을 줄이고 유지보수가 쉬워진다는 점을 이해하였다.

## 추가 작업
- `week10\Product_MVC\productmvc` 프로젝트를 `week13\Product_Rest`로 복사하고 관련 메타 정보를 업데이트함
- 복사된 프로젝트의 Maven `artifactId`, `finalName`, 패키지 이름, UI 이름 및 servlet 설정을 `Product_Rest`에 맞게 변경함

## 2차시 학습 내용 제목

Product MVC 프로젝트를 활용한 REST API 구현

## 2차시 학습 내용 정리 및 요약

이번 2차시에서는 기존 `Product_MVC` 프로젝트를 기반으로 REST API 기능을 추가하는 실습을 진행하였다.

기존 프로젝트는 Servlet과 JSP를 이용하여 상품 목록과 상품 상세 정보를 화면에 출력하는 MVC 구조였다.

이번 실습에서는 기존 MVC 구조를 유지하면서, 별도의 REST API 클래스를 추가하여 JSON 형식으로 상품 정보를 조회할 수 있도록 구현하였다.

작업은 `week10\Product_MVC\productmvc` 프로젝트를 `week13\Product_Rest`로 복사하는 것부터 시작하였다.

복사 후에는 프로젝트 이름, Maven의 `artifactId`, `finalName`, 패키지 이름, 화면 제목, servlet 설정 등 관련 메타 정보를 `Product_Rest`에 맞게 수정하였다.

REST API 구현을 위해 `ProductRestAPI.java` 클래스를 새로 작성하였다.

`ProductRestAPI` 클래스에서는 Jersey에서 제공하는 `@Path`, `@GET`, `@DELETE`, `@PathParam`, `@Produces` 어노테이션을 사용하였다.

전체 상품 목록 조회는 `GET /api/products/list` 경로로 구현하였다.

해당 요청이 들어오면 `ProductService`의 `findAll()` 메서드를 호출하여 전체 상품 목록을 JSON 배열 형식으로 반환하도록 하였다.

특정 상품 조회는 `GET /api/products/list/{pid}` 경로로 구현하였다.

이때 `{pid}` 값은 `@PathParam`을 이용하여 전달받고, `ProductService`의 `find()` 메서드를 통해 해당 상품 정보를 조회하도록 하였다.

상품이 존재하면 상품 정보를 JSON 형식으로 반환하고, 존재하지 않으면 오류 메시지를 반환하도록 처리하였다.

상품 삭제 기능은 `DELETE /api/products/{pid}` 경로로 구현하였다.

삭제 기능을 위해 기존 `ProductService` 클래스에 `delete(String id)` 메서드를 추가하였다.

`delete()` 메서드는 전달받은 상품 ID가 존재하면 내부 상품 목록에서 해당 상품을 삭제하고, 삭제 성공 여부를 boolean 값으로 반환한다.

REST API 설정은 `WEB-INF/web.xml`에 Jersey Servlet 설정을 추가하여 처리하였다.

Jersey REST 요청은 `/api/*` 경로로 매핑되도록 설정하였다.

Tomcat 8.5 환경에서 Jersey를 사용하기 위해 `pom.xml`에 Jersey 관련 라이브러리도 추가하였다.

추가한 라이브러리는 `jersey-container-servlet`, `jersey-hk2`, `jersey-media-json-jackson` 등이다.

구현 후에는 `curl` 명령어를 사용하여 REST API 동작을 확인할 수 있도록 테스트 명령어를 정리하였다.

테스트 항목은 전체 상품 목록 조회, 특정 상품 조회, 특정 상품 삭제, 삭제 후 재조회 오류 확인으로 구성하였다.

이번 실습을 통해 기존 JSP/Servlet 기반 MVC 프로젝트에 REST API 기능을 추가하는 방법을 익혔다.

또한 같은 상품 데이터를 JSP 화면 출력 방식과 JSON REST API 방식으로 모두 제공할 수 있다는 점을 확인하였다.

이를 통해 MVC 방식과 REST 방식의 차이를 이해하고, HTTP GET과 DELETE 요청을 이용한 기본적인 REST API 구현 방법을 학습하였다.

## 2차시 주요 구현 내용

### 1. 기존 프로젝트 복사 및 수정

`week10\Product_MVC\productmvc` 프로젝트를 `week13\Product_Rest`로 복사하였다.

복사 후 프로젝트 이름과 관련 설정을 `Product_Rest`에 맞게 수정하였다.

수정한 주요 항목은 다음과 같다.

* Maven `artifactId`
* Maven `finalName`
* 패키지 이름
* Servlet 설정
* 화면 제목 및 UI 이름
* 프로젝트 경로 및 실행 경로

### 2. ProductRestAPI 클래스 추가

REST API 처리를 위해 `ProductRestAPI.java` 파일을 새로 작성하였다.

이 클래스는 상품 목록 조회, 특정 상품 조회, 특정 상품 삭제 요청을 처리한다.

| 요청 방식  | API 경로                     | 처리 내용       |
| ------ | -------------------------- | ----------- |
| GET    | `/api/products/list`       | 전체 상품 목록 조회 |
| GET    | `/api/products/list/{pid}` | 특정 상품 조회    |
| DELETE | `/api/products/{pid}`      | 특정 상품 삭제    |

### 3. ProductService 기능 수정

기존 `ProductService` 클래스에는 상품 전체 조회와 특정 상품 조회 기능이 있었다.

이번 실습에서는 상품 삭제 기능을 추가하였다.

추가한 기능은 다음과 같다.

```java
public boolean delete(String id) {
    if (id == null) {
        return false;
    }

    return products.remove(id) != null;
}
```

이 메서드는 상품 ID를 전달받아 내부 상품 목록에서 해당 상품을 삭제한다.

상품이 정상적으로 삭제되면 `true`, 상품이 존재하지 않으면 `false`를 반환한다.

### 4. web.xml REST 설정 추가

`WEB-INF/web.xml` 파일에 Jersey REST Servlet 설정을 추가하였다.

REST API 요청은 `/api/*` 경로로 처리되도록 설정하였다.

```xml
<servlet>
    <servlet-name>Jersey REST Service</servlet-name>
    <servlet-class>org.glassfish.jersey.servlet.ServletContainer</servlet-class>
    <init-param>
        <param-name>jersey.config.server.provider.packages</param-name>
        <param-value>kr.hnu.ice.productrest</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
</servlet>

<servlet-mapping>
    <servlet-name>Jersey REST Service</servlet-name>
    <url-pattern>/api/*</url-pattern>
</servlet-mapping>
```

### 5. curl 테스트 명령어

구현한 REST API는 CMD 또는 PowerShell에서 `curl` 명령어로 테스트할 수 있다.

전체 상품 목록 조회:

```cmd
curl http://localhost:8080/Product_Rest/api/products/list
```

특정 상품 조회:

```cmd
curl http://localhost:8080/Product_Rest/api/products/list/P002
```

특정 상품 삭제:

```cmd
curl -X DELETE http://localhost:8080/Product_Rest/api/products/P002
```

삭제 후 재조회:

```cmd
curl http://localhost:8080/Product_Rest/api/products/list/P002
```

삭제 후 다시 조회했을 때 해당 상품이 존재하지 않는다는 오류 메시지가 출력되면 DELETE 기능이 정상적으로 동작한 것이다.

## 2차시 정리

이번 2차시에서는 기존 Product MVC 프로젝트를 REST API 방식으로 확장하였다.

기존 JSP 화면 출력 기능은 유지하면서, JSON 데이터를 반환하는 REST API를 추가하였다.

이를 통해 하나의 프로젝트에서 웹 화면 출력과 API 데이터 제공을 함께 구현할 수 있었다.

또한 `GET` 요청으로 데이터를 조회하고, `DELETE` 요청으로 데이터를 삭제하는 REST API의 기본 구조를 이해하였다.

이번 실습을 통해 Jersey 기반 REST API 설정 방법과 `curl`을 이용한 API 테스트 방법을 학습하였다.
