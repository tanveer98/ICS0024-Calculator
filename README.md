# **Calculator project for ICS0024**
## Purpose of calculation

## Requirement
| Package or software name | version |
| -------------------------| ------- |
| Java SDK|                   11.*
| Gradle  |                  5.6.2

## Linux environment setup guide from zero
### 1. Setup Java 
1.Download from Oracle official or apt command. NOTE: in apt , dot forget apt update
2.Installation *.deb package: 
```
dpkg install jdk-11.0.4_linux-x64_bin.deb
```
   Installation in apt 
```
sudo apt install openjdk-11-jdk
```
3.Verify installation 
```
java --version
```

### 2. Setup Gradle
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





