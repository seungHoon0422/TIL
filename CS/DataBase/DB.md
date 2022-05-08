# Database

## RDBMS

- 관게형 데이터베이스 개념
- 데이터를 테이블 단위로 관리한다.
- 중복 데이터를 최소화시킨다. => 정규화 (데이터를 수정할 때 문제가 발생할 가능성이 높아진다.)
- 여러 테이블에 분산되어 있는 데이터를 검색 시 테이블 간의 관계(join)을 이용하여 필요한 데이터를 검색

## SQL

- Database에 있는 정보를 사용할 수 있도록 지원하는 언어
- 모든 DBMS에서 사용 가능하고, 대소문자는 구별하지 않는다. (단, 데이터의 대소문자는 구분)

## SQL의 종류

- DML(Data Manipulate Language)
  - 데이터를 조작가능
  - CRUD : 개별적으로 테이블에서 행을 검색, 입력, 변경, 제거한다.
  - SELECT, INSERT, UPDATE, DELETE
  - 주의 : update sql을 실행할 때 where절을 생략하는 모든 데이터가 변경된다.
  - SQL 예시
```sql
#insert
Insert into ssafy(userid, username) values ('ssafy', 'ssafy'); 

#update
Update ssafy set username='ssafy2' where userid='ssafy';

#delete
Delete from ssafy where username = 'ssafy';

# distinct
select * from ssafy;
select distinct username from ssafy;

# in
select userid, username, depid from ssafy
where depid in (50,60,70);

# like
select * from ssafy where username like '%x%'; // 이름에 x가 들어간 사람
select * from ssafy where username like '%x___'; // 이름의 끝에서 3번째 자리에 'x'가 들어간 사람

# order by
select * from ssafy order by salsary desc;
```



<br>

- DDL(Data Define Lanugage)
  - 테이블로부터 데이터 구조를 생성, 변경, 제거한다.
  - CREATE, ALTER, DROP, RENAME
  - Database 관련 SQL 예시
``` sql
  - 이모지 문자까지 처리
create database db default character set utf8mb4 collate utf8mb4_general_ci;
alter database db defaultcharacter set utf8mb4 collate utf8mb4_general_ci;
drop database db;
```

  - Table 관련 SQL 예시
```sql
  create table ssafy{
    idx       INT     NOT NULL AUTO_INCREMENT,
    userid    VARCHAR(16) NOT NULL,
    username  VARCHAR(20),
    PRIMARY KEY(idx)
  } ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

<br>


- DCL(Data Control Language)
- DB, Table의 접근권한이나 CRUD 권한을 정의
  - Database와 그 구조에 대한 접근권한을 제공하거나 제거한다.
  - GRANT, REVOKE

- TCL(Transaction Control Laguage)
  - 트랜잭션 제어어
  - COMMIT, ROLLBACK    



