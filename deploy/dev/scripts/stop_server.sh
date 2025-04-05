#!/bin/bash

# Cargar las variables de entorno desde .env
#source "/home/jhojan/projects/aws/hello-codepipeline/deploy/dev/envs/.env" #used developing
source "/home/ec2-user/app/envs/.env" #used EC2

# Buscar el proceso del JAR que está corriendo
PROCESS_ID=$(pgrep -f "$JAR_FILE")

# Si se encuentra el proceso, lo matamos
if [ -z "$PROCESS_ID" ]; then
    echo "No se encontró el proceso del JAR en ejecución."
else
    echo "Deteniendo el proceso del JAR (PID: $PROCESS_ID)..."
    kill -9 "$PROCESS_ID"
    echo "Proceso detenido."
fi
