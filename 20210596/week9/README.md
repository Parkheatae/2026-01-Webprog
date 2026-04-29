# Week 9 - JSP Bean과 JSTL 학습

**작성일:** 2026년 4월 29일

## 📌 학습 내용 요약

### 1. Calc_useBean 프로젝트 (`1. Calc_usebean`)

#### 프로젝트 정보 수정

- **변경 사항:**
  - `artifactId`: `calc_ubean` → `calc_ubean_09`
  - `<name>`: `calc_ubean Maven Webapp` → `calc_ubean_09 Maven Webapp`
  - `<finalName>`: `calc_ubean` → `calc_ubean_09`

#### 목표: JSP 액션 태그를 이용한 Bean 활용

- JSP 액션 태그(`<jsp:useBean>`, `<jsp:setProperty>`)를 사용하여 `bean_exam.Calculator` 클래스 활용
- HTML 폼(`index.jsp`)에서 입력받은 두 숫자와 연산자를 전달
- `calc.jsp`에서 JSP 액션 태그로 Bean을 생성하고 계산 결과 출력

#### 핵심 클래스

- **Calculator.java**
  - 필드: `n1` (double), `n2` (double), `op` (String)
  - 메서드: `calc()` - 사칙연산 수행 (+, -, *, /)
  - 추가 예정: JavaBean 규칙에 따른 Getter/Setter 메서드

#### 파일 구조

```
1. Calc_usebean/
  └── calc_ubean/
      ├── pom.xml (수정됨)
      ├── src/main/java/bean_exam/
      │   └── Calculator.java
      └── src/main/webapp/
          ├── index.jsp (계산기 입력 폼)
          └── calc.jsp (JSP 액션 태그 사용 예정)
```

---

### 2. JSTL 프로젝트 (`2. jstl_exam`)

#### 프로젝트 초기 설정

- Maven 프로젝트 생성 (`artifactId`: `jstl`)
- Java 1.8 기반

#### 의존성 추가

```xml
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>jstl</artifactId>
    <version>1.2</version>
</dependency>
```

#### index.jsp 작성 - 포괄적인 JSTL 및 EL 예제

##### **Part 1: JSTL 기본 문법 예제**

1. **변수 설정 (c:set)**

   - 기본 변수 설정 (`name`, `age`, `score`)
   - 문자열 배열 설정 (`subjects`) 및 forEach 반복 출력
2. **조건문 (c:if)**

   - 단순 조건 테스트
   - 우수한 점수 검사
3. **다중 선택 (c:choose, c:when, c:otherwise)**

   - 학점 판정 (A, B, C, F)
   - 우수 → 우수 → 보통 → 재시험
4. **반복문 (c:forEach)**

   - 과일 목록 반복 (split 사용)
   - `varStatus` 활용하여 순번 표시
5. **토큰 분할 (c:forTokens)**

   - 색상 목록을 `:` 구분자로 분할
   - 각 색상 항목 출력
6. **숫자 범위 반복**

   - 1부터 5까지 숫자 출력
   - `begin`, `end`, `step` 속성 사용
7. **리스트/배열 반복**

   - 도시 목록 순회
   - 인덱스 정보 활용

##### **Part 2: Expression Language (EL) 동일 기능 표현**

1. **변수 출력 (EL)**

   - `${변수명}` 문법으로 직접 표현
2. **조건식 (EL)**

   - 삼항연산자 사용: `${조건 ? 참 : 거짓}`
3. **중첩 삼항연산자**

   - 학점 판정을 EL의 삼항연산자로 표현
4. **배열 인덱싱 (EL)**

   - `${array[index]}` 문법
5. **산술 연산 (EL)**

   - `+`, `-`, `*`, `/`, `%` 연산
6. **논리 연산 (EL)**

   - `&&` (AND), `||` (OR), `!` (NOT)
7. **학습 과목 배열 출력 (EL + forEach)**

   - `subjects` 배열을 JSTL forEach와 EL을 조합하여 출력

##### **Part 3: JSTL vs EL 비교 테이블**

- 기능별 JSTL 태그와 EL 표현식 비교
- 각 경우의 사용처와 장단점

#### 파일 구조

```
2. jstl_exam/
  └── jstl/
      ├── pom.xml (JSTL 의존성 추가됨)
      └── src/main/webapp/
          └── index.jsp (포괄적인 예제 페이지)
```

### 📚 핵심 개념

### JSTL 태그 라이브러리

- **Core (c)**: 제어 흐름, 반복, 변수 설정 등 기본 기능
- **Functions (fn)**: 문자열 처리 함수 (`split`, `length` 등)

### Expression Language (EL)

- JSP에 직접 표현식을 삽입하는 간단한 문법
- Scriptlet 대체 또는 보완용
- 객체 속성 접근 및 연산 지원

### JSP 액션 태그

- `<jsp:useBean>`: Bean 객체 생성 또는 참조
- `<jsp:setProperty>`: Bean 속성 설정 (요청 파라미터 자동 바인딩 가능)
- `<jsp:getProperty>`: Bean 속성 값 출력

---

## 🔧 다음 단계

1. **calc.jsp 작성**

   - JSP 액션 태그를 사용하여 Calculator Bean 활용
   - 입력값 바인딩 및 계산 결과 표시
2. **Calculator.java 수정**

   - JavaBean 규칙에 따른 Getter/Setter 메서드 추가
3. **웹 애플리케이션 배포 및 테스트**

   - Maven 빌드 후 JSP 컨테이너에 배포
   - 브라우저에서 기능 검증

---

**작성자:** GitHub Copilot
**마지막 수정:** 2026년 4월 29일
