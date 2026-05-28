# Product_Rest

## 개요
`week10/Product_MVC/productmvc` 프로젝트를 `week13/Product_Rest`로 복사하여 생성한 프로젝트입니다.

## 변경 사항
- Maven `artifactId`를 `productrest`로 변경
- WAR `finalName`을 `productrest`로 변경
- Java 패키지를 `kr.hnu.ice.productrest`로 변경
- JSP import 경로를 `kr.hnu.ice.productrest.Product`로 변경
- `index.jsp` 화면 제목을 `Product REST`로 변경
- `web.xml`의 `display-name`을 `Product REST Application`으로 변경

## 실행 방법
1. `mvn clean package` 실행
2. 생성된 `productrest.war`를 Tomcat에 배포
3. `http://localhost:8080/productrest/` 접속
4. "상품 목록 보기" 클릭
