# Weather API
This project is a RESTful API that provides weather information for specific dates that is obtained from external api

## Prerequisites
In order to run this app you should have Docker installed on your machine

## Technologies Used
- Spring Boot
- Spring Data JPA
- Spring Web MVC
- Spring Cloud OpenFeign
- Spring Boot Validation
- SpringDoc OpenAPI
- Logstash
- Lombok
- PostgreSQL
- JUnit
- Instancio
- Mockito
- Docker

## Installation

1. Clone the repository: git clone https://github.com/ankoo0/weather-api.git

2. Open a terminal and navigate to the project directory.

3. Run docker-compose up *don't forget to add project root directory to Docker file sharing or compose will stuck in infinite loop 

4. When the application is running, open your browser and go to http://localhost:8080/swagger-ui/index.html to test endpoints.

You can use the provided samples or create your own requests, but be aware that application considers valid only dd-MM-yyyy date format.
I created init SQL script, so you can request information starting from 23-12-2023

Alternatively, you can use the Postman collection located in the project root to test the API.

** I'm exposing api key for ease of access but, of course, it's not a good practice)