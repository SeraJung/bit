/* 인스턴스변수
 - 값을 개별적으로 관리할 필요가 있을 때 사용.
  
  */
package java01.test30;

//주제: Calculator의 기능을 이용하여 다음 계산을 수행하라!
//단, 계산은 순차적으로 행하라(즉, 연산자 우선순위 적용하지 말라!)
//단 두개의 식을 동시에 계산하라
//10 + 2 * 7 - 4 / 2
//20 * 3 + 76 - 5
//단계 7 : result 변수를 개별적으로 유지.=> 인스턴스 변수
//          => Calculator 클래스를 정의하고 계산과 관련된 기능을 분리한다.

public class Test30 {

   
  public static void main(String[] args) {
  //10 + 2 * 7 - 4 / 2
  //20 * 3 + 76 - 5
    
    //claculator 클래스의 명령에 따라 준비된 메모리를  => 인스턴스
    //그 인스턴스 메모리의 주소를 저장하는 변수를 => 레퍼런스
    Calculator c1= new Calculator();// 인스턴스를 생성했다.
    // c1은 calculator class 주소를 갖고 있다. class 기능을 다 할수 있다.
    // c1은 참조를 한다. 왜냐면 주소를 저장하고있기 때문에.. 
    // c1은 인스턴스변수의 주소를 참조하는 변수이다. 줄여서 인스턴스라고 하는겁니당!!
    
    Calculator c2= new Calculator();
    
    
    Calculator.plus(c1,10);
    Calculator.plus(c2, 20);
    
    Calculator.plus(c1,2);
    Calculator.multiple(c2, 3);
    
    Calculator.multiple(c1, 7);
    Calculator.plus(c2, 76);
    
    Calculator.minus(c1,4);
    Calculator.minus(c2, 5);
    
    Calculator .divide(c1,2);
    System.out.println("결과는 = "+Calculator.getResult(c1));
    System.out.println("결과는 = "+Calculator.getResult(c2));
    

  }
//void : 리턴하는 결과가 없다.
  

}
