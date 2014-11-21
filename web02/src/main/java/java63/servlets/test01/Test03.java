package java63.servlets.test01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/* 한글 출력허라 때 깨지는 문제 해결
 * 
 * 이유 : 
 * ServletResponse 가 준 출력스트림은
 * 기본적으로 출력할 때 ISO=8859-1f로 인코딩한다
 * => 한글은 ISO-8859-1 문자집합에 없기 때문에 ?로 태체하여 출력한다.
 * 
 * 해결책 :
 * ServletResponse로 부터 출력 스트림으로 얻기 전에,
 * => response.setContextType("text/plain:charset=UTF-8")
 * => response.setCharacterEncoding("UTF-8")
 * 
 * MINE => 콘텐츠의 타입을 표현
 * 
 */
@WebServlet("/test01/Test03")
public class Test03 extends GenericServlet {
  private static final long serialVersionUID = 1L;
  @Override
  public void service(ServletRequest reqeuest, ServletResponse response)
      throws ServletException, IOException {

    //방법1.
    //response.setCharacterEncoding("UTF-8");
    
    //방법2
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
   
    out.println("<html>");
    out.println("<body>");
    out.println("<h1>안뇽하세요</h1>");
    out.println("</body>");
    out.println("</html>");
  }
  

}
