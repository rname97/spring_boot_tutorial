## Spring boot - Simple JWT & MYSQL

## System Requirements
- Java : (openjdk version "11.0.18")
- Maven : (Apache Maven 3.9.1)
- Editor : (Intellij IDEA 2023.1.1 Community Edition)
- Postman : (Version 10.17.7)


## Dependencies
- Spring Data JPA
- Spring Security
- Spring Web
- Validation
- Spring Boot DevTools
- MySQL Driver
- Spring Configuration Processor
- Lombok
- jjwt


## run project

1. clone project Spring Boot - Simple JWT & MySQL
```
git clone https://github.com/rname97/spring-jwt.git
```

2. add new database mysql with name "db_spring_jwt"

3. open project with intellij IDEA then edit config database in application.properties chage username and password match your config database

4. open terminal in intellij IDEA and input command 
```
mvn clean install 
```
5. if success next input command
```
mvn spring-boot:run
```

6. open postman and add 3 new Request endpoint with Method POST (signup, signin, refreshToken)

### #Testing Endpoint signup

![signup](https://github.com/rname97/spring-jwt/assets/47927755/a3570cbc-8ba4-430b-8272-11f919a76a36)
``` 
localhost:8080/auth/signup
``` 

Request :
``` 
{
    "userUsername":"user1",
    "userPassword":"user1",
    "userEmail":"user1@gmail.com",
    "userNama":"user1"
}
``` 

Response :
``` 
{
    "userId": 1,
    "userUsername": "user1",
    "userPassword": "$2a$10$gyL2EGhwTJWF1ISNtlW9W.5XqZ8/cbXzRaxt7heQ0DkplmTutAtWK",
    "userNama": "user1",
    "userAlamat": null,
    "userEmail": "user1@gmail.com",
    "userNoHp": null,
    "userRoles": "user",
    "userIsAktif": true
}
```

### #Testing Endpoint signin

![siginin](https://github.com/rname97/spring-jwt/assets/47927755/5339a0f5-d1eb-45f2-b3ab-aef9d37de907)

``` 
localhost:8080/auth/signin
``` 
Request :
``` 
{
    "username":"user1",
    "password":"user1"
}
``` 

Response :
``` 
{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMSIsImlhdCI6MTY5NDgxMzM3NSwiZXhwIjoxNjk0ODE2OTc1fQ.eSQRJpu0NSHc1k7g0JI-3OaWq-UdxX0mj6INEqKIJ_x0h9kG_qPOhbMtU821bM_ZcVC3YB-1B-xJWW24N-JxIw",
    "refreshToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMSIsImlhdCI6MTY5NDgxMzM3NSwiZXhwIjoxNjk1MTczMzc1fQ.ZAV5LT1_QyLAwT8TCW4FnPl4XYbejR2inpRJ2KbN0HQMdVY2mAZhSPFUhkRX3m2eAJC6IdHToRLB6r9sHKJSNQ",
    "type": "Bearer",
    "userId": 1,
    "userUsername": "user1",
    "userEmail": "user1@gmail.com",
    "userRoles": "user"
}
```


### #Testing Endpoint refreshToken
![refreshtoken](https://github.com/rname97/spring-jwt/assets/47927755/69b16674-c59a-472d-930e-388aeb1a8e92)

``` 
localhost:8080/auth/signin
``` 
Request :
``` 
{
    "refreshToken":"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMSIsImlhdCI6MTY5NDgxMzM3NSwiZXhwIjoxNjk0ODE2OTc1fQ.eSQRJpu0NSHc1k7g0JI-3OaWq-UdxX0mj6INEqKIJ_x0h9kG_qPOhbMtU821bM_ZcVC3YB-1B-xJWW24N-JxIw"
}
``` 

Response :
``` 
{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMSIsImlhdCI6MTY5NDgxMzQ0OCwiZXhwIjoxNjk0ODE3MDQ4fQ.bVBoFYjRZOEaPfCMczEusJewQcoEEsKdj4UKcDe2DHlknQBo1gA6XTnX_hgVn3WnLho4aiAbVDOlxi7yxpFTVA",
    "refreshToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMSIsImlhdCI6MTY5NDgxMzQ0OCwiZXhwIjoxNjk1MTczNDQ4fQ.HAEyw4hV-SOuWjVZnMOadPdTZv1aXPv22cG5nyQP_R627xcDvsyRXpDxszsOQ-ckQQwZgSujHIjEFIxxACKcMA",
    "type": "Bearer",
    "userId": 1,
    "userUsername": "user1",
    "userEmail": "user1@gmail.com",
    "userRoles": "user"
}
```
