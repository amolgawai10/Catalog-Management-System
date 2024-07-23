
# Catalog Management System

The objective of this project is to develop a robust Spring Boot application for managing product inventory. The application provides a comprehensive set of RESTful APIs to perform CRUD operations on products, ensuring seamless integration with a MySQL database. It includes features like logging for troubleshooting, auditing for tracking modifications, and supports predefined product categories using an enum. 




## Setting Up and Running a Spring Boot Project


Prerequisites:

```bash
Java Development Kit (JDK): Ensure you install JDK 8 or later.
IntelliJ IDEA: An IDE for Java development.
MySQL Workbench: To manage your MySQL database
Postman: A tool to test APIs.
```






## Steps

A] Create a Spring Boot Project
Go to the Spring Initializr website.
Configure the project with the necessary dependencies:


1.Spring Boot DevTools

2.Spring Web

3.Spring Data JPA

4.MySQL Driver

5.Lombok               

Use Spring Boot version 3.3.2.
Click on the Generate button to download the project as a ZIP file.
Extract the downloaded ZIP file.

B] Open the Project in IntelliJ IDEA:

Open IntelliJ IDEA.
Click on File > New > Project from Existing Sources.

Select the extracted folder and open it in IntelliJ IDEA.

C] Configure Database Connectivity:

Open the application.properties file located in the src/main/resources folder.
Add the necessary configurations for database connectivity. 

For example:

spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name

spring.datasource.username=your_username

spring.datasource.password=your_password


spring.jpa.hibernate.ddl-auto=update


Running the Project:
You can run the application by navigating to the main class (annotated with @SpringBootApplication) and clicking the run icon in IntelliJ IDEA.

D] Use Postman: A tool to test APIs. 

1] POST API: Add the product in Database

Endpoint: http://localhost:8080/product/add

Request:
{

    "name":"Boat Nirvana",
    "brand":"boat",
    "description":"Boat for rockerz",
    "price":"1500",
    "quantity":1,
    "category":"ELECTRONICS"
}

Response:
Product added successfully

2] GET API: Get the product details by name 

Endpoint: http://localhost:8080/product/getProductByName?name=ParleG

Request: key= name, value=parleG

Response:
 
{

    "id": 2,
    "name": "ParleG",
    "brand": "Parle",
    "description": "Biscuit of India",
    "price": "10",
    "quantity": 1,
    "category": "SNACKS",
    "createdOn": "2024-07-23T21:05:59.137+00:00",
    "updatedOn": "2024-07-23T21:05:59.137+00:00"
}

3] GET API: Get the product details by its brand
	
Endpoint: http://localhost:8080/product/getProductByBrand?brand=polo

Request : key=brand & value=polo

Response
	
    {
        "id": 4,
        "name": "Black TShirt",
        "brand": "Polo",
        "description": "Fashion for all",
        "price": "800",
        "quantity": 1,
        "category": "CLOTHS",
        "createdOn": "2024-07-23T21:07:58.702+00:00",
        "updatedOn": "2024-07-23T21:07:58.702+00:00"
    }



4] GET API: Get the details of products by its Category

Endpoint: http://localhost:8080/product/getProductByCategory?cat=ELECTRONICS

Request: key=cat & value=ELECTRONICS

Response

	
    {
        "id": 5,
        "name": "Boat Nirvana",
        "brand": "boat",
        "description": "Boat for rockerz",
        "price": "1500",
        "quantity": 1,
        "category": "ELECTRONICS",
        "createdOn": "2024-07-23T21:08:45.867+00:00",
        "updatedOn": "2024-07-23T21:08:45.867+00:00"
    }

 
5] PUT API: Update the available product attributes

Endpoint: http://localhost:8080/product/update?productId=5

Request: key=productId and value=5

Body in JSON:

{

    "name":"Boat Nirvana",
    "brand":"boat",
    "description":"Boat for rockerz",
    "price":"1600",
    "quantity":1,
    "category":"ELECTRONICS"
}


Response

{

    "id": 5,
    "name": "Boat Nirvana",
    "brand": "boat",
    "description": "Boat for rockerz",
    "price": "1600",
    "quantity": 1,
    "category": "ELECTRONICS",
    "createdOn": "2024-07-23T21:08:45.867+00:00",
    "updatedOn": "2024-07-23T21:41:10.853+00:00"

}


6] DELETE API: Delete the existing product details from the database

Endpoint: http://localhost:8080/product/delete?productId=5

Request: key=productId & value=5

Response: The product is deleted Successfully


Summary

I created a Product entity within an entity package and developed a ProductController class within a controller package, which includes six endpoints. The controller is dependent on a service layer through autowiring. Business logic for adding, updating, retrieving, and deleting data is implemented in the service layer. Additionally, I created a repository extending JpaRepository, incorporating custom methods such as findByName, findByBrand, and findByCategory. An enum package was also created, containing an enum class with categories such as grocery, electronics, clothes, snacks, beauty, and kitchen. Logging was implemented for troubleshooting and auditing features to display createdOn and updatedOn timestamps for each endpoint. The project is fully functional and deployed on GitHub. Follow these steps to complete a similar project.
