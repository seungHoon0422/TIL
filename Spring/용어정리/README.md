# Spring 용어정리


### EJB(Enterprise Java Bean)

2개의interface, 1개의 class, 설정파일 2개 를 무조건 작성해서 jar파일로 만들어 container에 배포 하고 테스트해야한다.

개발자의 입장에서는 상당히 불편한 작업, 배우기 어렵고 설정해야할 부분이 상당히 많다.



### Contaier

쉽게 생각해서 실행시킬 수 있는 환경을 구비해놓은 공간이라고 생각하면 된다. servlet의 제어권은 WAS(tomcat 서버)가 실행되면서, init, service, destroy라는 life cycle이 진행된다. 객체의 생성과 관리를 담당



### Spring Container

spring이 지원하는 서비스를 관리해주는 메모리 영역



### AOP(Aspect Oriented Programming)

관점 지향 프로그래밍, **관심사의 분리**를 통해서 소프트웨어의 **모듈성을 향상**, **공통 모듈**을 여러 코드에 쉽게 적용 가능

함수를 실행하면서 로그인 확인과같이 공통적으로 수행되는 작업들은 공통작업으로 빼놓는다.

함수의 시작부분, 함수의 마지막부분, 함수의 시작과 끝 동시에 지정하는 부분 

너는 니 할일만 해!! 공통으로 해야되는 부분은 내가 다 할께



### BeanFactory

2.x 버전까지 사용

Bean을 등록, 생성,조회,반환 관리



### ApplicationContext

3.x 버전부터 사용

BeanFactory + alpha

Bean 등록,생성,조회,반환 관리 기능

Spring의 부가서비스 추가 제공



### IoC





### DI (Dependency Injection)



### Spring Core
Spring Framework의 핵심 기능을 제공하며, Core 컨테이너의 주요 컴포넌트는 Bean Factory이다.
### Spring Context
Spring을 컨테이너로 만든 것이 Spring core의 BeanFactory라면, Spring을 Framework로 만든 것은 Context module이며, d이 module은 국제화된 메시지, Application 생명주기 이벤트, 유효성 검증 등을 지원함으로써 BeanFactory의 개념을 확장한다.
### Spring AOP
설정 관리 기능을 통해 AOP기능을 Spring Framework와 직접 통합시킨다.
### Spring DAO
Spring JDBC DAO추상 레이어는 다른 데이터베이스 벤더들의 예외 핸들링과 오류 메시지를 관리하는 중요한 예외 게층을 제공한다.
### Spring ORM
Spring Framework는 여러 ORM(Object Relational Mapping) Framework에 플러그인 되어, Object Relational Tool(JDO, Hibernate, iBatis)을 제공한다.
### Spring Web
Web Context module은 Aplication Context module 상위에 구현되어, Web 기반 Application에 context를 제공한다.
### Spring Web MVC
Spring Framework는 자체적으로 MVC 프레임워크를 제공하고 있으며, 스프링만 사용해도 MVC기반의 웹 어플리케이션을 어렵지 않게 개발이 가능하다.









### spring bean xml 설정

namespace를 통해 prefix 설정

`@Autowired`사용을 위해 context:component-scan 한줄 입력

객체를 주입할 경우 ref 속성을 사용





