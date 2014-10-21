/* 캡슐화(encapsulation)?
 - 클래스를 정의한 의도와 다르게 변수나 매소드를 사용할 경우 오류가 발생
   1) 변수에 무효한 값을 넣는다거나,
   2) 내부에서 호출할 매소드를 외부에서 직접 호출한다거나  등
 - => 클래스 작성자가 의도한 대로만 사용하도록 접근을 제한하는 문법
 -  => 최소한의 안정장치
 - 문법:
  [접근 제어자(access modifier)] 타입 변수명;
  [접근 제어자(access modifier)] 리턴타입 메서드명;
- 접근제어자:
   1) private =>클래스 맴버만 접근 가능
   2) Protected =>같은 패키지의 클래스에 접근 가능, 자식클래스 접근 가능
   3) (dafault) => 같은 패키지의 클래스만 접근 가능
   4) public => 모두 접근 가능 
  
  */
package java01.test29;

//주제: Calculator의 기능을 이용하여 다음 계산을 수행하라!
//단, 계산은 순차적으로 행하라(즉, 연산자 우선순위 적용하지 말라!)
//10 + 2 * 7 - 4 / 2
//단계 6 : result 변수의 외부 접근 차단. =>캡술화
import java.util.Scanner;
public class Test29 {

   
  public static void main(String[] args) {
    // 클래스 변수나 인스턴스 변수는 자동 초기화 된다
    // 따라서 다음과 같이 별도로 초기화 할 필요는 없다.
    //Calculator.result= 0; 
    
    Calculator.plus(10);
    Calculator.plus(2);
    Calculator.multiple(7);
    Calculator.minus(4);
    Calculator.divide(2);
    System.out.println("결과는 = "+Calculator.getResult());
  

  }
//void : 리턴하는 결과가 없다.
  

}
