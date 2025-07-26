# JWT로 로그인/ 로그아웃 기능 구현하기
## JWT를 적용한 전반적인 인증과정 
<img width="616" height="388" alt="image" src="https://github.com/user-attachments/assets/22cc8482-e91e-44de-a385-5c3b34787fa9" />
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


