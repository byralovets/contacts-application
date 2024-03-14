# Contacts application

### Deployment

1. Build and package your project:

```
mvn clean package
```

2. Build docker image with tag `contacts-backend`:

```
docker build -t contacts-database .
```

3. Checkout to directory `deployment` then run the following command:

```
docker compose up -d
```

4. You can access Swagger UI documentation on URL: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
