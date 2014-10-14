/* main(): JVM이 클래스를 실행할 때 호출하는 함수
 * - start entry
 * - 다음 소스의 규칙에 따라 작성하라! 
 * 
 * 자바 클래스 실행
 * java -classpath [클래스파일경로지정] 클래스명
 * -만약 클래스가 특정 팩키지에 소속된 멤버라면
 * java -classpath [패키지가 있는 경로] [패키지명.클래스명]
 * 
 * -classpath 대신 -cp라고 해도됨.
 * 
 * 패키지명.클래스명= Fully Qualified Name(QName)
 * 
 *  */
package java01;

public class test03{
  public static void main(String[] args){
    //콘솔창으로 출력
    System.out.print("hello, world! \n");
  }
}
/*quiz:
 * 1)net.java63.test 패키지를 생성하라.
 * 2)이 패키지에 HelloWorld 이름을 갖는 클래스를 생성하라
 * 3) 클래스를 실행하면 다음과 같이 출력되게 작성하라
 *   >나의 첫번째 자바 프로그램
 * 4) 터미널을 사용하여 HelloWorld 클래스를 실행하라.
 */
