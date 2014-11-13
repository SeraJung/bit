Gradle 프로젝트 폴더 구조
src/
src/main => 애플리케이션 기본 소스
src/mian/java => 자바 소스
src/main/resources => .xml, .properties 등 파일
src/main/webapp => .html, .css, .js, .gif등 웹 관련 파일

src/test => JUnit 등 단위 테스트를 수행할 소스
src/test/main
src/test/resource

build/ => 컴파일된 파일드
.gradle => 그래들 설정 파일 및 의존 라이브러리 파일들

bulid.gradle => groovy로 작성된 빌드 설정 파일

*주의
.project 파일에 Gradle을 사용한다고 설정해야만
메뉴에서 그래들 관련 명령을 실행할 수 있다.

<nature>org.springsource.ide.eclipse.gradle.core.nature</nature>

[그래들 빌드하기]
1.그래들 빌들 실행
1) 컴파일 하기
project > 컨텍스트 메뉴 > Run AS > Gradle Build.. 클릭

2. build.gradle설정
1) java 그래들 플러그인 임포트
apply plugin: 'java'

[그래들 java 플러그인 명령어]
1.clean
- build 폴더를 제거한다.

2.compileJava
- /src/main/java 소스파일 컴파일
- /build/classes/main 폴더에 클래스 파일 복사.

3.compileTestJava
- /src/test/java 소스파일 컴파일
- /build/classes/test 폴더에 클래스 파일 복사.

4.processResource
- /src/main/resources 폴더의 모든 파일을
   /build/resources/main 폴더에 복사한다.
   
5.processResource
- /src/test/resources 폴더의 모든 파일을
   /build/resources/test 폴더에 복사한다.
   
6. Classes   
- compileJava와 processResources 작업을 모두 실행
- 기타 컴파일 관련 작업을 추가

7.jar
- classes 작업을 수행한 후, 클래스 파일과 기타 자원 파일을
묶어서 .jar 파일로 만든다.

8.build
-모든 작업수행!!(완판이다)~!]

9.cleanEclipse
- 이클립스 관련 모든 설정 파일 제거

10.eclipse
- 이클립스 관련 모든 설정 파일 추가
- 기존에 이미 같은 파일이 있다면, 그 파일에 내용만 추가

[의존 라이브러리 설정]
1) 의존 라이브러리를 다운로드 받을 서버 저장
  => maven 서버를 공유한다.
repositories {
    mavenCentral()
}


2) 다운로드 할 의존 라이브러리 이름 설정
dependencies {
  //[의존라이브러리 사용 용도] '그룹명:라이브러리:버전'
  
  compile 'commons-lang:commons-lang:2.6'
  testCompile 'org.mockito:mockito:1.9.0-rc1'


  //[의존라이브러리 사용 용도] group:'그룹명',name:'이름', version:'버전'
  compile group: 'com.google.code.guice', name: 'guice', version: '1.0'

  //[의존라이브러리 사용 용도] files('경로','경로')
  compile files('hibernate.jar', 'libs/spring.jar')

  //[의졸라이브러리 사용 용도] fileTree('JAR 파일들이 들어있는 경로')
  compile fileTree('libs')
}

의존 라이브러리 사용 용도
compile => 컴파일할 대 사용하고 배포할 때도 포함하라!
testCompile => 단위 테스트 파일을 컴파일할 때만 사용하라. 배포에서 제외한다.


[bulid.gradle 설정하기]
- 각 명령어 별로 메서드를 호출하여 설정한다.

