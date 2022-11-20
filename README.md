# spring_rest_api

## Info
- This is a REST API for storing Employees and their cars
- The data is stored inside a MySql Database
- To store and query data, I used Spring Data JPA and to validate user entry, I used Spring Boot Validation
- Spring Boot Web is used to implement a Controller to handle HTTP requests
- only accepts and returns JSON Data
- HTTP request example are stored in: src/main/java/niklas.office/ExampleApiRequests

## Endpoints
EmployeeController
- GET: api/employees -> gets all employees
- GET: api/employee/{employeeId} -> gets an employee by Id
- POST: api/employee -> upload a new Employee
- PUT: api/employee/{employeeId} -> updates or stores a new employee
- DELETE: api/employee/{employeeId} -> deletes an employee by Id

CarController
- GET: api/car/{carId} -> get a Car by Id
- GET: api/employee/{employeeId}/cars -> get all cars from an employee
- POST: api/employee/{employeeId}/car -> stores a new car for an existing employee
- PUT: api/car/{carId} -> (only) updates an existing car by Id
- DELETE: api/car/{carId} -> delete Car by Id
- DELETE: api/employee/{employeeId}/cars -> delete all cars from an employee
