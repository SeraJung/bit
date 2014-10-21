/* 퀴즈 
 * 1에서 100까지 출력 4의 배수를 출력하라
 * 단 20의 배수일때마다 다음라인으로가라.
 * 20의 배수이지만 60의 배수인 경우에는 @문자열을 출력해
 * for문 사용하기
 */
package java01;

public class Test24 {
  public static void main(String[] args) {
    for(int i=0;i<=100;i=i+4){    
       if(i==0){
         System.out.printf("");}
       else{
       System.out.printf("%d   ", i);
        if(i%20 == 0){
          System.out.println();
          if(i%60  == 0){
           System.out.print("@");
          }
        }
       }
    }
  }
  
  }


