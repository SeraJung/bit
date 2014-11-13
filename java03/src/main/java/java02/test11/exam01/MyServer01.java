package java02.test11.exam01;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer01 {

  public static void main(String[] args) throws Exception {
    System.out.println("서버소켓생성");
    ServerSocket ss = new ServerSocket(8888);
    System.out.println(" 클라이언트와 연결 기다리중");
    Socket socket = ss.accept();
    System.out.println("대기중에 있는 클라이언트와 연결됨");
    //소켓을 통해 읽고 쓰기 위해 입/출력 스트림 얻기
    
    Scanner in = new Scanner(socket.getInputStream());
    PrintStream out = new PrintStream(socket.getOutputStream());
    //클라이언트가 보낸 문자열 읽기
    //클라이언트에서 한줄의 문자열을 보내기 전까지 리턴하지 않는다.
    //실행이 완료될까지 리턴하지 않는다. == blocking
    String line = in.nextLine();
    
    //클라이언트가 보낸 메세지를 출력
    System.out.println(line);
    
    
  //사용자에게 문자열을 한 줄 입력받은다.
    String massage = prompt();
    //사용자에게 문자열을 한 줄 입력받은 다음, 클라이언트로 보낸다.
    //클라이언트에서 문자열을 모두 받을 때 까지 리턴하지 않는다. = blocking
    //입 /출력은 항상 블로킹으로 다룬다 => 단점 해결 : java non-blocking등장
    out.println(massage);
    
    in.close();
    out.close();
    socket.close();
    ss.close();
    
  }

  private static String prompt() {
    System.out.println(">");
    Scanner keyboard = new Scanner(System.in);
    String message = keyboard.nextLine();
    keyboard.close();
    return message;
  }

}
