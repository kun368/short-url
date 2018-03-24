FROM node:9
MAINTAINER codekun <www.zzkun.com>

ENV HTML_ROOT=/var/www/html
ENV SRC_ROOT=/appsrc
RUN echo 'deb http://mirrors.163.com/debian/ jessie main non-free contrib \
          deb http://mirrors.163.com/debian/ jessie-updates main non-free contrib \
          deb http://mirrors.163.com/debian-security/ jessie/updates main non-free contrib' > /etc/apt/sources.list
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
