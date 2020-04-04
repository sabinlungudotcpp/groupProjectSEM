
# Group Members :family:
> Sabin Constantin Lungu

> Taylor Aidan Courtney

> Jonathan Sung

> Sadeem Rashid

# Agile Project Proposal :runner:
A company gave us a list of requirements that they would like for us to complete regarding the world population. The product backlog can be found further down in the **Product Backlog** section. The company wants us to create different types of reports, for example creating a report for **Cities** or a report for the **Population** in the world.

The reports are meant to be worked on after retrieving the correct data for the requirements using SQL queries as all of the required data is held in a relational database.

As a  group we have also implemented **Unit Testing** and **Integration Testing** to ensure that the correct results are being retrieved. This is done by the Unit Tests. We have also implemented integration testing which is used to test each module independetly.

In our project we have 2 different **Docker Containers** that controls the application.

> **1. Docker Container for the Application.**

> **2. Docker container for the SQL Database.**

Therefore these 2 containers are tested to ensure that they run properly and communicate with each other in order for the application to work as a whole unit.

Finally as a team we are making use of different branches where each member of the team works on a seperate branch in order to implement a new working feature for the application.

# Prerequisites

> 1. IntelliJ IDEA

> 2. Docker must be installed

> 3. Active GitHub account

> 4. Travis Continuous Integration (CI) account.

# How to build & run the application?

> 1. Go to your current directory, wherever that may be using the command in the command line: > cd <your current directory>
  
> 2. After you have created the directory, in the command line type the command: > mkdir <name your folder>
  
> 3. After you have created a folder within a folder, in the command line type the command to clone the repository: > git clone <URL goes here> to clone the repository from the GitHub repo.

> 4. Next, open IntelliJ IDEA and choose "Open project from existing sources"

> 5. Wait a bit for the project to load. After the project has been loaded, **Build** the project to make sure that the projects builds before it can run. You can do this by clicking the green hammer next to the run button.

> 6. The project should build without any problems. After the project has been built go to the right hand side of the project and choose the **Maven** option.

> 7. Double click on **Clean**

> 8. Click **Package**

> 9. Navigate over on the left hand side of the project and open the **docker-compose.yml** file

> 10. Also go to the **dbb** folder and open the **Dockerfile** file.

> 11. In the **docker-compose.yml** file, click the green button next to **dbb** in order to run the Database Container.

> 12. After the database container has been initialised, do the same for the app.

> 13. Go in the Dockerfile file and click the two green buttons next to **FROM MySQL** to run the image.

# Code Of Conduct :bookmark:

1. All members must attend meetings.
2. Equal contributions to the coursework.
3. No discrimination (racial, religion, gender etc.).
4. Respect and value alternative viewpoints and, seek, accept and offer honest criticisms of work.
5. Be polite to each other.
6. No distractions; all members must be fully focused on work.
7. All members must have the right tools to do the work (e.g. Docker, Travis, IntelliJ).


# Build Statuses of Branches :statue_of_liberty:
- Master Build Status [![Build Status](https://travis-ci.com/sabinlungudotcpp/World-Population-Java-SQL-Group-Project.svg?branch=master)](https://travis-ci.com/sabinlungudotcpp/World-Population-Java-SQL-Group-Project)
- Develop Build Status [![Build Status](https://travis-ci.com/sabinlungudotcpp/World-Population-Java-SQL-Group-Project.svg?branch=develop)](https://travis-ci.com/sabinlungudotcpp/World-Population-Java-SQL-Group-Project)
- License [![LICENSE](https://img.shields.io/github/license/kevin-chalmers/sem.svg?style=flat-square)](https://github.com/kevin-chalmers/sem/blob/master/LICENSE)
- Release [![Build Status](https://travis-ci.com/sabinlungudotcpp/World-Population-Java-SQL-Group-Project.svg?branch=release)](https://travis-ci.com/sabinlungudotcpp/World-Population-Java-SQL-Group-Project)

# User Stories
Before implementing the solutions for the requirements, the following User Stories are to be taken into consideration.

> **1.  As a researcher, I want a report of all the countries in the world organised by largest population to smallest so that the organisation is more informed about the data of the population.**

> **2.  As a researcher, I want a report of all the countries in a continent organised by largest population to smallest so that the organisation is more informed about the data of the population.**

> **3.  As a researcher, I want a report of all the countries in a region organised by largest population to smallest so that the organisation is more informed about the data of the population.**

> **4.  As a researcher, I want a report of the top N populated countries in the world where N is provided by the user so that the organisation is more informed about the data of the population.**

> **5.  As a researcher, I want a report of the top N populated countries in a continent where N is provided by the user so that the organisation is more informed about the data of the population.**

> **6.  As a researcher, I want a report of the top N populated countries in a region where N is provided by the user so that the organisation is more informed about the data of the population.**

> **7.  As a researcher, I want a report of all the cities in the world organised by largest population to smallest so that the organisation is more informed about the data of the population.**

> **8.  As a researcher, I want a report of all the cities in a continent organised by largest population to smallest so that the organisation is more informed about the data of the population.**

> **9.  As a researcher, I want a report of all the cities in a region organised by largest population to smallest so that the organisation is more informed about the data of the population.**

> **10. As a researcher, I want a report of all the cities in a country organised by largest population to smallest so that the organisation is more informed about the data of the population.**

> **11. As a researcher, I want a report of all the cities in a district organised by largest population to smallest so that the organisation is more informed about the data of the population.**

> **12. As a researcher, I want a report of the top N populated cities in the world where N is provided by the user so that the organisation is more informed about the data of the population.**

> **13. As a researcher, I want a report of the top N populated cities in a continent where N is provided by the user so that the organisation is more informed about the data of the population.**

> **14. As a researcher, I want a report of the top N populated cities in a region where N is provided by the user so that the organisation is more informed about the data of the population.**

> **15. As a researcher, I want a report of the top N populated cities in a country where N is provided by the user so that the organisation is more informed about the data of the population.**

> **16. As a researcher, I want a report of the top N populated cities in a district where N is provided by the user so that the organisation is more informed about the data of the population.**

> **17. As a researcher, I want a report of all the capital cities in the world organised by largest population to smallest so that the organisation is more informed about the data of the population.**

> **18. As a researcher, I want a report of all the capital cities in a continent organised by largest population to smallest so that the organisation is more informed about the data of the population.**

> **19. As a researcher, I want a report of all the capital cities in a region organised by largest to smallest so that the organisation is more informed about the data of the population.**

> **20. As a researcher, I want a report of the top N populated capital cities in the world where N is provided by the user so that the organisation is more informed about the data of the population.**

> **21. As a researcher, I want a report of the top N populated capital cities in a continent where N is provided by the user so that the organisation is more informed about the data of the population.**

> **22. As a researcher, I want a report of the top N populated capital cities in a region where N is provided by the user so that the organisation is more informed about the data of the population.**

> **23. As a researcher, I want a report of the population of people, people living in cities, and people not living in cities in each continent so that the organisation is more informed about the data of the population.**

> **24. As a researcher, I want a report of the population of people, people living in cities, and people not living in cities in each region so that the organisation is more informed about the data of the population.**

> **25. As a researcher, I want a report of the population of people, people living in cities, and people not living in cities in each country so that the organisation is more informed about the data of the population.**

# Product Backlog :book:
This section will contain a list of requirements that have been put into a product backlog. As a group we are required to write Java code and SQL queries in order to extract the database results for each of the requirements. As a group we are using Travis Continuous Integration which allows us to continuously test and build this project after we make ***Commits*** and ***Pushes*** which are crucial features of Version Control using Git. 

The requirements that we had to write SQL queries for are:

> **1.  All the countries in the world organised by largest population to smallest.**

> **2.  All the countries in a continent organised by largest population to smallest.**

> **3.  All the countries in a region organised by largest population to smallest.**

> **4.  The top N populated countries in the world where N is provided by the user.**

> **5   The top N populated countries in a continent where N is provided by the user.**

> **6.  The top N populated countries in a region where N is provided by the user.**

> **7.  All the cities in the world organised by largest population to smallest.**

> **8.  All the cities in a continent organised by largest population to smallest.**

> **9.  All the cities in a region organised by largest population to smallest.**

> **10. All the cities in a country organised by largest population to smallest.**

> **11. All the cities in a district organised by largest population to smallest.**

> **12. The top N populated cities in the world where N is provided by the user.**

> **13. The top N populated cities in a continent where N is provided by the user.**

> **14. The top N populated cities in a region where N is provided by the user.**

> **15. The top N populated cities in a country where N is provided by the user.**

> **16. The top N populated cities in a district where N is provided by the user.**

> **17. All the capital cities in the world organised by largest population to smallest.**

> **18. All the capital cities in a continent organised by largest population to smallest.**

> **19. All the capital cities in a region organised by largest to smallest.**

> **20. The top N populated capital cities in the world where N is provided by the user.**

> **21. The top N populated capital cities in a continent where N is provided by the user.**

> **22. The top N populated capital cities in a region where N is provided by the user.**

> **23. The population of people, people living in cities, and people not living in cities in each continent.**

> **24. The population of people, people living in cities, and people not living in cities in each region.**

> **25. The population of people, people living in cities, and people not living in cities in each country.**

**Additionally, the following information should be accessible to the organisation:**

> **The population of the world.**

> **The population of a continent.**

> **The population of a region.**

> **The population of a country.**

> **The population of a district.**

> **The population of a city.**

# Languages Report

> **Finally, the organisation has asked if it is possible to provide the number of people who speak the following the following languages from greatest number to smallest, including the percentage of the world population:**

> **Chinese.**

> **English.**

> **Hindi.**

> **Spanish.**

> **Arabic.**

# Country Report

**A country report requires the following columns:**

> **Code.**

> **Name.**

> **Continent.**

> **Region.**

> **Population.**

> **Capital.**

# City Report

**A city report requires the following columns:**

> **Name.**

> **Country.**

> **District.**

> **Population.**

# Capital City Report

**A capital city report requires the following columns:**

> **Name.**

> **Country.**

> **Population.**

# Population Report

**For the population reports, the following information is requested:**

> **The name of the continent/region/country.**

> **The total population of the continent/region/country.**

> **The total population of the continent/region/country living in cities (including a %).**

> **The total population of the continent/region/country not living in cities (including a %).**

# Software Project Documentation

## Connect to Database Method

> public void connect(String location)

### Description of Function
> Connects to the MySQL Database.

<img width="962" alt="ConnectDB Image" src="https://user-images.githubusercontent.com/29733613/78162520-e4953700-743e-11ea-88f1-a35e203ee303.png">

### Parameters
> String location: This identifies the location of where to connect to.

### Disconnect Method

> public void disconnect()

### Description of Function
> Disconnects from the database when no longer in use to prevent errors.

### Method Implementation Screenshot
<img width="469" alt="DisconnectMethod" src="https://user-images.githubusercontent.com/29733613/78162978-93397780-743f-11ea-9ff0-5e86f910fbef.png">

### Parameters
> This method takes no parameters because its only function is to disconnect from the running process.

# Get Countries By Population #

### Description of Function ###

> This function is responsible for retrieving all the countries from the countries table of the database and orders it by population in descending order.

### Get Countries By Population Method Implementation ###

> public ArrayList<Country> getAllCountriesOrderByPopulation(String ID);
  
### Method Parameters

> String ID: The unique ID of the country that is specified by the user in order to retrieve the country with that ID.

### Method Implementation Screenshot

### SQL Query 
<img width="944" alt="Requirement 1 - Get Countries by Population" src="https://user-images.githubusercontent.com/29733613/78450957-442b5680-767a-11ea-82c4-42d1a6672dc9.png">

### SQL Query Results
<img width="1153" alt="Requirement 1 - Data Results" src="https://user-images.githubusercontent.com/29733613/78451033-c61b7f80-767a-11ea-9ba9-1748bb8e2e5c.png">

# Get Countries In A Continent By Largest Population

### Description of Function ###

> This function is responsible for executing an SQL query that returns the countries in a continent specified by our team in order to get the countries by largest population in that continent for the report.

### Get Countries In A Continent By Largest Population Method Implementation

> private ArrayList<Country> getCountriesInContinentByLargestPopulation(Continent continent); Continent is an enum
  
### Method Parameters

> **Continent continent** -> This is a continent enum that stores a menu of continents

### Method Implementation Screenshot

### SQL Query

<img width="980" alt="Requirement - 2 Query" src="https://user-images.githubusercontent.com/29733613/78451525-00d2e700-767e-11ea-83e7-c8b6ee5fe2cf.png">

### SQL Query Results

<img width="1121" alt="Requirement 2 - Data Results" src="https://user-images.githubusercontent.com/29733613/78451526-016b7d80-767e-11ea-82f4-cba12826d521.png">

# Get Countries In A Region By Largest Population

### Description of Function ###

> This function is responsible for executing an SQL query that selects all the data from the country table where the region is specified by the user and it orders the population in descending order

# Method Implementation

> private ArrayList<Country> getCountriesInRegionByLargestPopulation(String region);
  
# Method Parameters
  
  > String region: The region that will be specified by the user.
  
# Method Implementation Screenshot

<img width="957" alt="Requirement 3 - Get Countries in a Region " src="https://user-images.githubusercontent.com/29733613/78461544-f5a1aa80-76c1-11ea-8533-4d095c94217e.png">

# SQL Query Results

<img width="1186" alt="Requirement 3 Data Set" src="https://user-images.githubusercontent.com/29733613/78461545-f76b6e00-76c1-11ea-8c7c-4f24981e3a5d.png">
