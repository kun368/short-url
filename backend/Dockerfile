FROM maven:3-jdk-8

ENV APP_ROOT=/app
RUN mkdir -p $APP_ROOT
WORKDIR $APP_ROOT
ADD . $APP_ROOT
COPY docker/settings.xml /usr/share/maven/ref/

RUN mvn clean install -DskipTests=true -Dmaven.javadoc.skip=true -B -V

ENV JAVA_OPTS ""
ENV SPRING_PROFILES_ACTIVE test

EXPOSE 8080
CMD ["/bin/sh", "-c", "java $JAVA_OPTS -jar target/app.jar --spring.profiles.active=$SPRING_PROFILES_ACTIVE"]
