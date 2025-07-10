# 블로그 기획하고 API 만들기	
![image](https://github.com/user-attachments/assets/069d3314-4e80-4c54-b0cf-2920b9036af0)
</br></br></br>


## REST API
- 웹 자원을 HTTP 방식으로 요청하고 응답하는 API
- 주소와 메서드만 보고 요청 내용을 쉽게 파악할 수 있음
</br></br>

**규칙** 
1. RESTful API는 동사를 쓰지 않는다  (예 : /articles/1 )
2. 동사는 HTTP 메서드로 구현함 (예 : GET, POST, PUT, DELETE)
</br></br></br>


# 빌더 패턴을 사용하는 이유
![image](https://github.com/user-attachments/assets/3e243f31-571a-4d6e-9aa0-b628bf858798) </br>
- 어느 필드에 어떤 값이 들어가는지 명시적을 파악할 수 있다 (코드 가독성 향상됨)
</br></br></br>

# DTO vs DAO
- **DTO** : 계층끼리 데이터를 교환하기 위해 사용하는 객체
- **DAO** : 데이터베이스와 상호작용할때 사용하는 객체
</br>


### DTO를 사용하는 이유
- 필요한 필드만 전달 ([회원정보를 보여줄때 비밀번호 노출방지](https://github.com/juho-creator/SpringBoot101/blob/main/6%EC%9E%A5/dto-practice/src/main/java/me/juhokim/dto/UserResponse.java))

- 입력값 유효성 검사 ([회원가입시 비밀번호 유효성 검사](https://github.com/juho-creator/SpringBoot101/blob/main/6%EC%9E%A5/dto-practice/src/main/java/me/juhokim/dto/UserRequest.java))

</br></br></br>




# 역직렬화 vs 직렬화
![image](https://github.com/user-attachments/assets/44e7bb90-fab9-47d4-8709-e56a06dae4ed)
- HTTP에서는 JSON, 자바에서는 객체를 사용한다
- ObjectMapper의 직렬화 (객체 => JSON) 또는 역직렬화 (JSON => 객체)를 통해 적절히 데이터를 변형하여 용도에 맞게 사용할 수 있다
  </br></br></br>

### 바인딩이란?
- 외부 입력값 (Json)을 자바 객체 필드에 자동 매핑해주는 과정
- Jackson은 getter가 없으면 DTO를 바인딩 못함
</br></br></br>

# 프로젝트 개발 과정
1. DAO 작성하기 (빌더 패턴)
2. 리포지토리 작성하기
3. DTO 작성하기
4. 서비스 작성하기
5. 컨트롤러 작성하기
6. 테스트 코드 작성하기
  
