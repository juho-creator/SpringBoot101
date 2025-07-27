# OAuth2로 로그인/로그아웃 구현하기	
## OAuth 기초 용어
- **리소스 오너** (사용자) : 인증 서버에 자신의 정보를 사용하도록 허가하는 주체 
- **리소스 서버** (네이버, 구글, 페이스북): 리소스 오너의 정보를 소유하고 보호하는 주체 
- **인증 서버** (Google OAuth) : 클라이언트에게 리소스 오너의 정보에 접근할 수 있는 토큰을 발급하는 애플리케이션 
- **클라이언트 애플리케이션** :  인증 서버에게 인증 받고 리소스 오너의 리소스를 사용하는 주체 
</br></br></br></br>
</br></br></br></br>

## 리소스 오너 정보를 취득하는 방법
### 권한 부여 코드 승인 타입 (Authorization Code grant type / OAuth2.0)
- 인증 서버(카카오톡, 구글)에서 권한에 접근할 수 있는 코드와 리소스 오너에 대한 엑세스 토큰을 발급받는 방식
<img width="833" height="495" alt="image" src="https://github.com/user-attachments/assets/be7f88b2-cfb2-41a3-a682-45cc93e0120a" />
</br></br>

1. **권한 요청** </br>
```
GET spring-authorization-server.example/authorize?
  client_id = 66a36b4c2&                                 // 클라이언트에 할당한 고유 식별자 (애플리케이션)
  redirect_uri = http://localhost:8080/myapp&            // 로그인 성공 시 이동해야 하는 URI
  response_type = code&                                  // 클라이언트가 제공받길 원하는 응답 타입  (json)
  scope = profile                                        // 제공받고자 하는 정보 목록 (예 : google calendar events)
```
</br></br>


2. 데이터 접근용 권한 부여
- 처음에 로그인 창을 띄운 후 데이터 접근 동의를 얻음
- 데이터에 접근할 수 있게 인증 및 권한 부여를 수신함
</br></br>


3. 인증 코드 제공
redirect_uri로 리다이렉션 되면서 파라미터에 인증 코드를 제공함
```
GET http://localhost:8080/myapp?code=a1s2f3mcj2
```
</br></br>


4. 액세스 토큰 응답
- 인증 코드를 받으면 아래와 같이 /token POST 요청을 보냄
```
POST spring-authorization-server.example.com/token
{
  "client-id": "66a36b4c2",
  "client_secret": "aabb11dd44",                      //  OAuth 서비스에 등록할 때 제공 받은 비밀키
  "redirect_uri": "http://localhost:8080/myapp",
  "grant_type": "authorization_code",                 //    
  "code" : "a1b2c3d4e5f6g7h8"
}
```
</br>

- 그럼 access token으로 응답함
```
{
  "access_token" : "aasdffb",
  "token_type" : "Bearer", 
  "expires_in" : 3600m
  "scope" : "openid profile",
  .... (생략) ....
  
}
```
</br>

5. 액세스 토큰으로 API요청
- 아래와 같이 액세스 토큰을 이용해서 요청하면 리소스 서버에서 토큰 유효성을 검사한 후 응답함
```
GET spring-authorization-resource-server.example.com/userinfo
Header: Authorization: Bearer aasdffb
```
</br></br>
</br></br>




### 암시적 승인 타입 (implicit grant type)
- 클라이언트가 요청을 보내면 액세스 토큰을 발급 받음
</br></br>
</br></br>


### 리소스 소유자 암호 자격증명 승인 타입 (resource owner password credentials)
- 클라이언트의 패스워드를 이용해서 토큰을 발급함
</br></br>
</br></br>


### 4. 클라이언트 자격증명 승인 타입 (client credentials grant)
- 컨텍스트 외부에서 액세스 토큰을 얻은 후 특정 리소스에 접근 요청함






## 쿠키란?
- 해당 웹사이트의 서버에서 저장하는 작은 데이터
<img width="981" height="616" alt="image" src="https://github.com/user-attachments/assets/90d3c39a-ed9d-480c-98e7-8dd28892339b" /> </br>
1. 유저가 서버에 요청하면 쿠키를 보냄 </br>
2. 브라우저가 쿠키 저장 </br>
3. 다음 요청할 때 쿠키도 전송 </br>
4. 다음 번에 요청했을때 쿠키값을 이용해 사용자 로그인 상태를 유지함
   
   






