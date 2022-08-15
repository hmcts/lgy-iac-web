# Start process in a subshell
(/busybox/sh /opt/tomcat/bin/catalina.sh run)&
PID=$!
# Do other stuff
echo "Hello world!"
# Wait for server to terminate
wait $PID
