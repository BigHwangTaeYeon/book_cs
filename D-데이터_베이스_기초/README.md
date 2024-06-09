# 💡데이터 베이스 기초
데이터 베이스 개론
database(DB) : 전자적으로(electronically) 저장되고 사용되는 관련있는(related) 데이터들의 조직화된 집합(organized collection)
관련있는 데이터들 - 같은 서비스에서 사용되는 데이터
DBMS(database management systems) : 사용자에게 DB를 정의하고 만들고 관리하는 기능을 제공하는 소프트웨어 시스템(PostgreSQL MySQL ORACLE ...)
DB를 정의하다 보면 부가적인 데이터가 발생(metadata)
metadata : data about data, 데이터를 설명하기 위한 데이터 (사진을 찍으면 그 사진의 해상도는 얼마인지.)
database 를 정의하거나 기술하는(descriptive) data
catalog 라고도 부름
e.g.) 데이터 유형, 구조, 제약 조건, 보안, 저장, 인덱스, 사용자 그룹 등등
metadata 또한 DBMS 를 통행 저장/관리된다.
database system : database + DBMS + 연관된 applications
줄여서 database 라고도 부름
유저 -> 어플리케이션 쿼리 -> 쿼리 분석 -> 요청 처리 -> 메타데이터 확인 ->요청 처리(스토리지)
|유저	|	DatabaseSystem |	DBMS Software |
data models
DB의 구조(structure)를 기술하는데 사용될 수 있는 개념들이 모인 집합
DB 구조를 추상화해서 표현할 수 있는 수단을 제공한다
data model 은 여러 종류가 있으며 추상화 수준과 DB 구조화 방식이 조금씩 다르다
DB 에서 읽고 쓰기 위한 기본적인 동작들(operations)도 포함한다
* DB 구조 : 데이터 유형, 데이터 관계(relationship), 제약 사항(constraints) 등등
분류
- conceptual(개념적) (or high-level) data models
일반 사용자들이 쉽게 이해할 수 있는 개념들로 이뤄진 모델
추상화 수준이 가장 높음
비즈니스 요구 사항을 추상화하여 기술할 때 사용
대표적 conceptual data model 이 entity-relationship model - 데이터베이스 구조를 엔티티와 엔티티들간의 관계로 모델링하는 것
ER diagram
- logical(논리적) (or representational표현적인) data models
이해하기 어렵지 않으면서도 디테일하게 DB를 구조화 할 수 있는 개념들을 제공
데이터가 컴퓨터에 저장될 때의 구조와 크게 다르지 않게 DB 구조화를 가능하게 함
특정 DBMS 나 storage 에 종속되지 않는 수준에서 DB를 구조화할 수 있는 모델
table 의 low 는 데이터 각각, column 은 속성(attribute)을 의미
종류
- relational data model(가장 많이 사용)
Oracle, MySQL, MS-SQL
- object data model
- object-relational data model
PostgreSQL
- physical(육체적인) (or low-level) data models
컴퓨터에 데이터가 어떻게 파일 형태로 저장되는지를 기술할 수 있는 수단을 제공
data format, data orderings, access path 등등
access path : 데이터 검색을 빠르게 하기 위한 구조체, e.g)index
database schema
data model 을 바탕으로 database 의 구조를 기술(description) 한 것
schema 는 database 를 설계할 때 정해지며 한번 정해진 후에는 자주 바뀌지 않는다
database state
database 에 있는 실제 데이터는 꽤 자주 바뀔 수 있다
특정 시점에 database 에 있는 데이터를 database state 혹은 snapshot 이라고 한다
혹은 database 에 있는 현재 instances 의 집합이라고도 한다
three-schema architecture (database architecture)
database system 을 구축하는 architecture 중의 하나
user application 으로 부터 물리적인(physical) database 를 분리시키는 목적
세 가지 level 이 존재하며 각각의 level 마다 schema 가 정의되어 있다
스키마 종류
End Users	->	External Level 	->	Conceptual Level 	->	Internal Level 	->	Stored database
- external schemas (or user views) at external (or view) level
external views, user views 라고도 불림
특정 유저들이 필요로 하는 데이터만 표현
그 외 알려줄 필요가 없는 데이터는 숨김
logical data model 을 통해 표현
- conceptual schemas at conceptual level
전체 database 에 대한 구조를 기술
물리적인 저장 구조에 관한 내용은 숨김
entities, data types, relationships, user operations, constrains에 집중
logical data model 을 통해 기술
- internal schemas at internal level
물리적으로 데이터가 어떻게 저장되는지 physical data model 을 통해 표현
data storage, data structure, access path 등등 실체가 있는 내용 기술
각 레벨을 독립시켜서 어느 레벨에서의 변화가 상위 레벨에 영향을 주지 않기 위함
대부분의 DBMS 가 three level 을 완벽하게 혹은 명시적으로 나누지는 않음
데이터가 존재하는 곳은 internal level

	데이터 베이스 언어
		data definition language (DDL)
			conceptual schema 를 정의하기 위해 사용되는 언어
			internal schema 까지 정의할 수 있는 경우도 있음
		storage definition language (SDL)
			internal schema 를 정의하는 용도로 사용되는 언어
			요즘은 특히 relational DBMS 에서는 SDL 이 거의 없고 파라미터 등의 설정으로 대체됨
		view definition language (VDL)
			external schemas 를 정의하기 위해 사용되는 언어
			대부분의 DBMS 에서는 DDL 이 VDL 역할까지 수행
		data manipulation language (DML)
			database 에 있는 data 를 활용하기 위한 언어
			data 추가, 삭제, 수정, 검색 등등의 기능을 제공하는 언어
		통합된 언어
			오늘날의 DBMS 는 DML VDL DDL 이 따로 존재하기 보다는 통합된 언어로 존재
			대표적인 예가 relational database language : SQL

관계형 데이터베이스 (relational database)
set (relation 이 수학에서의 의미를 알기 위한 배경지식)
서로 다른 elements 를 가지는 collection
하나의 set 에서 elements 의 순서는 중요하지 않다.
e.g.) 1,3,11,4,7

relational data model
    주요 개념 			|	설명
    domain			|	set of atomic values ( 더이상 나누어질 수 없는 값들의 집합 )
    domain name 	| 	domain 이름
    attribute 		|	domain 이 relation 에서 맡은 역할 이름
    tuple 			|	각 attribute 의 값으로 이루어진 리스트. 일부 값은 NULL 일 수 있다.
    relation 		|	set of tuples ( 튜플들의 집합 )
    relation name 	|	relation 의 이름

relation schema, .. etc
    relation 의 구조를 나타낸다
    relation 이름과 attribute 리스트로 표기된다
    e.g.) STUDENT(id, name, grade, major, phone_num, emer_phone_num)
        relation 이름을 적어주고 괄호 안에 attribute 를 적어준다
    attributes 와 관련된 constraints 도 포함한다
        constraints
    degree of a relation
        relation schema 에서 attributes 의 수
        e.g.) STUDENT(id, name, grade, major, phone_num, emer_phone_num) -> degree 6
    relation(or relation state)
        set of tuples (튜플들의 집합)
        데이터에 한정해서 relation 이라 칭한다
relational database(관계형 디비)
    relational data model 에 기반하여 구조화된 database
    relational database 는 여러 개의 relations 로 구성된다
    relation database schema
        relation schema set + integrity constraints set
        릴레이션 스키마 집합 + integrity 관련된 contraints set 으로 구성
relation의 특징들
    relation 은 중복된 tuple 을 가질 수 없다 (relation is set of tuples)
        서로 다른 튜플인데 튜플의 모든 값들이 동일한 튜플은 존재할 수 없다.
    relation 의 tuple 을 식별하기 위해 attribute 의 부분 집합을 key 로 설정한다.
        id 를 통해 유니크하게 식별자로 사용
    relation 에서 tuple 의 순서는 중요하지 않다
        순서가 바뀌어도 릴레이션의 의미는 달라지지 않는다
    하나의 relation 에서 attribute 의 이름은 중복되면 안된다
    하나의 tuple 에서 attribute 의 순서는 중요하지 않다.
    attribute 는 atomic 해야 한다 (composite or multivalued attribute 허용 안됨) (atomic : 원자적인, 더 이상 나누어 질 수 없는)
        주소 컬럼에 서울시 강남구 청담동 attribute는 서울시 / 강남구 / 청담동 이렇게 나누어 질 수 있기에 composite 이며
        전공 컬럼에 컴공, 디자인 attribute는 복수 전공이니 나누어 주어야 하기에 multivalued 이다
NULL의 의미
    값이 존재하지 않는다
    값이 존재하나 아직 그 값이 무엇인지 알지 못한다
    해당 사항과 관련이 없다
        토익 점수가 업데이트 안됬거나 시험을 안봤거나
        최대한 사용하지 않는 것이 좋다
key 설명 (기본키, 외래키 등등)
    superkey
        relation 에서 tuples 를 unique 하게 식별할 수 있는 attributes set
        e.g. PLAERY(id, name, team_id, back_number, birth_date) 의 superkey는
            {id, name, team_id, back_number, birth_date}, {id, name}, {name, team_id, back_number}, ... etc
    candidate key
        어느 한 attribute 라도 제거하면 unique 하게 tuples 를 식별할 수 없는 super key
        key or minimal superkey
        e.g. PLAERY(id, name, team_id, back_number, birth_date) 의 candidate key 는
            {id}, {team_id, back_number}	- id 더이상 attribute 를 나눌 수 없고, team_id, back_number 를 나누어 독립적으로 식별할 수 없다
    primary key
        relation 에서 tuple 를 unique 하게 식별하기 위해 선택된 candidate key
        e.g. PLAERY(id, name, team_id, back_number, birth_date) 의 primary key 는
            {id} or {team_id, back_number}	- 보통 attribute 적은 쪽으로 primary key 가 선택된다
    unique key
        primary key 가 아닌 candidate keys
        alternate key
        e.g. PLAERY(id, name, team_id, back_number, birth_date) 의 unique key 는
            {team_id, back_number}
    foreign key
        다른 relation 의 PK 를 참조하는 attributes set
        e.g. PLAERY(id, name, team_id, back_number, birth_date) 와 TEAM(id, name, manager) 가 있을 때,
            foreign key 는 PLAYER 의 {team_id}
constraints 설명
    relational database 의 relations 들이 언제나 항상 지켜줘야 하는 제약 사항
    제약사항
        implicit constraints
            relational data model 자체가 가지는 constraints
            relation 은 중복되는 tuple 을 가질 수 없다
            relation 내에서는 같은 이름의 attribute 를 가질 수 없다
        schema-based constraints
            주로 DDL 을 통해 schema 에 직접 명시할 수 있는 constraints
            explicit constraints
            종류
            domain constraints
                attribute 의 value 는 해당 attribute 의 domain 에 속한 value 여야 한다
                    학년에 1,2,3 은 이해되도 100 학년은 말이 안된다
            key constraints
                서로 다른 tuples 는 같은 value 의 key 를 가질 수 없다.
                    같은 primary key 값을 가질 수 없다
            NULL value constraints
                attribute 가 NOT NULL 로 명시됐다면 NULL 을 값으로 가질 수 없다
            entity integrity constraint
                primary key 는 value 에 NULL 을 가질 수 없다
            referential integrity constraint
                FK 와 PK 와 도메인이 같아야 하고 PK 에 없는 values 를 FK 가 값으로 가질 수 없다

SQL의 개념과 SQL로 데이터베이스를 정의하는 법을 배웁니다.
SQL 기본 개념
SQL (Structured Query Language)
현업에서 쓰이는 relational DBMS 의 표준 언어
종합적인 database 언어 : DDL + DML + VDL
주요 용어
relational data models					SQL
relation							table
attributes							column
tuple								row
domain								domain
SQL 에서 relation 이란 ?
multiset(=bag) of tuples @ SQL (multiset 이란 set 과는 반대로 중복응 허용한다는 뜻)
중복된 tuple 을 허용한다
SQL & RDBMS
SQL 은 RDBMS 의 표준 언어이지만 실제 구현에 강제가 없기 때문에 RDBMS 마다 제공하는 SQL 의 스펙이 조금씩 다르다
MySQL로 정의할 예제 DB 소개

database 만들기
    DATABASE vs SCHEMA
        MySQL 에서는 DATABASE 와 SCHEMA 가 같은 뜻을 의미
        CREATE DATABASE company = CREATE SCHEMA company
        다른 RDBMS 에서는 의미가 다르게 쓰임
        i.g. PostgreSQL 에서는 SCHEMA 가 DATABASE 의 namespace 를 의미
table 만들기 시작

attribute data type 소개
    attribute data type : 숫자
        정수					정수를 저장할 때 사용 						TINYINT, SMALLINT, MEDIUMINT, INT or INTEGER, BIGINT
        부동 소수점 방식 		실수(real number)를 저장할 때 사용 			FLOAT, DOUBLE or DOUBLE PRECISION
         (floating-point)	고정 소수점 방식에 비해 정확하지 않다
        고정 소수점 방식 		실수를 정확하게 저장할 때 사용 					DECIMAL or NUMERIC
         (fixed-point)		DECIMAL(5,2) => [-999.99~999.99]
    attribute data type : 문자열
        고정 크기 문자열		최대 몇 개의 '문자'를 가지는 문자열을 저장할지를 지정 					CHAR(n)
                            저장될 문자열의 길이가 최대 길이보다 작으면 나머지를 space로 채워서 저장 	(0 <= n <= 255)
                            name char(4)일 때 다음과 같이 저장 : 'a   ', '한국  ', '고고고고'
        가변 크기 문자열 		최대 몇 개의 '문자'를 가지는 문자열을 저장할지를 지정 					VARCHAR(n)
                            저장될 문자열의 길이 만큼만 저장 									(0 <= n <= 65,535)
                            name varchar(4)일 때 다음과 같이 저장 : 'a', '한국', '고고고고'
        사이즈가 큰 문자열 		사이즈가 큰 문자열을 저장할 때 사용 									TINYTEXT, TEXT, MEDIUMTEXT, LONGTEXT
PRIMARY KEY 적용하기
    primary key : table 의 tuple 을 식별하기 위해 사용, 하나 이상의 attribute(s)로 구성
    primary key 는 중복된 값을 가질 수 없으며, NULL 도 값으로 가질 수 없다
    attribute 하나일 경우
        create table PLAYER ( id INT PRIMARY KEY)
    attribute 둘 이상
        create table PLAYER ( team_id VARCHAR(12), back_number INT ... PRIMARY KEY (team_id, back_number))
UNIQUE constraint 적용하기
    Key constraints : UNIQUE
        UNIQUE 로 지정된 attribute(s)는 중복된 값을 가질 수 없다
        단 NULL 은 중복을 허용할 수도 있다 (RDBMS 마다 다름)
NOT NULL constraint 적용하기
    attribute 가 NOT NULL 로 지정되면 해당 attribute 는 NULL 을 값으로 가질 수 없다
    보통 UNIQUE 와 같이 사용, UNIQUE 가 NULL 을 허용하는 RDBMS 도 있기에
DEFAULT 적용하기
    attribute DEFAULT
        attribute 의 default 값을 정의할 때 사용
        새로운 tuple 을 저장할 때 해당 attribute 에 대한 값이 없다면 default 값으로 저장
        i.g. salary DEFAULT 50000000 이라면 따로 지정하지 않을 때 디폴트 값이 저장
CHECK constraint 적용하기
    CHECK constraint
        attribute 의 값을 제한하고 싶을 때 사용
        i.g. salary CHECK (salary >= 50000000) 라면 10000000으로 입력이 불가능
    attribute 하나일 경우
        create table PLAYER ( age INT CHECK (age >= 20))
    attribute 둘 이상
        create table PLAYER ( start_date DATE, end_date DATE ... CHECK (start_date < end_date))
    CHEC (sex in ('M', 'F'))
FOREIGN KEY 적용하기
    Referential integrity constraint : FOREIGN KEY
        attribute(s) 가 다른 table 의 primary key 나 unique key 를 참조할 때 사용
    선언 방법
    reference_option		설명
    CASCADE					참조값의 삭제/변경을 그대로 반영
    SET NULL 				참조값이 삭제/변경 시 NULL 로 변경
    RESTRICT 				참조값이 삭제/변경되는 것을 금지
    NO ACTION 				RESTRICT 와 유사
    SET DEFAULT 			참조값이 삭제/변경 시 default 값으로 변경

    create table PLAYER (
        dept_id INT,
        FOREIGN KEY (dept_id)
            references DEPARTMENT(id)
            on delete reference_option
            on update reference_option
    )
constraint에 이름 붙이기
    이름을 붙이면 어떤 constraint 을 위반헀는지 쉽게 파악할 수 있다
    constraint 를 삭제하고 싶을 때 해당 이름으로 삭제 가능
ALTER TABLE로 schema 변경하기
    atrribute 추가 				ALTER TABLE employee ADD blood VARCHAR(2);
    attribute 이름 변경 			ALTER TABLE employee RENAME COLUMN phone TO phone_num;
    attribute 타입 변경 			ALTER TABLE employee MODIFY COLUMN blood CHAR(2);
    table 이름 변경 				ALTER TABLE logs RENAME TO backend_logs;
    primary key 추가 				ALTER TABLE log ADD PRIMARY KEY (id);
    ...

    이미 서비스 중인 table 의 schema 를 변경하는 것이라면 변경 작업 때문에 서비스의 백엔드에 영향이 없을지 검토 후 변경하는 것이 중요
table 삭제하기
    DROP TABLE
        table 을 삭제할 때 사용
        DROP TABLE table_name;
DB 구조 정의할 때 중요한 점
    만들려는 서비스의 스펙과 데이터 일관성, 편의성, 확장성 등등을 종합적으로 고려하여 DB 스키마를 적절하게 정의하는 것이 중요하다
    시니어와 주니어의 기준을 가르는 척도가 DATABASE 설계이기도 하다

