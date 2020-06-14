#!/usr/bin/env bash

java -jar -Dspring.profiles.active=aws /home/ec2-user/elements-auth.jar > /dev/null 2> /dev/null < /dev/null &
java -jar -Dspring.profiles.active=aws /home/ec2-user/elements-api.jar > /dev/null 2> /dev/null < /dev/null &
