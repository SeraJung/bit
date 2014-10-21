/* 형변환
 - 정의 : 다른 데이터 형의 임시 메모리를 만들고 값을 복사하는 것.
 - 명시적 형변환(explicit Type conversion) : 명령어를 사용하여 형변환을 지정하는 것.
  (임시메모리의 데이터형) 값;
  예)
  int i =10;
  byte b = (byte )i;
 - 암시적 형변환 : JVM이 내부 규칙에따라 자동으로 형 변환;
 -
 */
package java01;

public class Test34 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int i=10;
    //l-value, r-value?
    //- 할당 연산자를 기준으로 왼쪽의 메모리를 l-value라 한다.
    //- 할당 연산자를 기준으로 오른쪽의 상수 값이나 변수를 r-value라 한다.
    //- l-value는 반드시 메모리여야 하고
    //- r-value는 메모리 또는 상수 값이다.
    
    //비록 상수값이 4바이트 정수이지만, 메모리(l-value)에 넣을 수 있으면 허락한다.
    byte b=10;
    
    //상수가 아닌 경우는 값을 l-value에 넣을 수 있다 하더라도 허락하지 않는다.
    //허락하지 않는다.
    //byte b2=i;// 오류
    
    //해결책!!
    // r-value을 강제로 l-value에 넣는 방법
    // l-value = (데이터형)r-value;
    // 단, r-value가 l-value 온전히 저장될 수 있다는 확신이 필요.
    byte b3=(byte)i;
    //i는 10이란 값이기 대문에 1 바이트로 만들어 b3에 넣더라도 문제없다.
    
    //그러나 다음의 경우를 조심해야 한다.
    int i2= 256;
    byte b4=(byte)i2;
    //JVM은 i2의 값에서 상위 3바이트를 날리고 마지막 바이트를 b4에 넣는다.
    //이것이 문제이다.
    
    System.out.println(b4);

  }

}
