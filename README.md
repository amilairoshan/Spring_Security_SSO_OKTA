# Technical Assignment
# Name : V.P.A.Iroshan
# Mobile No : 0779010639

The objectives of this application is:

- Provide authentication to authenticated users(Onborded users) by using Auth0 and Spring security,
- Authenticate API(Rest end point) using JWT.
- Allowing authenticated users to access certain resources.
- Provide authentication with credentials(usernae and password) and social like Google. 

### Application configuration

- src/main/resources/application.yml property file contains the client-id and client-secret which are provided by auth0. 
	client-id: yOe1t513V0TrvN7kZdMpEmUivzRwJ4dE
    client-secret: fMeuE1_jkMUQBDQ3EFg1trDSE4mFpXTGGKSmh_-OVikwNmE--MDtCme40Q4AXBzO

- Application run on port: 8080

### Running application
The project build tool is gradle.
Then Open a terminal, go to the project root directory and run the following command:
./gradlew bootRun

The application will be accessible at http://localhost:8080/.

Then apply on boarded user credentials.
Un : amila@gmail.com
PW : Amila@1234


### Accessing Rest End points(API Authentication)

-First you should get the user token using 

HttpResponse<String> response = Unirest.post("https://dev-amila-iroshan.us.auth0.com/oauth/token")
  .header("content-type", "application/json")
  .body("{\"client_id\":\"AVxkJdUnXSSJBcU4ip9VROKpXlH2ZPfl\",\"client_secret\":\"S5S3SqPVSv5UFa4879djdTG4qKSL5IUbCaTzfStYibfFGWpI89PqB_M_7x0F0Jpj\",\"audience\":\"https://Villvay-assignment-api/api\",\"grant_type\":\"client_credentials\"}")
  .asString();


- Above post method returns the  "access_token".

-After set the access token to header value with 'Bearer' , use can consume the exposed rest end point

Method type = GET
Header = authorization : Bearer "value of access_token"
URL = http://localhost:8080/api/cartDetails








