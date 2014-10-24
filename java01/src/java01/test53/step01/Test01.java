/* 1단계
 - 하드코드되어있는 데이터를 순차적으로 출력하기.
 
   
 */
package java01.test53.step01;

import java01.test53.step02.Iterator;

public class Test01 {

  public static void main(String[] args) {
   String[] data = {"홍길동","임꺽정","유관순","안중근","윤봉길","안창호"};
   Iterator iterator = new Iterator(data);
   while(iterator.hasNext()){
     System.out.println(iterator.next());
   }
  }

}
