# Start process in a subshell
echo "In start_tomcat.sh"
echo "UserId is <" + `id`+ ">"
find /opt/tomcat -exec ls -l {} \;
(/busybox/sh /opt/tomcat/bin/catalina.sh run)&
PID=$!
# Do other stuff
echo "Hi this is my tomcat"

# Wait for server to terminate
wait $PID
