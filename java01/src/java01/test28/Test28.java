/* 클래스 ?
 - 역활에 따라 메서드(함수)와 변수를 정의 한 것. 묶어 놓은것.
 
  */
package java01.test28;

//주제: Calculator의 기능을 이용하여 다음 계산을 수행하라!
//단, 계산은 순차적으로 행하라(즉, 연산자 우선순위 적용하지 말라!)
//10 + 2 * 7 - 4 / 2
//단계 5 : 클래스 분리!
//          => Calculator 클래스를 정의하고 계산과 관련된 기능을 분리한다.
import java.util.Scanner;
public class Test28 {

   
  public static void main(String[] args) {
    // 클래스 변수나 인스턴스 변수는 자동 초기화 된다
    // 따라서 다음과 같이 별도로 초기화 할 필요는 없다.
    //Calculator.result= 0; 
    
    Calculator.plus(10);
    Calculator.plus(2);
    Calculator.multiple(7);
    Calculator.minus(4);
    Calculator.divide(2);
    System.out.println("결과는 = "+Calculator.result);
  

  }
//void : 리턴하는 결과가 없다.
  

}
