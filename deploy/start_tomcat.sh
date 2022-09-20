#!/bin/bash

export SECRETS_PATH=/mnt/secrets/lgy-iac/
export_mounted_keyvault_values () {
  for file in $SECRETS_PATH/*
  do
    eval "export `basename $file`=`cat $file`"
    echo `basename $file` : `cat $file`
  done
}

#logging some environment variable
echo "EPDQ_PSPID:"  $EPDQ_PSPID
echo "STORAGE_METHOD:"  $STORAGE_METHOD

# Exporting the Azure Keyvault secrets mounted by the java chart before invoking tomcat
if [ -d $SECRETS_PATH ]
then
  export_mounted_keyvault_values
else
  echo "Key Vault Secrets not mounted"
fi

(/busybox/sh /opt/tomcat/bin/catalina.sh run)&
PID=$!

# Do other stuff
echo "Hi this is my tomcat"

# Wait for server to terminate
wait $PID
