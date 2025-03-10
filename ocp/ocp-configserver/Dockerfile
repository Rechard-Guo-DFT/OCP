FROM image-registry.openshift-image-registry.svc:5000/openshift/ubi8-openjdk-17:1.18

USER root
RUN mkdir -p /Logs

RUN chmod -R 777 /Logs
USER whoami
COPY ocp-configserver.jar app.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=ocp,native","app.jar"]
#ENTRYPOINT ["/bin/sh", "-c", "tail -f /dev/null"]