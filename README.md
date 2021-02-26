### How To Use

1. Clone project

2. Build docker image

```
docker build . jff:1.0.0
```

3. Run with port expose

```
docker run -p 8080:8080 jff:1.0.0
```

4. Test

```
curl -x GET 0.0.0.0:8080/compute/100
```

Response:

```json
{
  "result" : 354224848179261900000
}
```
