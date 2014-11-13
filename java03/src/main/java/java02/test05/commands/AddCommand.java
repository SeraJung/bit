/* 명령을 처리하는 매서드를 별도의 클래스 분리 -> command패턴
 * 새로운 멸영어를 추가하더라도 기존코드르 손대지 않고
 * 명ㄹ영을 처리하는 새도르르 클래스도 만든다.
 * 클래스는 외부 파일이기 때문에 추가하기 슆ㅂ다.
 */
package java02.test05.commands;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java02.test05.Command;
import java02.test05.Score;
import java02.test05.ScoreDao;

public class AddCommand implements Command {

  public String getCommandInfo() {
    return "add";
  }

  public void service(Map<String, Object> params) throws Exception {
    ScoreDao scoreDao = (ScoreDao)params.get("scoreDao");
    @SuppressWarnings("unchecked")
    ArrayList<String> options = (ArrayList<String>)params.get("options");
    
    Score score = new Score(options.get(0),
        Integer.parseInt(options.get(1)), 
        Integer.parseInt(options.get(2)), 
        Integer.parseInt(options.get(3)));
         scoreDao.add(score);
         System.out.println("저장되었습니다.");   

  }

}
