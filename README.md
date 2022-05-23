# 220523_OOP내용정리 :memo:

##  간단한 은행 계좌의 입출금 내역 조회 프로그램 구현하기 :pushpin:

### [프로그램 domain]
BankTransaction : 하나의 입출금 내역   
BankStatementParser : 입출금 내역 데이터 파일 처리기, 데이터 파일을 시스템에서 이해할 수 있는 형태로 파싱(Parsing)해주는 역할   
BankStatementAnalyzer : 입출금 내역 분석기, 파싱된 데이터를 분석, 연산 처리해주는 역할

**요구사항 check list**

-   [ ] 입출금 내역을 담고 있는 bank-data-simple.tsv(txt) 파일을 읽고, 총 입출금 내역을 처리한 후, 콘솔로 결과를 조회할 수 있음
-   [ ] 특정 월에 발생한 입출금 내역을 조회할 수 있음

### 0. 프로젝트 생성

File - new - other... - maven - maven project   
GroupId(패키지명) : dev.bank.bankstatement   
ArtifactId(프로젝트명) : bankstatement   

### 1. 컴파일러 버전 변경

1.  pom.xml 내부에 다음의 코드 추가
```xml
<properties>  
<maven.compiler.source>1.8</maven.compiler.source>   
<maven.compiler.target>1.8</maven.compiler.target>   
</properties>  
```

2.  project folder 우클릭 - maven - update project

