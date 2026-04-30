import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

@WebServlet("/calcControl")
public class CalcController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CalcController() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        try {
            // Calculator 객체 생성
            Calculator calculator = new Calculator();
            
            // BeanUtils.populate를 사용하여 요청 파라미터를 Calculator 객체에 자동으로 매핑
            BeanUtils.populate(calculator, request.getParameterMap());
            
            // 계산 수행
            double result = calculator.calc();
            
            // 계산 결과를 request에 저장
            request.setAttribute("calculator", calculator);
            request.setAttribute("result", result);
            
            // calcResult.jsp로 forwarding
            request.getRequestDispatcher("calcResult.jsp").forward(request, response);
            
        } catch (ArithmeticException e) {
            // 0으로 나누는 예외 처리
            request.setAttribute("error", "오류: " + e.getMessage());
            request.getRequestDispatcher("calcResult.jsp").forward(request, response);
        } catch (Exception e) {
            // 기타 예외 처리
            request.setAttribute("error", "오류 발생: " + e.getMessage());
            request.getRequestDispatcher("calcResult.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
