package java63.web03.control;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import java63.web03.dao.MakerDao;
import java63.web03.dao.ProductDao;
import java63.web03.domain.Product;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
public class ProductControl{  
  static final int PAGE_DEFAULT_SIZE = 3;
  static Logger log=Logger.getLogger(ProductControl.class);
  @Autowired  MakerDao makerDao;
  @Autowired  ProductDao productDao;
  @Autowired ServletContext servletContext;
  
  @RequestMapping(value="/add",method=RequestMethod.GET )
  public ModelAndView form() throws Exception {
    ModelAndView model = new ModelAndView();
    model.addObject("makers", makerDao.selectNameList());
    model.setViewName("product/ProductForm");
    return model;
    } 
  
  @RequestMapping(value="/add",method=RequestMethod.POST)
  public String add(Product product) throws Exception {
    String fileuploadRealPath = servletContext.getRealPath("/fileupload");    
    String filename = System.currentTimeMillis() +"_"; 
    File file = new File(fileuploadRealPath + "/" + filename);
      product.getPhotofile().transferTo(file);
      product.setPhoto(filename);
    
      productDao.insert(product);
      productDao.insertPhoto(product);
      return "redirect:list.do";
    }
  
  @RequestMapping("/delete")
  public String delete(int no) throws Exception {
    productDao.deletePhoto(no);
    productDao.delete(no);
    
    //해당 제품의 사진 경로를 알아내서 
    //파일 시스템에서 지운다.
    
    return "redirect:list.do";
  }
  @RequestMapping("/list")
  public String list(
      @RequestParam(defaultValue="0") int pageNo,
      @RequestParam(defaultValue="0") int pageSize,
      Model model) throws Exception {
    
    if (pageNo > 0) {
      pageSize = PAGE_DEFAULT_SIZE;
    }  
    
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", ((pageNo - 1) * pageSize));
    paramMap.put("pageSize", pageSize);
    
    model.addAttribute("products", 
        productDao.selectList(paramMap));
    
    return "product/ProductList";
  }
  
  @RequestMapping("/update")
  public String update(Product product) throws Exception {
        
    
    productDao.update(product);
    
    return "redirect:list.do";
  }
  
  @RequestMapping("/view")
  public String execute(int no, Model model) throws Exception {
    
    
    Product product = productDao.selectOne(no);
    model.addAttribute("product", product);
    model.addAttribute("photos", 
        productDao.selectPhoto(product.getNo()));
    
    model.addAttribute("makers", makerDao.selectNameList());
    return "product/ProductView";
  }

  
}












