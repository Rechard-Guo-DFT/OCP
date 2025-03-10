#oc login -u developer -p developer https://api.crc.testing:6443
oc new-build --name=dft-ms-coreservice --strategy=docker --binary

if [ -f "dft-coreservice-web.war" ]; then
    rm -rf dft-coreservice-web.war
fi

cp ../../dft-ms-coreservice/dft-coreservice-web/target/dft-coreservice-web.war ./dft-coreservice-web.war
cp ../common/skywalking-agent.jar ./skywalking-agent.jar
oc start-build dft-ms-coreservice --from-dir=. --follow
oc delete -f dft-ms-coreservice.yaml
oc apply -f dft-ms-coreservice.yaml

res=`oc get route|grep dft-ms-coreservice|awk '{print $1}'`
if [ -z "$res" ]; then
    oc expose service dft-ms-coreservice
fi