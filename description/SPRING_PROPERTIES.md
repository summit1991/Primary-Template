## application properties?
- 뜻 자체는 애플리케이션 속성들
- 애플리케이션 실행될 때 결정되는 글로벌 상수 정도?
- 용도
  - 애플리케이션이 명백히 또는 고정되는 속성(상수)를 등록해놓고 이용할 값들을 정의하는 설정 파일  
  - 애플리케이션은 로컬, 테스트, 라이브 등과 같은 여러 *실행 환경*을 가지는데, 환경마다 값은 다르지만 역할이 같은 글로벌 속성을 정의하기 위함
  - 예를들어 써드파티 서비스(인증, 결제, 문자, AWS 등)를 사용하는 경우 해당 서비스도 테스트나 라이브 환경 별로 id, url 등과 같이 환경마다 다른 속성 값들이 존재하는데 그에 맞게 매핑하기 위함
- 지원확장자
  - .properties
  - .yml(.yaml)
  - 동일한 위치에 .properties, .yml 모두 존재하는 경우 .properties가 우선적으로 사용됨
- 스캔방식
  1. From the classpath
     - root
     - ```/config``` 패키지
  2. From the current directory
     - current directory
     - current directory 내부의 ```/config``` 하위 폴더
     - ```/config``` 하위 폴더의 직계 자식 폴더들
- 순서
  - 빌드된 jar 파일 안에 존재하는 application.properties or application.yml
  - 빌드된 jar 파일 안에 존재하는 application-{profile}.properties or application-{profile}.yml
  - 빌드된 jar 파일 밖에 존재하는 application.properties or application.yml
  - 빌드된 jar 파일 밖에 존재하는 application-{profile}.properties or application-{profile}.yml

- 사용방식이랄까?
  - 속성파일의 이원화 
    - DB, Redis, AWS 등과 같이 접속 또는 인증과 같은 보안이 요구되는 속성들은 프로젝트 자체에 탑재하는 건 위험 
    - '**분리용속성파일**'과 '**포함용속성파일**'로 나눔
    - 환경마다 jar 파일 밖에 중요 및 환경 속성을 포함한 properties or yml을 배치 
    - 그 속성파일의 ```spring.profiles.active:{profile1},{profile2}...N``` 속성을 통해 jar 내부의 application-{profile}.properties or application-{profile}.yml을 다시 호출하는 형태가 괜찮아보임
  - 분리용속성파일 배치 (스캔방식 2번을 통한 것으로 보임)
    - 개발환경에서는 프로젝트 ```루트``` or ```루트/config```에 배치
    - 배포환경에서는 jar와 같은 디렉토리에 배치
    - jar로 빌드될 떄 프로젝트 ```루트``` or ```루트/config```에 배치된 속성파일들은 기본적으로는 포함되지 않으므로 배포환경에서 신경쓸 필요 없음
  - 포함용속성파일 배치
    - 개발환경의 ```resources``` or ```/resources/config```에 배치 (배포환경에서는 스캔방식 1번 형태로 처리됨. 개발환경에서는 IDE가 처리해주는 것으로)
    - 위의 폴더 이하는 빌드된 이후 모두 classpath root에 속함
