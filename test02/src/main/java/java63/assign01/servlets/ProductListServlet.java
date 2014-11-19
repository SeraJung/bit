package java63.assign01.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java63.assign01.dao.ProductDao;
import java63.assign01.domain.Product;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;



@WebServlet("/product/list")
public class ProductListServlet extends GenericServlet { 
  ProductDao productDao;
  private static final long serialVersionUID = 1L;
  

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    //ProductListServlet productListServlet =new ProductListServlet();
    
   
    
    int pageNo = 0,pageSize = 0;
    
    productDao = new ProductDao();    
    if (req.getParameter("pageNo") != null) {
      pageNo = Integer.parseInt(req.getParameter("pageNo"));
      pageSize = 3;
    }
    
    if (req.getParameter("pageSize") != null) {
      pageSize = Integer.parseInt(req.getParameter("pageSize"));
    }
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();

    
    for (Product product : productDao.selectList(pageNo, pageSize)) {
      out.printf("%-3d %-20s %7d %-3d\n", 
          product.getNo(), 
          product.getName(), 
          product.getQuantity(), 
          product.getMakerNo());
    }
   
    
  }

}
