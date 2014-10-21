/* Wrapper class
 - 기본 데이터형(primitive date Type)의 값을 좀 더 다양하게 다룰 수 있도록
   자바에서는 기본형에 대응하는 클래스를 제공한다.=> 이것을 랩퍼클래스라함
   byte=> java.lang.Byte
   short=> java.lang.Short
   int라는 기본형에 대해서  java.lang.Integer
   long => java.lang.Long
   float=> java.lang.Float
   double=> java.lang.Double
   boolean=> java.lang.Boolean
   char=> java.lang.Character
 */
package java01;

public class Test32 {
  public static void main(String[] args) {
    // 클래스를 지정할 때에는 반드시 패키지 이름을 적아야한다.
    // 단 java.lang 패키지만 안 적어도 된다.
    // 그러나 java.lang의 하위 패키지는 적어야 한다.
    byte pb=20;
    Byte b = new Byte(pb);
    
    short ps=20;
    Short s = new Short(pb);
    
    Integer i= new Integer(30);
    Long l = new Long(40);
    Float f = new Float(50);
    Double d = new Double(60);
    Boolean bool= new Boolean(true);
    Character ch= new Character('A');
    
    
    
    
    
  
  }
}
