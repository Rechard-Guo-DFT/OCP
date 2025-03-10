#FROM registry.redhat.io/jboss-eap-7/eap74-openjdk11-openshift-rhel8:7.4.9-5
FROM image-registry.openshift-image-registry.svc:5000/openshift/jboss-eap74-openjdk11-openshift:latest

COPY *.war /opt/eap/standalone/deployments/

COPY jboss/standalone.xml /opt/eap/standalone/configuration/standalone.xml

COPY jboss/modules/org /opt/eap/modules/org

#to resolve log4j logger file not exist can not create
# Create a directory for the log file
USER root
RUN mkdir -p /Logs
# Set the ownership and permissions of the log directory
RUN chmod -R 777 /Logs
USER whoami

EXPOSE 8080
EXPOSE 9443

CMD ["/opt/eap/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]