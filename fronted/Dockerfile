FROM node:9
MAINTAINER codekun <www.zzkun.com>

ENV HTML_ROOT=/var/www/html
ENV SRC_ROOT=/appsrc
RUN echo -e 'deb-src http://archive.ubuntu.com/ubuntu xenial main restricted #Added by software-properties \n \
          deb http://mirrors.aliyun.com/ubuntu/ xenial main restricted \n \
          deb-src http://mirrors.aliyun.com/ubuntu/ xenial main restricted multiverse universe #Added by software-properties \n \
          deb http://mirrors.aliyun.com/ubuntu/ xenial-updates main restricted \n \
          deb-src http://mirrors.aliyun.com/ubuntu/ xenial-updates main restricted multiverse universe #Added by software-properties \n \
          deb http://mirrors.aliyun.com/ubuntu/ xenial universe \n \
          deb http://mirrors.aliyun.com/ubuntu/ xenial-updates universe \n \
          deb http://mirrors.aliyun.com/ubuntu/ xenial multiverse \n \
          deb http://mirrors.aliyun.com/ubuntu/ xenial-updates multiverse \n \
          deb http://mirrors.aliyun.com/ubuntu/ xenial-backports main restricted universe multiverse \n \
          deb-src http://mirrors.aliyun.com/ubuntu/ xenial-backports main restricted universe multiverse #Added by software-properties \n \
          deb http://archive.canonical.com/ubuntu xenial partner \n \
          deb-src http://archive.canonical.com/ubuntu xenial partner \n \
          deb http://mirrors.aliyun.com/ubuntu/ xenial-security main restricted \n \
          deb-src http://mirrors.aliyun.com/ubuntu/ xenial-security main restricted multiverse universe #Added by software-properties \n \
          deb http://mirrors.aliyun.com/ubuntu/ xenial-security universe \n \
          deb http://mirrors.aliyun.com/ubuntu/ xenial-security multiverse' > /etc/apt/sources.list
RUN apt-get update && apt-get install -y nginx

RUN  mkdir -p $HTML_ROOT
RUN  mkdir -p $SRC_ROOT

WORKDIR $SRC_ROOT
COPY package.json $SRC_ROOT
RUN npm config set registry https://registry.npm.taobao.org
RUN npm install --production
COPY . $SRC_ROOT
RUN npm run build
RUN mv $SRC_ROOT/dist/* $HTML_ROOT
RUN rm -rf $SRC_ROOT

EXPOSE 80
CMD nginx -g "daemon off;"
