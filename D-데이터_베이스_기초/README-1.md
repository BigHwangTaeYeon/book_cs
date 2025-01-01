💡데이터 베이스 기초
https://www.youtube.com/@ezcd

```text
subquery로 하나의 query로 만드는 것보다 query 두 개를 쓰는 성능
	사용하는 DBMS에서 execution plan을 통해 성능 차이를 확인/비교

1. 데이터 베이스 개론
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

2. 관계형 데이터베이스 (relational database)
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

3. SQL의 개념과 SQL로 데이터베이스를 정의하는 법을 배웁니다.
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

4. SELECT
	projection attributes, selection condition, join condition	
		SELECT name, position FROM employee WHWER id = 9;
			id = 9 처럼 조건을 명시하는 것을 selection condition 이라고 한다.
			관심있는 attribute(name, position)만 가져오는 것을 projection attributes라고 한다.
		SELECT statement
			SELECT attribute(s)
			FROM table(s)
			[WHERE condition(s)]; - 관심있는 tuple 만 가져오기
		project 2002를 리딩(leading)하고 있는 임직원의 ID와 이름과 직군을 알고 싶다.
			project table 과 employee table 을 연결해야한다.
			project table 의 leader_id attribute 를 references 하는 employee id 를 통해 접근
				SELECT employee.id, employee.name, positioni
				FROM project, employee
				WHERE project.id = 2002 and project.leader_id = employee.id;
			project.leader_id = employee.id 는 두 개의 테이블을 연결시키는 조건이다, 두 개의 테이블을 조인시키는 조건이다라는 뜻에 join condition 이라고 한다.
	AS : 별칭
	DISTINCT : 중복되는 tuple 을 제거
	LIKE 
		LIKE 'J___' (J로 시작하는 4글자, 언더 스코어를 사용)
		LIKE '\%%' (% 문자로 시작하는 문자 찾기)
		LIKE '%\_' (언더 스코어로 끝나는 문자 찾기)

		LIKE				문자열 pattern matching 에 사용
		reserved character	%	0개 이상의 임의의 개수를 가지는 문자들을 의미
							_ 	하나의 문자를 의미
		escape character	\	예약 문자를 escape 시켜서 문자 본연의 문자로 사용하고 싶을 때 사용
	* (asterisk) : 선택된 tuple 의 모든 attributes 를 보여주고 싶을 때 사용

5. SUBQUERY
	subquery(nested query or inner query) : dml 에 포함된 query
	outer query(main query) : subquery 를 포함하는 query
	
	IN(v1, v2, v3 ...) : v가 (v1, v2, v3 ..) 중에 하나와 값이 같다면 TRUE 를 return 한다.
	(v1, v2, v3 ...) 는 명시적인 값들의 집합일 수도 있고 subquery 의 결과(set or multiset)일 수도 있다.
	v NOT IN (v1, v2, v3 ...) : v가 (v1, v2, v3 ...)의 모든 값과 값이 다르다면 TRUE 를 return 한다.

	unqualified attribute 가 참조하는 table 은
	해당 attribute 가 사용된 query 를 포함하여 그 query 의 바깥쪽으로 존재하는 모든 queries 중에 해당 attribute 이름을 가지는 가장 가까이에 있는 table 을 참조한다.
		(unqualified attribute 란? 쿼리에서 어트리뷰트에 릴레이션을 지정하지 않은 상태, proj_id 처럼. works_on.proj_id 하면 지정한 상태.)

	ID 가 7 혹은 12 인 임직원이 참여한 프로젝트의 ID 와 이름을 알고 싶다.
		SELECT P.id, P.name
		FROM project P
		WHERE EXISTS (
				SELECT *
				FROM works_on W
				WHERE W.proj_id = P.id AND W.empl_id IN (7,12)
			);
		-- 서브쿼리에 존재하는 튜플을 찾게 된다. EXISTS 는 서브 쿼리에서 찾은 튜플에 대해 TRUE 를 반환하여, 찾은 튜플에 해당하는 project 릴레이션에서 튜플을 가져온다.

		SELECT P.id, P.name
		FROM project P
		WHERE id IN (
				SELECT W.proj_id
				FROM works_on W
				WHERE W.empl_id IN (7,12)
			);

	리더보다 높은 연봉을 받는 부서원을 가진 리더의 ID 와 이름과 연봉을 알고 싶다.
		SELECT E.id, E.name, E.salary
		FROM department D, employee E
		WHERE D.leader_id = E.id AND E.salary < ANY (
				SELECT salary
				FROM employee
				WHERE id <> D.leader_id AND dept_id = E.dept_id
			);
		-- <>의 의미는 != 과 같음, E.salary < ANY 의미는 E.salary 가 단 하나라도 작은 경우가 있다면.

	v comparison_operator ANY (subquery) : subquery 가 반환한 결과들 중에 단 하나라도 v 와의 비교 연산이 TRUE 라면 TRUE 를 반환한다.
	SOME 도 ANY 와 같은 역할을 한다.

	ID 가 13 인 임직원과 한번도 같은 프로젝트에 참여하지 못한 임직원들의 ID, 이름, 직군을 알고 싶다.
		SELECT DISTINCT E.id, E.name, E.position
		FROM employee E, works_on W
		WHERE E.id = W.empl_id AND W.proj_id <> ALL (
				SELECT proj_id
				FROM works_on
				WHERE empl_id = 13
			);
	-- 서브쿼리와 전부 같지 않은 proj_id

	v comparison_operator ALL (subquery) : subquery 가 반환한 결과들과 v와의 비교 연산이 모두 TRUE 라면 TURE 를 반환한다.

	성능 비교 : IN vs EXISTS
		RDBMS 의 종류와 버전에 따라 다르며 최근 버전은 많은 개선이 이루어져서 IN 과 EXISTS 의 성능 차이가 거의 없는 것으로 알고 있습니다.

6. NULL의 의미와 NULL이 포함된 비교 연산을 수행할 때의 결과
	SQL에서 NULL의 의미
		- unknown (알려지지 않음, 생일 속성이 있고 당연히 클라이언트는 있겠지만 튜플에 없을 때)
		- unavailable or withheld (본인의 생일 정보를 공개하지 않을 때, 생일 정보를 이용할 수 없다)
		- not applicable(현대에는 집 전화가 필요 없음 그러므로 입력할 필요 없음, 해당 사항이 아님)

	SELECT id FROM employee WHERE birth_date = NULL;
	결과 : Empty set(0.00 sec)
		null 을 연산하기 위해서는 =(equal)이 아닌 IS 연산자를 사용해야한다.
	SELECT id FROM employee WHERE birth_date IS NULL;
	id
	--
	14
	15

	NULL과 Three-Valued Logic
		SELECT * FROM employee where birth_date = '1990-03-09';
	
	- SQL에서 NULL과 비교 연산을 하게 되면 그 결과는 "UNKNOWN"이다.
	- UNKNOWN은 'TRUE일 수도 있고 FALSE일 수도 있다'라는 의미이다.
	- three-valued logic : 비교/논리 연산의 결과로 TRUE, FALSE, UNKNOWN을 가진다.

	비교연산		결과
	1  = 1 		TRUE
	1 != 1 		FALSE
	1  = NULL 	UNKNOWN
	1 != NULL 	UNKNOWN
	1  > NULL  	UNKNOWN
	1 <= NULL  	UNKNOWN
	NULL = NULL UNKNOWN

	AND 연산
	TRUE   	UNKNOWN 	UNKNOWN
	FALSE   UNKNOWN 	FALSE
	UNKNOWN UNKNOWN 	UNKNOWN

	OR 연산
	TRUE   	UNKNOWN 	TRUE
	FALSE   UNKNOWN 	UNKNOWN
	UNKNOWN UNKNOWN 	UNKNOWN

	NOT
	TRUE   	UNKNOWN 	UNKNOWN
	FALSE   UNKNOWN 	UNKNOWN
	UNKNOWN UNKNOWN 	UNKNOWN

	WHERE절의 condition(s)
		- where절에 있는 condition(s)의 결과가 TRUE인 tuple(s)만 선택 된다.
		- 즉, 결과가 FALSE거나 UNKNOWN이면 tuple은 선택되지 않는다.

	NOT IN 주의사항
	3 not in (1,2,4)		TRUE
	3 not in (1,2,3)		FALSE
	3 not in (1,3,NULL)		FALSE
	3 not in (1,2,NULL)		UNKNOWN

7. SQL에서 JOIN의 의미와 종류와 특징
	조인 의미 : 두 개 이상의 table들에 있는 데이터를 한 번에 조회하는 것, 여러 종류의 JOIN이 존재한다.
		- Primary Table : from 절의 테이블
	implicit join vs explicit join
		implicit join : from절에는 table들만 나열하고 where절에 join condition을 명시하는 방식
			- old-style join syntax
			- where 절에 selection condition과 join condition이 같이 있기 때문에 가독성이 떨어진다.
			- 복잡한 join 쿼리를 작성하다 보면 실수로 잘못된 커리를 작성할 가능성이 크다.
			- ID가 1인 임직원이 속한 부서 이름은?
				SELECT D.name
				FROM employee AS E, department AS D
				WHERE E.id = 1 and E.dept_id = D.id;	-- E.id = 1 selection condition, E.dept_id = D.id join condition
		explicit join : from절에 JOIN 키워드와 함께 joined table들을 명시하는 방식
			- from절에서 ON 뒤에 join condition이 명시된다.
			- 가독성이 좋다.
			- 복잡한 join 쿼리 작성 중에도 실수할 가능성이 낮다.
			- ID가 1인 임직원이 속한 부서 이름은?
				SELECT D.name
				FROM employee AS E JOIN department AS D ON E.dept_id = D.id
				WHERE E.id = 1;
	Inner join vs Outer join
		Inner join : 두 table에서 join condition을 만족하는 tuple들로 result table을 만드는 join
			- FROM table1 [INNER] join table2 ON join_condition
			- join condition에 사용 가능한 연산자(operator) : =, <, >, != 등등 여러 비교 연산자가 가능하다.
			- join condition에서 null 값을 가지는 tuple은 result table에 포함되지 못한다.
			SELECT *
			FROM employee AS E JOIN department AS D ON E.dept_id = D.id;
			-- JOIN 키워드 앞에 INNER 생략된 것이다.
		Outer join : 두 table에서 join condition을 만족하지 않는 tuple들도 result table에 포함하는 join
			- FROM table1 LEFT [OUTER] JOIN table2 ON join_condition
			- FROM table1 RIGHT [OUTER] JOIN table2 ON join_condition
			- FROM table1 FULL [OUTER] JOIN table2 ON join_condition
			- join condition에 사용 가능한 연산자(operator) : =, <, >, != 등등 여러 비교 연산자가 가능하다.
	equi join : join condition에서 = (equality comparator, 비교 연산자)를 사용하는 join
		ON 절에 = 연산자를 사용하여 join condition을 명시
		두 가지 시각
			- inner join, outer join 상관없이 = 을 사용한 join이라면 equi join으로 보는 경우
			- inner join으로 한정해서 = 를 사용한 경우에 equi join으로 보는 경우
	using : 두 table이 equi join 할 때, join 하는 attribute의 이름이 같다면, USING으로 간단하게 작성할 수 있다.
		- 이 때 같은 이름의 attribute는 result table에서 한번만 표시 된다.
		- FROM table1 [INNER] JOIN table2 USING (attribute(s))
		- FROM table1 LEFT [OUTER] JOIN table2 USING (attribute(s))
		- FROM table1 RIGHT [OUTER] JOIN table2 USING (attribute(s))
		- FROM table1 FULL [OUTER] JOIN table2 USING (attribute(s))
		SELECT *
		FROM employee AS E JOIN department AS D ON E.dept_id = D.dept_id;
		-> FROM employee AS E JOIN department AS D USING (dept_id);
	natural join
		- 두 table에서 같은 이름을 가지는 모든 attribute pair(쌍)에 대해서 equi join을 수
		- join condition을 따로 명시하지 않는다.(모든 attribute pair에 적용되기 때문)
		- FROM table1 NATURAL [INNER] JOIN table2
		- FROM table1 NATURAL LEFT [OUTER] JOIN table2
		- FROM table1 NATURAL RIGHT [OUTER] JOIN table2
		- FROM table1 NATURAL FULL [OUTER] JOIN table2

		SELECT *
		FROM employee E INNER JOIN department D ON E.dept_id = D.dept_id AND E.name = D.name;
		=> FROM employee E INNER JOIN department D USING (dept_id, name);
		=> FROM employee E NATURAL INNER JOIN department D;

	cross join
		- 두 table의 tuple pair로 만들 수 있는 모든 조합(= Cartesian product)을 result table로 변환한다.
		- join condition이 없다.
		- implicit cross join : FROM table1, table2
		- explicit cross join : FROM table1 CROSS JOIN table2

		SELECT *
		FROM employee CROSS JOIN department;

		in MySQL
		- MySQL에서는 cross join = inner join = join 이다.
		- CROSS JOIN에 ON(or USING)을 같이 쓰면 inner join으로 동작한다.
		- INNER JOIN(or JOIN)이 ON(or USING) 없이 사용되면 cross join으로 동작한다.

	self join
		- table이 자기 자신에게 join하는 경우

	예. ID가 2001인 프로젝트에 참여한 임직원들의 이름과 직군과 소속 부서 이름을 알고 싶다.
	SELECT ...
	FROM works_on W JOIN employee E ON W.empl_id = E.id
				LEFT JOIN department D ON E.dept_id = D.id
	WHERE W.proj_id = 2001;
	- LEFT OUTER JOIN을 한 이유는, null 인 값도 출력하기 위해서.
		없으면 null로 표기해도 되는 상황, INNER JOIN 하면 null은 짤린다.

8. group by, aagregate function, order by 설명
	- 조회 결과를 특정 attribute(s) 기준으로 정렬하여 가져오고 싶을 때 사용한다.
	- default 정렬 방식은 오름차순이다.
	- 오름차순 정렬은 ASC로 표기한다.
	- 내림차순 정렬은 DESC로 표기한다.

	aggregate function(group by와 관련)
		- 여러 tuple들의 정보를 요약해서 하나의 값으로 추출하는 함수
		- 대표적으로 COUNT, SUM, MAX, AVG 함수가 있다.
		- (주로)관심있는 attribute에 사용된다. e.g.) AVG(salary), MAX(birth_date)
		- NULL 값들은 제외하고 요약 값을 추출한다.

	GROUP BY
		- 관심있는 attribute(s) 기준으로 그룹을 나눠서 그룹별로 aggregate function을 적용하고 싶을 때 사용
		- grouping attribute(s) : 그룹을 나누는 기준이 되는 attribute(s)
		- grouping attribute(s)에 NULL 값이 있을 때는 NULL 값을 가지는 tuple끼리 묶인다.

	HAVING
		- GROUP BY와 함께 사용한다.
		- aggregate function의 결과값을 바탕으로 그룹을 필터링하고 싶을 때 사용한다.
		- HAVING절에 명시된 조건을 만족하는 그룹만 결과에 포함한다.

	SELECT로 조회하기 요약
		SELECT attribute(s) or aggregate function(s)
		FROM table(s)
		[WHERE condition(s)]
		[GROUP BY group attribute(s)]
		[HAVING group condition(s)]
		[ORDER BY attribute(s)];

		실행 순서 : FROM, WHERE, GROUP BY, HAVING, ORDER BY, SELECT
			- select 쿼리에서 각 절(phrase)의 실행 순서는 개념적인 순서이다.
			- select 쿼리의 실제 실행 순서는 각 RDBMS에서 어떻게 구현했는지에 따라 다르다.

9. stored function
	stored function 뜻과 예제
		- 사용자가 정의한 함수
		- DBMS에 저장되고 사용되는 함수
		- SQL의 select, insert, update, delete statement에서 사용할 수 있다.

		- 이외에도 loop를 돌면서 반복적인 작업을 수행하거나
		- case 키워드를 사용해서 값에 따라 분기 처리 하거나
		- 에러를 핸들링하거나 에어를 일으키는 등의 다양한 동작을 정의할 수 있다.

	stored function 는 언제 써야할까 ?
		- 개인적인 의견

		사전에 알고 있어야 할 것.
			Three-tier architecture

			Presentation tier
				- 사용자에게 보여지는 부분을 담당하는 tier
				- HTML, javascript, CSS, native app, desktop app
			Logic tier
				- 서비스와 관련된 기능과 정책 등 비즈니스 로직을 담당하는 tier
				- application tier, middle tier 라고도 불림
				- Java + Spring, Python + Django, etc...
			Data tier
				- 데이터를 저장하고 관리하고 제공하는 역할을 하는 tier
				- MySQL, Oracle, SQL Server, PostgreSQL, MongoDB

		- util 함수로 쓰기에는 괜찮을 것 같다.
		- 비즈니스 로직을 stored function에 두는 것은 좋지 않을 것 같다.
			- 로직 티어만 보면 알 수 있는 것을 데이터 티어까지 확인해야하는 번거로움
			- 위의 예에서 비즈니스 로직을 가지는가
			dept_avg_salary		X
			id_generator		애매
			toeic_pass_fail		O 			(소스코드 레벨에서 관리하는 것이 좋을 것으로 보임)

	예제
		1. 임직원의 ID를 열자리 정수로 랜덤하게 발급하고 싶다, ID의 맨 앞자리는 1로 고정이다.
			> delimeter $$ 
				-- 기본적으로 SQL에서 사용되는 delimeter는 ;(세미콜론)이다. $$는 임의의 문자이며, 다른 것으로 해도 된다.
				-- delimiter를 $$로 변경해주고 중간에 function의 세미콜론을 사용해도 거기서 끝나지 않도록 해주는 역할을 한다.
				-- 그리고 function이 끝났다는 것을 delimiter를 지정한 $$로 마무리를 지어준다.
				-- 마지막으로 delimiter를 ; 으로 바꿔준다.
			> CREATE FUNCTION id_generator()	-- 함수 이름 지정
			-> RETURNS int 						-- returnS s 유의, 리턴타입 지정
			-> NO SQL 							-- mysql에서 사용하는 문법이라 큰 특징은 없음
			-> BEGIN
			-> 		RETURN (10000000000 + floor(rand() * 10000000000));
				-- 10000000000 지정으로 앞자리를 1로 지정하고 10자리 정수로 나타냄
				-- rand() 는 0 <= x < 1 값을 가져온다. 여기에 10억을 곱하면 9자리 정수를 가져온다.
				-- floor() 내장함수를 통해 내림을 하고 정수만 가져온다.
			-> END
			-> $$
			> delimiter ;

			> INSERT INTO employee VALUES (id_generator(), 'JEHN', '1991-08-04', 'F', 'PO', 10000000000, 1005);

		2. 부서의 ID를 파라미터로 받으면 해당 부서의 평균 연봉을 알려주는 함수 작성
			> delimiter $$
			> CREATE FUNCTION dept_avg_salary(d_id int)
			-> RETURNS int
			-> READS SQL DATA
			-> BEGIN
			-> 		DECLARE avg_sal int;							-- 변수 선언
			-> 		select avg(salary) into avg_sal 				-- avg_sal 변수에 평균 연봉 저장
			-> 							from employee
			-> 							where dept_id = d_id;
			-> 		RETURN avg_sal;
			-> END
			-> $$
			> delimiter ;

			* 변수 선언하지 않고 바로 사용하는 방법
			-> 		select avg(salary) into @avg_sal
			-> 							from employee
			-> 							where dept_id = d_id;
			-> 		RETURN @avg_sal;

			> SELECT *, dept_avg_salary(id)
			-> FROM department;

		3. 졸업 요건 중 하나인 토익 800 이상을 충족했는지를 알려주는 함수를 작성
			> delimiter $$
			> CREATE FUNCTION toeic_pass_fail(toeic_score int)
			-> RETURNS char(4)
			-> NO SQL
			-> BEGIN
			-> 		DECLARE pass_fail char(4);
			-> 		IF 		toeic_score is null THEN SET pass_fail = 'fail';
			-> 		ELSEIF 	toeic_score < 800 	THEN SET pass_fail = 'fail';
			-> 		ELSE 							 SET pass_fail = 'pass';
			-> 		END IF;
			-> 		RETURN pass_fail;
			-> END
			-> $$
			> delimiter ;

			-> 		IF 		toeic_score is null THEN SET @pass_fail = 'fail';
			-> 		ELSEIF 	toeic_score < 800 	THEN SET @pass_fail = 'fail';
			-> 		ELSE 							 SET @pass_fail = 'pass';
			-> 		END IF;
			-> 		RETURN @pass_fail;

			> SELECT *, toeic_pass_fail(toeic)
			-> FROM student;

	삭제하기 : DROP FUNCTION stored_function_name;

	등록된 stored function 파악하기
		1. SHOW FUNCTION STATUS where DB = 'company';
			company db에 있는 function
			create function db.function
		2. SHOW CREATE FUNCTION id_generator;
			정의된 함수를 볼 수 있다.


10. stored procedure 란?, stored function와의 차이
	- 사용자가 정의한 프로시저
	- RDBMS에 저장되고 사용되는 프로시저
	- 구체적인 하나의 태스크(task)를 수행한다

	- 이외에도 조건문을 통해 분기처리 하거나
	- 반복문을 수행하거나
	- 에러를 핸들링하거나 에러를 일으키는 등의 다양한 로직을 정희할 수 있다.

	stored procedure vs stored function
		- MySQL, Oracle, MS SQL Server, PostgreSQL 대상으로 조사하여 공통적인 부분을 묶어서 정리한 내용입니다.
		- 일부 디테일한 부분에서 차이가 있을 수 있습니다.

									STORED PROCEDURE							STORED FUNCTION
		create 문법이라				CREATE PROCEDURE ...						CREATE FUNCTION ...
		return 키워드로 값 반환 		불가능										가능
									(SQL server는 상태코드 반환용으로 사용 가능)		(MySQL, SQL server는 값 반환하려면 필수)
		파라미터로 값(들) 반환 			가능											일부 가능
									(값(들)을 반환하려면 필수값)						(oracle 가능하나 권장안함, postgreSQL 가능)
									(값 들이란, output을 이용하여 여러개 반환 가능)
		값을 꼭 반환해야 하나?			필수 아님										필수
		SQL statement에서 호출			불가능										가능
		(SELECT *, product(price, order_count) FROM orders;, 이렇게 쿼리문에 사용하는 것)
		transaction 사용 				가능											대부분 불가능(oracle 가능)
		주된 사용 목적					business logic 								computation(연산)

		이외에..
		- 다른 function/procedure를 호출할 수 있는지
		- resultset(= table)을 반환할 수 있는지
		- precompiled execution plan(RDB에 저장시켜서 미리 컴파일 시켜서 효율적으로 실행될 수 있도록 실행 계흭을 만들어 두는지)을 만드는지
		- try-catch를 사용할 수 있는지
		등

	예제
		1. 파라미터 두 개의 곱
			> delimiter $$
			> CREATE PROCEDURE product(IN a int, IN b int, OUT result int)
				-- INPUT parameter : IN, OUTPUT parameter : OUT, Default IN
			-> BEGIN
			->		SET result = a * b;
			-> END
			-> $$
			> delimiter ;

			> call product(5, 7, @result);	-- @를 붙여주면 사용자가 정의한 변수
			> select @result;
				@result
				-------
				     35

		2. 두 정수를 맞바꾸는 프로시저를 작성
			> delimiter $$
			> CREATE PROCEDURE swap(INOUT a int, INOUT b int)
			-> BEGIN
			->		set @temp = a;
			->		set a = b;
			->		set b = @temp;
			-> END
			-> $$
			> delimiter ;

			> set @a = 5, @b = 7;
			> call swap(@a, @b);
			> select @a, @b;

		3. 각 부서별 평균 연봉을 가져오는 프로시저를 작성
			> delimiter $$
			> CREATE PROCEDURE get_dept_avg_salary()
			-> BEGIN
			->		select dept_id, avg(salary)
			->		from employee
			->		group by dept_id;
			-> END
			-> $$
			> delimiter ;

			> call get_dept_avg_salary();
			평균 연봉 관련 데이터 출력
			NULL 은 dept_id 가 null인 것들의 평균

		4. 사용자가 프로필 닉네임을 바꾸면 이전 닉네임을 로그에 저장하고 새 닉네임으로 업데이트하는 프로시저를 작성
			> delimiter $$
			> CREATE PROCEDURE change_nickname(user_id INT, new_nick varchar(30))
			-> BEGIN
			-> 		insert into nickname_logs (
			-> 			select id, nickname, now() from users where id = user_id
			-> 		);
			-> 		update users set nickname = new_nick where id = user_id;
			-> END
			-> $$
			> delimiter ;

			> call change_nickname(1, 'ZIDANE');

11. trigger 의미와 예제
	사전적 의미
		- 방아쇠
		- 계기
		- 촉발시키다
		- 작동시키다
	SQL에서 Trigger
		데이터베이스에서 어떤 이벤트가 발생했을 때, 자동적으로 실행되는 프로시저(procedure)
		데이터에 변경이 생겼을 때 즉, DB에 insert, update, delete가 발생했을 때 자동적으로 실행되는 프로시저(procedure)를 의미

	예시
		> delimiter $$
		> CREATE TRIGGER log_user_nickname_trigger
		-> BEFORE UPDATE								-- update 일어날 때 발동되고, 업데이트 before 이전에 실행할 예정
		-> ON users FOR EACH ROW						-- for each 업데이트 되는 각 로우에 대해 실행
		-> BEGIN
		->		insert into users_log values(OLD.id, OLD.nickname, now());	-- OLD, update 되기 전의 tuple을 가리키고 delete된 tuple을 가리킨다.
		-> END
		-> $$
		> delimiter ;

		> delimiter $$
		> CREATE TRIGGER sum_buy_prices_trigger
		-> AFTER INSERT
		-> ON buy FOR EACH ROW
		-> BEGIN
		->		DECLARE total INT;
		->		DECLARE user_id INT DEFAULT NEW.user_id;	-- insert된 tuple을 가리킴, update된 후의 tuple을 가리
		->
		->		select sum(price) into total from buy where user_id = user_id;
		->		update user_buy_stats set price_sum = total where user_id = user_id;
		-> END
		-> $$
		> delimiter ;

	update, insert, delete 등을 한번에 감지하도록 설정 가능하다.(MySQL은 불가능)
		> CREATE TRIGGER avg_empl_salary_trigger
		> 	AFTER INSERT OR UPDATE OR DELETE
		> 	ON employee
		> 	FOR EACH ROW
		> 	EXECUTE FUNCTION update_avg_empl_salary();
		조회되는 tuple개수 만큼 실행(5개라면 5번 실행)

	row 단위가 아니라 statement 단위로 trigger가 실행될 수 있도록 할 수 있다.(MySQL은 FOR EACH STATEMENT 사용 불가능)
		위 예제에서 조회되는 tuple 개수와 상관없이 한번만 실행
		단순히
		> 	FOR EACH ROW
		위 명령어를
		> 	FOR EACH STATEMENT
		로 바꿔주면 된다.

	trigger를 발생시킬 디테일한 조건을 지정할 수 있다.(MYSQL 불가능)
		> CREATE TRIGGER log_user_nickname_trigger
		> 		BEFORE UPDATE
		>		ON users
		>		FOR EACH ROW
		>		WHEN (NEW.nickname IS DISTINCT FROM OLD.nickname)	-- true 만 실행, 기존 닉네임과 다르다면
		>		EXECUTE FUNCTION log_user_nickname();

	주의사항
		1. 소스 코드로는 발견할 수 없는 로직이기 때문에 어떤 동작이 일어나는지 파악하기 어렵고 문제가 생겼을 때 대응하기 어렵다.
			(웹 어플리케이션에서는 트리거의 존재를 알 수 없다. 앱은 소스코드만 확인가능)
		2. 많이 사용하면 트리거 간에 호출이 발생하여 문제가 생겨서 문제점을 파악할 때, 개발자가 확인하기 어렵다.
		3. 과도한 트리거 사용은 DB에 부담을 주고 응답을 느리게 한다.
		4. 디버깅이 어렵다.
		5. 문서 정리가 특히나 중요하다.

12. 트랜잭션(transaction)
	트랜잭션
		- 단일한 논리적인 작업 단위(a single logical unit of work)
		- 논리적인 이유로 여러 SQL문들을 단일 작업으로 묶어서 나눠질 수 없게 만든 것이 transaction 이다.
		- transaction의 SQL문들 중에 일부만 성공해서 DB에 반영되는 일은 일어나지 않는다.

	예제.
		> START TRANSACTION;	-- transaction 시작
		> UPDATE account SET balance = balance - 2000000 WHERE id = 'J';
		> UPDATE account SET balance = balance + 2000000 WHERE id = 'H';
		> COMMIT;				-- 지금까지 작업한 내용을 DB에 영구적으로(permanently) 저장하라, transaction을 종료

		> START TRANSACTION;	-- transaction 시작
		> UPDATE account SET balance = balance - 300000 WHERE id = 'J';
		> ROLLBACK;				-- 지금까지 작업들을 모두 취소하고 transaction 이전 상태로 되돌린다, transaction 종료

		> SELECT @@AUTOCOMMIT;	-- 활성화 여부 확인, 1이면 true
			-- 각각의 SQL 문을 자동으로 transaction 처리 해주는 개념
			-- SQL문이 성공적으로 실행하면 자동으로 commit 한다.
			-- 실행 중에 문제가 있었다면 알아서 rollback 한다.
			-- MYSQL 에서는 default로 autocommit이 enabled되어 있다.
			-- 다른 DBMS에서도 대부분 같은 기능을 제공한다.

		> SET autocommit = 0;
			-- 오토커밋 비활성화

		START TRANSACTION 실행과 동시에 오토커밋은 off가 된다.
		COMMIT / ROLLBACK 과 함께 트랜잭션이 종료되면, 원래 오토커밋 상태로 돌아간다.

	일반적인 트랜잭션 사용 패턴
		1. transaction을 시작(begin)한다.
		2. 데이터를 읽거나 쓰는 등의 SQL문들을 포함해서 로직을 수행한다.
		3. 일련의 과정들이 문제없이 동작했다면 transaction을 commit 한다.
		4. 중간에 문제가 발생했다면 transaction을 rollback 한다.

	public void transfer(String fromId, String told, int amount) {
		try {
			Connection connection = ..;
			connection.setAutoCommit(false);
			...
			connection.commit();
		} catch(Exception e) {
			...
			connection.rollback();
			...
		} finally {
			connection.setAutoCommit(true);
		}
	}

	ACID
		A(Atomicity, 원자성)
			- ALL or NOTHING
			- transaction은 논리적으로 쪼개질 수 없는 작업 단위이기 때문에 내부의 SQL문들이 모두 성공해야 한다.
			- 중간에 SQL문이 실패하면 지금까지의 작업을 모두 취소하여 아무 일도 없었던 것처럼 rollback 한다.
			- commit 실행 시, DB에 영구적으로 저장하는 것은 DBMS가 담당하는 부분이다.
			- rollback 실행 시, 이전 상태로 되돌리는 것도 DBMS가 담당하는 부분이다.
			- 개발자는 언제 commit 하고 rollback할지 챙겨야 한다.
		C(Consistency, 일관성)
			- 보증금은 0이하가 될 수 없도록 constraint 걸었을 때, 0이하의 연산결과가 발생하면 일관성이 무너진다.
			- transaction은 DB의 상태를 consistent 상태에서 또 다른 consistent 상태로 바꿔줘야 한다.
			- constraints, trigger 등을 통해 DB에 정의된 rules을 transaction이 위반했다면 rollback 해야 한다.
			- transaction이 DB에 정의된 rule을 위반했는지는 DBMS가 commit 전에 확인하고 알려준다.
			- 그 외에 application 관점에서 transaction이 consistent하게 동작하는지는 개발자가 챙겨야 한다.
		I(Isolation, 격리 분리)
			- 여러 transaction들이 동시에 실행될 때도 혼자 실행되는 것처럼 동작하게 만든다.
			- DBMS는 여러 종류의 isolation level을 제공한다.
			- 개발자는 isolation level 중에 어떤 level로 transaction을 동작시킬지 설정할 수 있다.
			- concurrency control의 주된 목표가 isolation이다.
		D(Durability, 영존성)
			- commoit된 transaction은 DB에 영구적으로 저장된다.
			- 즉, DB system에 문제(power fail or DB crash)가 생겨도 commit된 transaction은 DB에 남아 있는다.
			- '영구적으로 저장한다'라고 할 때는 일반적으로 '비휘발성 메모리(HDD, SSD, ...)'에 저장함을 의미한다.
			- 기본적으로 transaction의 durability는 DBMS가 보장한다.

	1. transaction을 어떻게 정의해서 쓸지는 개발자가 정하는 것이다.
		구현하려는 기능과 ACID 속성을 이해해야 transaction을 잘 정의할 수 있다.
	2. transaction의 ACID와 관련해서 개발자가 챙겨야 하는 부분들이 있다.
		DBMS가 모든 것을 알아서 해주는 것은 아니다.

13. concurrency control 기초 : schedule과 serializability

					K person 			H person
	transaction1	read(K_balance) => 100
	transaction1	write(K_balance = 80)
	transaction1						read(H_balance) => 200
	transaction2						read(H_balance) => 200
	transaction2						write(H_balance = 230)
	transaction2				commit
	transaction1						write(H_balance = 220)
	transaction1				commit

					K person 			H person
	transaction1	r1(K)
	transaction1	w1(K = 80)
	transaction1						r1(H)
	transaction2						r2(H)
	transaction2						w2(H)
	transaction2				c2
	transaction1						w1(H)
	transaction1				c1

	r1(K)
	  |
	w1(K)
	  |
	r1(H)
	  |
	r2(H)
	  |
	w2(H)
	  |
	c2
	  |
	w1(H)
	  |
	c1
	  |
	  ...

	sched.4 r1(K) w1(K) r1(H) r2(H) w2(H) c2 w1(H) c1 -- 관련된 문서를 보면 이러한 형식을 볼 수 있다.

	Lost update : update된 데이터가 사라져 버림. (위 예시에 t1의 read 이후 바로 t2 read가 실행된 것을 볼 수 있다.)
	operation : read(balance), write(balance) 하나하나의 실행을 나눈 단위
	schedule : 여러 transaction들이 동시에 실행될 때 각 transaction에 속한 operation들의 실행 순서
		각 transaction 내의 operations들의 순서는 바뀌지 않는다.
	Serial(순차적) schedule : transaction들이 겹치지 않고 한 번에 하나씩 실행되는 schedule
	Nonserial schedule : transaction들이 겹쳐서(interleaving) 실행되는 schedule

	serial schedule 성능 : 한 번에 하나의 transaction만 실행되기 때문에 좋은 성능을 낼 수 없고 현실적으로 사용할 수 없는 방식이다.
		Serial
		|
		r2(H)		-- IO 작업, CPU는 놀고 있다.
		|
		w2(H)		-- IO 작업, CPU는 놀고 있다.
		|
		r1(K)
		|
		..

	Nonserial schedule 성능 : transaction들이 겹쳐서 실행되기 때문에 동시성이 높아져서 같은 시간 동안 더 많은 transaction들을 처리할 수 있다.(serial schedule 보다 더 빨리 끝난다.)
		r2(H)		-- CPU는 IO를 기다리는 동안 다른 트랜잭션을 실행 시킨다.
		  |
		r1(K)		-- CPU는 IO를 기다리는 동안 다른 트랜잭션을 실행 시킨다.
		  |
		w2(H)
		  |
		w1(K)
		  |
		c2			-- t2 commit
		  |
		  ...		-- t1 나머지 operation 실행

		단점 : transaction들이 어떤 형태로 겹쳐서 실행되는지에 따라 이상한 결과가 나올 수 있다.

	성능 때문에 여러 transaction들을 겹쳐서 실행할 수 있으면 좋겠다.(nonserial schedule)
	하지만 이상한 결과가 나오는 것은 싫다.
		serial schedule과 동일한(equibalent) nonserial schedule을 실행하면 된다.
		schedule이 동일하다의 의미부터 정의하자.

	Conflict 
	of two operations
		세 가지 조건을 모두 만족하면 conflict
		1. 서로 다른 transaction 소속
		2. 같은 데이터에 접근
		3. 최소 하나는 write operation
			r2(H) - w1(H)
			w2(H) - w1(H)
			w2(H) - r1(H)
			이렇게 총 3개의 conflict 존재

		conflict operation은 순서가 바뀌면 결과도 바뀐다.

	conflict equivalent
	for two schedules
		두 조건 모두 만족하면 conflict equivalent
		1. 두 schedule은 같은 transaction들을 가진다.
		2. 어떤(any) conflicting operations의 순서도 양쪽 schedule 모두 동일하다.

		sched.3 		sched.2

		r1(K)			r2(H)
		  |
		w1(K)			w2(H)
		  |
		r1(H)			c2
		  |
		r2(H)			r1(K)
		  |
		w2(H)			w1(K)
		  |
		c2				r1(H)
		  |
		w1(H)			w1(H)
		  |
		c1				c1
		  |

		sched.2는 serial schedule이고, sched.3은 serial schedule과 conflict equivalent일 때, Conflict serializable이라 한다.
		그래서 nonserial sched.3는 conflict serializable 하다라고 볼 수 있다.

	* 성능 때문에 여러 transaction들을 겹쳐서 실행할 수 있으면 좋다(nonserial schedule)
	* 하지만 이상한 결과가 나오는 것은 싫다
		해결책 : conflict serializable한 nonserial schedule을 허용하자
		구현 : 여러 트랜잭션이 실행될 때 마다 해당 schedule이 conflict serializable인지 확인
			요청이 밀려오면 동시에 실행될 수 있는 트랜잭션 수는 너무나 많아, 그 스케쥴이 확인하는 것이 비용이 많이 든다.
			그래서 이러한 구현 방법이 사용되지 않는다.
		여러 트랜잭션을 동시에 실행해도 schedule이 conflict serializable하도록 보장하는 프로토콜 적용
			아예 conflict serializable한 스케쥴만 실행될 수 있도록 그것을 보장하는 프로토콜을 적용

	정리
		a schedule이 어떤 임의의 a serial schedule과 equivalent하다면 a schedule은 serializable하다고 한다.
		a schedule이 어떤 임의의 a serial schedule과 conflict equivalent하다면 a schedule을 conflict serializable하다보고 conflict serializability 속성을 가진다.
		a schedule이 어떤 임의의 a serial schedule과 view equivalent하다면 a schedule은 view serializable하다보고 view serializability 속성을 가진다.
		concurrency control makes any schedule serializable
			트랜잭션의 속성인 Isolation 특성이 밀접한 관련이 있다.
		Isolation을 엄격하게, serializability를 완벽하게 추구하면 그만큼 성능은 줄어든다. 제약사항이 걸려서 동시성이 떨어진다.
			isolation level provide relaxed isolation(위와 같은 이유로 나온 개념)

14. reconverable schedule, cascadeless schedule, strict schedule
	K가 H에게 20만원 이체하고 H는 자신에게 30만원을 이체한다면
		tx1 K 계좌에서 20만원 차감
		tx2 H 계좌에 30만원 입금
			H 계좌에 20만원 입금

		tx2가 롤백한다면 tx1도 롤백해야하지만 tx1 먼저 commit 하고 tx2 롤백한다면
		tx1은 이미 commit 된 상태이므로 durability 속성으로 인해 rollback 할 수 없다.

		unrecoverable schedule : 스케쥴 내에서 커밋된 트랜잭션이 롤백된 트랜잭션의 write 했던 데이터를 읽은 경우.
			롤백을 하더라도 이전 상태로 회복 불가능할 수 있기에 이런 스케쥴은 DBMS가 허용하면 안된다.

		recoverable schedule : 스케쥴 내에서 그 어떤 트랜잭션도 자신이 읽은 데이터를 write한 트랜잭션이 먼저 commit/rollback 전까지는 커밋하지 않는 경우
			롤백할 때 이전 상태로 온전히 돌아갈 수 있기에 DBMS는 이러한 스케쥴만 허용해야 한다.

		cascading rollback : 하나의 트랜잭션이 롤백하면 의존성이 있는 다른 트랜잭션도 롤백해야 한다.
			여러 트랜잭션의 롤백이 연쇄적으로 일어나면 처리하는 비용이 많이 든다.

		cascading rollback 해결책 - 데이터를 write 한 트랜잭션이 커밋/롤백 한 뒤에 데이터를 읽는 스케쥴만 허용하자.
			20만원 입금을 tx1, tx2는 30만원 입금만 담당한다.
			그러면 tx2가 롤백되도 tx1은 영향이 없다.
		cascadeless schedule : 스케쥴 내에서 어떤 트랜잭션도 커밋되지 않은 트랜잭션들이 write한 데이터를 읽지 않은 경우

	H가 상품 가격 3만원을 2만원으로 낮추려하는데, K도 실수로 1만원으로 낮추려할 때
		tx1 상품 가격 조회
		tx2 write 2만원
		tx1 abort
		결과 3만원

		cascadeless schedule : 스케쥴 내에서 어떤 트랜잭션도 커밋되지 않은 트랜잭션들이 write한 데이터는 읽지 않은 경우

		strict schedule : 스케쥴 내에서 어떤 트랜잭션도 커밋되지 않은 트랜잭션들이 write한 데이터는 쓰지도 읽지도 않은 경우
			롤백할 때 recovery가 쉽다, 트랜잭션 이전 상태로 돌려놓기만 하면 된다.
			tx1 상품 조회
				write 1만원
				commit / abort
			tx2 상품 조회
				write 2만원
				commit
			결과 2만원

	recoverable schedule 안에 cascadeless schedule이 있고,
	cascadeless schedule 안에 strict schedule이 있다.

	Isolation : concurrency control provides serializablility & recoverability
		여러 트랜잭션이 동시에 실행되도 각각의 트랜잭션이 마치 혼자서 실행되는 것 처럼 실행되야 한다.

15. isolation level - transaction들이 동시에 실행될 때 발생 가능한 이상 현상들
	예제 1
		데이터 베이스 내에 x=10, y=20 값이 있다.
		tx1 : x += y
		tx2 : y = 70

		tx1 			tx2
		read(x)
						write(y=70)
		read(y)
		write(x=80)
		commit
						abort : rollback(y=20)

		(tx2는 롤백되었기 때문에 x는 이상한 값으로 대입된다.)

		Dirty read : commit 되지 않은 변화를 읽음

	예제 2
		데이터 베이스 내에 x = 10 값이 있다.
		tx1 : x를 두 번 읽는다
		tx2 : x에 40을 더한다

		tx1 			tx2
		read(x)
						read(x)
						write(x=50)
						commit
		read(x)
		commit

		tx1 의 두 read의 값은 다르게 된다.(isolation관점에서 일어나면 안되는 일)

		Non-repeatable read : 같은 데이터의 값이 달라짐(Fuzzy read라고도 불림)

	예제 3
		데이터 베이스 내에 두가지 튜플이 각각 값을 가지고 있다.
		t1(..., v=10) t2(..., v=50)
		tx1 : v가 10인 데이터를 두 번 읽는다.
		tx2 : t2의 v를 10으로 바꾼다.

		tx1 			tx2
		read
						write
						commit
		read
		commit

		tx1에서는 첫번째 read는 t1을 두번째 read는 t1,t2를 반환한다.

		Phantom read : 없던 데이터가 생김

	Dirty read, Non-repeatable read, Phantom read와 같은 이상한 현상들이 모두 발생하지 않게 만들 수 있지만
	제약사항이 많아져서 동시 처리 가능한 트랜잭션 수가 줄어들어 결국 DB의 전체 처리량(throughput)이 하락하게 된다.

	isolation level : 일부 이상한 현상은 허용하는 몇 가지 level을 만들어서 사용자가 필요에 따라 적절하게 선택할 수 있도록 하자.


	isolation level 		Dirty read 		Non-repeatable read 	Phantom read (O 허용, X 비허용)

	Read uncommitted		O 				O 						O
	Read committed 			X 				O 						O
	Repeatable read 		X 				X 						O
	Serializable 			X 				X 						X

	serializable : 위 세가지 현상 뿐 아니라 모든 이상한 현상 자체가 발생하지 않는 level을 의미한다.
	세 가지 이상 현상을 정의하고 어떤 현상을 허용하는지에 따라 각각의 isolation level이 구분된다.
	애플리케이션 설계자는 isolation level을 통해 전체 처리량(throughput)과 데이터 일관성 사이에서 어느정도 거래(trade)를 할 수 있다.
	
	위 내용은 표준 SQL 기준으로 92년도에 발표하여 ANSI/IOS standard SQL 92 라 부른다.
	이 내용을 비판하는 standard 92 비판이 있다.
		1. 세 가지 이상 현상의 정의가 모호하다.
		2. 이상 현상은 세 가지 외에도 추가로 더 있다.
		3. 상업적인 DBMS에서 사용되는 방법을 반영해서 isolation level을 구분하지 않았다.

	예제 4
		데이터 베이스 내에 x = 100 값이 존재한다.
		tx1 : x = 10
		tx2 : x = 100

		tx1 			tx2
		write(x=10)
						write(x=100)
		abort
						abort

		tx1에서 abort되면 데이터베이스에 x == 0이 되어야 하는가 ?
		tx2에서 abort되면 데이터베이스에 x == 10이 되어야 하는가 ?
		둘다 잘못된 것이다.

		Dirty write : commit 안된 데이터를 write함
			tx2에서 write하고 commit 후 tx1에서 abort하면 tx2에서 100을 대입했음에도 불구하고 x는 0이 된다.

		롤백 시, 정상적인 recovery는 매우 중요하기 때문에 모든 isolation level에서 dirty write를 허용하면 안된다.

	예제 5
		데이터 베이스 내에 x = 50 값이 존재한다.
		tx1 : x += 50
		tx2 : x += 150

		tx1 			tx2
		read(x)
						read(x)
						write(x=200)
						commit
		write(x=100)
		commit

		tx1의 write가 덮어 써버리기에 tx2 write가 사라진다.(update됬는데 반영이 되지 않음)

		Lost update : 업데이트를 덮어 씀

	예제 6 (예제 1의 dirty read 확장판)
		데이터 베이스 내에 x=50, y=50 값이 있다.
		tx1 : x가 y에 40을 이체한다.
		tx2 : x와 y를 읽는다.

		tx1 			tx2
		read(x)
		write(x=10)
						read(x=10)
						read(y=50)
						commit
		read(y)
		write(y=90)
		commit

		데이터는 일관성 있게 데이터베이스 내에 x와 y의 합이 100이 되어야하지만, tx2의 ready x,y는 60이다.(데이터 정합성이 깨진다)

		Dirty read : commit 되지 않은 변화를 읽음(abort가 발생하지 않아도 dirty read가 발생할 수 있다.)

	예제 7
		데이터 베이스 내에 x=50, y=50 값이 있다.
		tx1 : x가 y에 40을 이체한다.
		tx2 : x와 y를 읽는다.

		tx1 			tx2
						read(x)
		read(x)
		write(x=10)
		read(y)
		write(y=90)
		commit
						read(y)

		예제 6과 동일하게 tx2 x==50, y==90으로 정합성이 깨진다.

		Read skew : inconsistent한 데이터 읽기

	예제 5
		데이터 베이스 내에 x=50, y=50 값이 있다. x + y >= 0 이라는 제약사항도 있다.
		tx1 : x에서 80을 인출한다.
		tx2 : y에서 90을 인출한다.

		tx1 			tx2
		read(x)
		read(y)
						read(x)
						read(y)
		write(x= -30)
						write(y= -40)
		commit
						commit

		tx1,tx2 모두 read에서는 제약사항에 대해 문제 없지만, 결과는 x == -30, y == -40으로 제약사항을 위반하게 된다.(제약사항을 위반하는 데이터 불일치)

		Write skew : inconsistent한 데이터 쓰기

	예제 5 (예제 3의 Phantom read 확장판)
		데이터 베이스 내의 튜플이 t1(..., v=7)와 cnt=0(#of(v>10), v가 10보다 큰 데이터 개수를 세는 데이터)을 가지고 있다.
		tx1 : v>10 데이터와 cnt를 읽는다.
		tx2 : v=15인 t2를 추가하고 cnt를 1 증가한다.

		tx1 				tx2
		read(v>10) => .
							write(insert t2:..., v=15)
							read(cnt) => 0
							write(cnt=1)
							commit
		read(cnt) => 1
		commit

		tx1입장에서는 v>10은 아무것도 없는데 cnt가 1이 된다.(데이터 불일치)

		Phantom read : 없던 데이터가 생김

	예제 5 (SQL 92 비판 중 세번째, 상업적으로 구분하지않았다는 내용)
		기존의 isolation level은 이상한 현상에 대해 얼마큼 허용하는지에 따라 레벨을 구분하였지만
		SNAPSHOT ISOLATION은 concurrency control이 어떻게 동작할지 그 구현을 바탕으로 정의된 isolation level이다.

		첫번째
			데이터 베이스 내에 x = 50, y = 50 값이 존재한다.
			tx1 : x가 y에 40을 이체한다.
			tx2 : y에 100을 입금한다.

			tx1 			tx2
			read(x) => 50
			write(x=10)
							read(y) => 50
							write(y=150)
							commit
			read(y) => 50
			write(y=90)
			abort(commit될 수 없음)

			SNAPSHOT은 특정 시점에서의 현상이라고 말한다.
			SNAPSHOT의 시점은 트랜잭션이 시작된 그 시점을 얘기한다.

			tx1이 시작 된 시점에 SNAPSHOT이 생성되고 SNAPSHOT에서 read해오고 write한다.
			그래서 write를 해도 실제 데이터베이스에 반영이 되지않아 tx2에서 read(y) 값은 50이 된다.
			그렇게 tx2는 commit을 하고 데이터베이스에 반영되며 tx1도 y의 데이터를 쓰고 commit 하려하지만 abort가 된다.
			이유는 같은 데이터에 대해 write를 할 때, 먼저 commit된 transaction만 인정을 해준다.
			즉 tx1은 폐기된다.

			Snapshot isolation : type of MVCC(multi version concurrency control)(MVCC의 한 종류이다)
				MVCC : 각 트랜잭션마다 특정 시점에서의 스넵샷을 기준으로 각각의 버전이 있다.
				tx 시작 전에 commit된 데이터만 보임
				First-committer win(write-write conflict가 발생했을 때, 먼저 발생한 commit이 반영된다)

	실무버전
		MYSQL(innnoDB - 사용하는 엔진)(MySQL은 디폴트 값이 repeatable read)
			표준에서 정의한 Isolation level과 동일하게 정의한다.
			Read uncommitted, Read committed, Repeatable read, Serializable
		Oracle
			표준에서 정의한 Isolation level과 동일하게 정의한다.
			Read committed, Serializable(실제로는 snapshot isolation level로 동작한다고 보면 된다.)
		SQL server(MS-SQL)
			표준에서 정의한 Isolation level과 동일하게 정의한다.
			Read uncommitted, Read committed, Repeatable read, Snapshot, Serializable
		postgreSQL
			표준에서 정의한 Isolation level과 동일하게 정의한다.
			표준 이상현상(Dirty read, Non-repeatable read, Phantom read)을 제외하고 생길 수 있는 현상을 Serialization anomaly처럼 따로 정의해준다.
			Read uncommitted, Read committed, Repeatable read(snapshot isolation level), Serializable

		같은 이름의 isolation level 이라도 동작 방식이 다를 수 있다.
		잘 파악해서 적절한 isolation level을 사용할 수 있도록 한다.

16. LOCK을 활용한 concurrency control 기법 (write-lock, read-lock, 2PL(two-phase locking) protocol)
	예제 1
		DB x=10
		tx1 : x = 20
		tx2 : x = 90

		tx1 			tx2
		write(x=20)		write(x=90)

		write(..)
			단순히 값 하나 바꾸는 것보다 더 복잡한 과정
			같은 데이터에 또다른 read/write가 있다면 예상치 못한 동작을 할 수 있다.
			so LOCK을 사용

		tx1 			tx2
		write_lock(x)	
						write_lock(x)
		write(x=20)
		unlock(x)
						write(x=90)
						unlock(x)

		tx1에서 먼저 write_lock으로 락을 쥐고 있기 때문에 tx2의 write_lock은 락을 획득하기 전까지는 기다리게 된다.(tx2는 block)
		tx1이 실행되고 unlock이 실행되면서 락은 tx2가 쥐게 되면서 실행 된다.

	예제 2
		DB x=20
		tx1 : x = 20
		tx2 : x를 읽는다

		tx1 			tx2
		write_lock(x)	
						read_lock(x)
		write(x=20)
		unlock(x)
						read(x)
						unlock(x)

	write-lock (exclusive lock)
		read/write(insert, modify, delete)할 때 사용된다.
		다른 tx가 같은 데이터를 read/write하는 것을 허용하지 않는다.
	read-lock (shared lock)
		read 할 때 사용한다.
		다른 tx가 같은 데이터를 read하는 것은 허용한다.

	예제 3
		DB x=10
		tx1 : x = 20
		tx2 : x를 읽는다

		tx1 			tx2
						read_lock(x)
		write_lock(x)
						read(x)
						unlock(x)
		write(x=20)
		unlock(x)

	예제 4
		DB x=10
		tx1 : x를 읽는다
		tx2 : x를 읽는다

		tx1 			tx2
						read_lock(x)
		read_lock(x)
		read(x)			read(x)
		unlock(x)		unlock(x)

	lock 호환성
				read-lock 		write-lock
	read-lock 		O 				X
	write-lock 		X 				X

	예제 5 (이상한 현상)
		DB x=100, y=200
		tx1 : x와 y의 합을 x에 저장
		tx2 : x와 y의 합을 y에 저장

		serial schedule #1 : tx1 실행되고 tx2가 실행되면 x=300, y=500이 된다.
		serial schedule #2 : tx2 실행되고 tx1이 실행되면 x=400, y=300이 된다.

		동시 실행
			tx1 			tx2
							read_lock(x)
							read(x)
							unlock(x)
			read_lock(y)
							write_lock(y)
			read(y)
			unlock(y)
							read(y) => 200
							write(y=300)
							unlock(y)
			write_lock(x)
			read(x) => 100
			write(x=300)
			unlock(x)

			Nonserializable : 두 개의 트랜잭션이 겹쳐서 실행되면서 x=300 y=300이 되는 이상한 결과가 나온다.

			원인 분석
				tx1에서 update된 y값을 읽지 못해서 생긴 현상

			해결책
				tx1 			tx2

								unlock(x)
				read_lock(y)
								write_lock(y)
						위 문제를 
								write_lock(y)
				read_lock(y)
								unlock(x)
						이렇게 순서를 바꿔주면 tx2이 update한 y값을 tx1에서 읽게 된다.

				그러므로 tx1에서는 read_lock(y)이 락을 취득하지 못해 tx2의 update를 기다리고 tx2가 unlock(y)한 이후 실행된다.

			결과
				tx1 			tx2
								read_lock(x)
								read(x)
								write_lock(y)
				read_lock(y)
								unlock(x)
								read(y) => 200
								write(y=300)
								unlock(y)
				read(y) => 300
				unlock(y)
				write_lock(x)
				read(x) => 100
				write(x=400)
				unlock(x)

				만약 tx1이 먼저 실행되면 동일한 이상한 현상이 발생할 수 있으므로
					read(y) => 300
					write_lock(x)
					unlock(y)
					read(x) => 100
					이렇게 write_lock(x)와 unlock(y)의 위치를 바꿔줘야 한다.

			최종 결과
				tx1 			tx2
								read_lock(x)
								read(x)
								write_lock(y)
				read_lock(y)
								unlock(x)
								read(y) => 200
								write(y=300)
								unlock(y)
				read(y) => 300
				write_lock(x)
				unlock(y)
				read(x) => 100
				write(x=400)
				unlock(x)

		2PL protocol(two-phase locking) : tx에서 모든 locking operation이 최초의 unlock operation 보다 먼저 수행되도록 하는 것
			tx1 		 	tx2
			read_lock(y)	read_lock(x)		<<	Expanding phase(growing phase)
			write_lock(x) 	write_lock(y)		<<		lock을 취득하기만 하고 반환하지 않는 phase
			unlock(y)		unlock(x)			<<	Shrinking phase(contracting phase)
			unlock(x)		unlock(y)			<<		lock을 반환만 하고 취득하지 않는 phase
			이렇게 두 페이즈로 나누어져서 라킹이 동작하기 때문에 two-phase locking이라 한다.

			Serializability를 보장한다.

		2PL과 deadlock
			tx1 			tx2
							read_lock(x)
			read_lock(y)
			read(y) => 200
			write_lock(x)						락을 기다리는 block 상태
							read(x) => 100
							write_lock(y) 		락을 기다리는 block 상태

			Deadlock 상태 : OS에서 해결하는 데드락 상태와 비슷하고 해결하는 방식도 비슷하다

	2PL protocol 종류
		DB : x, y, z
		tx : x와 y와 z를 더해서 y에 쓴다. x에 2를 곱해서 z에 쓴다.

		read_lock(x)
		read(x)
		write_lock(y)
		read(y)
		write_lock(z)
		unlock(x)
		read(z)
		write(y=x+y+z)
		unlock(y)
		write(z=2*x)
		unlock(z)

		1) conservative 2PL
			- 모든 lock을 취득한 뒤 트랜잭션 시작
			- deadlock-free(데드락이 발생하지 않음)
			- 실용적이진 않다(트랜잭션에서 필요하는 모든 락을 취득해야하기 때문에 어려움)
			read_lock(x)
			write_lock(y)
			write_lock(z)
			read(x)
			unlock(x)
			read(y)
			read(z)
			write(y=x+y+z)
			unlock(y)
			write(z=2*x)
			unlock(z)
		2) strict 2PL(S2PL)
			- strict schedule을 보장하는 2PL
			- recoverability 보장
			- write-lock을 commit/rollback 될 때 반환
			read_lock(x)
			read(x)
			write_lock(y)
			read(y)
			write_lock(z)
			unlock(x)
			read(z)
			write(y=x+y+z)
			write(z=2*x)
			commit 				(commit이 되어야 lock 반환)
			unlock(y)
			unlock(z)
		3) strong strict 2PL(SS2PL or rigorous 2PL)
			- strict schedule을 보장하는 2PL
			- recoverability 보장
			- read-lock / write-lock을 commit/rollback 될 때 반환
			- S2PL 보다 구현이 쉽다(concurrency control을 S2PL보다 구현이 쉽다)
			단점 : 락을 오래 쥐기 때문에 다른 트랜잭션이 해당 락을 취득하려면 기다려야 한다.
			read_lock(x)
			read(x)
			write_lock(y)
			read(y)
			write_lock(z)
			read(z)
			write(y=x+y+z)
			write(z=2*x)
			commit 				(commit이 되어야 lock 반환)
			unlock(x)
			unlock(y)
			unlock(z)

					read-lock 		write-lock
		read-lock 		O 				X
		write-lock 		X 				X
		read-read를 제외하고는 한 쪽이 block이 되니까 전체 처리량이 좋지 않다.

		read와 write가 서로를 block 하는 것이라도 해결해보자 !
			이 해결책이 MVCC(multiversion concurrency control) 이다.
			오늘날의 많은 RDBMS가 lock과 MVCC를 혼용해서 사용한다.
```