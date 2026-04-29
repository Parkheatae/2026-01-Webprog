<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSTL 예제</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .section { margin: 30px 0; padding: 15px; border: 1px solid #ccc; background-color: #f9f9f9; }
        .el-section { background-color: #ffffcc; }
        h2 { color: #333; border-bottom: 2px solid #0066cc; }
        h3 { color: #0066cc; margin-top: 15px; }
        pre { background-color: #f0f0f0; padding: 10px; overflow-x: auto; }
        .output { color: #006600; font-weight: bold; }
    </style>
</head>
<body>

<h1>JSTL (JavaServer Pages Standard Tag Library) 예제</h1>

<!-- ========== JSTL 기본 문법 예제 ========== -->
<div class="section">
    <h2>1. JSTL - 변수 설정 및 기본 문법</h2>
    
    <h3>1-1) 변수 설정 (c:set)</h3>
    <c:set var="name" value="Kim" />
    <c:set var="age" value="25" />
    <c:set var="score" value="95.5" />
    <p>설정된 변수: name=${name}, age=${age}, score=${score}</p>
    
    <h3>1-1-1) 문자열 배열 설정 및 forEach 출력</h3>
    <%
        String[] subjects = {"국어", "영어", "수학", "과학", "사회"};
        request.setAttribute("subjects", subjects);
    %>
    <p><strong>학습 과목 목록 (forEach 반복):</strong></p>
    <c:forEach var="subject" items="${subjects}" varStatus="status">
        <p class="output">${status.count}. ${subject}</p>
    </c:forEach>
    
    <h3>1-2) if 문법</h3>
    <c:if test="${age >= 20}">
        <p class="output">✓ ${name}은 성인입니다 (나이: ${age})</p>
    </c:if>
    <c:if test="${score >= 90}">
        <p class="output">✓ 우수한 점수입니다 (${score}점)</p>
    </c:if>
    
    <h3>1-3) choose, when, otherwise 문법</h3>
    <c:choose>
        <c:when test="${score >= 90}">
            <p class="output">학점: A (${score}점) - 매우 우수</p>
        </c:when>
        <c:when test="${score >= 80}">
            <p class="output">학점: B (${score}점) - 우수</p>
        </c:when>
        <c:when test="${score >= 70}">
            <p class="output">학점: C (${score}점) - 보통</p>
        </c:when>
        <c:otherwise>
            <p class="output">학점: F (${score}점) - 재시험</p>
        </c:otherwise>
    </c:choose>
    
    <h3>1-4) forEach 문법 (배열 반복)</h3>
    <c:set var="fruits" value="사과,바나나,포도,딸기,수박" />
    <p><strong>과일 목록 (forEach):</strong></p>
    <c:forEach var="fruit" items="${fn:split(fruits, ',')}" varStatus="status">
        <p class="output">${status.count}. ${fruit}</p>
    </c:forEach>
    
    <h3>1-5) forTokens 문법 (문자열 토큰 분할)</h3>
    <c:set var="colors" value="red:blue:green:yellow:purple" />
    <p><strong>색상 목록 (forTokens):</strong></p>
    <c:forTokens var="color" items="${colors}" delimiters=":">
        <p class="output">▪ ${color}</p>
    </c:forTokens>
    
    <h3>1-6) 숫자 범위 반복</h3>
    <p><strong>1부터 5까지의 숫자:</strong></p>
    <c:forEach var="i" begin="1" end="5" step="1">
        <span class="output">[${i}]</span>
    </c:forEach>
    <br><br>
    
    <h3>1-7) 리스트 생성 및 반복</h3>
    <c:set var="studentList" value="${['Seoul', 'Busan', 'Incheon', 'Daegu']}" />
    <p><strong>도시 목록:</strong></p>
    <c:forEach var="city" items="${studentList}" varStatus="loop">
        <p class="output">${loop.index}. ${city}</p>
    </c:forEach>
</div>

<!-- ========== Expression Language (EL) 버전 ========== -->
<div class="section el-section">
    <h2>2. Expression Language (EL) - 동일한 내용 출력</h2>
    
    <h3>2-1) 변수 출력 (EL)</h3>
    <p>EL로 설정된 변수: name=${name}, age=${age}, score=${score}</p>
    
    <h3>2-2) 조건식 (EL)</h3>
    <% 
        String elName = "Kim";
        int elAge = 25;
        double elScore = 95.5;
        request.setAttribute("elName", elName);
        request.setAttribute("elAge", elAge);
        request.setAttribute("elScore", elScore);
    %>
    <p>
        ${elAge >= 20 ? '✓ ' += elName += '은 성인입니다' : '미성년자입니다'}
    </p>
    <p>
        ${ elScore >= 90 ? '✓ 우수한 점수입니다 (' += elScore += '점)' : '재시험 필요' }
    </p>
    
    <h3>2-3) 조건식 (중첩) - 학점 판정</h3>
    <p class="output">
        학점: 
        ${ elScore >= 90 ? 'A (매우 우수)' : 
           elScore >= 80 ? 'B (우수)' : 
           elScore >= 70 ? 'C (보통)' : 'F (재시험)' }
    </p>
    
    <h3>2-4) 배열/리스트 출력 (EL)</h3>
    <%
        String[] fruitArray = {"사과", "바나나", "포도", "딸기", "수박"};
        request.setAttribute("fruitArray", fruitArray);
    %>
    <p><strong>과일 목록 (EL 배열 인덱싱):</strong></p>
    <p class="output">
        1. ${fruitArray[0]}<br>
        2. ${fruitArray[1]}<br>
        3. ${fruitArray[2]}<br>
        4. ${fruitArray[3]}<br>
        5. ${fruitArray[4]}
    </p>
    
    <h3>2-5) 토큰 분할 출력 (EL)</h3>
    <%
        String colorsStr = "red:blue:green:yellow:purple";
        String[] colorArray = colorsStr.split(":");
        request.setAttribute("colorArray", colorArray);
    %>
    <p><strong>색상 목록 (EL):</strong></p>
    <p class="output">
        ▪ ${colorArray[0]}<br>
        ▪ ${colorArray[1]}<br>
        ▪ ${colorArray[2]}<br>
        ▪ ${colorArray[3]}<br>
        ▪ ${colorArray[4]}
    </p>
    
    <h3>2-5-1) 학습 과목 배열 출력 (EL - forEach 활용)</h3>
    <p><strong>학습 과목 목록 (EL + forEach):</strong></p>
    <c:forEach var="subject" items="${subjects}" varStatus="loop">
        <p class="output">${loop.count}. ${subject}</p>
    </c:forEach>
    
    <h3>2-6) 산술 연산 (EL)</h3>
    <%
        int num1 = 10;
        int num2 = 3;
        request.setAttribute("num1", num1);
        request.setAttribute("num2", num2);
    %>
    <p class="output">
        ${num1} + ${num2} = ${num1 + num2}<br>
        ${num1} - ${num2} = ${num1 - num2}<br>
        ${num1} * ${num2} = ${num1 * num2}<br>
        ${num1} / ${num2} = ${num1 / num2}<br>
        ${num1} % ${num2} = ${num1 % num2}
    </p>
    
    <h3>2-7) 논리 연산 (EL)</h3>
    <p class="output">
        ${true && true} = true and true (참)<br>
        ${true && false} = true and false (거짓)<br>
        ${true || false} = true or false (참)<br>
        ${!true} = not true (거짓)
    </p>
</div>

<!-- ========== 비교 요약 ========== -->
<div class="section">
    <h2>3. JSTL vs Expression Language 비교</h2>
    <table border="1" cellpadding="10" cellspacing="0" style="width: 100%;">
        <tr style="background-color: #0066cc; color: white;">
            <th>기능</th>
            <th>JSTL 태그</th>
            <th>Expression Language (EL)</th>
        </tr>
        <tr>
            <td>변수 설정</td>
            <td>&lt;c:set var="x" value="10" /&gt;</td>
            <td>스크립틀릿에서 setAttribute() 사용</td>
        </tr>
        <tr>
            <td>조건문</td>
            <td>&lt;c:if test="${조건}"&gt;</td>
            <td>${조건 ? 참 : 거짓}</td>
        </tr>
        <tr>
            <td>다중 선택</td>
            <td>&lt;c:choose&gt; &lt;c:when&gt; &lt;c:otherwise&gt;</td>
            <td>삼항연산자 중첩</td>
        </tr>
        <tr>
            <td>반복 (배열)</td>
            <td>&lt;c:forEach items="${list}"&gt;</td>
            <td>인덱싱: ${array[0]}, ${array[1]}</td>
        </tr>
        <tr>
            <td>문자열 분할</td>
            <td>&lt;c:forTokens delimiters=":"&gt;</td>
            <td>Java split() 사용 후 EL 인덱싱</td>
        </tr>
    </table>
</div>

</body>
</html>
