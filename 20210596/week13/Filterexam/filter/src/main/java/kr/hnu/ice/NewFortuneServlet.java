package kr.hnu.ice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * /newf 경로로 행운의 편지를 반환하는 서블릿
 * 한글 처리 없음 - 필터 적용 여부 확인용
 */
public class NewFortuneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글 처리를 서블릿에서 하지 않음
		PrintWriter out = response.getWriter();

		String fortuneLetter = "<!DOCTYPE html>\n" +
				"<html>\n" +
				"<head>\n" +
				"    <meta charset=\"UTF-8\">\n" +
				"    <title>행운의 편지</title>\n" +
				"    <style>\n" +
				"        body {\n" +
				"            font-family: Arial, sans-serif;\n" +
				"            margin: 50px;\n" +
				"            line-height: 1.8;\n" +
				"        }\n" +
				"        .letter-container {\n" +
				"            border: 3px solid gold;\n" +
				"            padding: 30px;\n" +
				"            max-width: 600px;\n" +
				"            background-color: #fffacd;\n" +
				"        }\n" +
				"        .letter-header {\n" +
				"            font-size: 20px;\n" +
				"            font-weight: bold;\n" +
				"            margin-bottom: 20px;\n" +
				"            text-align: center;\n" +
				"            color: #ff6600;\n" +
				"        }\n" +
				"        .letter-content {\n" +
				"            font-size: 14px;\n" +
				"            white-space: pre-wrap;\n" +
				"            margin-bottom: 20px;\n" +
				"        }\n" +
				"        .warning {\n" +
				"            font-size: 12px;\n" +
				"            color: red;\n" +
				"            font-weight: bold;\n" +
				"            margin-top: 20px;\n" +
				"            border: 1px solid red;\n" +
				"            padding: 10px;\n" +
				"        }\n" +
				"    </style>\n" +
				"</head>\n" +
				"<body>\n" +
				"    <div class=\"letter-container\">\n" +
				"        <div class=\"letter-header\">*** 행운의 편지 ***</div>\n" +
				"        <div class=\"letter-content\">\n" +
				"이 편지는 행운을 가져다줍니다.\n" +
				"\n" +
				"이 편지를 받은 지 96시간 이내에 \n" +
				"다른 사람 10명에게 이 편지를 전해주세요.\n" +
				"\n" +
				"그러면 당신에게 행운이 찾아올 것입니다.\n" +
				"\n" +
				"이 편지를 무시하면 불행이 올 것이니\n" +
				"꼭 퍼뜨려 주시기 바랍니다.\n" +
				"\n" +
				"행운을 빈다!\n" +
				"        </div>\n" +
				"        <div class=\"warning\">\n" +
				"⚠️ 주의: 이것은 교육용 예시입니다!\n" +
				"        </div>\n" +
				"    </div>\n" +
				"</body>\n" +
				"</html>";

		out.println(fortuneLetter);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
