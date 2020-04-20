# shopping-list-api
API

### Tecnologies
<ul>
  <li>JDK_11</li>
  <li>Spring-boot</li>
  <li>Maven</li>
  <li>Lombok</li>
<ul>
### Deploy Local  

`mvn clean-install spring-boot:run`

### Deploy with Docker

`sh build.sh`

`sh run.sh`

### See container logs
`docker ps --all `
`docker logs shopping-list`

`docker exec -ti shopping-list /bin/sh`

### Software working and manual test

`curl http://localhost:8080/shopping-list`

and FOR HAVE MORE, you can use import postman project in this repository /postman-collections .

# Heroku
`heroku login`
`git push heroku master`
`curl http://dsmanioto-shopping-list.herokuapp.com/shopping-list`
<br>
http://dsmanioto-shopping-list.herokuapp.com/