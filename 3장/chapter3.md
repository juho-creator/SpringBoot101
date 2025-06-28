### 프로젝트의 전체적인 구조 
![image](https://github.com/user-attachments/assets/4123ed5e-b1fc-422e-87bd-594041142180) </br></br></br>

### 계층으로 나눈 프로젝트 구조
![image](https://github.com/user-attachments/assets/056d62b3-b84f-490f-a325-f9ee7d4c969b)
- **프레젠테이션 계층** : HTTP요청을 받고 비즈니스 계층으로 전송함
- **비즈니스 계층** : 비즈니스 로직, 즉 서비스를 만들기 위한 로직이 구현되어있음
- **퍼시스턴스 계층** : 데이터베이스 관련 로직 처리함 (DAO 객체를 사용하여 데이터베이스  계층과 상호작용함)
</br></br></br>


### 스프링 부트 요청 응답 과정 이해하기
![image](https://github.com/user-attachments/assets/54554a24-6e52-43ef-9d5e-5ecb61ba25ee)
1. 클라이언트가 /test GET 요청을 하면 **디스패처 서블릿**이 URL을 분석한 후 컨트롤러를 찾고 /test GET 요청을 전달함
2. getAllMembers() 메서드가 /test 요청처리함 (비즈니스 계층과 퍼시스턴스 계층을 통하면서 피룡한 데이터를 가져옴)
3. 뷰 리졸버가 템플릿 엔진을 사용해 데이터를 생성한다 (HHTLM, JSON, XML, 등)
4. members (테이블)를 반환함
