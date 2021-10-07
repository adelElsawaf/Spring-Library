startDockerPostgres= sudo docker start postgres
dataBase= $( sudo docker images -q postgres )
runSystemlocally= ./gradlew bootRun --args='--spring.profiles.active=local'
if [[ -name "$dataBase" ]]; then
"$startDockerPostgres".
wait
"$runSystemlocally"
else
downloadPostgres= sudo docker pull postgres
wait
dockerRunDataBaseInstance= sudo docker run -name postgre -e POSTGRES_PASSWORD = mysecretpassword -d -p 5432:5432 postgres
"$downloadPostgres"
"$dockerRunDataBaseInstance"
fi