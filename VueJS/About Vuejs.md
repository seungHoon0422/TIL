<h1 style="text-align:center">Vue.js</h1>


### Vue.js 특징

- Approachable (접근성)
- Versatile (유연성)
-  Performant(고성능)



### MVVM Pattern

- Model + View + ViewModel
- Model : 순수 자바스크립트 객체
- View : 웹페이지의 DOM
- ViewModel : Vue의 역할
- 기존에는 js로 view에 해당하는 DOM에 접근하거나 수정하기 위해서 jquery와 같은 libarary를 사용했지만, Vue는 view 와 Model을 연결하고 자동으로 바인딩하므로 양방향 통신 가능     



### Vue Instance

- el : Vue가 적용될 요소를 지정, css selector or html element
- data : Vue에서 사용되는 정보를 저장, 객체 or 함수 형태
- template : 화면에 표시할 html, css등의 마크업 요소를 정의하는 속성, 뷰의 데이터 , 속성들도 그릴 수 있음
- methods : 화면 로직 제어와 관련된 method를 정의하는 속성, 마우스 클릭 이벤트 처리와 같은 전반적인 이벤트와 화면 동작과 관련된 로직을 추가
- created : 뷰 인스턴스가 생성되자 마자 실행할 로직을 정의



### Life Cycle

Life Cycle은 Instace를 기준으로 생성, 부착, 갱신, 소멸 4단계로 구성

- beforeCreate : Instance가 생성되고 각 정보의 설정 전에 호출, DOM과 괕은 화면요소에 접근이 불가능
- created : Instance 생성 후 데이터들의 설정이 완료된 후 호출, 화면에 부착하기 전이므로 template 속성에 정의된 DOM요소는 접근 불가, 주로 서버에 데이터를 요청하여 받아오는 로직 수행
- beforeMount : 마운트가 시작되기 전에 호출
- mounted : 지정된 element에 instance가 마운트 된 후에 호출, template속성에 정의한 화면 요소에 접근할 수 있어 화면 요소를 제어하는 로직 수행
- beforeUpdate : 데이터가 변경될 때 virtual DOM이 랜더링, 패치되기 전에 호출
- updated : Vue에서 관리되는 데이터가 변경되어 DOM이 업데이트 된 상태, 데이터 변경 후 화면 요소 제어와 관련된 로직 추가
- beforeDestroy : Instance가 제거되기 전에 호출
- destroyed : Instance가 제거된 후에 호출



### Vue Event

- Dom Event를 청취하기 위해 v-on directive 사용
- inline event handling : jquery처럼 script딴으로 분리해서 이벤트를 적용시키지 않는다.



### Component

- Vue의 가장 강력한 기능 중 하나
- 