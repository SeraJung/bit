package java63.web03.control;

import java63.web03.dao.ProductDao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ProductDeleteControl {
  @Autowired ProductDao productDao;
  
  @RequestMapping("/product/delete.do")
  public String execute(int no) throws Exception {
    productDao.deletePhoto(no);
    productDao.delete(no);
    
    //해당 제품의 사진 경로를 알아내서 
    //파일 시스템에서 지운다.
    
    return "redirect:list.do";
  }
  
}












