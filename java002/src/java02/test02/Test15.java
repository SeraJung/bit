/* Deserialize => 바이트 배열을 통하여 인스턴스 복원.
 - 인스턴스 값을 통째로 출력하기 => ObjectOutputStream
 - 용어
   Serialize(Marshaling) => 바이트 배열로 만드는 것.
   Deserialize(Unmarshaling) => 바이트 배열을 인스턴스로 복원하는것.
 */
package java02.test02;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

//인스턴스 값들을 바이트 배열로 만들려면 Serialize를 허용해야 한다.
// java.io.Serializable 인터페이스를 구현하면 된다.
// Serializable 인터페이스
//  1)메서드가 없다.
// 2) 단지 바이트 배열로 출력할 수 있다는 표시용이다.


public class Test15 {
  /* Test14.java 소스에서 생성한 Score 클래스 사용*/
  
  public static void main(String[] args)throws Exception {
    FileInputStream in = new FileInputStream("test13.dat");
    ObjectInputStream in2 = new ObjectInputStream(in);
    
    Score obj = (Score)in2.readObject();
    
    System.out.println(obj.name);
    System.out.println(obj.kor);
    System.out.println(obj.eng);
    System.out.println(obj.math);
    System.out.println(obj.sum);
    System.out.println(obj.average  );
    
    
    
    in2.close();
    in.close();
  }
}
