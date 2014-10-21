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
//e단계 2 : 메서드도입 => 결과 출력을 별도의 메소드로 분리
import java.util.Scanner;
public class Test27_02 {
  //void : 리턴하는 결과가 없다.
  static void displayResult(int v1, int v2,int result,String op){    
    System.out.println("===============================");
    System.out.println(v1+" "+op+" "+v2+" = "+ result);
    System.out.println("===============================");
  }
  public static void main(String[] args) {
    Scanner scanner= new Scanner(System.in);
    int result = 0;
    System.out.printf("값1? ");
    int v1=Integer.parseInt(scanner.nextLine());
    System.out.printf("값2? ");
    int v2=Integer.parseInt(scanner.nextLine());
    System.out.printf("연산자? ");
    String op=scanner.nextLine();
    switch(op){
    case "+": result=v1+v2;    break;
    case "-": result=v1-v2;    break;
    case "*": result=v1*v2;    break;
    case "/": result=v1/v2;    break;       
    default:
      System.out.println("연산자를 잘못 입력하셨습니다.!!!!!!!!");
    }
    //메소드 호출
    displayResult(v1,v2,result,op);
    
  

  }

}
