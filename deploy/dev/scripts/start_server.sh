#!/bin/bash

#loading environment variables
#source "/home/jhojan/projects/aws/hello-codepipeline/deploy/dev/envs/.env" #used developing
source "/home/ec2-user/app/envs/.env" #used EC2
# define variables
APP_DIR=${APP_DIR}
JAR_FILE=${JAR_FILE}
SPRING_PROFILE=${PROFILE}
CONFIG_FILE=${CONFIG_FILE}
LOG_FILE=$APP_DIR/app.log

# start application
nohup java -jar "$JAR_FILE" --spring.config.location="file:$CONFIG_FILE" --spring.profiles.active="$SPRING_PROFILE" > "$LOG_FILE" 2>&1 &

echo "Server started with:"
echo "  Profile       : $SPRING_PROFILE"
echo "  Config file   : $CONFIG_FILE"
echo "  JAR file      : $JAR_FILE"
echo "  Log file      : $LOG_FILE"