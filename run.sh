#! /usr/bin/bash
startDockerPostgres= sudo docker start postgres
sudoPassword= 1234567
downloadPostgres= sudo docker pull postgres
dockerRunDataBaseInstance= sudo docker run -name postgre -e POSTGRES_PASSWORD = mysecretpassword -d -p 5432:5432 postgres
dataBase= $( sudo docker images -q postgres )
runSystemlocally= ./gradlew bootRun --args='--spring.profiles.active=local'
echo "$sudoPassword"
if [[ -n "$result" ]]; then
echo "$startDockerPostgres".
echo "$sudoPassword"
echo "$runSystemlocally"
else
echo "$downloadPostgres"
echo  "$sudoPassword"
echo "$dockerRunDataBaseInstance"
echo "$sudoPassword"
fi

