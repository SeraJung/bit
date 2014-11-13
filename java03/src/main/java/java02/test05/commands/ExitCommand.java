/* 명령을 처리하는 매서드를 별도의 클래스 분리 -> command패턴
 * 새로운 멸영어를 추가하더라도 기존코드르 손대지 않고
 * 명ㄹ영을 처리하는 새도르르 클래스도 만든다.
 * 클래스는 외부 파일이기 때문에 추가하기 슆ㅂ다.
 */
package java02.test05.commands;

import java.util.Map;
import java02.test05.Command;
import java02.test05.ScoreDao;

public class ExitCommand implements Command {

  public String getCommandInfo() {
    return "exit";
  }

  public void service(Map<String, Object> params) throws Exception {
    try{
      ScoreDao scoreDao = (ScoreDao)params.get("scoreDao");
      scoreDao.save();
    }catch(Exception e){
      System.out.println("데이터 저장 중 오류가 발생 했습니다.");
    }

  }

}
