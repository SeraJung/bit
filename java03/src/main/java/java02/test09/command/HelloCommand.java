package java02.test09.command;

import java.util.Map;
import java02.test09.annotation.Command;

public class HelloCommand  {

  @Command
  public void service(Map<String, Object> params) throws Exception {
    System.out.println("안녕하세요");
  }

}
