# Start process in a subshell
echo "In start_tomcat.sh"
echo "UserId is <" + `id`+ ">"
find /opt/tomcat -exec ls -l {} \;
(/busybox/sh /opt/tomcat/bin/catalina.sh run)&
PID=$!
# Do other stuff
echo "Hello world!"
# Wait for server to terminate
wait $PID
