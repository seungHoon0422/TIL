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




### spring bean xml 설정

namespace를 통해 prefix 설정

`@Autowired`사용을 위해 context:component-scan 한줄 입력

객체를 주입할 경우 ref 속성을 사용





