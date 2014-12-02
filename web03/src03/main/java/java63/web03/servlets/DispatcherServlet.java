package java63.web03.servlets;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

   
  @Override
  public void service(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    
    try {
      
      //스프링의 ContextLoaderListener가 준비한 
      //ApplicationContext 객체 꺼내기
      ApplicationContext appCtx =
          WebApplicationContextUtils.getWebApplicationContext(
              this.getServletContext());
      //1. servlet URL을 알아낸다. 예)/prudect/list.do
      String servletPath = request.getServletPath();
      //2. 서블릿 경로로 컨트롤 객체를 꺼낸다. 예) ProductListControl객체
      Object controller = appCtx.getBean(servletPath);
      //3. controller의 excute() 메서드 꺼내기
      Method execute = controller.getClass().getMethod(
          "execute", HttpServletRequest.class);
      //4. execute 메서드 호출
      String viewUrl = (String)execute.invoke(controller, request);
      
      //5. 쿠키 추가하기
      @SuppressWarnings("unchecked")
      ArrayList<Cookie> cookieList = 
          (ArrayList<Cookie>)request.getAttribute("cookieList");
      if(cookieList != null){
        for(Cookie cookie: cookieList){
          response.addCookie(cookie);
        }
      }
      
      //6. view 컴포넌트로 보내기.
      if(viewUrl.startsWith("redirect:")){
        response.sendRedirect(viewUrl.substring(9));
      }else{//viewURL을 인쿠르딩한다.
        response.setContentType("text/html;charset=UTF-8");    
        RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
        rd.include(request, response);
      }
      
     
      
    } catch (Exception e) {
      RequestDispatcher rd = 
          request.getRequestDispatcher("/common/Error.jsp");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }
  }
  
}












