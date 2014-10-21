/* 사용자 정의 데이터 타입 + 연산자 추가
 - 클래스의 속성 값을 다루는 연산자를 정의하는 방법  =>
 */
package java01.test37;

//Score : 학생의 이름과, 국어, 영어, 수학, 평균, 합계를 저장하는
///         메모리의 데이터 형이다.

public class Score {
  String name; // 인스턴스 변수. 속성(attribute)
  int kor;
  int eng, math, sum;
  float average;
  
  public void compute(){
    this.sum = this.kor+this.eng + this.math;
  }
}
