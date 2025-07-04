# 개발 환경 구축하기
## 기본 프로젝트 구조 
![image](https://github.com/user-attachments/assets/b80b9fa6-9205-4249-ba0f-68b6043d2376)

- `SpringBootApplication 클래스` : 스프링 부트 애플리케이션의 시작점
- `build.gradle` : 애플리케이션 설정에 필요한 내용을 갖고 있다 </br>
  * 애플리케이션 설정에 필요한 내용을 build.gradle를 읽어 필요한 의존성 주입을 하게 된다.
</br></br></br>


## 그레이들 vs 메이븐
**그레이들**과 **메이븐**은 자바 생태계에서 널리 사용하는 빌드 관리 도구지만
그레이들 (gradle)을 많이 사용하는 추세다


 메이븐을 대신 그레이들을 사용하는 이유는 다음과 같다 :
- 가독성이 좋음
- 다양한 언어를 지원함
- 빌드 스크립트를 자유자재로 작성할 수 있음
- 빌드와 테스트 속도가 빠름
</br></br></br>


## 스프링부트 기초용어
- `Repository`: 외부 라이브러리를 가져오는 저장소 (예 : mavencentral)
- `의존성 (dependency)`: 프로젝트가 의존성을 가진다는건 외부 라이브러리에 의존한다는 의미한다 </br>
따라서 dependencies 설정은 라이브러리 설정을 의미한다
</br></br></br>


## 스프링 부트3 프로젝트 만들기
1. 인텔리제이(자바 통합 개발 환경)를 설치한다
2. 프로젝트를 생성한 후 [`build.gradle`](https://github.com/juho-creator/SpringBoot101/blob/main/0%EC%9E%A5/chapter0_Springboot101/build.gradle)파일을 아래와 같이 수정한다 :
      - 프로젝트에 필요한 플러그인 추가
      - 컴파일 할때 자바 버전 설정
      - 의존성을 받을 저장소 지정
      - 프로젝트 개발에 필요한 기능의 의존성 설정

3. springbootdeveloper package를 생성한 후 [`SpringBootApplication 클래스`](https://github.com/juho-creator/SpringBoot101/blob/main/0%EC%9E%A5/chapter0_Springboot101/src/main/java/me/juhokim/springbootdeveloper/SpringBootDeveloperApplication.java)를 작성한다
4. `resources` 폴더에 [`static/index.html`](https://github.com/juho-creator/SpringBoot101/blob/main/0%EC%9E%A5/chapter0_Springboot101/src/main/resources/static/index.html) 페이지를 생성한다.
</br></br></br>



## 왜 저자는 build.gradle에서 mavenCentral()을 사용했을까?
MavenCentral에 대부분의 라이브러리들이 있음. </br>
따라서 Gradle 빌드 도구를 사용하지만 라이브러리 다운로드하는 저장소만 Maven 빌드 도구에 있는 저장소 (MavenCentral)를 사용함.
</br></br></br>



## Postman이란?
사용자와 서버가 통신하기 위한 인터페이스 (API)를 번거롭게 웹 브라우저를 열지 않고 효율적으로 테스트 하기 위한 프로그램
</br></br></br>


## 저자에게 깃허브 이슈로 질문하는 법
1. 나와 같은 오류를 마주한 사람이 있었는지 [closed issue](https://github.com/shinsunyoung/springboot-developer-2rd/issues) 확인
2. 저자의 저장소에서 `[장 번호] 제목`으로 issue를 생성한다
