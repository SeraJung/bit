package java63.web03.control;

import java.io.File;
import java.util.Map;

import java63.web03.dao.MakerDao;
import java63.web03.dao.ProductDao;
import java63.web03.domain.Product;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/* RequestMapping
 * => 매서드의 URL을 연결한다.
 * => 이 애노테이션의 기능을 완전히 활용하려면
 *    이 애노테이션 처리기를 등록해야한다.
 * 
 */
//방법 1)@Component("/product/add.do")
//방법 2)@Component
//방법 3)@Component
//방법 3)@RequestMapping("/product/add.do")
//방법 4)@Component
//방법 4)@RequestMapping("/product")
//@Component //Spring IoC 컨테이너의 기본 객체를 지정할 때 주로 사용
@Controller // Spring MVC의 컴포넌트(페이지 컨포넌트)임을 지정할 때 사용
@RequestMapping("/product/add.do")
public class ProductAddControl{  
  @Autowired  MakerDao makerDao;
  @Autowired  ProductDao productDao;
  @Autowired ServletContext servletContext;
  //방법1)@RequestMapping
  //방법 2)@RequestMapping("/product/add.do")
  //방법 3)@RequestMapping
  //방법 4)@RequestMapping("/add.do")
  @RequestMapping(method=RequestMethod.GET )
  public ModelAndView form() throws Exception {
    ModelAndView model = new ModelAndView();
    model.addObject("makers", makerDao.selectNameList());
    model.setViewName("/product/ProductForm.jsp");
    return model;
    }
  /* Model은 request에 담을 값을 보관할 임시 저장소.
  public String form(Model model) throws Exception {
    model.addAttribute("makers", makerDao.selectNameList());
    return "/product/ProductForm.jsp";
    }
  */
 /* 방법1. Map은 리퀘스트에 답을 값을 보관할 임시 저장소.
  * public String form(Map<String,Object> model) throws Exception {
    model.put("makers", makerDao.selectNameList());

    return "/product/ProductForm.jsp";
    }
    */
  
  
  
  
  /*@RequestParam
   * => 파라미터 값을 담을 변수명을 선언
   * => 선언하지 않아도 파라미터와 이름이 같다면 값을 넣어 준다.
   * => 단 MultipartFile인 경우는 선언해야 한다.
   * 
   */
  @RequestMapping(method=RequestMethod.POST)
  public String add(
      @RequestParam("name")String name,/**/
      @RequestParam int qty,/*요청 파라미터 이름과 변수의 이름이 같다면 생략가능*/
      int mkno,/*@RequestParam 생략가능*/
      @RequestParam MultipartFile photo) throws Exception {
    String fileuploadRealPath = servletContext.getRealPath("/fileupload");    
    String filename = System.currentTimeMillis() +"_"; 
    File file = new File(fileuploadRealPath + "/" + filename);
      photo.transferTo(file);
      
      //FileUploadHelper 삭제 후 오류 발생문제 때문에 주석으로 막음
      //Map<String , String> paramMap = FileUploadHelper.parse(request);
      Map<String, String> paramMap = null;// 임시조치
      Product product = new Product();
      product.setName(name);
      product.setQuantity(qty);
      product.setMakerNo(mkno);
      product.setPhoto(filename);
    
      productDao.insert(product);
      productDao.insertPhoto(product);
      return "redirect:list.do";
    }
  

}












