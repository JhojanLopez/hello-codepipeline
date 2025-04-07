#!/bin/bash
# Asegura propiedad y permisos correctos

chown -R ec2-user:ec2-user /home/ec2-user/app
chmod -R 755 /home/ec2-user/app