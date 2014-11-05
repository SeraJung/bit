/* 클러이언톼와 여러번 데이터 주고 받기.
 */
package java02.test11.exam01;


import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer03 {
  static Scanner keyboard = new Scanner(System.in);
  public static void main(String[] args) throws Exception {
    
    System.out.println("서버소켓생성");
    
    ServerSocket ss = new ServerSocket(8888, 1);
    System.out.println(" 클라이언트와 연결 기다리중");
    
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
    ss.close();    
    keyboard.close();

    
  }

  private static String prompt() {
    System.out.println(">");
    String message = keyboard.nextLine();
    return message;
  }

}
