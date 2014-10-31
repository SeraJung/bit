/* 예외 발생을 먼 호출자에게 던지고자 할때
 - 바로 전 호출자가 아닌 더 상위 호출자에게 오류정보를 던지고자 싶을 때
   RuntimeException 객체를 사용하라.
 
 - RuntimeException은 Exception의 자식이지만, Error처럼 동작한다.
 
 - 아니 그럼 강사님, 그냥 Error 처럼 사용하면 안되겠습니까?
   => Error는 시스템 오류를 담을 때 사용한다.
   => 따라서 어플리케이션에서 Error을 사용하는 것은 바람직 하지 않다.
   => 그럼에도 불구하고 Error처럼 예외를 던지고 싶을 때가 있는데
      그럴 경우를 대비해서 만든 클래스가 RuntimeException
 */
package java02.test01;

import java.util.Scanner;
// RutimeException을 사용하지 않을 때 ! 고통!
// => 상위 호출자에게 오류를 던지기 위해
//    매서드 선언에 반드시 throws를 던저야 한다.
// 예) printResult(), printContent(), PrintPage()를 보아라.
public class Exception06 {
  static int a,b;
  static String op;
  static class Calculator{
    //Exception 계열의 예외를 던지는 메서드는 반드시
    //베서드 선언부에 throws Exception 처럼 지정해야 한다.
    public static int compute(int a, int b,String op)throws Exception{
      switch(op){
      case "+" : return a + b; 
      case "-" : return a - b;
      default : 
        throw new Exception("지원하지 않는 연산자 입니다.");
      }
    }
  }
  // compute()에서 발생하는 예외를 처리하기 싫으면 상위 호출자에게 넘긴다.
  // 문법 : 함수 선언부에 "throws예외명"추가
  public static void printResult() throws Exception{
    System.out.println("a = " + a);
    System.out.println("b = " + b);
    System.out.println("결과는 = " + Calculator.compute(a, b, op));
  }
  //printResult() 에서 던진 예외를 처리하기 싫으면 상위 호출자에게 던진다.
  public static void printContent() throws Exception{
    System.out.println("*************");
    printResult();
    System.out.println("*************");
    
  }
  //printContent() 에서 던진 예외를 처리학 싫으면 상위 호출자에게 던진다.
  public static void printPage() throws  Exception{
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
    
    //compute() 에서 발생된 예외를 printResult()가 아닌
    //main에서 처리한다..
    try{
    printPage();
    }catch(Exception ex){
      System.out.println(ex.getMessage());
    }
    
  }
}