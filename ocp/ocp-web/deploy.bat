oc login -u developer -p developer https://api.crc.testing:6443
oc new-build --name=dft-ms-coreservice --strategy=docker --binary
del dft-coreservice-web.war
copy ..\..\dft-ms-coreservice\dft-coreservice-web\target\dft-coreservice-web.war .\dft-coreservice-web.war
copy ..\common\skywalking-agent.jar .\skywalking-agent.jar
oc start-build dft-ms-coreservice --from-dir=. --follow
oc delete -f dft-ms-coreservice.yaml
oc apply -f dft-ms-coreservice.yaml
oc expose service/dft-ms-coreservice