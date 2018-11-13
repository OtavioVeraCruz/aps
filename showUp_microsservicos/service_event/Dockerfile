FROM ubuntu

RUN apt-get update && \
    apt-get install -y openjdk-8-jdk && \
    apt-get install -y ant && \
    apt-get clean;

ENV PROJECT_HOME /usr/src
RUN mkdir -p $PROJECT_HOME/activator $PROJECT_HOME/app

WORKDIR $PROJECT_WORKPLACE/activator

RUN  apt-get update \
  && apt-get install -y wget \
  && rm -rf /var/lib/apt/lists/*

RUN apt-get update
RUN apt-get install -y unzip 

RUN wget http://downloads.typesafe.com/typesafe-activator/1.3.10/typesafe-activator-1.3.10.zip && unzip typesafe-activator-1.3.10.zip

ENV PATH $PROJECT_HOME/activator/activator-dist-1.3.10/bin:$PATH
ENV PATH $PROJECT_WORKPLACE/build/target/universal/stage/bin:$PATH
COPY . $PROJECT_HOME/app
WORKDIR $PROJECT_HOME/app
EXPOSE 8080
