package java02.test07.epsode.step02;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* 애노테이션을 정의할 때 반드시 그 정책을 지정하라.
 - @Retention(유지범위)
   유지범위
   1) source : 일반 주석과 같다. .class파일에는 없다.
   2) CLASS : .class 파일에는 주석이 존재한다. 
              다만, JVM에서는 읽을 수 없다.
              즉, JVM이 클래스를 로딩할 때 이 애노테이션은 로딩 하지 않는다.
   3) RUMTIME : .class 파일에 주석이 존재한다. JVM에서 읽을 수 있다.
               JVM이 클래스를 로딩할 때 이 애노테이션 값도 같이 로딩한다.
               즉, 프로그램을 실행하는 중에 클래스에 있는 주석을 꺼낼 수 있다.
 */

/* 실행 중에 꺼내 쓸 애노테이션의 형식을 정의한다 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
  String value();
  String name();
  
  //값을 설정하지 않아도 기본으로 갖는 값. => 선택속성
  //즉, 애노테이션을 사용 할 때 값을 주지 않아도 되는 속성
  
  String country() default "korea";
  
  int age();
  
  String[] language();
  
  
}
