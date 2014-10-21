package java01.test39;

public class Test39 {
  public static void main(String[] args) {
    
     //new Score();
    //1) new Score ; Score 클래스에 정의돈 인스턴스 변수를 Heap에 준비한다.
    //2) (): 호출할 생성자를 선택하는 명령어
    //       값을 안줬죠?
    //         생성자 중에서 파라미터 값을 받지 않는 생성자(기본생성자)를 호출하라.
    //생성자는 나중에 따로 호출할 수 있다.
    //반드시 new 명령 다음에 즉시 호출해야 한다.
    
    Score s = new Score("홍길동",100,100,90);
    Score s2 = new Score();
    s2.name = "임꺽정";
    s2.kor = 90;
    s2.eng = 90;
    s2.math = 90;
    s2.compute();
    

    System.out.println("-----------------------------------------" );
    System.out.println("이름 : " + s.name);
    System.out.println("국어 : " + s.kor);
    System.out.println("영어 : " + s.eng);
    System.out.println("수학 : " + s.math);
    System.out.println("총점 : " + s.sum);
    System.out.println("평균 : " + s.average);
    System.out.println("-----------------------------------------" );
    System.out.println("이름 : " + s2.name);
    System.out.println("국어 : " + s2.kor);
    System.out.println("영어 : " + s2.eng);
    System.out.println("수학 : " + s2.math);
    System.out.println("총점 : " + s2.sum);
    System.out.println("평균 : " + s2.average);
  }
}
