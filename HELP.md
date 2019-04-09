# Getting Started

### Reference
The project was made using the following technologies:

* Java 8
* Gradle
* Spring Boot v2.1.4.RELEASE
* H2 Database
* Accessing Data with JPA
* REST Services with Spring
* Spring Aspect
* Spring Async


### Initialization
The project loads the initialization script (resources/data.sql) which contains the insert of 5 vehicles id from 1-5 to perform the tests. The service port is 80.


### Endpoints

#### Save position
| method | path| content-type |
| ------ | ------| ------ |
|POST | /gbm/api/v1/position|application/json|

##### Body
```json
{
	"vehicleId":1,
	"latitude": 19.3635374,
	"longitude": -99.1825208
}
```

#### Get last position by vehicle
| method | path| param |
| ------ | ------| ------ |
|GET | /gbm/api/v1/position|vehicle|

##### Example
localhost:80/gbm/api/v1/position?vehicle=2

#### Get the position history by vehicle
| method | path| param |
| ------ | ------| ------ |
|GET | /gbm/api/v1/position/history|vehicle|

##### Example

localhost:80/gbm/api/v1/position/history?vehicle=2

#### Receive update position
localhost:80/gbm/api/v1/consumer/position
##### Body
```json
{
	"vehicleId":1,
	"latitude": 19.3635374,
	"longitude": -99.1825208
}
```
