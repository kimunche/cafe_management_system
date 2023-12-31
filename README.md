# 커피가게 백엔드 API 구현

시스템정보
- Java 17
- Spring Boot 3.1.2
- JPA
- QueryDsl

* UI 제외, API만 개발. (restful Tool을 이용한 데이터 확인)
* Swagger 적용을 통한 API 문서 노출

## 주문관리

- 주문 프로세스: 메뉴 선택 -> 고객 전화번호를 통한 멤버십 조회 -> 멤버십 포인트를 통한 결제.
- 고객 메뉴 조회 API
- 고객 상품 선택 API
- 고객 멤버십 조회 API
- 결제 API

## 상품관리

- 커피관련 상품을 판매할 수 있도록 상품관리.
- 메뉴관련 구성 참고: https://www.theventi.co.kr/new2022/menu/all.html?mode=2

## 고객관리

- 고객정보는 휴대폰 번호를 통해서 조회하며, 해당 번호를 통한 멤버십 포인트로 주문이 가능.

## 비즈니스 로직 플로우차트
![image](https://github.com/kimunche/cafe_management_system/assets/90191707/01e08b7e-4091-471a-a4a6-5a75aa94aeb2)

