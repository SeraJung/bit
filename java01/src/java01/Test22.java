/* 퀴즈 
 * 1에서 100까지 출력 4의 배수를 출력하라
 * 단 20의 배수일때마다 다음라인으로가라.
 * 20의 배수이지만 60의 배수인 경우에는 @문자열을 출력해
 */
package java01;

public class Test22 {
  public static void main(String[] args) {
    long startMilliSec=System.currentTimeMillis();
    int i=1;
    do{
      if(i%4 ==0){        
        System.out.printf("%d   ", i);
        if(i%20 == 0){
          System.out.println();
          if(i%60  == 0){
           System.out.print("@");
          }
        }
       }
      i++;
    }while(i < 210000);
  
    
    long endMilliSec=System.currentTimeMillis(); //시간확인
    System.out.println(endMilliSec-startMilliSec);
  }

}
