## myRetailRestService
An end to end Implementation of the myRetail case study. Supporting both GET and PUT for /products/

## Dependencies
Java installed (Tested with java 8)  
Mongodb installed and running (Tested with Community Server 3.42)  

## Building
1. Pull this repository.  
2. cd to myRetailRestService  
3. Use the command "gradlew build"  This will build the module using a gradle wrapper and run the tests.  

## Running (after building)
1. cd to myRetailRestService\build\libs  
2. Use the command "java -jar myRetail-rest-service-0.1.0.jar"  
3. OR use the command "java -jar myRetail-rest-service-0.1.0.jar sampledata" to load sample data for 3 products into the mongodb  

## Testing Results
Test results can be found in the included myRetailRestService/build/reports/tests/test/index.html  
This file will be updated with local results after running a "gradlew build"

## Interaction
This progam in its current configuration will run a tomcat server accessible at http://localhost:8080/  
This means that put and get requests to http://localhost:8080/products/{id} will return data.
If the sample data flag was used on the jar the database will be cleared of persistedPrices and initialized with results for the following commands.  
http://localhost:8080/products/16696652  
http://localhost:8080/products/13860421  
http://localhost:8080/products/13860428  
example response
{ "id": "13860428", "name": "The Big Lebowski (Blu-ray)", "price": { "value": 29.99, "currencyCode": "USD"  } }  
<b>Note:</b> Using GET /products/{id} for an id that has no product data in redsky or no persisted price information will result in a plain text error response
    
Put functions expecting an application/json string in the following format.  
{"id": "13860428", "name": "The Big Lebowski (Blu-ray)", "price": { "value": 223.12, "currencyCode": "YEN" } }  
And should return a near identical string (PUT disregards the name element as it is not persisted but pulled from the redsky service)  
<b>Note:</b> Using PUT /products/id for an id that has no product data in redsky or with a non double value will result in a plain text error response

## Technology Stack
Java 8  
Spring/Spring Boot 1.5.1  
Mongodb 3.42  
Gradle 3.3  
Eclipse  
eGit  
Postman (for testing)  

## Acknowledgements
https://spring.io/guides for countless useful examples and guides on spring behavior




