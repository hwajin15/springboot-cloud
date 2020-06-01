C:/Users/HPE/Work/vagrant/.vagrant/machines/jenkins-server/virtualbox/private_key

1>ssh -p 22 -i C:/Users/HPE/Work/vagrant/.vagrant/machines/jenkins-server/virtualbox/private_key vagrant@192.168.56.11

2>ssh -p 19211 -i C:/Users/HPE/Work/vagrant/.vagrant/machines/jenkins-server/virtualbox/private_key vagrant@127.0.0.1

3>vagratn ssh jenkins-server

docker --version

id

useradd dockeradmin

passwd dockeradmin

usermod -aG  docker dockeradmin(docker -> root)

su dockeradmin 

docker images



docker run -d --rm --name tomcat-container --publish 38080:8080 tocat:latest



docker-host

192.168.56.13

dockeradmin



FROM tomcat:latest

COPY ./webapp.war /usr/local/tomcat/webapps
~                                                                                                                                                             ~                                                            

[Trilead API](https://plugins.jenkins.io/trilead-api)





cd /home/dockeradmin;docker build -t hello-project  .;docker run -d --name hello-container -p 8080:8080 hello-project 