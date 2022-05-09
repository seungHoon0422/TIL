# myBatis 적용시 변경사항



- pom.xml 

  - myBatis 관련 설정 등록

  - `<property>` 설정

  - ```  xml
    <mybatis-version>3.5.9</mybatis-version>
    ```

  - `<dependency>` 설정

  - ``` xml
    <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>${mybatis-version}</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis-spring</artifactId>
      <version>${mybatis-spring-version}</version>
    </dependency>
    ```

  

- mapper xml 작성

  -  namespace 설정
    - `com.ssafy.guestbook.model.dao.MemberDao` 와 같이 class 명으로 설정
    - 협업 과정에서 충돌이 발생하지 않게 최대한 상세하게 설정한다.(중복되지 않게)
    - `id` : Dao에서 사용하는 method 명과 동일하게 작성
    - `parameterType` : mybatis-config파일에 설정되어있는 alias 사용(full class path사용해도 상관없음)
    - sql문 안의 value값을 넣을때에는 `#{columnName}`와 같이 사용한다.(대소문자 구분 없음)
    - 알맞는 getter, setter 실행



- mybatis-config.xml
  - JDBC 연결 관련 설정정보 저장
  - Dao mapping 경로 저장
  - type Aliases 설정을 통해 간편하게 사용



* Dao sql 처리방식 변경
  * 기존 StringBuilder를 사용하여 sql문을 사용하여 작성하여 query를 날리는 방식에서 SqlSession을 사용해 dBUtil을 사용하지 않는다.
  * Connection, PSTMT, ResultSet을 사용하여 DB에 접근하는 방식에서 SqlSession을 사용하여 선언해놓은 SqlMapConfig class를 통해 객체를 받아온다. 
  * 중복되는 Namespace는 final 선언을 통해 제거
  * 기본적으로 auto commit option값이 false로 되어있기 때문에 Sql문을 실행시킬 때마다 DB에 적용시키려면 매번 commit()을 수행해야 한다.



# MyBatis Spring



- 스프링을 사용하는 경우에는 Spring Container에 MyBatis 관련 Bean을 등록하여 사용
- 기존에 복잡하게 처리했던 Transaction을 간단하게 처리 가능
- Data Source 설정
  - 스프링에서 데이터 소스를 관리하므로 MyBatis 설정 파일에서는 일부 설정 생략
- Transaction Manager 설정
  - Transaction Manager 아이디를 가진 빈은 트랜잭션을 관리하는 객체이다.
  - MYBatis 는 JDBC를 그대로 사용하기 때문에 DataSourceTransactionManager 타입의 빈을 사용
  - tx:annotation-driven 요소는 트랜잭션 관리방법을 어노테이션으로 선언하도록 설정
  - Spring은 메소드나 클래스에 `@Transactional` Annotation이 선언되어있으면 AOP를 통해 트랜잭션 처리 ? 
- SqlSessionFactoryBeam 설정
  - Spring에서 SqlSessionFactory 객체를 생성하기 위해서는 SqlSessionFactoryBean을 빈으로 등록해야 한다.
- mapper bean 등록
  - Mapper





### 설정파일 적용 순서

- 프로젝트가 실행되면 Meta-INF 폴더에 점근해서 context.xml파일을 먼저 읽는다.
- context.xml파일이 없으면 자동적으로 web.xml파일을 읽고, context.xml파일이 존재하는 경우 DB connection 을 실행한 후 web.xml Watch Resource태그를 확인하고 web.xml 파일을 읽는다.



### pom.xml

- ``` xml
  <mybatis-version>3.5.9</mybatis-version>
  <mybatis-spring-version>2.0.7</mybatis-spring-version>
  ```

  

### root-context.xml

- 이전에는 SqlMapConfig를 통해 sqlSessionFactory를 직접 생성했지만 객체이므로 `bean`으로  등록하여 spring container가 관리

- type Alias, data Source, Mapper `<property>` 추가

  ``` xml
  <bean id="sqlSessionFactoryBean" class="org.mybatis.spring.SqlSessionFactoryBean">
    <property name="dataSource" ref="ds"/>
    <property name="mapperLocations" value="classpath:mapper/*.xml"/>
    <!-- 		<property name="configLocation" value="classpath:mybatis-config.xml"></property> -->
    <property name="typeAliasesPackage" value="com.ssafy.guestbook.model"></property>
  </bean>
  ```

  classpath : => src 폴더의 경로를 알려준다.



- 기본적으로 auto-commit이 된다.

- 트랜잭션 처리를 해야하는 method에서는 `@transactional` Annotation을 선언하면 데이터 처리 중 exception 발생할 경우 rollback, exception이 발생하지 않고 정상 종료될 경우 auto commit이 된다.

- 위의 transaction처리가 자동으로 되게 하기 위해서는 spring-tx가 pom.xml에 들어있어야 한다.

- transaction 관리는 웹과 관련없는 항목이기 때문에  root-context.xml에 추가해야 한다.

- namespace `tx` 추가 후 transcation manager 설정 추가

- `dataSource`에 대한 transaction 관리

- Transcation Manager를 `bean`객체로 등록 후 `<tx:annotation-driven>`을 통해 transaction Manager 등록

- ``` xml
  <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="ds"/>
  </bean>	
  <tx:annotation-driven transaction-manager="transactionManager"/>
  ```

- mybatis-config.xml파일은 삭제해도 무관



- 최종적으로 추가된 root-context.xml

``` xml
<bean id="ds" class="org.springframework.jndi.JndiObjectFactoryBean">
  <property name="jndiName" value="java:comp/env/jdbc/ssafy"></property>
</bean>

<bean id="sqlSessionFactoryBean" class="org.mybatis.spring.SqlSessionFactoryBean">
  <property name="dataSource" ref="ds"/>
  <property name="mapperLocations" value="classpath:mapper/*.xml"/>
  <!-- 		<property name="configLocation" value="classpath:mybatis-config.xml"></property> -->
  <property name="typeAliasesPackage" value="com.ssafy.guestbook.model"></property>
</bean>

<bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
  <constructor-arg ref="sqlSessionFactoryBean"/>
</bean>

<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
  <property name="dataSource" ref="ds"/>
</bean>	
<tx:annotation-driven transaction-manager="transactionManager"/>
```











