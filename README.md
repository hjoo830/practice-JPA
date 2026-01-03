## 프로젝트 소개
- JPA를 연습하기 위해 회원 등급별 주문/할인 로직을 개발하였습니다.
- 회원 등급은 BASIC과 VIP 두가지
- VIP인 경우 구매 금액의 10%를 할인받을 수 있습니다.

## API
- 회원 생성
- 회원 등급 변경
- 회원 등급 조회
- 주문 생성
- 가격 계산
- 주문 조회

### Swagger
- 실행 후 http://localhost:8080/swagger-ui/index.html 에서 API를 직접 호출해 테스트할 수 있습니다.
<img width="827" height="390" alt="image" src="https://github.com/user-attachments/assets/7f2ef934-e4c7-4f03-9b88-6c2edbabfaa6" />

## 테스트 결과
- API 호출 후 H2 DB에 저장된 결과입니다.
<img width="114" height="62" alt="image" src="https://github.com/user-attachments/assets/48c0485c-767d-48c4-a27b-0a86e6a13c38" />
<img width="573" height="64" alt="image" src="https://github.com/user-attachments/assets/a9df7c0c-a3bc-4d04-ac47-ad2043ba3ffb" />
