package java63.web03.control.bind;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

// 프론트 컨트롤러에게 조언하고 싶다.
// => 프론트 컨트롤러에게 조언하는 역활의 클래스는 @ControllerAdvicef를 붙인다.
// => @ControllerAdvic가 붙은 클래스는 스플링에서 적절히 메서드를 호출한다.

//야~~ 스프링 MVC 프레임워크!
//다음클래스는 컨트로러에게 조언할 기능이 있는 클래스이니깐.
//그러니, 클래스를 살펴보고 상황에 맞는 메서드를 호출해라~!!


@ControllerAdvice
public class GlobalInitBinder {
  static Logger log = Logger.getLogger(GlobalInitBinder.class);
  /* 조언하나
   * => 문자열의 요청 파라미터 값을 java.util.Date으로 바꿀때에는
   *    CustomDateEditeor를 사용하라~!!
   */
  @InitBinder
  public void initBinder(WebDataBinder binder) throws ParseException {
    log.debug("initbinder 호출됨");
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    dateFormat.setLenient(false);
    
    binder.registerCustomEditor(
        Date.class, 
        new CustomDateEditor(dateFormat, true)
        );
  }

}
