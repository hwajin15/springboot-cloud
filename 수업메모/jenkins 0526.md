git  설치 - yum install git -y

maven 설치 - yum install maven -y 



새로운 프로젝트 만들기 Deploy  to tomcat server 생성

build - > pom.xml  	

​	clean install package 

빌드후 조치 

```
**/*.war
containers Tomcat9,x 
deployer /deployer 
tomcat url http://192.168.56.12:8080
```

cd webapps/  확인



tomcat manager - webapps 확인