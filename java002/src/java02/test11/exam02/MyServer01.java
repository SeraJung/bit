/* 클라이언트의 요청을 처리하는 코드를 스레드로 분리
 */
package java02.test11.exam02;


import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer01 {
  static Scanner keyboard = new Scanner(System.in);

  static class ChatSkeleton implements Runnable{
    Socket socket;
    Scanner in;
    PrintStream out;

    public ChatSkeleton(Socket socket) throws Exception{
      this.socket = socket;
      in = new Scanner(socket.getInputStream());
      out = new PrintStream(socket.getOutputStream());
    }
    @Override
    public void run() {
      try{
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
      }catch (Exception e){
        System.out.println("클라이언트와 통신 중 오류 발생!");    

      }finally{
        try{in.close();}catch (Exception e){}
        try{out.close();}catch (Exception ex){}
        try{socket.close();}catch (Exception ex){}

      }
    }
  }
  public static void main(String[] args) throws Exception {

    System.out.println("서버소켓생성");
    ServerSocket ss = new ServerSocket(8888, 2);
    System.out.println(" 클라이언트와 연결 기다리중");
    
    
    while(true){     

      Socket socket = ss.accept();
      System.out.println("대기중에 있는 클라이언트와 연결됨");

      new Thread(new ChatSkeleton(socket)).start();
      
     /* 
      ChatSkeleton chat = new ChatSkeleton(socket);
      Thread t = new Thread(chat);
      t.start();
     */

    }
    
  }

  private static String prompt() {
    System.out.println(">");
    String message = keyboard.nextLine();
    return message;
  }

}
