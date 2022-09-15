#!/bin/bash

# Start process in a subshell
echo "In start_tomcat.sh"
echo "UserId is <" + `id`+ ">"

# Exporting the Azure Keyvault secrets mounted by the java chart before invoking tomcat
export SECRETS_PATH=/mnt/secrets/lgy-iac/
export_mounted_keyvault_values

(/busybox/sh /opt/tomcat/bin/catalina.sh run)&
PID=$!

# Wait for server to terminate
wait $PID

export_mounted_keyvault_values() {
  for file in $SECRETS_PATH/*
  do
    export `basename $file`=`cat $file`
  done
}
