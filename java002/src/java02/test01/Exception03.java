/* 예외 상황 발생 시 던질 수 있는 클래스 : Throwable
 - 서브클래스 : Error, Exception
 - 시스템 관련 예외는 Error 계열의 객체에 담아서 던진다.
 - 애플리케이션 관련 예외는 Exception 계열의 객체에 담아서 던진다.
   => 개발자가 처리할 수 있는 예외 상황을 이야기 한다.
 
 - 왜 복잡하게 예외 정보를 담는 클래스가 많은가?
   => 예외 상황을 좀 더 쉽게 구분하기 위해 
   => 예외 처리를 상황에 따라 조정하기 쉽도록
   
 - 개발할 때 보통 Exception 계열의 예외를 발생 시킨다.
 */
package java02.test01;

public class Exception03 {
  //여러개의 예외를 던지는 방법
  public static int compute(int a, int b, String op)
  throws Exception, ArithmeticException{
    if(op == null)
      throw new Exception("연산자를 지정하세요.");
    switch(op){
    case "+" : return a + b; 
    case "-" : return a - b; 
    case "*" : return a * b; 
    case "/" : 
      if(b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
      return a / b;
    default : 
      throw new Exception("지원하지 않는 연산자 입니다.");
    }
  }
  //여러개의 예외를 처리하는 방법
  public static void main(String[] args) {
    //catch 문 작성시 자식 예외부터 처리하라. => 다형적 변수!!
    try{
      int result = compute(10,0,"/");
      System.out.println(result);
    }catch(ArithmeticException ex){ 
      // ArithmeticException 은 Exception의 자식이기 때문에
      // 만약 Exception을 먼저 사용하면.. 이명령문을 사용 할 수가 없다.
      System.out.println("연산 오류"); 
    }catch(Exception ex){
      System.out.println("실행 오류");
    }
    
  }
}
