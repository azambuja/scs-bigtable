#!/bin/bash

JAVAPATH=/opt/java/bin/java
SERVICENAME=../../scripts/execute/run-orbd.sh
ENPATH=../../scripts/execute/ExecutionNode.sh
USER=scorrea@ 
NUN_EXEC_NODE=3 


#lanca servico de nomes
$SERVICENAME 
echo "servico de nomes lancado"
sleep 5

#apaga arquivos
ls std* |xargs rm -f 
find scs/demos/mapreduce/dataset/ -name "teste*" |xargs rm -f
cp scs/demos/mapreduce/seed/teste100K.txt scs/demos/mapreduce/dataset/
        

#lanca execution node
$ENPATH
j=1
while [ $j -le $NUN_EXEC_NODE ] 
do
    if [ $j -le 9 ]
    then 
	SSH=${USER}n0$j
    else
	SSH=${USER}n$j
    fi 
    ssh -f $SSH "cd /home/server/scorrea/scs-turma08.2/src/java/ && ../../scripts/execute/ExecutionNode.sh"
    j=`expr $j + 1`
done
echo "execution nodes lancados"
#sleep 150

#executa aplicacao
echo "iniciando aplicacao"
$JAVAPATH -Xmx500m -classpath . scs.demos.mapreduce.app.MapReduceApp ../../scripts/execute/mapReduce.properties  
PID="$!"

#mata execution node
j=0 
while [ $j -le $NUN_EXEC_NODE ] 
do
    if [ $j -le 9 ]
    then
        SSH=${USER}n0$j
    else
        SSH=${USER}n$j
    fi
    ssh $SSH  "killall java"
    j=`expr $j + 1`
done
kill -9 `/sbin/pidof java`
killall orbd
echo "execution nodes eliminados"
#sleep 10 


