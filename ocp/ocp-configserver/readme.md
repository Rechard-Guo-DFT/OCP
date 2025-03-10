# how to edit configmap
1. oc edit configmap dft-ms-configserver-cm-regional-mars
2. oc create configmap dft-ms-configserver-cm-regional-mars --from-file=path\to\new\data -n my-namespace -o yaml --dry-run=client | oc replace -f -
