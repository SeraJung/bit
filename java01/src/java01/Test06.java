/* 변수선언
 -변수란? 값을 저장하는 메모리
 -문법: [변수의 유형] [변수명];
 -예 : byte b; int i;
 
 값 할당 : 변수(메모리에)값을 저장하기
 변수명 = 값;
 '='을 할당(assignment) 연산자라고 부름.
 -'=='equal 연산자
 */
package java01;

public class Test06 {
  public static void main(String[] args) {
    byte i;
    
    i = 20;
    //같은 유형의 메모리를 여러개 생성
    byte b1,b2,b3;
    
    //같은유형의 메모리를 여러개생성+값 할당 => 초기화 문장
    byte b4=20,b5=30,b6=60;
    
    //변수의 값을 꺼내기 전에 반드시 초기화 해야 한다.
    byte b7;
    //System.out.printf(b7);//초기화 되지 않은 변수를 사용하면 컴파일 오류
    
    
  }

}
/*
 * 10 <=(4바이트 정수)
 * 10L or 10l <-(8바이트 정수)
 * 10F or 10f <-(4바이트 부동소수점)
 *  10.20 ->8Byte 부동소수점
 *  true or false
 */