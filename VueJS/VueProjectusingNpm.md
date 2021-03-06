# Vue Project using CLI


## 프로젝트 생성 과정

- NodeJS LTS 버전 설치
- `npm i -g @vue/cli` 
- `npm init` : 새로운 프로젝트나 패키지 만들때 사용, package.json 생성
  - 저장해놓은 preset 사용, 2.x version Vue, Router, Vuex 추가 설치
- `npm install axios` : 비동기를 위해 사용하는 axios는 순수 js 라이브러리이므로 npm을 사용해서 따로 설치
- `npm run serve` : 생성된 프로젝트 실행
- vsCode 설정 printwidth를 80으로 변경하여 Vue 프로젝트의 경고 수정
- `"prettier/prettier": ["error",{"endOfLine": "auto"}]` : `package.json` 파일 안에 `eslitConfig` rules에 추가하여 enter를 입력받았을 떄 `/r/n`으로 오류가 발생하는 부분 해결, window, mac 구분하지 않고 알아서 개행 오류 해결

## SFC ( Single File Component )

- 확장자명이 `.vue`로 생성
- vue 파일은 `template`, `script`, `style` 태그로 구성되어 있다.
- style에 적용시키는 css는 `scoped` 속성을 통해서 현재 컴포넌트에서만 사용 가능한 css를 지정 가능하다. 
