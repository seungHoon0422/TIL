# Spring

 
## list
- [Spring](#spring)
  - [list](#list)
  - [Spring Framewokr란 ?](#spring-framewokr란-)
  - [Library](#library)
  - [Framework](#framework)
  - [Library vs Framework](#library-vs-framework)
  - [Spring MVC 구조](#spring-mvc-구조)
  - [IOC (Inversion of Control)](#ioc-inversion-of-control)
  - [DI (Dependency Injection)](#di-dependency-injection)
  - [DI의 장점](#di의-장점)



<br>


## Spring Framewokr란 ?

---

자바 플랫폼을 위한 **오픈소스 애플리케이션 프레임워크**이다.

**동적인 웹 사이트**를 개발하기 위해 여러가지 서비스를 제공한다.



## Library

---

라이브러리는 개발에 필요한 기능이 있을 때 직접 가져와 사용할 수 있도록 **자주 사용되는 기능들을 모아 미리 구현해둔 것**이다.

## Framework

---

프레임워크도 개발에 필요한 기능이 미리 구현되어 있는 것이다. 하지만 프레임 워크는 라이브러리와는 다르게 **기본 틀이 정해져있다**. 때문에 제약업싱 사용할 수 있는 라이브러리와 달리 프레임워크는 정해진 틀 안에서 미리 구현된 기능을 사용해야 한다.

스프링 프레임워크의 경우 **MVC** 구조안에서 개발자가 프로그램을 개발한다.



## Library vs Framework

---

라이브러리와 프레임워크의 가장 큰 차이는 **흐름을 누가 결정하는가**이다. 라이브러리는 개발자가 직접 프로그램의 흐름을 결정하지만 프레임워크는 정해진 흐름에 맞게 개발자가 프로그램을 개발한다.



## Spring MVC 구조

---

MVC는  Model - View - Controller의 줄임말이다.

- View - Controller - Service - ServiceImpl - DAO - DAOImpl - DTO

각 구조에 대해 보면 크게 View, Controller, Service, Dao, Dto 로 이루어져있다.

- View

말 그대로 **사용자에게 보여지는 화면**을 View라고 한다. Spring 에서는 JSP를 사용해 화면을 구성하고 Controller를 통해 백엔드 서버와 연결한다.

- Controller

**View와 Service 사이를 연결**해준다. 클라이언트가 입력한 URL에 맞는 View를 매핑해주고, View에서 처리하는 데이터를 Service로 전달해준다.

- Service

**실제 로직을 처리하는 곳**으로 모든 기능은 Service에서 만들어진다. Controller를 통해 화면과 연결되고, DAO를 통해 데이터베이스와 연결된다.

- DAO(Data Access Object)

**프로젝트와 데이터베이스를 연결**한다. Mapper에 SQL을 명시한 뒤 Mapper와 함께 데이터베이스와 데이터를 주고받는다.

- DTO(Data Transfer Object)

VO(Value Object)라고도 불리는 DTO는 MVC구조 사이사이에 **데이터 교환을 위한 오브젝트**이다. 특이하게 getter/setter 두가지 함수만 가지고 있으며, 주로 데이터베이스 테이블과 매칭된다.



## IOC (Inversion of Control)

---

IOC는 직역하면 제어의 역전으로 무엇인가 제어하는 주체가 바뀐다는 의미이다. Spring을 사용하다보면 직접 Servlet을 사용해 구현할때와 다르게 Service, DAO 같은 객체를 사용자가 직접 생성하지 않는다. @Autowired를 통해 받아 사용하는데 이 Autowired가 IoC이다. 

스프링 컨테이너(IoC Container)는 프로젝트에서 사용되는 객체들을 Bean 객체로 관리하고, @Autowired를 통해 객체를 주입해준다.

기존엔 사용자가 생성해 파라미터로 다른 객체로 보내거나, 사용할 일이 없는 경우 객체를 소멸하는 등 객체에 대한 제어를 직접 하였다. 하지만 Spring에서는 위처럼 사용자가 제어하느게 아니라, Spring Framework가 진행하기 때문에 제어의 역전이라고 표현한다.



## DI (Dependency Injection)

---

DI는 Spring에서 IoC 구조를 만드는 방식이다. DI를 그대로 해석하면 의존성 주입이다. DI를 사용하는 이유는 객체간의 의존성을 줄이기 위함이다. 밖에서 객체를 생성해 넣어주기 때문에 재사용성이 늘어나고 수정이 용이해진다. 

의존관계를 인터페이스로 추상화하게 되면, 더 다양한 의존 관계를 맺을 수가 있고, 실제 구현 클래스와의 관계가 느슨해지고, 결합도가 낮아진다.

토비의 스프링의 DI 만족을 위한 3가지 조건

> - 클래스 모델이나 코드에는 런타임 시점의 의존관계가 드러나지 않는다. 그러기 위해서는 인터페이스만 의존하고 있어야 한다.
> - 런타임 시점의 의존관계는 컨테이너나 팩토리 같은 제3의 존재가 결정한다.
> - 의존관계는 사용할 오브젝트에 대한 래퍼런스를 외부에서 제공해줌으로써 만들어진다.

## DI의 장점

---

1. 의존성이 감소한다.
2. 재사용성이 높은 코드가 된다.
3. 테스트하기 좋은 코드가 된다.
4. 가독성이 높아진다.
