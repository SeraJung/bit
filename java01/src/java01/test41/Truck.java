/* 호출할 수퍼클래스 생성자를 지정하기
 - 서브 클래스에서 어떤 수퍼 클래스 생성자를 호출할지 지정하지 않으면,
   수퍼 클래스의 기본 생성자를 호출한다.
 - 문법 : super(호출할 생성자의 파라미터 값);
   
 
 */
package java01.test41;


public class Truck extends Car {
  float weight = 1000; 
  boolean autoDump;
  
  public Truck(){
    super("미정","미정",800);
    this.autoDump = true;
    
  }
}
