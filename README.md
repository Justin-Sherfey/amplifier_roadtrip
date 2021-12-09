# Amplifier Road Trip API

### Java API for the Amplifier Road Trip web application

<p>
  <a href="#About">About</a> •
  <a href="#Getting-Started">Getting Started</a> •
  <a href="#Design">Design</a> •
  <a href="#Features">Features</a> •
  <a href="#Team">Team</a> 
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

## Design

## Features

The core features of the API is the registration/login authentication as well as managing the different objects on the application such as users, trips, and waypoints. 
More detailed information on how to use the features can be found below

<p>
  <a href="#User-Login-and-Registration">User Login and Registration</a> •
  <a href="#User-Management">User Management</a> •
  <a href="#Trip-Management">Trip Management</a> •
  <a href="#Waypoint-Management">Waypoint Management</a> •
</p>

### User Login and Registration

The user can register or login into an account using the following URI's. This is in the case where the server is deployed locally to localhost.

#### REGISTER A USER 
New user will be registered and added to database

REQUEST
```

```

HEADER
| Key          | Value            |
| -----------  | ---------------- |
| Content-Type | application/json |

JSON BODY
```

```

POST REQUEST
```
localhost:5000/register
```

HEADER
| Key          | Value            |
| -----------  | ---------------- |
| Content-Type | application/json |

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

POST REQUEST
```
localhost:5000/login
```
HEADER
| Key          | Value            |
| -----------  | ---------------- |
| Content-Type | application/json |

JSON BODY
```
{ 
  "username" : "[exampleUsername]",
  "password" : "[examplePassword]"
}
```
This will return a JSON object with the jwt token needed for future authentication

______________________________________________________________________________________________________________________________________________

### User Management
User objects saved in database can be managed 

#### Retrieve a Users information
Will be retrieved using authentication token given at login

GET request
```
localhost:5000/users
```
HEADER
| Key           | Value              |
| -----------   | ----------------   |
| Content-Type  | application/json   |
| Authorization | Bearer [token_val] |

This will return the users information if found on the database in a JSON Object

#### Update a Users information

PUT request
```
localhost:5000/users
```
HEADER
| Key           | Value              |
| -----------   | ----------------   |
| Content-Type  | application/json   |
| Authorization | Bearer [token_val] |

JSON BODY
```

```

#### Delete a User
REQUEST
```

```

HEADER
| Key           | Value              |
| -----------   | ----------------   |
| Content-Type  | application/json   |
| Authorization | Bearer [token_val] |

JSON BODY
```

```


______________________________________________________________________________________________________________________________________________

### Trip Management
Trip objects saved in database can be managed 

#### Create a new trip
REQUEST
```

```

HEADER
| Key           | Value              |
| -----------   | ----------------   |
| Content-Type  | application/json   |
| Authorization | Bearer [token_val] |

JSON BODY
```

```

#### Retrieve a trips information
REQUEST
```

```

HEADER
| Key           | Value              |
| -----------   | ----------------   |
| Content-Type  | application/json   |
| Authorization | Bearer [token_val] |

JSON BODY
```

```

#### Retrieve all the trips owned by a user
REQUEST
```

```

HEADER
| Key           | Value              |
| -----------   | ----------------   |
| Content-Type  | application/json   |
| Authorization | Bearer [token_val] |

JSON BODY
```

```

#### Update a trips information
REQUEST
```

```

HEADER
| Key           | Value              |
| -----------   | ----------------   |
| Content-Type  | application/json   |
| Authorization | Bearer [token_val] |

JSON BODY
```

```

#### Delete a trip
REQUEST
```

```

HEADER
| Key           | Value              |
| -----------   | ----------------   |
| Content-Type  | application/json   |
| Authorization | Bearer [token_val] |

JSON BODY
```

```

______________________________________________________________________________________________________________________________________________


### Waypoint Management
Waypoint objects saved in database can be managed

#### Create a new waypoint
REQUEST
```

```

HEADER
| Key           | Value              |
| -----------   | ----------------   |
| Content-Type  | application/json   |
| Authorization | Bearer [token_val] |

JSON BODY
```

```

#### Retrieve a waypoints information
REQUEST
```

```

HEADER
| Key           | Value              |
| -----------   | ----------------   |
| Content-Type  | application/json   |
| Authorization | Bearer [token_val] |

JSON BODY
```

```

#### Retrieve all the waypoints belonging to a trip
REQUEST
```

```

HEADER
| Key           | Value              |
| -----------   | ----------------   |
| Content-Type  | application/json   |
| Authorization | Bearer [token_val] |

JSON BODY
```

```

#### Update a waypoint
REQUEST
```

```

HEADER
| Key           | Value              |
| -----------   | ----------------   |
| Content-Type  | application/json   |
| Authorization | Bearer [token_val] |

JSON BODY
```

```

#### Delete a waypoint
REQUEST
```

```

HEADER
| Key           | Value              |
| -----------   | ----------------   |
| Content-Type  | application/json   |
| Authorization | Bearer [token_val] |

JSON BODY
```

```

______________________________________________________________________________________________________________________________________________


## Team

**Evan Ritchey**

**Isaiah Anason**

**Noah Frederick**

**Justin Sherfey**

