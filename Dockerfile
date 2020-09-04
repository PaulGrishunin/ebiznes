FROM ubuntu:18.04

MAINTAINER Pavel Hryshunin

USER root

ENV TZ=Europe/Warsaw
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone 


RUN apt-get update && apt-get install apt-file -y && apt-file update && apt-get install vim -y \
  wget \
  vim \
  git \
  openjdk-8-jdk \
  unzip \
  gnupg \
  gnupg1 \
  curl 

CMD echo "deb https://dl.bintray.com/sbt/debian /" | sudo tee -a /etc/apt/sources.list.d/sbt.list
RUN apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 2EE0EA64E40A89B84B2DF73499E82A75642AC823
RUN curl -L -o sbt.deb http://dl.bintray.com/sbt/debian/sbt-0.13.15.deb
RUN dpkg -i sbt.deb
RUN apt update && apt install -y \
    sbt
 
RUN wget www.scala-lang.org/files/archive/scala-2.12.8.deb
RUN dpkg -i scala-2.12.8.deb

RUN apt-get update && apt-get upgrade -y && \
    apt-get install -y nodejs \
    npm
    
RUN npm i -g npm@6.8.0    
  
EXPOSE 8000
EXPOSE 9000
EXPOSE 5000
EXPOSE 8888

RUN useradd -ms /bin/bash paul
RUN adduser paul sudo

USER paul
WORKDIR /home/paul/
VOLUME ["/home/paul/projekt"] 
