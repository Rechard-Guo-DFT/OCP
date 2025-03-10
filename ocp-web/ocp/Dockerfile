FROM image-registry.openshift-image-registry.svc:5000/openshift/jboss-eap74-openjdk11-openshift:latest

COPY jboss/deployments/*.war /opt/eap/standalone/deployments/

COPY jboss/configuration/ /opt/eap/standalone/configuration/
COPY jboss/bin/ /opt/eap/standalone/bin/

COPY jboss/modules/ /opt/eap/modules/

#to resolve log4j logger file not exist can not create
# Create a directory for the log file
USER root
RUN mkdir -p /Logs
# Set the ownership and permissions of the log directory
RUN chmod -R 777 /Logs
USER whoami

EXPOSE 8080
EXPOSE 9443

CMD ["/opt/eap/bin/standalone.sh"]