package java02.test13;

import java.io.*;

//만약 다른 패키지라면 다음과 같이 임포트 문을 작성한다.
//import java02.test13.Test01;

//static inner class import
//방법1. 정확하게 모든 정보를 지정한다.
// 예) 패키지명,.패키지명.바깥클래스명.중첩클래스명;
//import java02.test13.Test01.TopLevelInnerClass;

//방법2. import static 구문을 사용하여 static 맴버를 모두 지정하기.
import static java02.test13.Test01.*;
public class InnerClassUser {

  public static void main(String[] args) {
    // 1.다른클래스의 Top level inner class 사용법.
    // 방법1.
    Test01.TopLevelInnerClass p = new Test01.TopLevelInnerClass();
    
    // 방법2.
    // satic 클래스를 import 하여 사용하기
    TopLevelInnerClass p2 = new TopLevelInnerClass();
    
    //2.다른클래스의 member inner class 사용하기
    Test01.MemberInnerClass p3 = null;
    //멤버이너클래스는 static 멤버가 아니기 때문에 
    // 클래스 이름으로 접근할 수 없다.
    // 예외 : 참조 변수는 선언할 때는 => 바깥 클래스명.멤버이너클래스명
    //p3 = new Test01.MemberInnerClass(); // error
    
    //member inner class 를 사용하려면 바깥 클래스의 인스턴스가 필요하다.
    //=> 인스턴스매서드를 호출하려면 인스턴스가 필요하듯이!~!
    Test01 outer = new Test01();
    p3 = outer.new MemberInnerClass(); //참 괴상하다! => 결론:잘 안쓴다.

  }

}
