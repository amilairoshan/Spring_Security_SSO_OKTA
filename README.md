# Name : Amila Iroshan

The objectives of this application is:

-Provide authentication and authorization to spring boot web application using okta. (allow social login along with Google) 
- Authenticate API(Rest end point) with JWT using okta.
- Manage users using okta user management.

### Application configuration

- src/main/resources/application.yml property file contains the client-id and client-secret which are provided by auth0. 
	client-id: 
    client-secret: 

- Application run on port: 8080

### Running application
The project build tool is gradle.
Then Open a terminal, go to the project root directory and run the following command:
./gradlew bootRun

The application will be accessible at http://localhost:8080/.




### Accessing Rest End points(API Authentication)

-First you should get the user token using 

HttpResponse<String> response = Unirest.post("https://dev-amila-iroshan.us.auth0.com/oauth/token")
  .header("content-type", "application/json")
  .body("{\"client_id\":\"AVxkJdUnXSSH2ZPfl\",\"client_secret\":\"S5SB_M_7x0F0Jpj\",\"audience\":\"https://FFt-api/api\",\"grant_type\":\"client_credentials\"}")
  .asString();


- Above post method returns the  "access_token".

-After set the access token to header value with 'Bearer' , use can consume the exposed rest end point

Method type = GET
Header = authorization : Bearer "value of access_token"
URL = http://localhost:8080/api/cartDetails

Read more about this project : https://medium.com/@vpaipathirana/spring-boot-security-sso-oauth2-with-okta-88bbb08e3bee




😊😊



