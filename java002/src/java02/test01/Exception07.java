/* RuntimeException을 사용하여Exception의 고통을 해결함.
 -  */
package java02.test01;

import java.util.Scanner;
public class Exception07 {
  static int a,b;
  static String op;
  static class Calculator{
    //Exception 대신에 RuntimeException을 던진다.
    // Error 처럼 메서드 선언부에 지정하지 않는다.
    public static int compute(int a, int b,String op)
    /*throws Exception*/{
      switch(op){
      case "+" : return a + b; 
      case "-" : return a - b;
      default : 
        throw new RuntimeException("지원하지 않는 연산자 입니다.");
      }
    }
  }
  
  //compute에서는 RuntimeException을 던진다.
  //try.. Catch.. 로 처리하지 않으면 
  //****자동으로 상위 호출자에게 던진다.
  //throws절을 선언 하지 않아도 된다.
  public static void printResult() /*throws Exception*/{
    System.out.println("a = " + a);
    System.out.println("b = " + b);
    System.out.println("결과는 = " + Calculator.compute(a, b, op));
  }
  
  public static void printContent() /*throws Exception*/{
    System.out.println("*************");
    printResult();
    System.out.println("*************");
    
  }
  
  //이렇게 일반 메서드 호출하듯이 printContent()를 호출 할 수 있다.
  //throws생략가능 => 코드가 간결해짐.
  public static void printPage()/*throws Exception*/ {
    System.out.println("머리말 정보....");
    printContent();
    System.out.println("꼬리말 정보....");
    
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("a ? ");
    a = Integer.parseInt(scanner.nextLine());
    
    System.out.println("b ? ");
    b = Integer.parseInt(scanner.nextLine());

    System.out.println("op ? ");
    op = scanner.nextLine();
    
    // compute() 에서 발생된 예외를 중간의 메서드에서는 처리할 필요가 없다.
    // 이렇게 처음 호출자가 통합하여 처리하면 됨.
    // => 오류관리가 쉽고 코드가 간결해짐.
    try{
    printPage();
    }catch(Exception ex){
      System.out.println(ex.getMessage());
    }
    
  }
}
