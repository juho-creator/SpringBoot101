# 스프링 부트3 시작하기
### 스프링 vs 스프링부트 </br>
- 스프링부트 : 스프링 프레임워크를 더 쉽고 빠르게 이용할 수 있도록 만들어주는 도구
![화면 캡처 2025-06-28 001024](https://github.com/user-attachments/assets/1789cfee-33fa-4810-b6b0-69ac44eef935)
</br></br></br>

### 스프링 콘셉트
- **빈**: 스피링 컨테이너가 생성하고 관리하는 객체
- **스프링 컨테이너** : 빈을 생성하고 관리함
- **제어의 역전 (IoC)** : 객체의 생성과 관리를 프레임워크가 대신하는 것 (스프링 컨테이너가 객체를 관리하는 방식)
- **의존성 주입 (DI)** : 외부에서 객체를 주입받아 사용하는 것 

```java
public class A {
    // 스프링 컨테이너가 빈 b를 관리함 (IoC) 
    @Autowired     // A 클래스가 B 객체를 외부에서 주입받음 (DI)
    private B b;
}
```
</br>

- **관점 지향 프로그래밍 (AOP)** : 관점과 부가 관점으로 나누어서 개발하는 것 </br>
![image](https://github.com/user-attachments/assets/95d269c5-1eb8-4f60-950b-6e70de8fa952)

- 이식 가능한 서비스 추상화 (PSA) : 스프링에서 사용되는 기술들을 추상화한 인터페이스 </br>
ex : 클라이언트의 매핑과 클래스, 데이터베이스에 접근하기 위한 JPA, JDBC
</br></br></br>

#### 스프링 부트 스타터 
- 스프링부트 스타터는 의존성이 모여 있는 그룹이다
- spring-boot-starter-[작업유형]으로 불러옴 </br>
![image](https://github.com/user-attachments/assets/4abfffa5-d7a7-4776-99bd-4cad3898ecac)
</br></br></br>

#### 자동 구성
- 서버를 시작할 때 구성 파일을 읽어와서 자동설정함
- spring-boot-autconfigure/spring.factories에서 확인할 수 있음
</br></br></br>

### @SpringBootApplication의 구성
![image](https://github.com/user-attachments/assets/a7441ba2-3b43-4d1c-8c12-7cec78ed51a4)
- **@SpringBootConfiguration** : 스프링 부트 관련 설정
- **@ComponentScan** : 사용자가 등록한 빈을 읽고 등록함
- **@EnableAutoConfiguration**: 스프링 부트에서 자동 구성을 활성화하는 애너테이션
- **@Component** 애너테이션이 있는 클래스는 빈으로 등록되며 </br>
사용자는 용도에 따라 이를 상속 받은 애너테이션을 아래와 같이 빈을 다르게 정의할 수 있다: </br>
![image](https://github.com/user-attachments/assets/5c352eed-8eb5-4c79-884c-f4f1c39d4ca8)



