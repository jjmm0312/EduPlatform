1. /member/login - 로그인
2. /member/signup - 회원가입
3. 0 - 관리자, 1- 선생님, 2 - 학생
4. /member/ ~~~ 지민이가 전부-

-------



1. 공지사항 - /notice/getall - 메인용 API
2. 공지사항 작성 - /notice/write - 공지사항 작성
3. 공지사항 수정 - /notice/modify - 공지사항 수정
4. 모든 강좌 목록 - /lecture/getall - 메인용 모든 강좌목록
5. 학생 수강중 강좌 목록 - /lecture/getstudentall - 메인용 수강중인 강좌목록



1. 수강신청 페이지의 모든 강좌 목록은 - 4번을 이용할 것, 4번과 공용으로 쓰기 위해서 pagenation 이 필요함
2. 수강신청 페이지의 강좌 검색 - /lecture/searchlecture - 검색
3. 수강신청 상세 페이지 -  /lecture/detail - 상제 페이지
4. 수강신청 버튼 - /lecture/submitlecture - 학생이 수강신청 가능하게
5. 강의 상세 페이지 - /lecture/class/detail - 학생의 강의 상세
6. 강의 비디오 API - /lecture/class/video - 비디오 가져오기
7. 강의 첨부파일 API - /lecutre/class/getfile - 첨부파일 받아오기
8. 강의 첨부파일 첨부 API - /lecture/class/attachfile -첨부파일 첨부하기 - 강사용
9. 학습 현황 보류





- Teacher 메뉴

1. 수강생 관리



1. 배너에는 무슨 글자? - API로만 제공? - 글자를 수정할 수 있도록 한다.

----------------

자 철아 일단, 공지사항을 제일 먼저 해보자.

일단 글쓰기부터 해볼게 -> 하고 뷰랑 연결까지 글쓰기부터 Until 12시.

회원가입 먼저. 

Until 12시