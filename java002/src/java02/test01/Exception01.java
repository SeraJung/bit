/* 예외처리를 위한 문법이 없었을 때
 - 메서드의 리턴 값을 통해 호출자에게 예외상황을 알렸다.
 - 따라서 호출자는 늘 리턴값을 검사 해야 했다.
   => 늘 매서드의 리턴 값을 출력하는 if문이 존재
   => 작업 코드와 에러처리 코드가 뒤 섞여 있다.
   => 리턴 값이 때론 실제 계산 결과일 수 있다.
   
 */
package java02.test01;

public class Exception01 {
  public static float divide(float a, float b){
    if(b==0){ //예외상황 발생
      return -999999.0f;//특별한 값을 리턴.
    }
    return a/b;
  }

  public static void main(String[] args) {
    float result = divide(999999,-1);
    if(result != -999999.0f){
      System.out.println("결과는 : "+ result);
    }else {
      System.out.println("계산중, 오류가 발생!");
    }
  }

}
