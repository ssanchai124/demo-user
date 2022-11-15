
# README #
This a service create by sanchai srisamudh
* Apache Maven 3.6.1
* Java version 11
* Spring-boot 2.7.1

login elephantsql and run script

* table user
* table user_info
```
CREATE TABLE 'user'
(
id int ,
username  VARCHAR(50),
password  VARCHAR(50),
role      VARCHAR(50)
);
```

```
CREATE TABLE 'user_info'
(
id int ,
username        VARCHAR(50),
password        VARCHAR(50),
phone           VARCHAR(50),
date_of_birth   VARCHAR(50),
salary          VARCHAR(50),
reference_code  VARCHAR(50),
member_type     VARCHAR(50),
first_name      VARCHAR(50),
last_name       VARCHAR(50),
address         VARCHAR(50),
district        VARCHAR(50),
sub_district    VARCHAR(50),
province        VARCHAR(50),
zipcode         VARCHAR(50)
);
```

* mvn clean
* mvn spring boot -run

API	                        |Endpoint	                                              |Method|
----------------------------|-------------------------------------------------------|------|
register user authorization	|http://localhost:1150/auth/register	                  | POST |
login for get authorization	|http://localhost:1150/auth/login   	                  | POST |
user register             	|http://localhost:1150/user/register	                  | POST |
user get information	      |http://localhost:1150/user/information/{referenceCode}	| GET  |

