FROM persapiens/openjdk:8u171-jre-alpine

MAINTAINER Eduardo Henrique "eduardo.henrique@ifrn.edu.br"

VOLUME /tmp

EXPOSE 8080

ENV JAVA_OPTS=""

ENV SPRING_BOOT_OPTS=""

RUN adduser -D springboot

USER springboot

ADD --chown=springboot build/libs/*.jar /home/springboot/app.jar

ENTRYPOINT exec java $JAVA_OPTS -jar /home/springboot/app.jar $SPRING_BOOT_OPTS
