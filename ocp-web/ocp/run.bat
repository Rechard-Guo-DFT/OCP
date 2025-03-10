oc login -u developer -p developer https://api.crc.testing:6443
oc project workshop
oc new-build --name=test-web --strategy=docker --binary
call mvn clean package -DskipTests -f ..\pom.xml
del .\jboss\deployments\test-web.war
copy ..\target\test-web.war .\jboss\deployments\test-web.war
oc start-build test-web --from-dir=. --follow
oc delete -f test-web-build.yaml
oc policy add-role-to-user view -z default
oc apply -f test-web-build.yaml