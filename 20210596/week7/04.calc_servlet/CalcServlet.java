import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CalcServlet", urlPatterns = { "/calc.jsp" })
public class CalcServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String n1 = req.getParameter("n1");
        String n2 = req.getParameter("n2");
        String op = req.getParameter("op");

        String message;
        String resultText = "";

        if (n1 == null || n1.isEmpty() || n2 == null || n2.isEmpty() || op == null || op.isEmpty()) {
            message = "숫자와 연산자를 모두 입력해야 합니다.";
        } else {
            try {
                double value1 = Double.parseDouble(n1.trim());
                double value2 = Double.parseDouble(n2.trim());
                double result;

                switch (op) {
                    case "+":
                        result = value1 + value2;
                        break;
                    case "-":
                        result = value1 - value2;
                        break;
                    case "*":
                        result = value1 * value2;
                        break;
                    case "/":
                        if (value2 == 0) {
                            message = "0으로 나눌 수 없습니다.";
                            result = Double.NaN;
                            break;
                        }
                        result = value1 / value2;
                        break;
                    default:
                        message = "알 수 없는 연산자입니다.";
                        result = Double.NaN;
                        break;
                }

                if (Double.isFinite(result)) {
                    resultText = String.format("%s %s %s = %s", formatNumber(value1), op, formatNumber(value2), formatNumber(result));
                    message = "계산 결과";
                }
            } catch (NumberFormatException e) {
                message = "유효한 숫자를 입력해 주세요.";
            }
        }

        PrintWriter out = resp.getWriter();
        out.append("<!DOCTYPE html>\n")
           .append("<html lang=\"ko\">\n")
           .append("<head>\n")
           .append("<meta charset=\"UTF-8\">\n")
           .append("<title>계산 결과</title>\n")
           .append("</head>\n")
           .append("<body>\n")
           .append("<h2>계산기 결과</h2>\n")
           .append("<hr>\n")
           .append("<p>").append(message).append("</p>\n");

        if (!resultText.isEmpty()) {
            out.append("<p>").append(resultText).append("</p>\n");
        }

        out.append("<p><a href=\"index.html\">다시 계산하기</a></p>\n")
           .append("</body>\n")
           .append("</html>\n");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }

    private String formatNumber(double value) {
        if (Math.floor(value) == value) {
            return String.format("%.0f", value);
        }
        return String.format("%s", value);
    }
}
