# GUI 회원관리 만들기(Swing)

## 프로젝트 설계

![1](/images/200909-1.png)

ServiceLayer가 GUI와 DAO`(Data Access Object)`를 연결해 주고, DAO가 모델인 VO`(Value Object)`를 바탕으로 DBMS와 연결돼있는 설계

## 프로젝트 구조

![2](/images/200909-2.png)

## GUI 디자인

![3](/images/200909-3.png)

## 싱글턴 Service, DAO

Service와 DAO 객체는 효율적인 구조를 위해 싱글턴으로 생성하였고, DAO는 sql 문법으로 MySQL과 연동된 DB에서 데이터를 출력하는 구조

### 싱글턴 ServiceLayer

![4](/images/200909-4.png)

### 싱글턴 UserDAO

![5](/images/200909-5.png)

### 데이터 출력 sql

![6](/images/200909-6.png)