package java01;
/** 자바문서 주석
 *  - javadoc 개발 도구를 통해서 HTL 문서를 만들때 사용하는 주석
 *  - javadoc은 소스 파일에서 자바 문서 주석 을 추출하여  HTML을생성
 *  - '@'키워드를 통해 HTML문서에 특별한 문장을 생성할 수 있다.
 *  - 바이트코드에는 포함되지 않는다.
 *  @author bit
 */

public class Test05 {
  /*
   * 애노테이션 
   * - 컴파일러나 JVM이 사용하는 아주 특별한 주석
   * - 문법 : @키워드(변수=값,변수=값...)
   * - 주석 유지 범위 : 
   *  1) SOURCE => 컴파일 이후 버려짐, 클래스 파일에 포함하지 않는다.
   *  2) CLASS  => 클래스 파일에 포함됨. 단, JVM이 사용할수 없다.
   *  3) RUNTIME => 클래스 파일에포함됨. 단 JVM이 꺼낼수 있다.
   *                  즉, 실행 중에 클래스 파일에 있는 주석을 꺼내 볼 수 있다.  
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return super.toString();
  }
  public static void main(String[] args) {
 
  }  
}
