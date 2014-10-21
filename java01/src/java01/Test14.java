/* garbage와 garbage collector
 * Garbage? 참조 하는 변수가 없는 메모리
 * Garbage Collector? garbage의 메모리를 해제하는 객체
 */
package java01;

public class Test14 {

  public static void main(String[] args) {
    int[] a= new int[]{};
    a[0]=7;
    a[1]=7;
    a[2]=7;
    a[3]=7;
    a[4]=7;
    for(int i=0;i<a.length;i++){
      System.out.println(a[i]);
    }
    
    // TODO Auto-generated method stub
    int[] p= new int[5];// 예) 배열의 주소가 100번지라고 하자!
    int[] p2= new int[3]; //예) 배열의 주소가 200번지라고 하자
    int[] p3=p;// 예) 배열의 주소가 100번지.
    
    p3[2]=100;
    System.out.println(p3[2]);
    System.out.println(p[2]);
     
    p2=p;// p2는 100번지 => 200번지의 주소를 잃어 버렸기 때문에
         // 해당 배열은 garbage가 된
    //200번지 배열의 주소는 누가 같고있는가?
    //갖고잇는 변수가 없다.=> 200번지 배열은 쓰레기(Garbage)가 되었다.
    //Garbage는 언제 청소하는가? (사용될수 없는 메모리 해제 시점).
    //1)idle time
    //2)memory가 부족할때
    //3)garbage Collector가 관리하는 메모리 영역은 Heap이다. 
    //* 잠깐 실행하는 경우는 garbage collector가 동작하지 않는다.
    //garbage가 생겼다고 garbage Collector가 즉시 동작하는 것이 아니다!
    //실무에서는 가비지 생성을 최소화 하도록 프로그래밍을 한다.

  }

}
/* JVM이 메모리를 관리하는 방법
 * 
 * 
 * 
 * 
 * 
 */
