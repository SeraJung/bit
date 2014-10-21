/* 클래스 변수(전역)
 - 클래스를 로딩할 때 준비되는 변수
 - Method Area 영역에 준비됨.
 - JVM이 실행을 종료할 때까지 유지
 
 *로컬변수(지역)
 - 함수가 호출될 때 준비되는 변수
 - Stack 영역에 준비됨
 - 함수호출이 끝나면 제거된다.
 
 *인스턴스 변수
 - 인스턴스가 생성 될 때 준비되느 변수
 - Heap 영역에 준비됨
 - 가비지 컬렉터에 의해 해제되기 전까지 존재한다.
  */
package java01;

//주제: 사용자로부터 두개의 값과 연산자를 입력받아 계산한 후 그 결과 출력
//실행 예 : 
//$ 값1? 10
//$ 값2? 20
//$ 연산자? +
//$ 10 + 20 = 30
//단계 4 : 클래스 변수 도입=> compute()와 DisplayResult()에서 공유할 값을 보관
import java.util.Scanner;
public class Test27 {
  static int v1;
  static int v2;
  static String op;
  static int result;
  
  static void displayResult(){    
    System.out.println("===============================");
    System.out.println(v1+" "+op+" "+v2+" = "+ result);
    System.out.println("===============================");
  }
  static void compute(){ 
    
    switch(op){
    
    case "+": result = v1+v2; break;   
    case "-": result = v1-v2;  break;  
    case "*": result = v1*v2; break;   
    case "/": result = v1/v2;  break;         
    default:
      System.out.println("연산자를 잘못 입력하셨습니다.!!!!!!!!");
      
    }
   
  }
  public static void main(String[] args) {
    
   
     
    Scanner scanner= new Scanner(System.in);
    System.out.printf("값1? ");
    v1=Integer.parseInt(scanner.nextLine());
    System.out.printf("값2? ");
    v2=Integer.parseInt(scanner.nextLine());
    System.out.printf("연산자? ");
    op=scanner.nextLine();

   compute();
    //메소드 호출
    displayResult();
    
  

  }
//void : 리턴하는 결과가 없다.
  

}
