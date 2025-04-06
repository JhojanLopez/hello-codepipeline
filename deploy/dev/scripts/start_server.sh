#!/bin/bash

# Load environment variables
# source "/home/jhojan/projects/aws/hello-codepipeline/deploy/dev/envs/.env" # used in development
source "/home/ec2-user/app/envs/.env" # used in EC2

# Define variables
APP_DIR=${APP_DIR}
JAR_FILE=${JAR_FILE}
SPRING_PROFILE=${PROFILE}
CONFIG_FILE=${CONFIG_FILE}
LOG_FILE=$APP_DIR/app.log

# Ensure log file exists and has proper permissions
touch "$LOG_FILE"
chown ec2-user:ec2-user "$LOG_FILE"
chmod 664 "$LOG_FILE"

# Start application
nohup java -jar "$JAR_FILE" --spring.config.location="file:$CONFIG_FILE" --spring.profiles.active="$SPRING_PROFILE" > "$LOG_FILE" 2>&1 &

echo "Server started with:"
echo "  Profile       : $SPRING_PROFILE"
echo "  Config file   : $CONFIG_FILE"
echo "  JAR file      : $JAR_FILE"
echo "  Log file      : $LOG_FILE"