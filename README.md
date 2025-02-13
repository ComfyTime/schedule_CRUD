# 일정 관리 과제
## API 명세
|구분|Method|API|
|---|---|---|
|일정 생성|POST|/schedules|
|일정 전체 조회|GET|/schedules|
|일정 단건 조회|GET|/schedules/{id}|
|일정 수정|PUT|/schedules/{id}|
|일정 삭제|DELETE|/schedules/{id}|
|유저 생성|POST|/users|
|일정 전체 조회|GET|/users|
|일정 단건 조회|GET|/userss/{id}|
|일정 수정|PUT|/userss/{id}|
|일정 삭제|DELETE|/userss/{id}|

## ERD

## LV0
### 설명
* API 명세서 작성
* ERD 작성
* SQL 작성

## LV1
### 설명 - 일정 CRUD
* 작성자 명, 제목, 내용, 생성일, 수정일 필드 생성
  * 생성일 수정일을 JPA Auditing을 이용하여 작성


## LV2
### 설명 - 유저 CRUD
* 유저 이름, 이메일, 작성일, 수정일 필드 생성
  * 생성일 수정일을 JPA Auditing을 이용하여 작성
* 연관관계 구현
  * 유저를 기준으로 일정에서 유저 id를 참고하도록 구현
 
## LV3
### 설명
* 유저 필드에 비밀번호 필드 추가
  * User.java, UserService.java, UserResponseDto.java에 비밀번호 필드 삽입
