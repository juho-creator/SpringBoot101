# JWT로 로그인/ 로그아웃 기능 구현하기
## JWT를 적용한 전반적인 인증과정 
<img width="616" height="388" alt="image" src="https://github.com/user-attachments/assets/22cc8482-e91e-44de-a385-5c3b34787fa9" />
</br></br></br>
</br></br></br>


## 토큰의 특징 
- **무상태성 :** 인증 정보가 담겨있는 토큰은 클라이언트에 있으므로 서버에 저장할 필요가 없다
- **확장성 :** 하나의 토큰으로 서버에 여러 요청을 보낼 수 있다
- **무결성 :** 토큰읠 발급한 이후 내용을 변경할 수 없다
</br>
* JWT로 인증할떄 Http 요청 헤더 중 Authorization에 Bearer  + JWT 토큰값을 넣어 보낸다.

<img width="835" height="258" alt="image" src="https://github.com/user-attachments/assets/8f9b0c88-1168-4e0a-93b3-ad8e0ee947e1" />

</br></br></br>


## 토큰의 구성
<img width="346" height="112" alt="image" src="https://github.com/user-attachments/assets/c62e1d7d-aaee-44a1-a98a-c52178c68797" />

```
eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3NTM1MjI0MTQsImlzcyI6InRlc3RpbmdAZ21haWwuY29tIiwic3ViIjoiMTIzQDEyMyIsImV4cCI6MTc1MzUyMjQ3NH0.fhA_0c-OM6okABS9trs3VD314WbNQbz98Z1vGgflX_o
```

- **헤더** : 토큰 타입과 해시 알고리즘 정보를 담고 있음
- **내용** : 토큰 내용 (claim)을 담고 있음
- **서명** : 토큰 검증 용도 사용됨

</br></br></br>
</br></br></br>







## 리프레시와 액세스 토큰을 사용한 인증 과정 (처음 요청했을때)
<img width="910" height="702" alt="image" src="https://github.com/user-attachments/assets/14b0710e-bc07-4e0b-93b4-44e3d491da2d" />

- **액세스 토큰** : 유저 인증을 하기 위한 토큰
- **리프레시 토큰** : 새로운 액세스 토큰을 발급하기 위한 토큰
</br></br></br>
</br></br></br>


## 토큰 필터를 통한 서비스 로직 실행 과정 (액세스 토큰으로 요청했을때)
<img width="801" height="300" alt="image" src="https://github.com/user-attachments/assets/6eaca27b-a0d7-4b5d-8df6-23c9b304b23c" />

토큰 필터는 요청했을때 토큰 유효성을 검사하고, 유효하면 컨텍스트 홀더에 인증 정보를 </br>
  저장한 후 서비스 로직을 실행하며, 유효하지 않으면 응답을 반환한다.


