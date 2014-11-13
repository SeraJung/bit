/* 데이터 보관처리
 * File I/O API를 사용하여 데이터를 저장하고 꺼낸다.
 * load(), save() 메서드 준비
 * 
 - CSV(comma seperated value)  문자열을 가지고 객체를 초기화할 수 있도록
 Score13 생성자 추가한다.
 */
package java02.test05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import java02.test05.commands.AddCommand;
import java02.test05.commands.DeleteCommand;
import java02.test05.commands.ExitCommand;
import java02.test05.commands.HelpCommand;
import java02.test05.commands.ListCommand;
import java02.test05.commands.UpdateCommand;
import java02.test05.commands.ViewCommand;

public class Test01 {
  static Scanner scanner; 
  static ScoreDao scoreDao;

  // Entity 클래스 => 사용자(개발자) 정의 데이터 타입 
  public static void main(String[] args) {
    //명령어를 처리할 객체를 담아둔 맵
    HashMap<String, Command> commandMap = new HashMap<String, Command>();
    
    commandMap.put("list", new ListCommand());
    commandMap.put("help", new HelpCommand());
    commandMap.put("add", new AddCommand());
    commandMap.put("view", new ViewCommand());
    commandMap.put("delete", new DeleteCommand());
    commandMap.put("update", new UpdateCommand());
    commandMap.put("exit", new ExitCommand());
    
    scoreDao = new ScoreDao(); 
    try{     
      scoreDao.load();
    }catch(Exception e){
      System.out.println("데이터 로딩 중 오류가 발생하였습니다.");
    }
    scanner = new Scanner(System.in);
    Command command = null;
    loop: 
      
    while (true) {
      try {
        String[] token = promptCommand();
        command = commandMap.get(token[0]);
        
        if(command == null){
          System.out.println("해당 명령어를 지원하지 않습니다.");
          continue;
        }
        HashMap<String, Object> params = 
            new HashMap<String, Object>();
        params.put("scoreDao",scoreDao);
        params.put("scanner", scanner);
        ArrayList<String> options = new ArrayList<String>();
        for(int i = 1 ; i < token.length; i++){
          options.add(token[i]);
        }        
        params.put("options", options);   
        
        command.service(params);
        if(token[0].equals("exit"))
          break loop;
        //System.out.println("이 명령어를 지원하지 않습니다.");
      
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("명령어 처리 중 오류 발생. 다시 시도해 주세요.");
      }
    }
    scanner.close();


  }
  private static String[] promptCommand() {
    System.out.print("명령>");
    String[] token = scanner.nextLine().split(" ");
    return token;
  }
}







