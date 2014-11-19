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



@WebServlet("/product/update")
public class ProductUpdateServlet extends GenericServlet { 
  ProductDao productDao;
  private static final long serialVersionUID = 1L;
  

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    //ProductListServlet productListServlet =new ProductListServlet();
      
    
   
    productDao = new ProductDao();   
    Product product = new Product();
    product.setNo(Integer.parseInt(req.getParameter("no")));
    product.setName(req.getParameter("name"));
    product.setQuantity(Integer.parseInt(req.getParameter("qty")));
    product.setMakerNo(Integer.parseInt(req.getParameter("mkno")));
    
    productDao.update(product);
    
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();

    out.println("변경하였습니다.");
    out.println();
      
    
  }

}
