/*조건문퀴즈
 -다음과 같이 동작하도록 프로그램을 작성하시요
 java java01.Test18
   당신의 나이가 어떻게 되나요?? 다음 보기에서 고르시오 
   1.10대 2.20대 3.30대 4.40대 5.50대 6.기타
-사용자로부터 키보드 입력 값을 받는 방법
 java.util.Scanner scanner= new java.util.Scanner(System.in);
 String input=scanner.nextLine();
 스위치문 사용하셈
 */
package java01;

public class Test18 {

  public static void main(String[] args) {
    
    System.out.println("당신의 나이가 어떻게 되나요?? 다음 보기에서 고르세요");
    System.out.println("1) 10대 2) 20대 3) 30대 4) 40대 5) 50대 6)기타 ");
    System.out.println("아래에 입력해 주세요~~~!!! ");
    java.util.Scanner scanner= new java.util.Scanner(System.in);
    String input=scanner.nextLine();
    //System.out.println(input);
    int age=Integer.parseInt(input);
    switch(age){
    case 1:
      System.out.println("10대입니다.");
      break;
    case 2:
      System.out.println("20대입니다.");
      break;
    case 3:
      System.out.println("30대입니다.");
      break;
    case 4:
      System.out.println("40대입니다.");
      break;
    case 5:
      System.out.println("50대입니다.");
      break;
    default:
      System.out.println("기타 입니다.");
             
    }
    
  }

}
