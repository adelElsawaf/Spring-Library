#! /usr/bin/bash
startDockerPostgres= sudo docker start postgres
sudoPassword= 1234567
runSystemlocally= ./gradlew bootRun --args='--spring.profiles.active=local'
echo $startDockerPostgres"
echo $sudoPassword"
echo $runSystemlocally"

