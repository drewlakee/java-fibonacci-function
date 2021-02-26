### Deployment

#### Manual Option

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
