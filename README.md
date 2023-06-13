<h1 align="center">
  Place Service
</h1>



API para gerenciar lugares (CRUD) que faz parte [desse desafio](https://github.com/RocketBus/quero-ser-clickbus/tree/master/testes/backend-developer) para pessoas desenvolvedoras backend que se candidatam para a ClickBus.



## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [PostgreSQL](https://www.postgresql.org/)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [Docker](https://www.docker.com/)

## Práticas adotadas

- SOLID
- Testes automatizados
- Consultas com filtros dinâmicos usando o Query By Example
- Uso de DTOs para a API
- Injeção de Dependências
- Auditoria sobre criação e atualização da entidade

## Como Executar

### Localmente
- Clonar repositório git
- Construir o projeto:
```
./mvnw clean package
```
- Executar:
```
java -jar place-service/target/place-service-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](localhost:8080/swagger-ui.html)

### Usando Docker

- Clonar repositório git
- Construir o projeto:
```
./mvnw clean package
```
- Construir a imagem:
```
./mvnw spring-boot:build-image
```
- Executar o container:
```
docker run --name place-service -p 8080:8080  -d place-service:0.0.1-SNAPSHOT
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](localhost:8080/swagger-ui.html)

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [PostMan](https://www.postman.com/):

- POST /place
```
http POST :8080/places 

{
    name="Place" state="State"
}

HTTP/1.1 200 OK
Content-Length: 129
Content-Type: application/json

{
    "createdAt": "2023-06-13T00:36:23.414928595",
    "name": "Place",
    "slug": "place",
    "state": "State",
    "city": "City
}
```

- GET /places/{id}
```
http :8080/places/1
HTTP/1.1 200 OK
Content-Length: 129
Content-Type: application/json

{
    "createdAt": "2023-06-07T14:45:39.693689",
    "name": "Place",
    "slug": "place",
    "city": "City",
    "state":"state"
    
} 
```

- GET /places?name=?
```
http :8080/places?name=Place
HTTP/1.1 200 OK
Content-Type: application/json
transfer-encoding: chunked

[
    {
        "name": "Place",
        "slug": "place",
        "state": "State",
        "city":"City"
    }
]
```

- PUT /places/{id}
```
http PATCH :8080/places/1 
{
   "name"="New Name" 
   "state"="New State"
   "city"="New City"
   "slug" = "New Slug"
}

HTTP/1.1 200 OK
Content-Length: 142
Content-Type: application/json

{
    "name"="New Name" 
   "state"="New State"
   "city"="New City"
   "slug" = "New Slug"
}
```