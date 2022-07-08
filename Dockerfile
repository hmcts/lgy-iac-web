ARG APP_INSIGHTS_AGENT_VERSION=3.2.10
ARG PLATFORM=""
# Application image

FROM hmctspublic.azurecr.io/base/java${PLATFORM}:17-distroless

COPY lib/AI-Agent.xml /opt/app/
COPY build/libs/lgy-iac-web.jar /opt/app/

EXPOSE 8080
CMD [ "lgy-iac-web.jar" ]
