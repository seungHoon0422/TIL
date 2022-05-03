<h1 style="text-align : center">Vue.js Directive</h1>


v-model

- 양방향 바인딩 처리를 위해서 사용

v-bind

- 엘리먼트의 속성과 바인딩 처리를 위해서 사용
- 속성 이름으로 사용할 경우 []로 감싸서 사용
- v-bind: => : 하나로 생략 가능
- key와 값을 모두 바인딩 되었을 때 적용이 된다. key만 binding 적용 x

v-show

- 조건에 따라 엘리먼트를 화면에 렌더링 한다.
- `v-show="isShow"` isShow값이 false이면 `style="display : none;"`을 추가하여 항상 렌더링

v-if, v-else-if, v-else

- 조건에 따라 엘리먼트를 화면에 렌더링
- v-if의 조건이 false이면 렌더링 자체가 되지 않는다.

v-for

- 배열이나 객체의 반복에 사용되고, python과 유사한 문법 사용
- 2.x버전과 3.x버전사이에 v-for, v-if사이 우선수위가 서로 다르게 적용된다. 하지만 보통 front에서 v-for는 정제된 데이터를 반복하는 용도로만 사용하므로 크게 문제가되진 않는다.
- `       <tr v-for="(user, index) in users" :key="index">`
- for문에서 key값은 필수적인 요소이지만 없어도 실행은 된다. 하지만 반복되는 객체를 구분하는 용도로 index값을 많이 사용한다.

template

- 여러 태그들을 묶어서 처리해야 할 경우에 사용한다.
- v-if, v-for, component 등과 함께 많이 사용

v-clock

- Vue Instance가 준비될 때까지 mustache의 바인딩을 숨기는데 사용

















