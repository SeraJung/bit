package java02.test16.command;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java02.test16.Member;
import java02.test16.MemberDao;
import java02.test16.annotation.Command;
import java02.test16.annotation.Component;

@Component
public class MemberCommand {
  MemberDao memberDao;
  Scanner scanner;
  
  public void setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
  }
  
  public void setScanner(Scanner scanner) {
    this.scanner = scanner;
  }
  
  @Command("add")
  public void add(Map<String, Object> params) {
    Member member = new Member();
    String text = null;
    
    System.out.print("아이디:");
    member.setId(scanner.nextLine());
    
    System.out.print("비밀번호:");
    member.setPassword(scanner.nextLine());
    
    System.out.print("이메일:");
    member.setEmail(scanner.nextLine());
    
    System.out.print("이름:");
    member.setName(scanner.nextLine());
    
    System.out.print("전화번호:");
    member.setTel(scanner.nextLine());
    
    System.out.print("팩스번호:");
    text = scanner.nextLine();
    if(text.equals(" "))
      member.setFax(null);
    member.setFax(text);  
    
    System.out.print("자세한 주소:");
    text = scanner.nextLine();
    if(text.equals(" "))
      member.setDet_addr(null);
    member.setDet_addr(text);   
    
    System.out.print("사진:");
    text = scanner.nextLine();
    if(text.equals(" "))
      member.setPhoto(null);
    member.setPhoto(text);
    
    System.out.print("주소번호:");
    text = scanner.nextLine();
    if(text.equals(" "))
      member.setAddrNo(0);
    member.setAddrNo(Integer.parseInt(text));
    
    memberDao.insert(member);
    System.out.println("저장하였습니다.");
  }
  
  @Command("delete")
  public void delete(Map<String, Object> params) {
    @SuppressWarnings("unchecked")
    ArrayList<String> options = 
        (ArrayList<String>)params.get("options");
    
    String id = options.get(0);
    
    Member member = memberDao.selectOne(id);
    if (member == null) {
      System.out.println("해당 번호의 제품 정보를 찾을 수 없습니다.");
      return;
    }
    
    System.out.print(member.getName() + "을 삭제하시겠습니까?(y/n)");
    if (scanner.nextLine().equalsIgnoreCase("y")) {
      memberDao.delete(id);
      System.out.println("삭제하였습니다.");
    } else {
      System.out.println("삭제 취소하였습니다.");
    }
  }
  
  @Command("list")
  public void list(Map<String, Object> params) {
    for (Member member : memberDao.selectList()) {
      System.out.printf("%-10s %-20s %-30s %-20s \n", 
          member.getId(), 
          member.getEmail(), 
          member.getName(), 
          member.getTel());
    }
  }
  
  @Command("update")
  public void update(Map<String, Object> params) {
    @SuppressWarnings("unchecked")
    ArrayList<String> options = 
        (ArrayList<String>)params.get("options");
    
    String id =options.get(0);
    
    Member member = memberDao.selectOne(id);
    if (member == null) {
      System.out.println("해당 id의 회원 정보를 찾을 수 없습니다.");
      return;
    }
    
    Member tempMember = null;
    
    try {
      tempMember = member.clone();
    } catch (CloneNotSupportedException ex) {
      throw new RuntimeException(ex);
    }
    
    String text = null;
    System.out.printf("비밀번호(%s):", member.getPassword());
    text = scanner.nextLine();
    if (text.length() > 0)
      tempMember.setPassword(text);
    
    System.out.printf("이메일(%s):", member.getEmail());
    text = scanner.nextLine();
    if (text.length() > 0)
      tempMember.setEmail(text);
    System.out.printf("이름(%s):", member.getName());
    text = scanner.nextLine();
    if (text.length() > 0)
      tempMember.setName(text);
    
    System.out.printf("전화번호(%s):", member.getTel());
    text = scanner.nextLine();
    if (text.length() > 0)
      tempMember.setTel(text);
    
    System.out.printf("팩스(%s):", member.getFax());
    text = scanner.nextLine();
    if (text.length() > 0)
      tempMember.setFax(text);
    
    System.out.printf("상세주소(%s):", member.getDet_addr());
    text = scanner.nextLine();
    if (text.length() > 0)
      tempMember.setDet_addr(text);
    
    System.out.printf("사진(%s):", member.getPhoto());
    text = scanner.nextLine();
    if (text.length() > 0)
      tempMember.setPhoto(text);
   
    System.out.printf("주소번호(%d):", member.getAddrNo());
    text = scanner.nextLine();
    if (text.length() > 0)
      tempMember.setAddrNo(Integer.parseInt(text));
    
    System.out.print("정말 변경하시겠습니까?(y/n)");
    if (scanner.nextLine().equalsIgnoreCase("y")) {
      memberDao.update(tempMember);
      System.out.println("변경하였습니다.");
    } else {
      System.out.println("변경 취소하였습니다.");
    }
  }
  
  @Command("view")
  public void view(Map<String, Object> params) throws Exception {
    @SuppressWarnings("unchecked")
    ArrayList<String> options = 
        (ArrayList<String>)params.get("options");
    
    String id = options.get(0);
    
    Member member = memberDao.selectOne(id);
    if (member == null) {
      System.out.println("해당 번호의 제품 정보를 찾을 수 없습니다.");
      return;
    }
    
    System.out.println("아이디: " +member.getId() );
    System.out.println("이메일:"+ member.getEmail());
    System.out.println("이름:"+ member.getName());
    System.out.println("전화번호: " + member.getTel());
    System.out.println("팩스: " + member.getFax());
    System.out.println("상세주소: " + member.getDet_addr());
    System.out.println("사진: " + member.getPhoto());
  }
}








