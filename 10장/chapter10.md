# OAuth2로 로그인/로그아웃 구현하기	
### OAuth 기초 용어
- **리소스 오너** (사용자) : 인증 서버에 자신의 정보를 사용하도록 허가하는 주체 
- **리소스 서버** (네이버, 구글, 페이스북): 리소스 오너의 정보를 소유하고 보호하는 주체 
- **인증 서버** (Google OAuth) : 클라이언트에게 리소스 오너의 정보에 접근할 수 있는 토큰을 발급하는 애플리케이션 
- **클라이언트 애플리케이션** :  인증 서버에게 인증 받고 리소스 오너의 리소스를 사용하는 주체 
</br></br></br></br>
</br></br></br></br>

### 리소스 오너 정보를 취득하는 방법
**1. 권한 부여 코드 승인 타입 (Authorization Code grant type / OAuth2.0)**
- 인증 서버(카카오톡, 구글)에서 권한에 접근할 수 있는 코드와 리소스 오너에 대한 엑세스 토큰을 발급받는 방식
<img width="833" height="495" alt="image" src="https://github.com/user-attachments/assets/be7f88b2-cfb2-41a3-a682-45cc93e0120a" />
</br></br>

**권한 요청을 위한 파라미터** </br>
```
GET spring-authorization-server.example/authorize?
  client_id = 66a36b4c2&                                 // 클라이언트에 할당한 고유 식별자 (애플리케이션)
  redirect_uri = http://localhost:8080/myapp&            // 로그인 성공 시 이동해야 하는 URI
  response_type = code&                                  // 클라이언트가 제공받길 원하는 응답 타입  (json)
  scope = profile                                        // 제공받고자 하는 정보 목록 (예 : google calendar events)
```

</br></br>
</br></br>




**2. 암시적 승인 타입 (implicit grant type)**
- 클라이언트가 요청을 보내면 액세스 토큰을 발급 받음
</br></br>
</br></br>


**3. 리소스 소유자 암호 자격증명 승인 타입 (resource owner password credentials)**
- 클라이언트의 패스워드를 이용해서 토큰을 발급함
</br></br>
</br></br>


**4. 클라이언트 자격증명 승인 타입 (client credentials grant)**
- 컨텍스트 외부에서 액세스 토큰을 얻은 후 특정 리소스에 접근 요청함
