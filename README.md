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

The API is deployed online which can be found [here](https://cse112-sp20.github.io/Cloud-9-Leaderboard/ 
), and uses a preconfigured database on AWS. Detailed steps on the features available and how to use them can be found in the features section. 

In the case that both are shut down, one can deploy the API server locally using these instructions

1) Clone the repository to local machine and open using IDE of choice
2) Configure to compatible JDK/JRE (Java 8 or higher)
3) Navigate to src/main/resources/application.properties and change Database credentials to a valid database of choice
4) Create a runtime configuration with AmplifireRoadTripApplication.java as the main method
5) Run on machine, local tomcat server should now be running on [localhost:5000](localhost:5000)

## Design

This application uses a layered archicture to implement an MVC Design. In this API portion we have the models and controllers which will interact with our view component on the frontend. We also have a service layer that handles communication between the controller layer and model layer as to increase modularity and decrease coupling. To summarize the controller layer takes in HTTP requests from our web application, and then uses the service layer to manipulate the model layer which updates back to our view on the front end. 

## Features

The core features of the API is the registration/login authentication as well as managing the different objects on the application such as users, trips, and waypoints. 
More detailed information on how to use the features can be found below

<p>
  <a href="#User-Login-and-Registration">User Login and Registration</a> •
  <a href="#User-Management">User Management</a> •
  <a href="#Trip-Management">Trip Management</a> •
  <a href="#Waypoint-Management">Waypoint Management</a> •
</p>

## User Login and Registration

The user can register or login into an account using the following URI's. This is in the case where the server is deployed locally to localhost.


______________________________________________________________________________________________________________________________________________
### REGISTER A USER 

New user will be registered and added to database

POST REQUEST
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
______________________________________________________________________________________________________________________________________________

### LOGIN 
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

## User Management
User objects saved in database can be managed 

______________________________________________________________________________________________________________________________________________
### Retrieve a Users information
Will be retrieved using authentication token given at login

GET request
```
localhost:5000/users
```
HEADER
| Key           | Value              |
| -----------   | ----------------   |
| Authorization | Bearer [token_val] |

This will return the users information if found on the database in a JSON Object
______________________________________________________________________________________________________________________________________________

### Update a Users information
PUT REQUEST
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
{ user object with updated information } 
```

This will return the updated user object in the database
______________________________________________________________________________________________________________________________________________

### Delete a User
DELETE REQUEST
```
localhost:5000/users/{userid}
```
HEADER
| Key           | Value              |
| -----------   | ----------------   |
| Authorization | Bearer [token_val] |

This will return a boolean corresponding to the success of the deletion

______________________________________________________________________________________________________________________________________________

## Trip Management
Trip objects saved in database can be managed 
______________________________________________________________________________________________________________________________________________
### Create a new trip
POST REQUEST
```
localhost:5000/trips
```

HEADER
| Key           | Value              |
| -----------   | ----------------   |
| Authorization | Bearer [token_val] |

JSON BODY
```
{
    "tripName" : "[road trip name]",
    "user" :  { "userId" : [user id of user who will own trip] }
    "waypoints" : [array of JSON waypoint objects] 
}
```
Waypoints are optional in initialization. This will return the trip JSON object if successfully added to database
______________________________________________________________________________________________________________________________________________

### Retrieve a trips information
GET REQUEST
```
localhost:5000/trips/{tripId}
```

HEADER
| Key           | Value              |
| -----------   | ----------------   |
| Authorization | Bearer [token_val] |

This will return the Trip JSON object if found in the database
______________________________________________________________________________________________________________________________________________

### Retrieve all the trips owned by a user
GET REQUEST
```
localhost:5000/trips/getAll/{userId}
```

HEADER
| Key           | Value              |
| -----------   | ----------------   |
| Authorization | Bearer [token_val] |

This will return a list of JSON Trip objects of all the trips owned by the user
______________________________________________________________________________________________________________________________________________

### Update a trips information
PUT REQUEST
```
localhost:5000/trips
```

HEADER
| Key           | Value              |
| -----------   | ----------------   |
| Authorization | Bearer [token_val] |

JSON BODY
```
{ updated trip JSON object } 
```
This will return the updated JSON Trip object that is updated in the database
______________________________________________________________________________________________________________________________________________

### Delete a trip
DELETE REQUEST
```
localhost:5000/trips/{tripId}
```

HEADER
| Key           | Value              |
| -----------   | ----------------   |
| Authorization | Bearer [token_val] |

This will return a boolean corresponding to the success of the deletion
______________________________________________________________________________________________________________________________________________

## Waypoint Management
Waypoint objects saved in database can be managed

#### Create a new waypoint
POST REQUEST
```
localhost:5000/waypoints
```

HEADER
| Key           | Value              |
| -----------   | ----------------   |
| Authorization | Bearer [token_val] |

JSON BODY
```
{
    "waypointName":"Viriginia",
    "longitude": 24.59,
    "latitude": 60.11,
    "trip":
    {
        "tripId": [trip id that waypoint will be apart of]
    }
}
```
This will return a JSON waypoint object of the waypoint created in the database
______________________________________________________________________________________________________________________________________________

### Retrieve a waypoints information
GET REQUEST
```
localhost:5000/waypoints/{waypointId}
```

HEADER
| Key           | Value              |
| -----------   | ----------------   |
| Authorization | Bearer [token_val] |

This will return a JSON object of the waypoint if found in the database
______________________________________________________________________________________________________________________________________________

### Retrieve all the waypoints belonging to a trip
GET REQUEST
```
localhost:5000/waypoints/getAll/{tripId}
```

HEADER
| Key           | Value              |
| -----------   | ----------------   |
| Authorization | Bearer [token_val] |

This will return a list of JSON objects of the waypoints that are a part of the trip of tripID
______________________________________________________________________________________________________________________________________________

### Update a waypoint
PUT REQUEST
```
localhost:5000/waypoints
```

HEADER
| Key           | Value              |
| -----------   | ----------------   |
| Authorization | Bearer [token_val] |

JSON BODY
```
{ [updated] waypoint object }
```
______________________________________________________________________________________________________________________________________________

### Delete a waypoint
DELETE REQUEST
```
localhost:5000/waypoints/{waypointId}
```

HEADER
| Key           | Value              |
| -----------   | ----------------   |
| Authorization | Bearer [token_val] |

This will return a boolean corresponding to the success of the deletion

______________________________________________________________________________________________________________________________________________


## Team

**Evan Ritchey**

**Isaiah Anason**

**Noah Frederick**

**Justin Sherfey**

