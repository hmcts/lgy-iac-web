ARG APP_INSIGHTS_AGENT_VERSION=3.2.10
ARG PLATFORM=""

# Application image - (use debug to get busybox shell temporarily)
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
RUN rm -rf /opt/tomcat/webapps/docs
RUN rm -rf /opt/tomcat/webapps/examples
#RUN rm -rf /opt/tomcat/webapps/manager
#RUN rm -rf /opt/tomcat/webapps/host-manager

# Add debug logging to the scanjars to optimise startup times
RUN echo "org.apache.jasper.servlet.TldScanner.level=FINE" >> /opt/tomcat/conf/logging.properties

# Verify Java version
ENV JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
ENV CATALINA_OPTS="-Xmx512M -XX:MaxPermSize=1024m -Djava.security.egd=file:/dev/./urandom"
RUN java -version

# Expose port 8080 in the container
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
