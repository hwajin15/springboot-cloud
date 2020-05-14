calms 프레임워크

더자주배포하고 오류를 줄일수 있음



FREEDCAMP



kubernetes -container 가 존재해야함

docker cotainer service 가능



DEV 	->	QA 	->	OPS

​			(TEST SERVER) 

 application.properties ->yml

application_local.yml



CD (지속적인 배포)

젠킨스, codeship -> Packaging 

CI/CD 

---

#### Microservice

작은서비스 	

​	독립된서비스 : bounded context / 유비쿼스트 language

CRM (customer relationship management )

voc (voice of customer )

 bounded context -독립적인 실행 /다른서비스 결합이 없는 서비스

응집된 서비스 

​	coupling 을 낮추고 관계있는 것은 통합해서 제공하자

​	-> 단순해지고 명확 , 오류 최소화



도메인 이해/ 요구사항 /조직분석 - 역할 명칭구분 상관관계 등등

마이크로 서비스 원칙 수립  - 경계 /분할 /크기



상관 분석 - 사용자 업무 데이터간의 상관관계

서비스 식별 



payload 반환시킨 값 

http://localhostL8088/users users 는 endpoint

구축/ 운영 

sprints++ -하나의 개발 단위(2주)

 

CI/CD  자동화

devops

miscroservices 

containers

---

micro service 구성도

telemetry 잘 작동하는지 확인 / s3 instance 로 시각화 / log 파일 분석 등등 

mesh service  마이크로 서비스 단위를 어떻게 구성할것인지 / 문제가 생기면 우회할 수 있도록

​	미들웨어를 통해 인증 이라던가 라우팅 로드 밸런싱 

​	**자가 치유 복구 서비스** - 하나의 서비스가 문제가 생기면 stand by 서비스를 승격 시키는 등

​    

CI 목적 

빌드가 실행 complie 발생 ->  run (junit ) -> deply to test -> execute

coverage (메소드, 얼마나 실행 되었는지 ) 



http://server.users?id=1 ->requestparam

http://server.users/1 => pathvariable

---

service design

circuit breaker  문제가 감지되면 모든 시스템과의  연결을 차단 / 장애가 발생하는 서비스에 반복적인 호출이 되지 못하게 차단

정상이면 close / 정상x open

-@EnablCircuitBreaker 사용 

---

프로파일 cofig 설정 파일 

히스트릭스 대시보드 

터빈서버 log 파일을 모아 -> dashboard 