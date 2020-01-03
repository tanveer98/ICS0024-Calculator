### Website: 
#### https://team7.northeurope.cloudapp.azure.com/
#### https://ics-calc-team7.tk/

####  Staging Server access: ec2-user@13.53.177.46
####  Production Server: mhasan@65.52.229.255 

## Staging Server
Staging server has 2 gitlab runners running using the Shell executor, with the tags: 'runner' (for backend)  and 'front-end' (for frontend).
In order to build and test the backend, the staging server has OpenJDK-11.0.5 installed. (make sure to set up the _$JAVA_HOME_ shell variable in case gradle complains about it)
For the front end, the server has nodejs 12-LTS installed (NPM should also be installed with nodejs).

Hardware wise, staging has 3GB of swapfile configured

## Production Server
The production server only needs to have docker and docker-compose installed. DockerFile has a dependency on jdk11, and docker-compose on postgresSQL
Each time a change is pushed upstream, the docker container for the backend (but not DB) gets rebuilt from the new jar.

Hardware wise, production has 3GB of swapfile configured.

#### Production Server setting  ####
| Setting name/ package name | version / setted contents |
| -------------------------| ------- |
| Nginx version| 1.14.0
| IPv4 listening port| 80, 443 (SSL)
| IPv6 listening port| 80, 443 (SSL)
| Document root  | /var/www/html/build

#### Under /api setting ####  
| setting name | settings |
| -------------------------| ------- |
| proxy port  | 8080
| proxy_set_header (x-Forwarded-for)  |$proxy_add_x_forwarded_for 
| proxy_set_header (x-Forwarded-proto)  |$scheme
| proxy_set_header (x-Forwarded-port)  |$server_port
These are required for integrated tomcat server

#### Under /api : if request method is "GET"  ####
| setting name | settings |
| -------------------------| ------- |
| allowed option  | *
| allowed method | GET, POST, OPTIONS
| allowed headers | DNT, User-Agent,  X-requested-with, <br> If-method-since,   Cache-control, <br> Cache-Control,Content-Type, Range
| expose headers  | Content-Length, Content-Range
This is required for CORS.

# **Calculator project for ICS0024**
## Calculation requirement and logic
### Task title : Square of a distance between min-max
1. Inputted number should be integer.
2. Take absolute value of min and max. (max - min)
3. Square the absolute value and return a result.  

### API Endpoints:
    Calculator: https://team7.northeurope.cloudapp.azure.com/api/c?v={param1}&v={param2}...

         
## Business logic    
### Acceptable / Designed inputs
User enters several values in calculator page in GET request (insert domain name before /)

    example : /c?v=4,7  ---> returns 9  
    example : /c?v=10,-2, 0 ---> returns 144  


### Exceeding assumptions
Following inputations are out of design application returns "bad request (HTTP 400)"  
    
    example : /c?v=  
    example : /c?v=1, ,10  
    example : /c?v=abc  
    example : /c?v=1, abc



## Requirement package and version
| Package or software name | version |
| -------------------------| ------- |
| Java SDK|                   11.*
| Gradle  |                  5.6.2

## Linux environment setup guide from zero
### 1. Setup Java 
1.Download from Oracle official or apt command. NOTE: in apt , do not forget apt update  
```
sudo apt install openjdk-11-jdk
```
The case if installation *.deb package from :https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html
```
dpkg install jdk-11.0.4_linux-x64_bin.deb
```
   Installation in apt 
```
sudo apt install openjdk-11-jdk
```
2.Verify installation 
```
java --version
```

### 2. Setup Gradle * OPTIONAL
1. Go to Gradle official page and choose : https://gradle.org/releases/
2. For installation guide : https://gradle.org/install/


### 3. Clone a repository from TalTech GitLab 
```
git clone https://gitlab.cs.ttu.ee/mhasan/calculator
```
### 4. Install docker package
```
sudo apt-get install docker
sudo apt-get install docker-compose
```
### 5. Run Docker in backgound.
Goto cloned repository directory and run docker in backgound
```
sudo docker-compose up -d
```

### 6. Lombok
Install lombok plugin for intellij
Then go to File > Setting > Compiler > Annotation processor > Enable annotation processing


## Run REST 
1.Check running docker in background, if not , 
```
sudo docker-compose up -d
```

2.View our landing page   
http://localhost:40400/


3.Let's calculate   
http://localhost:40400/calculate?v=10,20



## For developers 

1.API documentation  
http://localhost:40400/swagger


## How to expand it:
The core calculate method takes in a list of integers and finds the min-max values 
and returns a ResponseDTO object (which is a wrapper around null).
The consumers of the api can serialize the json object and get the value returned 
by the calculate method from the squaredValue field.
