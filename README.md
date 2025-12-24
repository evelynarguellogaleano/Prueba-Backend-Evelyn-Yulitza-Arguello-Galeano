# Prueba Backend - Evelyn Yulitza Arguello Galeano

Este repositorio contiene la solución a la prueba técnica para desarrollador Back-End. El proyecto es una API REST construida con Java 21 y Spring Boot, que implementa CRUDS para la gestión de ligas de fútbol, equipos y países, así como una serie de ejercicios de lógica algorítmica

## Tecnologías Utilizadas

- **Java 21**
- **Spring Boot 3.3.5**
- **Maven**
- **PostgreSQL** 
- **Lombok** 
- **Spring Data JPA**:



### Configuración de la Base de Datos
Configurar las credenciales de la base de datos en el archivo `src/main/resources/application.properties`

### Ejecutar la aplicación
Para compilar y ejecutar el proyecto:

```bash
mvn spring-boot:run
```

La aplicación estará disponible en `http://localhost:8081`


### Controladores (API REST)
La API muestra los siguientes endpoints:

- **Ligas (`/ligas`)**:
    - `GET /ligas`: Listar todas las ligas
    - `POST /ligas`: Crear una nueva liga
    - `GET /ligas/{id}`: Obtener una liga por ID
    - `PUT /ligas/{id}`: Actualizar una liga
    - `GET /ligas/pais/{paisId}`: Listar ligas por país

- **Equipos (`/equipos`)**:
    - `GET /equipos`: Listar todos los equipos
    - `POST /equipos`: Crear un nuevo equipo
    - `GET /equipos/{id}`: Obtener un equipo por ID
    - `PUT /equipos/{id}`: Actualizar un equipo
    - `GET /equipos/liga/{ligaId}`: Listar equipos por liga

- **Países (`/paises`)**:
    - `GET /paises`: Listar todos los países
    - `POST /paises`: Crear un nuevo país
    - `GET /paises/{id}`: Obtener un país por ID
    - `PUT /paises/{id}`: Actualizar un país

### 2. Ejercicios de Lógica (`/logica`)
Se implementaron soluciones a problemas lógicos específicos en el `LogicaController`:

- **Anagrama**: `/logica/anagrama?palabra1=...&palabra2=...`
    - Verifica si dos palabras son anagramas
- **Par/Impar**: `/logica/par-impar/{numero}`
    - Determina si un número es par o impar (máximo 4 dígitos)
- **Moneda más pesada**: `/logica/moneda-pesada`
    - Simulación lógica para encontrar una moneda más pesada en 2 pesadas
- **Palíndromo**: `/logica/palindromo?texto=...`
    - Verifica si una cadena es un palíndromo (ignora mayúsculas y caracteres especiales)
- **Calcular Edad**: `/logica/edad?fechaNacimiento=dd/MM/yyyy`
    - Suma 2 años y 3 meses a la fecha dada y calcula la edad actual respecto a esa nueva fecha

### 3. Consultas SQL
El archivo `consultas.sql` en la raíz del proyecto contiene las consultas SQL solicitadas para:
1. Listar equipos con detalles de liga y país
2. Contar equipos por liga
3. Contar ligas por país
4. Encontrar el país con más equipos
5. Listar ligas sin equipos


