# Start process in a subshell
echo "In start_tomcat.sh"
echo "UserId is <" + `id`+ ">"
echo "ls started <" + `date` + ">"
find /opt/tomcat -exec ls -l {} \;
echo "ls finished <" + `date` + ">"

export_mounted_keyvault_values {
  for file in /mnt/secrets/lgy-iac/*
  do
    export `basename $file`=`cat $file`
  done
}

export_mounted_keyvault_values

(/busybox/sh /opt/tomcat/bin/catalina.sh run)&
PID=$!

# Wait for server to terminate
wait $PID
