/* 인스턴스변수
 - 값을 개별적으로 관리할 필요가 있을 때 사용.
 - 문법 : 인스턴스주소.매서드();
 - 해설:
    인스턴스 매서드를 호출할 때, 인스턴스의 주소를 앞에 준다.
    JVM은 인스턴스 변수가 어떤 클래스의 변수인지 알아낸다.
    알아낸 클래스의 매서드를 호출한다.
    이때, 메서드 앞에 준 인스턴스의 주소를 메서드에 넘긴다.
    메서드는 JVM이 호출할 대 넘겨준 인스턴스 주소를 내부 비밀 변수에 저장한다.
    비밀변수의 이름은 this.
  */
package java01.test31;

//주제: Calculator의 기능을 이용하여 다음 계산을 수행하라!
//단, 계산은 순차적으로 행하라(즉, 연산자 우선순위 적용하지 말라!)
//단 두개의 식을 동시에 계산하라
//10 + 2 * 7 - 4 / 2
//20 * 3 + 76 - 5
//단계 7 : result 변수를 개별적으로 유지.=> 인스턴스 변수
//          => Calculator 클래스를 정의하고 계산과 관련된 기능을 분리한다.

class seller{
  int a;
  int b;
  
  
  seller(int a, int b){
    this.a = a;
    this.b = b;
  }
  
}


public class Test31 {

   
  
  
  
  public static void main(String[] args) {
  //10 + 2 * 7 - 4 / 2
  //20 * 3 + 76 - 5
    
    //claculator 클래스의 명령에 따라 준비된 메모리를  => 인스턴스
    //그 인스턴스 메모리의 주소를 저장하는 변수를 => 레퍼런스
    Calculator c1= new Calculator();
    Calculator c2= new Calculator();
    
    seller s1= new seller(10 , 20);
    
    
    c1.plus(10);
    c2.plus(20);
    
    c1.plus(2);
    c2.multiple(3);
    
    c1.multiple(7);
    c2.plus(76);
    
    c1.minus(4);
    c2.minus(5);
    
    c1 .divide(2);
    System.out.println("결과는 = "+c1.getResult());
    System.out.println("결과는 = "+c2.getResult());
    

  }
//void : 리턴하는 결과가 없다.
  

}
