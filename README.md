# 📖 프로젝트 소개

**마루는 강쥐! 게시판(백엔드)**는 **Spring Framework와 React를 활용한 커뮤니티형 웹 애플리케이션**입니다.
사용자는 로그인 후 자유롭게 게시글을 작성하고, 게시물 목록을 확인하며 소통할 수 있습니다. 또한, react-session-api를 활용하여 **세션 기반 로그인 유지 기능**을 구현하여 보안성과 편의성을 높였습니다.

- **개발기간**: 2024.10.28 ~ 2024.10.30 (2일)
- **개발인원**: 1인 (개인 프로젝트)
- **주요기능**
  - react-session-api를 활용한 로그인 & 로그아웃
  - 로그인 상태에 따른 메뉴바 동적 변경
  - 게시물 목록 출력
  - 로그인 시, 게시물 작성
  - 게시물 상세 보기
  
---

## 🔧 기술 스택
- **백엔드**: Spring Framework, MyBatis
- **프론트엔드**: React, HTML, CSS, JavaScript
- **데이터베이스**: NCP(DB 구축), MySQL

---
## 🎰 주요 기능 및 스크린 샷

### 1. **로그인 화면**
- ‘로그인’ 메뉴 클릭 시, 로그인 화면 출력
- 아이디와 비밀번호 유효성 검사
- 로그인 실패 시, 실패 팝업 발생과 함께 실패 문구 ‘로그인 정보가 올바르지 않습니다.’ 노출


![로그인](https://github.com/user-attachments/assets/563f1523-c095-4c68-b037-a023816537cf)
![유효성검사](https://github.com/user-attachments/assets/b536e3ff-1c0e-49c4-8009-ff33ed7b2dad)|

![](https://velog.velcdn.com/images/hsh111366/post/fcc2fb0d-d8aa-43b7-ab8c-d6656b811a17/image.png)1층에서 본 모습 👀 | ![](https://velog.velcdn.com/images/hsh111366/post/ddc0ee11-47bb-4223-984a-22f8cf156bf9/image.png)2층에서 본 모습 👀 | ![](https://velog.velcdn.com/images/hsh111366/post/8c585428-8a27-4bc5-8f78-26bccb5a2466/image.png)굿즈들 🎁
---|---|---|

### 2. **도착지(강의실) 지정**
- 사용자가 원하는 강의실 정보(건물, 층, 호수) 선택
- 강의실 확인창에서 '강의실로 이동' 버튼 클릭 시, 길안내 시



### 3. **도착지(강의실) 길안내**
- 외부지도에서 GPS 기반 사용자의 현위치 표현하며 사용자가 원하는 건물까지 길안내
- 건물에 도착하면 내부지도 화면으로 전환되며 강의실까지 길 안내
![외부](https://github.com/user-attachments/assets/185c3d09-4bea-4f52-a9ac-ee22d92a3b19)
![내부](https://github.com/user-attachments/assets/e6ea1cb7-cb33-4423-913e-371daca9bc6e)
