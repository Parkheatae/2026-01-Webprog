import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="First HelloWorld Servlet", urlPatterns = "/hello2")
public class HelloWorldSvl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedNow = now.format(formatter);

        PrintWriter out = resp.getWriter();

        out.append("<!DOCTYPE html>\n")
           .append("<html lang=\"ko\">\n")
           .append("<head>\n")
           .append("<meta charset=\"UTF-8\">\n")
           .append("<title>현재 날짜와 시간</title>\n")
           .append("</head>\n")
           .append("<body>\n")
           .append("<h1>오늘 날짜와 시간</h1>\n")
           .append("<p>").append(formattedNow).append("</p>\n")
           .append("</body>\n")
           .append("</html>\n");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}