### How To Use

#### 1. Manual Option

1. Clone project

2. Build docker image

```
docker build . <some_tag>:<some_version>
```

3. Run with port expose

```
docker run -p 8080:8080 <some_tag>:<some_version>
```

4. Test It

```
curl -x GET 0.0.0.0:8080/compute/10
```

Response:

```json
{
  "result" : [1,1,2,3,5,8,13,21,34,55]
}
```

#### 2. Get Image Right From Docker Hub Registry

As example, docker-compose.yml:
```
version: '3'
services:
   java-fibonacci-function:
    container_name: java-fibonacci-function
    image: drewlakee/java-fibonacci-function:latest
    ports:
     - 8080:8080
```

then just ```docker-compose up```

Check in [Docker Hub Repository](https://hub.docker.com/repository/docker/drewlakee/java-fibonacci-function)
