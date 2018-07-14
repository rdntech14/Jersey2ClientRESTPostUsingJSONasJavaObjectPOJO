Jersey 2 REST Client - Develop REST api Client using Jersey 2 api to invoke GET/PUT/POST request + JSON body as Java Object POJO
=====

This example demonstrate how to create REST client using Jersey 1 api and send POST Request with **JSON body as Java Object POJO** and parse received Response from JSON to Java Object using POJO

**Prerequisite :**

Please download rest jar from 
*https://github.com/rdntech14/RESTWebServiceJar*

This is a REST web service should be executing on local machine and return result in JSON format.

```
java -jar rest.jar
```

**add Jersey dependency & jersey-json in pom.xml**

```
<dependency>
			<groupId>org.glassfish.jersey.core</groupId>
			<artifactId>jersey-client</artifactId>
			<version>2.25.1</version>
</dependency>

<dependency>
			<groupId>org.glassfish.jersey.media</groupId>
			<artifactId>jersey-media-json-jackson</artifactId>
			<version>2.25.1</version>
</dependency>

<dependency>
			<groupId>com.owlike</groupId>
			<artifactId>genson</artifactId>
			<version>0.99</version>
</dependency>
```

**GET/PUT/POST examples**

**GET**

url : http://localhost:8080/student/list


**POST**

url : http://localhost:8080/student 

Request body : 
```
{
	"id": 1111,
	"firstName": "Vernon",
	"lastName": "Harper",
	"email": "1111@gmail.com",
	"programme": "Financial Analysis",
	"courses": [
		"Accounting",
		"Statistics"
	]
}
```

Response body : 
```
{
  "msg" : "Student Updated"
}
```
**PUT**

url : http://localhost:8080/student/1 

body : 
```
{
	"id": 1,
	"firstName": "Vernon",
	"lastName": "Harper",
	"email": "1111aaaa@gmail.com",
	"programme": "Financial Analysis",
	"courses": [
		"computer",
		"Statistics"
	]
}
```

**Program Output**
```

###### Request Java Object toString method ####### 

MyPOJO [id=1, firstName=fname, lastName=lname, email=1111aaaa@gmail.com, programme=prog, courses=[ca, cb]]

#### Covert Java object to JSON to check  whether JSON is created correctly #### 

{"id":1,"firstName":"fname","lastName":"lname","email":"1111aaaa@gmail.com","programme":"prog","courses":["ca","cb"]}

###### Formatted JSON request ####### 

{
  "id" : 1,
  "firstName" : "fname",
  "lastName" : "lname",
  "email" : "1111aaaa@gmail.com",
  "programme" : "prog",
  "courses" : [ "ca", "cb" ]
}

####### Output from Server ....  ####### 


####### Receive JSON Response and convert into Java Object ####### 


###### Response Java Object toString method ####### 

ResponsePOJO [msg=Student Updated]
  ####### Covert Java object to JSON to check whether JSON is created correctly ####### 

{"msg":"Student Updated"}

###### Formatted JSON response ####### 

{
  "msg" : "Student Updated"
}

```
