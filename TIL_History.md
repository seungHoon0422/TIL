# History

### 2022.05.30(월)
- 오랜만에 코딩테스트 문제푸니까 감도 안잡힘...
- 감찾기 start


### ~2022.05.27(금)
- ssafy 1학기 관통프로젝트 완료
- 최종발표 끝!!


### 2022.05.18(수)  
- kakao map api와 vue 프로젝트 연동을 통해서 아파트 매매리스트 랜더링
- vuex를 사용해서 house view 컴포넌트와, 매매리스트 테이블 component, kakao map component 데이터 이동
- computed영역에 mapstate를 사용해서 state의 변화에 따라 동작 수행
- actions에서는 직접적인 state의 변경을 처리하지 않고, context 안에있는 commit을 사용해서 mutations를 호출하고, state 값의 변동은 mutation에서 처리한다.

### 2022.05.16(월)
- vue 라이브러리 vuex 학습

### 2022.05.13(금)
- vue 과목평가 준비
- 관통프로젝트 backend rest controller 방식으로 수정


### 2022.05.12(목)
- npm(node package manager)를 사용해서 Vue Project를 생성한다.
- 기존에 html, css, js 로 나뉘어있던 프로젝트를 Vue component로 수정 

### 2022.05.09(월)
- vue.js component router 적용
- VueRouter객체 활용해서 기존 html 페이지 이동방식에서 모두 비동기로 동작하게 수정


### 2022.05.09(월)
- vue js instance, component 학습
- 2 상하관계에 있는 component 관계에서 자식은 부모 component에게 emit 이벤트를 발생시키고, 부모는 자식 component에게 props 를 사용하여 파라메터를 전달한다.

### 2022.05.08(일)
- 월요일 DB, MYBatis 평가가 예정되어있어 기본 sql문법 정리, myBatis 복습

### 2022.05.07(토)
- 밤새 skt 1차면접 사전과제 했지만 제대로 구현하지 못했다... 무턱대고 spring boot security 건드렸다가 호되게 당함.

### 2022.05.06(금)
- 아파트 매매정보 리스트 중에서 선택한 아파트에 대한 주변 스타벅스 매장 보여주기 기능 추가
- 아파트 위도, 경도 좌표와 각 스타벅스 매장의 위도, 경도 좌표의 거리계산을 통하여 실제 거리를 구해서 아파트와 가장 가까운 매장을 중심에 위치시킨다.
- 회원 로그인 후에 관심목록 리스트를 보여주는 부분에서 관심목록으로 등록이 많이된 아파트 순서로 보여주는 기능 추가
- 해당 아파트에 대한 매매정보만 보여주는 화면에서는 매매가격 기준으로 정렬하여 보여준다.


### 2022.05.05(목)
- spring boot project 아파트 매매정보 등록 페이지, buisness logic 업데이트
- skt server/backend 사전과제  spring boot로 시작



### 2022.05.04(수)
- ES6문법 적용하여 Vue.js 추가학습
- 관통 프로젝트 update
  - 관심목록으로 설정한 아파트 테이블 모델링 후 등록하는 기능 추가
  - 적정 등급에 해당하는 사용자만 아파트 매물 등록이 가능하게 설정
  - 시,군,동 정보를 토대로 얻어온 아파트 이름을 비동기로 뿌리는 과정에서 문제 발생


### 2022.05.03(화)
- Vue.js 시작, element, directive 학습
- vue를 사용하기 위해서 vscode에 여러 확장파일을 설치하고, chrome debugging tool을 사용하기 위해 chrome확장파일인 vue.js devtools 설치



### 2022.05.02(월)

- spring legacy project로 작성되어있던 관통프로젝트 spring boot로 변환
- 전체적인 DB도 새로 모델링을 하는데 오랜만에 MYSQL Workbench를 사용해서 시간을 많이 낭비
- Vue.js 적용을 편하게 하기위해 데이터를 주고받는 부분의 경우 웬만하면 RestController로 처리


## 2022/04

### 2022.04.29

 - happy house 프로젝트 spring boot형식으로 변환하고, github를 사용해서 작업환경 구성


### 2022.04.28

- Spring 프로젝트에서 Spring Boot로 변경할 때 수정해야할 사항 정리
- Swagger를 사용하여 API 명세서 작성 시 필요한 Annotation 정리
- Spring Annotation 정리


### 2022.04.27

- REST API 적용 실습
- 기존 `@Controller`만을 사용하여 작성된 프로젝트를 `@Controller` 와 `@RestController`를 동시에 사용하는 방식으로 수정하려고 하니까 front 쪽에 처리하던 방식을 비동기 처리(ajax)로 변경해야 한다.(상당부분)
- Spring Annotation 정리


### 2022.04.26

- Swagger를 사용해서 작성한 API 문서화 작업을 자동화시킨다.
- Spring Legacy Project to Sprint Boot 전환 시작
- BOJ 3문제 풀이

