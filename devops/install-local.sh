#!/bin/sh

#Environment variable
TAG="visa-web"
LOGS_FOLDER="/var/log/us-gestor"
PORT="8855"
CONTAINER_NAME="us-visa-web"
LOG_LEVEL_SYSTEM=INFO
LOG_LEVEL_BUSINESS=INFO

$(aws ecr get-login --region us-east-1 | sed -e 's/-e none//g')
cd ..
#building image
docker build -t $TAG -f devops/Dockerfile .
echo "image created"
#creating container
docker run -d -p $PORT:8080 --name=$CONTAINER_NAME -e environment=ci   -v $LOGS_FOLDER:/var/log/us-visa-web $TAG
echo "container created"
read -rsp $'Press any key to continue...\n' -n1 key