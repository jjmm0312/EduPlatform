* 메인페이지 (일반)

  * 공지사항 5개 가져오기 - 철
    * GET / 고정
  * 모든 강좌 목록 ( 9개씩 ) - 지민
    * GET / page로 가져오기

* 메인페이지 (학생)

  * 수강 중인 강좌 목록 ( 9개씩) - 지민
    * GET / 학생의 id, page로 가져오기

* 수강신청 페이지

  * 검색 기능 
    * GET / keyword = ? 
    * 해당 강좌 목록 리턴
  * 강좌 목록 ( 9개씩 ) - 지민
    * 앞선 메인페이지 (일반) 에서의 API 사용할 것

* 강좌 상세 페이지

  * 강좌 정보 설명
    * GET / courseID = ?
    * Only Description 까지만
  * 강좌 챕터 리스트
    * GET / courseID
    * 리스트'만' 가져오기
  * 기 수강신청 여부
    * GET / courseID, userID
    * true / false 반환 여부에 따른 vue v-if
  * 수강신청
    * POST / courseID, userID

* 강의 상세 페이지 - 여기서는 userID가 수강이 신청되어있는지 확인하여야 함

  * 강의 내용과 첨부파일, 영상 링크까지?
    * GET / courseID, lectureID
  * 첨부 파일 가져오기
    * GET / courseID, lectureID

* 선생님 메인페이지

  * 개설 중인 강좌 목록 ( 9개씩 )  - 지민
    * GET / 선생의id, page로 가져오기

* 강사용 강좌 상세 페이지

  * 내 강의 여부 
    * GET / 선생의id, courseID
  * ***<u>내 강의일 경우, 수정, 수강생관리</u>***

* 강사용 내 강좌 페이지

  * 검색 기능
    * GET / 선생의id, keyword = ?
  * 내 강좌 리스트
    * GET / 선생의id, page
  * 강좌 등록
    * POST / 강좌 사진, 강좌제목, 강좌 소개, 선생id
  * 강의 등록
    * POST / ~~

* 수강생 관리 페이지

  * 수강생 목록
    * GET / courseID
  * 수강생 승인
    * GET / courseId, userID
  * 수강생 삭제
    * GET / courseID, userID

* *<u>**학원 관리 페이지**</u>*

  * *<u>**추후논의**</u>*

  