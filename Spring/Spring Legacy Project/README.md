# Spring Legacy Project 작성 유의사항 

* pom.xml

  * `<property>` java, spring version, context root 확인
  * `aop` :  weaver, rt(runtime) 추가 => tools 안에 2개다 들어있음

  * project maven update (Force update 선택해야함)
  * 프로젝트 실행시 에러 발생하면 tomcat 설정 체크 : server 프로젝트 안에 ~~/server.xml 파일 속 context 태그 확인(path와 context root 경로가 같은지 확인) => context root를 변경 하기 전에 project를 실행시킨 적이 있다면 수정해줘야한다.

- web.xml

  - 가장 먼저 비 웹 관련 설정 저장 root-context 파일이 실행된다. 
  - 프로젝트가 배포될 때 URL 매핑 정보를 갖고있는데 WAS가 web.xml을 읽으면서 loading이 되면 listener를 읽는다.
  - servlet-context 실행,  웹 관련 코드 실행
  - 웹, 비웹에서 사용하는 component를 구분하기 위해 xml 파일을 분리해놓았지만 분리하지 않고 사용하여도 에러는 발생하지 않는다.

  

- root-context.xml

  - namespace context 추가

  - 비웹 관련 component 설정( service, dao, dbuitl 추가 )

  - `<context:component-scan base-package="service, dao, dbutil"></context:component-scan>`

  - namesapce aop 추가

  - `<aop:aspectj-autoproxy></aop:aspectj-autoproxy>` 사용

  - default 설정은 false

  - db 관련 설정 추가

  - ```xml
    	<bean id="dataSource" class="org.springframework.jndi.JndiObjectFactoryBean">
    		<property name="jndiName" value="java:comp/env/jdbc/ssafy"></property>
    	</bean>
    ```

  

- servlet-context.xml

  - annotation driven 자동 설정

  - resources mapping 정보 수정

  - ``` xml
    	<resources mapping="/img/**" location="/resources/img/" />
    	<resources mapping="/css/**" location="/resources/css/" />
    	<resources mapping="/js/**" location="/resources/js/" />
    ```

  - View Resolver 자동 설정

  - component-scan base package 수정

  - 인터셉터 추가

  - 파일업로드, 다운로드 추가



- Main Controller 추가

  - `@Controller` Annotation
  - `/` 처음 index.jsp파일로 시작경로 지정

  

- index.jsp 파일 추가

  -  `<@% taglib="c" %>` 추가
  -  `c:set`을 사용해서 root경로를 지정한다. (index.jsp파일에서 지정하는 것 보단 header 파일에서 지정해 include하는게 보편적)

  

- Book Controller 추가

  - `@Controller` Annotation
  - `@RequestMapping(value="/book")` Annotation 추가

  

- Exception Controller advice

  - `ControllerAdivce` Annotation 사용
  - Controller에서 Exception이 발생했을 때 처리
  - `@ExceptionHandler(NoHandlerFoundException.class)` : 404 Not Found 발생시 실행
  - 추가적인 Exception 처리 시 `@ExceptionHandler(..)` ..위치에 exception class 입력
  - error page return

  

- Book Service
  - `@Service` Annotation 
  - `@Autowired` Dao 객체 DI 설정



- Book Dao

  - `@Repositroy` Annotation
  - `@Autowired` DBUtil, DataSource 
  - `root-context.xml` dataSource data pooling하기 위해 `bean` 설정
  - webapp 안에 META-INF 폴더를 생성해서  context.xml파일을 생성한다. jdbc를 사용하기 위해 mysql접근 관련 정보를 입력

  

- AOP 등록
  - `@Component, @Aspect` Annotation
  - Controller에 method마다 수행하지 말고, AOP 파일을 따로 작성
  -  비웹이므로 `root-context.xml` 파일에 설정 추가
  - `@Before` method 수행 전에 실행
  - `@Around` proceed는 중간 지점을 설정
    - proceed전에 작성된 코드는 실행 method 전에 체크
    - proceed 후에 작성된 코드는 실행 method 이후에 체크
  - `@AfterReturning`, `@AfterThrowing`

- Intercept 등록

  - 웹관련 설정이므로 `servlet-contex.xml` 파일에 설정 추가

  - `bean`으로 작성한 intercept class를 등록

  - `<interceptors>` 태그를 사용하여 mapping 시킨다.

  - ```xml
    <beans:bean id="confirm" class="com.ssafy.interceptor.ConfirmInterceptor"/>
    <interceptors>
    	<interceptor>
    		<mapping path="/guestbook/register"/>
    		<mapping path="/guestbook/modify"/>
    		<mapping path="/guestbook/delete"/>
    		<beans:ref bean="confirm"/>
    	</interceptor>
    </interceptors>
    ```

- MyInterceptor class 생성
  - `HandlerInterceptorAdaptor`를 extends 하여 작성
  - 3가지 method implement
    - preHandle : Controller를 수행하기 전에 수행, true return하면 정상 종료
    - postHandle :  Controller를 수행하고 수행(Exception 발생하지 않고 정상 종료)
    - afterCompletion : Exception이 발생하여도 무조건 마지막에 실행

