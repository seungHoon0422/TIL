# IoC and DI


## IOC (Inversion of Control)


IOC는 직역하면 제어의 역전으로 무엇인가 제어하는 주체가 바뀐다는 의미이다. Spring을 사용하다보면 직접 Servlet을 사용해 구현할때와 다르게 Service, DAO 같은 객체를 사용자가 직접 생성하지 않는다. `@Autowired`를 통해 받아 사용하는데 이 Autowired가 IoC이다. 

스프링 컨테이너(IoC Container)는 프로젝트에서 사용되는 객체들을 `Bean` 객체로 관리하고, `@Autowired`를 통해 객체를 주입해준다.

기존엔 사용자가 생성해 파라미터로 다른 객체로 보내거나, 사용할 일이 없는 경우 객체를 소멸하는 등 객체에 대한 제어를 직접 하였다. 하지만 Spring에서는 위처럼 사용자가 제어하는게 아니라, Spring Framework가 제어하기 때문에 제어의 역전이라고 표현한다.

어떤 객체를 사용하기 위해 필요에 의해서 new를 하고 사용을 했다. 하지만 framework이후에는 사용하기 위해 만드는 것이 아니라, 미리 객체를 생성해놓고 가져다가 사용한다.

객체 생성을 Container에게 위임하여 처리한다.

### 객체간의 결합도를 낮추는 방식

- Interface 사용
- Interface -> Factory Pattern
- Factory Pattern -> Runtime에 객체 생성


### IoC 적용의 효과

- 객체 간의 결함도를 떨어트릴 수 있다(loose coupling)
- 객체간의 결합도가 높으면 높을수록 유지보수가 힘들다. 
- 수정이 필요한 클래스가 유지보수 될 때 그 클래스와 결합된 다른 클래스도 같이 유지보수 되어야 할 가능성이 높음


<br/>


### Container

#### Container 란?
- 객체의 생성, 사용, 소멸에 해당하는 라이프사이클을 담당
- 라이프사이클을 기본으로 애플리케이션 사용에 필요한 주요 기능을 제공

#### Container 기능
- 라이프사이클 관리
- Dependency 객체 제공
- Thread 관리
- 기타 애플리케이션 실행에 필요한 환경


#### Container 필요성
- 서비스, COnfiguration에 대한 일관성을 갖기 위해 사용
- 서비스 객체를 사용하기 위해 각각 Factory, Singleton 패턴을 직접 구현하지 않아도 됨


### IoC Container

> 스프링 프레임워크도 객체에 대한 생성 및 생명주기를 관리할 수 있는 기능을 제공한다.
> 이때, IoC 컨테이너가 기능을 제공

#### 기존의 객체 생성 과정
1. new를 통해 객체 생성
2. 의존성 객체 생성 - 클래스 내부에서 생성
3. 의존성 객체 메서드 호출

#### 스프링의 객체 생성 과정
1. 객체 생성
2. 의존성 객체 주입 - 스스로 만드는 것이 아닌, 제어권을 스프링에게 위임하여 스프링이 만들어 놓은 객체를 주입
3. 의존성 객체 메서드 호출


### Spring DI Container

Spring DI Container가 관리하는 객체를 Bean이라 하고, 이 Bean들의 생명주기를 관리하는 의미로 Bean Factory라고 한다.
Bean Factory에 여러가지 컨테이너 기능을 추가하여 ApplicationContext라고 한다.

#### Bean Factory (interface)
- Bean을 등록, 생성, 조회, 반환 관리
- 일반적으로는 BeanFactory보다는 이를 확장한 Application Context를 사용
- `getBean()` method가 정의되어 있다.

#### Application Context (interface)

- Bean을 등록, 생성, 조회, 반환 관리
- Spring의 각종 부가서비스를 추가로 제공


<br/>
<br/>



## DI (Dependency Injection)


DI는 Spring에서 IoC 구조를 만드는 방식이다. DI를 그대로 해석하면 의존성 주입이다. DI를 사용하는 이유는 객체간의 의존성을 줄이기 위함이다. 밖에서 객체를 생성해 넣어주기 때문에 재사용성이 늘어나고 수정이 용이해진다. 

의존관계를 인터페이스로 추상화하게 되면, 더 다양한 의존 관계를 맺을 수가 있고, 실제 구현 클래스와의 관계가 느슨해지고, 결합도가 낮아진다.

토비의 스프링의 DI 만족을 위한 3가지 조건

> - 클래스 모델이나 코드에는 런타임 시점의 의존관계가 드러나지 않는다. 그러기 위해서는 인터페이스만 의존하고 있어야 한다.
> - 런타임 시점의 의존관계는 컨테이너나 팩토리 같은 제3의 존재가 결정한다.
> - 의존관계는 사용할 오브젝트에 대한 래퍼런스를 외부에서 제공해줌으로써 만들어진다.

## DI의 장점


1. 의존성이 감소한다.
2. 재사용성이 높은 코드가 된다.
3. 테스트하기 좋은 코드가 된다.
4. 가독성이 높아진다.


### Annotation

Autowired를 하기 위해서는 component-scan (범위지정), component설정 2가지를 모두 설정해야한다.

- @Component

- @Controller, @Service, @Repository는 모두 Component를 상속받는다.

Component라고 작성해도 되지만, 보다 구체적으로 역할을 명시하기 위해 위의 3가지로 나누어서 작성

- @Autowired : 참고하고자 하는 객체에 DI를 위해 사용

- @Qualifier => 인터페이스를 참조할 경우 구현체가 여러개가 존재하면 value를 통해 참조한다.

- @scope : xml파일에서 scope 변수에 설정했지만  annotation으로 표현하는 방식으로 변경 
  - `@Scope("singleton")`
  - scope의 종류 : singleton, prototype(빈 요청때마다   새로운 인스턴스 생성), request, session