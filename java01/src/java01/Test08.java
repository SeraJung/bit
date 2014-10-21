/* 정수변수
 * byte(1): -128 ~ 127
 * short(2): -32768~32767
 * int(4): 약-21억 ~21억
 * long(8): 약 -922경 ~ 922경
 *  */
package java01;

public class Test08 {

  public static void main(String[] args) {
    byte minByte=-128, maxByte=127;
    short minShort=-32768, maxShort=32767;
    int minInt=-2147483648,maxInt=2147483647;
    long minLong=Long.MIN_VALUE;
    long maxlong=Long.MAX_VALUE;
    
     //메모리의 크기보다 값이 더 크면 오류 발생
    //minByte=-129;
    //maxByte=128
    
    //정확한 오류 내용확인
    //Literal : 정수 리터럴 =>4바이트 정수값, 8바이트 정수값
    //10,20 <=4바이트정수
    //10L,20; <=8바이트 정수
    
    //1. 상수 값이 int(4)타입이라도 메모리에 저장할 수 있으면 허락한다.
    //
    byte b=127; //허락
    
    //2. 상수 값을 메모리에 저장할 수 없으면 원래대로 오류를 발생한다.
    //byte b2=128// 오류내용은 int를 byte 메모리에 저장할 수 없다.
     //short s=32768;
    
    //byte b3=30L;//에러 왜냐면 8바이트 상수값이기때문에
    //short s2=30L// 이와 같은 이유임
    //int i2= 30L//위와 같은 이유
    long l=30L;
  }

}
