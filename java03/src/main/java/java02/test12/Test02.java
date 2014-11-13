/* 특정 명령어 블록을 스레드로 분리하기
 1) Thread 클래스를 상속받아 만들기.
 2) Runnable 인터페이스 구현하기.
 
 */
package java02.test12;

public class Test02 {
  //q방법1. 스래드 상송받아 만들기.
  static class MyThread extends Thread{
    //병행으로 수행할 명령어는 run() 메소드에 넣는다.
    @Override
    public void run() {
      for( int i = 0 ; i< 1000 ; i++){
        double d = 3.14;
        d /= 12.56;
        System.out.println("> " + i);
      }
    }
  }
  //2. runable  인터페이스 구현
  //이 객체는 바로 실행 할 수 없고, Thread 객체를 통해 실행 시킨다.
  
  static class MyRunnable implements Runnable{
    //병행으로 수행할 명령어는 run() 메소드에 넣는다.
    @Override
    public void run() {
      for( int i = 0 ; i< 1000 ; i++){
        double d = 3.14;
        d /= 12.56;
        System.out.println("@@ " + i);
      }
    }
  }

  public static void main(String[] args) {
    for (int i = 0; i< 1000 ; i++){
      double d = 3.14;
      d /= 12.56;
      System.out.println("main: " + i);
    }
    
    MyThread t = new MyThread();
    t.start();
    
    Thread t2 = new Thread(new MyRunnable())  ;
    t2.start();
   
    for (int i = 0; i< 1000 ; i++){

      double d = 3.14;
      d /= 12.56;
      System.out.println("main2: " + i);
    }
  }

}
