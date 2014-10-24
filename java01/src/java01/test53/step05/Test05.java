/* 5단계
 - Iterator 뿐만 아니라 EvenIterator, ReverseIterator도 사용할 수 있게 하기
 - 해결책 : 
     이들 클래스에 공통점을 뽑아 슈퍼 클래스를 정의하라~! => Generalization수행  
     Iterator
      └-------> GeneralIterator
      └-------> EvenIterator
      └-------> ReverseIterator
      
 */
package java01.test53.step05;

import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Properties;

public class Test05 {
  public static void main(String[] args) throws Exception {
    String iteratorClassName = System.getProperty("iterator");
    
    //클래스 이름(패키지명 포함)으로 객체 생성하기
    //1) 클래스를 로딩하라.
    Class clazz = Class.forName(iteratorClassName);
    
    //2) 클래스 객체를 사용하여 인스턴스를 생성 
    
    Iterator iterator = (Iterator) clazz.newInstance();
    
    //3) Iterator를 사용하기 전에 필요한 값을 설정한다.
    iterator.setList(args);
   while(iterator.hasNext()){
     System.out.println(iterator.next());
   }
   
  /* 
   * //Iterator 클래스의 메소드 이름을 출력
   Method[] methods = clazz.getMethods();
   for(Method method: methods){
     System.out.println(method.getName()); //public 메소드의 정보
   }
   */
   //안탑깝게도 다른 Iterator는 사용할 수 없다.
   // 다음 단계를 보기 바람~~!!
   
  }
  

}
