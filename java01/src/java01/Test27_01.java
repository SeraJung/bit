/* 메서드(함수)
 - 특정기능을 수행하는 명령어를 묵어 놓은 것.
 - 파라미터 : 기능을 수행하는데 필요한 정보
 - 리턴 값 : 기능을 수행한 후 결과를 전달
 - 문법
   공개범위 스태틱여부 리턴타입 메서드명(타입 변수명, 타입 변수명){
    retrun 리턴값;
    }
    예)
    int plus(int i, int b){
    return i+b;
    }
   } */
package java01;

//주제: 사용자로부터 두개의 값과 연산자를 입력받아 계산한 후 그 결과 출력
//실행 예 : 
//$ 값1? 10
//$ 값2? 20
//$ 연산자? +
//$ 10 + 20 = 30
//e단계 1: 메서드도입전
import java.util.Scanner;
public class Test27_01 {
  //1) 단순한 출력문을 작성하라.
  //2) java.util.Scanner를 사용하여 값을 입력 받는다.
  //3)switch문을 사용하여 계산 결과를 result변수에 담는다. 그리고 출력
  public static void main(String[] args) {
    Scanner scanner= new Scanner(System.in);
    
    System.out.printf("값1? ");
    int v1=Integer.parseInt(scanner.nextLine());
    System.out.printf("값2? ");
    int v2=Integer.parseInt(scanner.nextLine());
    System.out.printf("연산자? ");
    String op=scanner.nextLine();
    
    switch(op){
    case "+":
      System.out.println(v1+" + "+ v2 +" = " + (v1+v2));
      break;
    case "-":
      System.out.println(v1+" - "+ v2 +" = " + (v1-v2));
      break;
    case "*":
      System.out.println(v1+" * "+ v2 +" = " + (v1*v2));
      break;
    case "/":
      System.out.println(v1+" / "+ v2 +" = " + (v1/v2));
      break;
       
    default:
      System.out.println("연산자를 잘못 입력하셨습니다.!!!!!!!!");
    }
  

  }
 /*public static void main(String[] args) {
    Scanner scanner= new Scanner(System.in);
   
    System.out.printf("값1? ");
    int v1=Integer.parseInt(scanner.nextLine());
    System.out.printf("값2? ");
    int v2=Integer.parseInt(scanner.nextLine());
    System.out.printf("연산자? ");
    String op=scanner.nextLine();
    
    System.out.println("10 + 20 = 30" );
  

  }
  /*public static void main(String[] args) {
    
   
    System.out.println("값1? 10");
    System.out.println("값2? 20");
    System.out.println("연산자? +");
    System.out.println("10 + 20 = 30" );
  

  }*/

}
