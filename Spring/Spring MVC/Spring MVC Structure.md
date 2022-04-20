# Spring MVC 구조

### MVC Pattern

* MVC는  Model - View - Controller의 줄임말이다.
* 컴포넌트의 변경이 다른 영역 컴포넌트에 영향을 미치지 않음( 유지보수에 용이하다 )
* 컴포넌트 간의 결합성이 낮아 프로그램 수정이 용이하다. ( 확장성이 뛰어남 )

* Model
  * **실제 로직을 처리하는 곳**으로 모든 기능은 Service에서 만들어진다. Controller를 통해 화면과 연결되고, DAO를 통해 데이터베이스와 연결된다.
  * 어플리케이션 상태의 캡슐화
  * 상태 쿼리에 대한 응답
  * 어플리케이션의 기능 표현
  * 변경을 view에 통지

* View
  * 말 그대로 **사용자에게 보여지는 화면**을 View라고 한다. Spring 에서는 JSP를 사용해 화면을 구성하고 Controller를 통해 백엔드 서버와 연결한다.
  * 모델을 화면에 시각적으로 표현
  * 모델에게 업데이트 요청
  * 사용자의 입력을 컨트롤러에 전달
  * 컨트롤러가 view를 선택하도록 허용

* Controller
  * **View와 Service 사이를 연결**해준다. 클라이언트가 입력한 URL에 맞는 View를 매핑해주고, View에서 처리하는 데이터를 Service로 전달해준다.
  * 어플리케이션의 행위 정의
  * 사용자 액션을 모델 업데이트와 mapping
  * 응답에 대한 view 선택

* 장점
  * 화면과 비즈니스 로직을 분리해서 작업 가능
  * 영역별 개발로 인하여 확장성이 뛰어남
  * 표준화된 코드를 사용하므로 공동작업이 용이하고 유지보수성이 좋음

* 단점
  * 개발과정이 복잡해 초기 개발속도가 늦음
  * 초보자가 이해하고 개발하기에 다소 어려움


## Spring MVC

* DI, AOP 기능 뿐만 아니라 Servlet 기반의 WEB개발을 위한 MVC Framework를 제공
* Spring MVC는 Model2 Architecture와 Front Controller Pattern을 Framework 차원에서 제공
* Spring이 제공하는 Transaction 처리나 DI 및 AOP 등을 손쉽게 사용


### 구성요소

* DispatcherServlet(Front Controller)
  * 모든 클라이언트의 요청을 전달받는다.
  * Controller에게 클라이언트의 요청을 전달하고 Controller가 리턴한 결과값을 View에게 전달하여 알맞은 응답을 생성

* HandlerMapping
  * 클라이언트의 요청 URL을 어떤 Controller가 처리할지를 결정한다.
  * URL과 요청 정보를 기준으로 어떤 핸들러 객체를 사용할지 결정하는 객체이며 DispatcherServlet은 하나 이상의 핸들러 매핑을 가질 수 있다.


* Controller
  * 클라이언트의 요청을 처리한 뒤, Model을 호출하고 그 결과를 Dispatcher Servlet에 알려준다.

* ModelAndView
  * Controller가 처리한 데이터 및 화면에 대한 정보를 보유한 객체


* ViewResolver
  * Controller가 리턴한 뷰의 이름을 기반으로 prefix, suffix정보를 저장하여 쳐리 결과를 보여줄 View를 결정한다.

* View
  * Controller의 처리 결과를 보여줄 응답화면을 생성한다.


### Spring MVC의 동작순서

1. 클라이언트의 요청
2. DispatcherServlet의 요청 수신 : 단일 Front Controller Servlet
3. DispatcherServlet은 Handler Mapping에 어느 Controller를 사용할 지 문의
4. DispatcherServlet은 요청을 Controller에 전송하고 Controller는 해당 로직
5. ModelAndView Object에 수행 결과가 포함되어 리턴
6. mav객체는 실제 JSP정보를 가지고 있지 않으며, View Resolver를 통해 논리적 이름을 실제 JSP이름으로 변환
7. View 결과정보를 사용하여 화면에 표시


### Spring MVC를 활용한 Application 구현 Step

* web.xml에 DispatcherServlet 등록 및 Spring 설정파일 등록
* 설정 파일에 HandlerMapping 설정
* Controller 구현 및 Context 설정파일 등록(servlet-context, root-context)
* Controller와 JSP의 연결을 위해 View Resolver 설정
* JSP코드 작성


### web.xml

* DispatcherServlet 설정
  * `<init-param>` 설정하지 않으면 `<servlet-name>-servlet.xml` file에서 applicationContext의 정보를 load
    * 기본적으로 spring legacy project를 생성하면 만들어지는`servlet-context.xml` 파일이 `<init-param>`으로 등록되어있다.
  * Spring Container는 설정파일의 내용을 읽고 ApplicationContext 객체를 생성
  * `<url-pattern>`은 DispatcherServlet이 처리하는 URL Mapping pattern을 정의한다.
  * Servlet이므로 1개 이상의 DispatcherServlet 설정이 가능하다.
  * `<load-on-startup>1</load-on-startup>` 설정 시 WAS startup시 초기화 작업이 진행된다.

* Controller class 작성
  * context 설정 파일에 Controller 등록(servlet-context.xml)
  * `<beans:bean class="com.spring.controller.Controller>`

* Controller와 response page연결을 위해 ViewResolver 설정(servlet-context.xml)
``` xml 
<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
  <beans:property name="prefix" value="/WEB-INF/views/" />
  <beans:property name="suffix" value=".jsp" />
</beans:bean>
```


