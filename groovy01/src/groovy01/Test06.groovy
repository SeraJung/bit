/*Arraylist 다루기 */
package groovy01


  scoreList = ["홍길동",100,90,80];// ArrayList 객체 생성
  println scoreList[2]
  println scoreList[0]
  println scoreList.get(0)
  println scoreList.size()
  
  emptyList = []
  println emptyList.size()
  println "--------------------"
  
  //맵사용
  scoreMap = ["name":"홍길동",
     "kor":100,
     "eng":90,
     "math":80]
  
  println scoreMap["name"]
  println scoreMap.name
  println scoreMap.getClass()
  
  scoreMap["kor"] = 50
  scoreMap.eng = 60
  println scoreMap.kor
  println scoreMap["eng"]
  
  emptyMap = [:]
  println emptyList.getClass()
  println emptyMap.getClass()
  println "------------------------"

