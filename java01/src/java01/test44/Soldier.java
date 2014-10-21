package java01.test44;

public class Soldier extends Mover {
  int attack;
  int level;
  
  //mover로 부터 move() 매소드를 
  // 서브 클래스에 역활에 맞게 재정의 하는것 => 오버라이팅
  //문법 :재정의 하려는 클래스와 같은 시그너쳐(signature)을 갖는 메서드를 만들어라.
  //      단 공개 범위는 축소되어서는 안된다.
  //      파라미터 변수의이름은 달라도 상관없다.
  //signature란? 메서드의 이름과 리턴타입, 파라미터타입을 말함.
  // C언어에서는 function prototype 이라 부른다.
  
  //슈퍼클래스의 메서드를 재정의 하는지 검사하라고 컴파일러에게 지시함.
  @Override 
  public void move(int dir){
    System.out.println("뚜벅뚜벅 걷는다~!!!!!힘들다..무겁다..집가고싶어"
        + "엄마가 보고싶다.....");
    x +=10;
    
  }
}
