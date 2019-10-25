# **Calculator project for ICS0024**
## Calculation requirement and logic
### Task title : Square of a distance between min-max
1. Inputted number should be integer.
2. Take absolute value of min and max.
3. Square the absolute value and return a result.  

## Business logic    
### Acceptable / Designed inputs
User enters several values in calculator page in GET request  
example : /calculator?v=4,7

### exceeding assumptions
Following inoputations are out of design 
example : /calculator?v=  
example : /calculator?v=1, ,10  
example : /calculator?v=a  


##Development
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

2.View our langind page   
http://localhost:40400/


3.Let's calculate   
http://localhost:40400/calculate?v=10,20



## For developers 

1.API documentation  
http://localhost:40400/swagger-ui.html