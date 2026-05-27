package kr.hnu.ice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * /myf 경로로 한글 시를 반환하는 서블릿
 */
public class MyPoemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String poem = "<!DOCTYPE html>\n" +
				"<html>\n" +
				"<head>\n" +
				"    <meta charset=\"UTF-8\">\n" +
				"    <title>한글 시</title>\n" +
				"    <style>\n" +
				"        body {\n" +
				"            font-family: Arial, sans-serif;\n" +
				"            margin: 50px;\n" +
				"            line-height: 2;\n" +
				"        }\n" +
				"        .poem-container {\n" +
				"            border: 2px solid #333;\n" +
				"            padding: 30px;\n" +
				"            max-width: 500px;\n" +
				"            background-color: #f5f5f5;\n" +
				"        }\n" +
				"        .poet {\n" +
				"            margin-top: 20px;\n" +
				"            font-style: italic;\n" +
				"            color: #666;\n" +
				"        }\n" +
				"        .title {\n" +
				"            font-size: 24px;\n" +
				"            font-weight: bold;\n" +
				"            margin-bottom: 15px;\n" +
				"            text-align: center;\n" +
				"        }\n" +
				"        .poem-text {\n" +
				"            white-space: pre-wrap;\n" +
				"            font-size: 16px;\n" +
				"        }\n" +
				"    </style>\n" +
				"</head>\n" +
				"<body>\n" +
				"    <div class=\"poem-container\">\n" +
				"        <div class=\"title\">나비야</div>\n" +
				"        <div class=\"poem-text\">\n" +
				"나비야\n" +
				"지저귀지 말고\n" +
				"날개를 접고\n" +
				"\n" +
				"이 봄 숲에서\n" +
				"조용히 죽거라\n" +
				"        </div>\n" +
				"        <div class=\"poet\">- 정지용</div>\n" +
				"    </div>\n" +
				"</body>\n" +
				"</html>";

		out.println(poem);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
