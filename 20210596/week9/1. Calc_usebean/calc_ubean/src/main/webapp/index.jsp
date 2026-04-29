<html>
<body>
    <h2>Calculator</h2>
    <form method="post" action="calc.jsp">
        <label for="n1">Number 1:</label>
        <input type="number" id="n1" name="n1" required>
        <br><br>

        <label for="op">Operator:</label>
        <select id="op" name="op" required>
            <option value="+">+</option>
            <option value="-">-</option>
            <option value="*">*</option>
            <option value="/">/</option>
        </select>
        <br><br>

        <label for="n2">Number 2:</label>
        <input type="number" id="n2" name="n2" required>
        <br><br>

        <button type="submit">Calculate</button>
    </form>
</body>
</html>
