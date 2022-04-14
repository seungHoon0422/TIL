## Spring MVC 구조


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