# Start process in a subshell
echo "In start_tomcat.sh"
echo "UserId is <" + `id`+ ">"

# Test exporting the mounted secrets
export SECRET_PATH=/mnt/secrets/lgy-iac/
export POSTGRES_DATABASE=`cat $SECRET_PATH/POSTGRES_DATABASE`
export POSTGRES_HOST=`cat $SECRET_PATH/POSTGRES_HOST`
export POSTGRES_PASSWORD=`cat $SECRET_PATH/POSTGRES_PASSWORD`
export POSTGRES_USER=`cat $SECRET_PATH/POSTGRES_USER`

(/busybox/sh /opt/tomcat/bin/catalina.sh run)&
PID=$!

# Wait for server to terminate
wait $PID
