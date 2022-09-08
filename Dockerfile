ARG APP_INSIGHTS_AGENT_VERSION=3.2.10
ARG PLATFORM=""

# Application image (use debug to get busybox shell temporarily)
FROM hmctspublic.azurecr.io/base/java:openjdk-8-debug-distroless-1.4

USER root
SHELL ["/busybox/sh", "-c"]

COPY lib/AI-Agent.xml /opt/app/

RUN mkdir /opt/app/tomcat/
WORKDIR /opt/app/tomcat

#Install Tomcat 8 (Version 8.5.81)
RUN wget https://www-eu.apache.org/dist/tomcat/tomcat-8/v8.5.82/bin/apache-tomcat-8.5.82.tar.gz
RUN tar xvfz apache*.tar.gz
RUN mv apache-tomcat-8.5.82/ /opt/tomcat/

# Remove the default ROOT folder (we will replace it)
RUN rm -rf /opt/tomcat/webapps/ROOT

# Verify Java version
ENV JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
ENV CATALINA_OPTS="-Xmx512M -XX:MaxPermSize=1024m"

# ENV ENV_NAME="Local Dev PG"
# ENV DB_JDBC_DRIVER="org.postgresql.Driver"
# ENV DB_JDBC_URL="jdbc:postgresql"
# ENV DB_HOST="172.17.0.1"
# ENV DB_PORT="5432"
# ENV DB_USER="lgyiacadmin"
# ENV DB_PASSWORD="dummy"
# ENV DB_NAME="lgyiac"
# ENV EPDQ_PSPID="a"
# ENV EPDQ_URL="b"
# ENV EPDQ_SHAIN="c"
# ENV EPDQ_SHAOUT="d"

RUN java -version

EXPOSE 8080

RUN mkdir -p /opt/moj/IACFees.files/Backup
RUN mkdir -p /opt/moj/IACFees.files/IAC_Submissions/PDF_Files/
RUN mkdir -p /opt/moj/IACFees.files/IAC_Submissions/XML_Files/
RUN mkdir -p /opt/moj/IACFees.files/IAC_Submissions/Status_Files/
RUN mkdir -p /opt/moj/IACFees.files/Backup/PDF_Files/
RUN mkdir -p /opt/moj/IACFees.files/Backup/XML_Files/

ADD deploy/IACFees.war /opt/tomcat/webapps
ADD deploy/start_tomcat.sh /opt/tomcat/bin

ADD deploy/health.war /opt/tomcat/webapps

# Try to debug using a statically linked curl deployed to the container
ADD deploy/curl-amd64 /opt
RUN chown hmcts:hmcts /opt/curl-amd64
RUN chmod +x /opt/curl-amd64

RUN chown -R hmcts:hmcts /opt/tomcat

# The default ENTRYPOINT is the equivalent of "java -jar" which gives an error about java specification
# Make sure to call a valid entrypoint (even on the command line, e.g. '--entrypoint "/busybox/sh"')

#COPY --from=busybox:1.35.0-uclibc /bin/sh /bin/sh (alternative to running dev distro)
ENTRYPOINT ["/busybox/sh", "/opt/tomcat/bin/start_tomcat.sh"]
