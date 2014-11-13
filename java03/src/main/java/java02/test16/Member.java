/* Value Object
 * => Class 문법을 사용하여 사용자 정의 데이터 타입 만들기
 * 
 * 1) Serializable 인터페이스 구현
 *    => SerialVersionUID 스태틱 변수 선언
 * 
 * 2) 인스턴스 변수 선언
 * 
 * 3) setter/getter 생성
 * 
 * 4) 기본 생성자와 파라미터 값을 받는 생성자 선언
 * 
 * 5) equals()/hashCode() 메서드 오버라이딩
 * 
 * 6) toString() 오버라이딩
 */
package java02.test16;

import java.io.Serializable;

public class Member implements Serializable, Cloneable {
  private static final long serialVersionUID = 1L;
  
  protected String    id;
  protected String    password;
  protected String    email;
  protected String    name;
  protected String    tel;
  protected String    fax;
  protected String    det_addr;
  protected String    photo;
  protected int      addrNo;
  
  public Member() {}
  

  public Member(String id, String password, String email, String name,
      String tel, String fax, String det_addr, String photo, int addrNo) {
    super();
    this.id = id;
    this.password = password;
    this.email = email;
    this.name = name;
    this.tel = tel;
    this.fax = fax;
    this.det_addr = det_addr;
    this.photo = photo;
    this.addrNo = addrNo;
  }


  @Override
  public Member clone() throws CloneNotSupportedException {
    return (Member) super.clone();
  }


  @Override
  public String toString() {
    return "Member [id=" + id + ", password=" + password + ", email=" + email
        + ", name=" + name + ", tel=" + tel + ", fax=" + fax + ", det_addr="
        + det_addr + ", photo=" + photo + ", addrNo=" + addrNo + "]";
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + addrNo;
    result = prime * result + ((det_addr == null) ? 0 : det_addr.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((fax == null) ? 0 : fax.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((password == null) ? 0 : password.hashCode());
    result = prime * result + ((photo == null) ? 0 : photo.hashCode());
    result = prime * result + ((tel == null) ? 0 : tel.hashCode());
    return result;
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Member other = (Member) obj;
    if (addrNo != other.addrNo)
      return false;
    if (det_addr == null) {
      if (other.det_addr != null)
        return false;
    } else if (!det_addr.equals(other.det_addr))
      return false;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    if (fax == null) {
      if (other.fax != null)
        return false;
    } else if (!fax.equals(other.fax))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (password == null) {
      if (other.password != null)
        return false;
    } else if (!password.equals(other.password))
      return false;
    if (photo == null) {
      if (other.photo != null)
        return false;
    } else if (!photo.equals(other.photo))
      return false;
    if (tel == null) {
      if (other.tel != null)
        return false;
    } else if (!tel.equals(other.tel))
      return false;
    return true;
  }


  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public String getPassword() {
    return password;
  }


  public void setPassword(String password) {
    this.password = password;
  }


  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    this.email = email;
  }


  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public String getTel() {
    return tel;
  }


  public void setTel(String tel) {
    this.tel = tel;
  }


  public String getFax() {
    return fax;
  }


  public void setFax(String fax) {
    this.fax = fax;
  }


  public String getDet_addr() {
    return det_addr;
  }


  public void setDet_addr(String det_addr) {
    this.det_addr = det_addr;
  }


  public String getPhoto() {
    return photo;
  }


  public void setPhoto(String photo) {
    this.photo = photo;
  }


  public int getAddrNo() {
    return addrNo;
  }


  public void setAddrNo(int addrNo) {
    this.addrNo = addrNo;
  }


  
  
 
  
  
}













