# shopping-list-api
API

### Tecnologies
Jdk11
Maven
Caching
Lombok -> https://projectlombok.org/features/GetterSetter

### Local

`mvn clean-install spring-boot:run`

### Deploy

`sh build.sh`
`sh run.sh`

### See connectair logs
`docker ps --all `
`docker logs shopping-list`

`docker exec -ti shopping-list /bin/sh`

### Software working and manual test

curl http://localhost:8080/shopping-list

and FOR HAVE MORE, you can use import postman project in this repository /postman-collections .
