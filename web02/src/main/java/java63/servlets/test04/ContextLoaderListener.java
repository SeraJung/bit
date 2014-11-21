package java63.servlets.test04;

import java.io.InputStream;

import java63.servlets.test04.dao.ProductDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebServlet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/* ServletContextListener는
 * 웹 애플리케이션이 시작하거나 종료하는 이벤트에 대해 작업 수행!
 */

//@WebServlet
public class ContextLoaderListener implements ServletContextListener {
  /* 공통으로 사용하는 자원은 보통 ServletContext에 보관한다.
   * 
   * ServletContext => 웹 애플리케이션 시작 시 생성됨, 종료하면 제거됨
   * HttpSession => 최초 요청 시 생성, 타임아웃 또는 무효화 명령 시 제거됨
   * HttpServletRequest => 요청 때마다 생성. 응답 후 제거됨.
   * PageContext => JSP에서 사용됨
   *      각 JSP 실행할 때 마다 생성되고 실행 완료되면 제거됨 
   */
  @Override
  public void contextInitialized(ServletContextEvent sce) {

    try {
      ServletContext ctx = sce.getServletContext();
      InputStream inputStream = Resources.getResourceAsStream(
          ctx.getInitParameter("mybatisConfig"));
      SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);

      ProductDao productDao = new ProductDao();
      productDao.setSqlSessionFactory(sqlSessionFactory);
      
      ctx.setAttribute("productDao", productDao);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /* 웹 애플리케이션이 종료할 때 호출됨
   * =>서블릿이 사용한 자원을 해재할 때 
   */
  @Override
  public void contextDestroyed(ServletContextEvent sce) {

  }

}
