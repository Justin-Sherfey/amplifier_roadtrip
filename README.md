# Amplifier Road Trip API

### Java API for the Amplifier Road Trip web application

<p>
  <a href="#About">About</a> •
  <a href="#Getting-Started">Getting Started</a> •
  <a href="#Features">Features</a> •
  <a href="#Team">Features</a> 
</p>

## About
The Amplifier Road Trip API uses a Java backend to provide functionality and database persistance to its front-end counterpart.
- Layered Architecture Design for increased modularity and lowered coupling
- AWS RDS for data persistance and storage
- Spring security using JWT's for a more secure authentication system
- Built on a Spring boot framework utilizing Spring Core, JPARepository, Tomcat server, etc.
- AWS Codepipeline for CI/CD

## Getting Started

The API is deployed online which can be found here, and uses a preconfigured database on AWS. Detailed steps on the features available and how to use them can be found in the features section. 

In the case that both are shut down, one can deploy the API server locally using these instructions

1) Clone the repository to local machine and open using IDE of choice
2) Configure to compatible JDK/JRE (Java 8 or higher)
3) Navigate to src/main/resources/application.properties and change Database credentials to a valid database of choice
4) Create a runtime configuration with AmplifireRoadTripApplication.java as the main method
5) Run on machine, local tomcat server should now be running on [localhost:5000](localhost:5000)

## Features

### User Login and Registration

The user can register or login into an account using the following URI's. This is in the case where the server is deployed locally to localhost.

#### REGISTER A USER 
New user will be registered and added to database

POST request
```
localhost:5000/register
```
JSON BODY
```
{ 
  "username" : "[exampleUsername]",
  "password" : "[examplePassword]"
}
```

This will return the JSON User object of the new user saved on the database

#### LOGIN 
User will be authenticated and given a JWT token if valid login attempt

POST request
```
localhost:5000/login
```
JSON BODY

POST request



### User Management

### Trip Management

### Waypoint Management


## Team

**Evan Ritchey**

**Isaiah Anason**

**Noah Frederick**

**Justin Sherfey**

