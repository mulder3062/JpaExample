# Jpa Example
Springboot JPA 예제

- 예제 DDL: mariadb
  [create_tables.sql](create_tables.sql)
- 설정 파일: [application.yml](src/main/resources/application.yml)

# ORM?
- Object-Relational Mapping. 즉 객체 관계 매핑을 의미
- 객체와 테이블을 매핑시켜 쿼리를 작성하지 않고도 직관적으로 CRUD 작업을 할 수 있도록 해준다.
  Mybatis의 경우 DTO 클래스를 작성, CRUD에 따른 쿼리 생성이 필요하나 JPA는 대부분을 자동으로 처리해준다.
  
## 장점
- 재사용성이 증가한다.
- 유지보수가 편리하다.
- DBMS에 대한 종속성이 줄어들어 개발자는 Object에만 집중하면 된다.


## 단점
- 완벽한 ORM 매핑은 불가능해서 설계시 주의해야한다.
- 설계를 잘못하면 성능 저하 및 일관성에 문제가 발생할 수 있다.
- DBMS 고유 기능을 사용하기 어렵다.
- 복잡한 쿼리를 반영하기 쉽지 않다.
- 배치성 쿼리가 필요한 경우 구현이 어렵다.
- 기존 Mybatis를 사용한 방식보다 성능이 떨어질 수 있다.


# Jpa?
- Java Persistence API 또는 JPA는 Java ORM 명세이다.
- Hibernate, OpenJPA, EclipseLink, DataNucleus, TopLink 등의 구현체가 있다.
  예제에서는 가장 많이 사용하는 JPA 구현체인 Hibernate를 사용한다.

# Hibernate?
- 커뮤니티 크고 다른 구현체에 비해 안정성이 높다.
- JPA 기능이외에 부가적인 도구, 유효성 검사, 검색 기능을 추가로 지원한다
 이러한 추가 기능을 이용하면 배치성 데이터 처리에 유용하게 사용할 수 있다.



