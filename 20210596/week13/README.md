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
