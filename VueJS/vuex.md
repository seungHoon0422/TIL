# Vuex

### vuex

<br>

Vue.js application에 대한 **상태관리 패턴 + 라이브러리**
application 모든 component들의 중앙 저장소 역할
상위, 하위 관계가 복잡해지면 emit, props를 사용하여 데이터를 전달하는 부분이 매우 복잡해진다.

### 상태관리 패턴

<br>

상태(data) : 앱을 작동하는 원본 소스
뷰(teplate) : 상태의 선언적 매핑
액션(method) : 뷰에서 사용자 입력에 대해 반응적으로 상태를 바꾸는 방법

### Vuex 사용 방법

<br>

- `npm install vuex --save` 명령어를 사용하여 설치
- `store.js`파일에 추가
  - `import Vue form 'vue'`
  - `import Vuex from 'vuex'`
  - `Vue.use(Vuex)`
- `App.vue`파일 수정
  - `import store from './store/store'`
  - Vue객체에 store등록

### vuex 저장소 개념

<br>


State : 단일 상태 트리를 사용, applicaiton마다 하나의 저장소를 관리(data)
  - 저장소에서 data속성의 역할
  - 접근 방법 : `this.$store.state.data_name`  

Getter : Vue instacne의 Computed와 같은 역할, state를 기반으로 계산
  - component가 vuex의 state를 직접 접근하는 코드가 중복되는 경우 해결
  - 접근 방법 : `return this.$store.getters.countMsg`

Mapgetters : getters를 조금 더 간단하게 호출
  - `import { mapeGetters } from 'vuex'`
  - computed : `mapGetters(['countMsg', 'msg1', 'msg2'])`
  
Mutations : State의 상태를 변경하는 유일한 방법 (동기 methods)
  - 각 컴포넌트에서 state의 값을 직접 변경하는 것은 권장하지 않는 방식
  - mutations는 직접 호출이 불가능하고, store.commit('이름')으로 호출
  - `this.$store.commit('addCount', 10)`


Actions : 상태를 변이 시키는 대신 액션으로 변이에 대한 커밋 처리(비동기 methods)
  - 비동기 작업의 결과를 적용하려고 할 때 사용
  - Mutations는 상태 관리를 위해 동기적으로 처리하고, 비동기적인 처리는 Actions가 담당
  - Actions는 비동기 로직의 처리가 종료되면 Mutations를 호출  
  - `this.$store.dispatch('asyncAddOne')`










