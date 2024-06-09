# 조인의 종류
하나의 테이블이 아닌 두 개 이상의 테이블을 묶어서 하나의 결과물을 만드는 것을 말합니다.<br>
MySQL 에서는 JOIN 이라는 쿼리로,<br>
MongoDB 에서는 lookup 이라는 쿼리로 처리할 수 있습니다.

참고로 MongoDB 를 사용할 때 lookup 은 되도록 사용하지 말아야합니다.<br>
조인 연산(lookup)에 대해 관계형 데이터베이스보다 성능이 떨어진다고 여러 벤치마크 테스트에서 알려져 있습니다.

여러 테이블을 조인하는 작업이 많을 경우 MongoDB 보다는 관계형 데이터베이스를 써야 합니다.

조인의 종류 중 대표적인 내부 조인, 왼쪽 조인, 오른쪽 조인, 합집합 조인이 있습니다.<br>
inner join : 왼쪽 테이블과 오른쪽 테이블의 두 행이 모두 일치하는 행이 있는 부분만 표기합니다.<br>
left outer join : 왼쪽 테이블의 모든 행이 결과 테이블에 표기됩니다.<br>
right outer join : 오른쪽 테이블의 모든 행이 결과 테이블에 표기됩니다.<br>
full outer join : 두 개의 테이블을 기반으로 조인 조건에 만족하지 않는 행까지 모두 표기합니다.

### 내부 조인
두 테이블 간에 교집합을 나타냅니다.<br>
SELECT * FROM TableA A <br>
INNER JOIN Table B ON <br>
A.key = B.key

### 왼쪽 조인
테이블 B의 일치하는 부분의 레코드와 함께 테이블 A를 기준으로 완전한 레코드 집합을 생성합니다.<br>
만약 테이블 B에 일치하는 항목이 없으면 해당 값은 null 값이 됩니다.<br>
SELECT * FROM TableA A <br>
LEFT JOIN Table B ON <br>
A.key = B.key

### 오른쪽 조인
테이블 A에서 일치하는 부분의 레코드와 함께 테이블 B를 기준으로 완전한 레코드 집합을 생성합니다.<br>
만약 테이블 A에 일치하는 항목이 없으면 해당 값은 null 이 됩니다.<br>
SELECT * FROM TableA A <br>
RIGHT JOIN Table B ON <br>
A.key = B.key

### 합집합 조인(완전 외부 조인)
양쪽 테이블에서 일치하는 레코드와 함께 테이블 A,B의 모든 레코드 집합을 생성합니다.<br>
이때 일치하는 항목이 없으면 누락된 쪽에 null 값이 포함되어 출력됩니다.<br>
SELECT * FROM TableA A <br>
FULL OUTER JOIN Table B ON <br>
A.key = B.key
