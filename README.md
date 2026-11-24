# Práctica 2: Biblioteca

Repositorio: https://github.com/alexzxc1980/aux-prac-2-juan-chambi

Estudiante: Juan Alex Chambi Montes. SIS-414 G2, auxiliar Manuel Martinez Orcko.

API REST de libros con almacenamiento temporal en una lista en memoria, sin base de datos. Se utiliza Java 21, Spring Boot 3.5.16 y Swagger/OpenAPI.

## Ejecutar

Requisitos: JDK 21 y acceso a internet para descargar Maven y las dependencias.

```bash
git clone https://github.com/alexzxc1980/aux-prac-2-juan-chambi.git
cd aux-prac-2-juan-chambi
./mvnw spring-boot:run
```

En Windows: `.\mvnw.cmd spring-boot:run`. Las pruebas se ejecutan con `./mvnw test` o `.\mvnw.cmd test`.

## Endpoints

| Método | Ruta | Resultado |
| --- | --- | --- |
| POST | `/api/books` | Registra un libro y responde 201 con su ubicación |
| GET | `/api/books` | Lista todos los libros; responde 200 |
| GET | `/api/books/{id}` | Consulta un libro; responde 200 o 404 |
| PUT | `/api/books/{id}` | Reemplaza los datos del libro; responde 200 o 404 |
| DELETE | `/api/books/{id}` | Elimina un libro; responde 204 o 404 |

Los cuerpos de POST y PUT llevan `title`, `author`, `isbn`, `publicationYear`, `category` y `available`. El servidor genera `id`. Las solicitudes inválidas devuelven 400.

## Swagger

Abrir http://localhost:8080/swagger-ui/index.html. La especificación JSON está en http://localhost:8080/v3/api-docs. Los ejemplos se pueden ejecutar con **Try it out**.

## Organización

`controller` recibe las solicitudes HTTP; `dto` define los datos de entrada y salida; `service` implementa el CRUD; `model` representa el libro.

Los datos se pierden al detener la aplicación, tal como requiere esta práctica.

## Evidencias

- [Endpoints en Swagger](evidencias/p2-swagger.png)
- [Consulta HTTP 200 desde Swagger](evidencias/p2-get-200.png)
- [CRUD, validaciones y errores](evidencias/p2-crud.png)

