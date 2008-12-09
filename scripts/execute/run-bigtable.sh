#!/bin/bash

JAVAPATH=/usr/bin/java
SERVICENAME=../../scripts/execute/run-orbd.sh
ENPATH=../../scripts/execute/ExecutionNode.sh

#lanca servico de nomes
$SERVICENAME 
echo "servico de nomes lancado"
sleep 5


#lanca execution node
$ENPATH
echo "Execution node sera lancado"
"../../scripts/execute/ExecutionNode.sh"
echo "execution node lancado"
sleep 5

#executa aplicacao
echo "iniciando aplicacao"
$JAVAPATH -Xmx500m -classpath . scs.demos.bigtable.app.BigTableTester

killall java
killall orbd


