package java63.assign01.servlets;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/help")
public class HelpServlet extends GenericServlet {

  
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("list?pageNo=숫자&pageSize=숫자");
    out.println("view?no=숫자");
    out.println("add?name=이름&quantity=숫자&mkno=숫자");
    out.println("delete?no=숫자");
    out.println("update?no=숫자");
    out.println();
    
  }

}
