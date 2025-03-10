oc login -u developer -p developer https://api.crc.testing:6443
oc project workshop
oc delete bc ocp-configserver
oc new-build --name=ocp-configserver --strategy=docker --binary
oc delete configmap ocp-configserver-cm-supportedoperations
oc create configmap ocp-configserver-cm-supportedoperations --from-file=..\..\ocp-configserver\src\main\resources\config\broker\SupportedOperations\

oc delete configmap ocp-configserver-cm-supportedtradeoperations
oc create configmap ocp-configserver-cm-supportedtradeoperations --from-file=..\..\ocp-configserver\src\main\resources\config\broker\SupportedTradeOperations\

del ocp-configserver.jar
copy ..\..\ocp-configserver\target\ocp-configserver.jar .\ocp-configserver.jar
oc start-build ocp-configserver --from-dir=. --follow

oc delete -f ocp-configserver.yaml
oc apply -f ocp-configserver.yaml

oc expose service ocp-configserver
