# week07 학습 정리 2026년 4월 16일

## 1. 서블릿 실습

- `04.calc_servlet` 폴더에 `CalcServlet.java`를 작성했다.
- 기존 `index.html`의 계산기 폼에서 `calc.jsp`로 요청을 보내는 흐름을 서블릿으로 처리하도록 구현했다.
- 입력 받은 두 숫자(`n1`, `n2`)와 연산자(`op`)를 읽어들여 계산을 수행했다.
- `+`, `-`, `*`, `/` 연산을 지원하고, 0으로 나누는 경우 예외 처리를 추가했다.
- 결과를 HTML 응답으로 출력하며, 다시 계산할 수 있도록 `index.html`로 돌아가는 링크를 제공했다.

## 2. Maven 프로젝트 설정 확인

- `pom.xml`에 `javax.servlet-api` 의존성이 `provided`로 설정되어 있어 서블릿 환경에서 실행할 수 있다.
- `CalcServlet`은 어노테이션 `@WebServlet(name = "CalcServlet", urlPatterns = { "/calc.jsp" })`으로 매핑했다.

## 3. 학습 내용 요약

- Java Servlet의 `HttpServlet` 상속과 `doGet`, `doPost` 메서드 구조를 익힘.
- 클라이언트 요청 파라미터를 읽고 계산 로직을 처리하는 방법을 연습함.
- 서블릿에서 한글 인코딩(`UTF-8`) 설정과 HTML 응답 생성 방법을 확인함.
