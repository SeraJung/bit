/* 맵에 데이터를 저장할 때 문자열이 아닌
   특별한 객체를 사용
 */
package java01.test49;
import java.util.HashMap;

public class Test49 {
  //map에 데이터를 저장할 때 특수키를 사용하기.
  public static void main(String[] args) {
    MyKey key1 = new MyKey("1234abcd",100,125);
    MyKey key2 = new MyKey("1234abcd",100,125);
    MyKey key7 = new MyKey("123",100,123);
    Integer key3 = new Integer(10);
    Integer key4 = new Integer(10);
        
    String key5 = new String("1234abcd");
    String key6 = new String("1234abcd");
    HashMap 냉장고2 = new HashMap();
    
    //map에 데이터를 저장할 때 원리?
    // 키 객체에 Hash값을 사용해서 저장한다.
    냉장고2.put(key1,"보약");
    
    //키로 냉장고를 열어본다.
    //map에서 값을 꺼낼 때 원리?
    // 1) 저장할 때 사용할 키의 해쉬값이 같은지 조사.
    // 2) equals()를 호출하여 값이 같은지 조사.
    
    System.out.println(냉장고2.get(key2));
    System.out.println(냉장고2.get(key7));
    
    //주소가 다름을 증명
    /*System.out.println("------------");    
    System.out.println("key1 == key2 ? "+(key1 == key2));
    System.out.println("key3 == key4 ? "+(key3 == key4));
    System.out.println("key5 == key6 ? "+(key5 == key6));
    
    System.out.println("------------");    
    System.out.println(key1.hashCode());
    System.out.println(key2.hashCode());
    System.out.println(key3.hashCode());
    System.out.println(key4.hashCode());
    System.out.println(key5.hashCode());
    System.out.println(key6.hashCode());*/
    
    /*왜 Integer 객체와 String 객체의 해시 값이 같을까?
     =  Object에서 상속 받은 원래 매소드는 인스턴스가 다르면
         해시 값도 다르도록 프로그램 되어 있다.
     - 그런데, Integer 클래스와 랩퍼클래스(byte,integer...)는
       상속받은 hashCode()를 재정의 하였다.
       => 비록 인스턴스가 다르더라도 값이 같다면 같은 해시 값을 리턴하도록 
         재정의한 것이다.
    */
    
    
    //equals() 리턴값 조사.
    System.out.println("------------");    
    System.out.println("key1.equals(key2) ? "+key1.equals(key2));
    System.out.println("key3.equals(key4) ? "+key3.equals(key4));
    System.out.println("key5.equals(key6) ? "+key5.equals(key6));    
    
    
  }
  //Map에 데이터를 저장할 때 문자열을 키로 사용하기
  public static void main01(String[] args) {
    HashMap studentMap = new HashMap();
    //배열은 보관된 인덱스를 사용하지만 맵은 값을 사용한다...
    studentMap.put("s001", new Student("홍길동",10));
    studentMap.put("s002", new Student("임꺽정",10));
    
    System.out.println(studentMap.get("s001"));
    System.out.println(studentMap.get("s002"));
  
  }

}
