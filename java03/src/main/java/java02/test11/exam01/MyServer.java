/* 여러 클라이언트와 대화 나누기 ?
 => 동시에 대화 나누는 것이 불가능.
 */
package java02.test11.exam01;


import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {
  static Scanner keyboard = new Scanner(System.in);
  public static void main(String[] args) throws Exception {
    
    System.out.println("서버소켓생성");
    ServerSocket ss = new ServerSocket(8888, 2);
    System.out.println(" 클라이언트와 연결 기다리중");
    //클라이언트와 연결이 종료되면 대기열의 다른 클라이언트와 연결한다.
    //다만, 코딩한 바와 같이 순차적으로 실행한다.
    //
    while(true){     

      Socket socket = ss.accept();
      System.out.println("대기중에 있는 클라이언트와 연결됨");

      Scanner in = new Scanner(socket.getInputStream());
      PrintStream out = new PrintStream(socket.getOutputStream());

      String line = null;
      String massage = null;
      while(true){
        line = in.nextLine();    
        System.out.println(line); 

        if(line.equalsIgnoreCase("quit")){
          out.println("goodbye");
          break;        
        }
        massage = prompt();
        out.println(massage);

      }

      in.close();
      out.close();
      socket.close();
    }
    //ss.close();
    //keyboard.close();
  }

  private static String prompt() {
    System.out.println(">");
    String message = keyboard.nextLine();
    return message;
  }

}
