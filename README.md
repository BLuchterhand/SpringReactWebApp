# SpringReactWebApp

This is a simple WebApp that employs Java Spring and React (Javascript) to enable a user to upload a document containing IMDB data to a queriable table.
Please see the video located in the root directory "demo.mov" for a brief overview of the project and some missed goals/inefficiencies. Otherwise, here's a 
breif writeup of some inefficiencies (it doesn't want to embed...)

# Requirements/Built With
Java version 11.0.11
npm version 8.1.4

# Functioning
Run "SpringbootBackendApplication" in the Java code, and npm start within "src\main\ui\react-frontend".

Browse to "localhost:3000":

![entry](/readme_resources/Screenshot_1.png)


Upload a file (use "data_new.tsv" from the root directory!):

![upload a file](/readme_resources/Screenshot_2.png)

![upload a file](/readme_resources/Screenshot_3.png)

![upload a file](/readme_resources/Screenshot_4.png)


Enter a query (supports *some* 2-parameter queries, more info in video and below!):

![upload a file](/readme_resources/Screenshot_5.png)

![upload a file](/readme_resources/Screenshot_6.png)


# Future Work/Inefficiencies
1. Cannot, in production, handle 1 million records. While this is possible it simply takes too long to load. This could likely be remedied withan database, but I 
chose to avoid one to make this as easy to run as possible for you. No extra systems to install. Additionally, I have yet to spend the time to research other options.

2. Routing/Mapping is messy and likely inefficient. Currently, I am coding in a function for each permutation of each possible query column. This requires a large if/else 
statement to drive. I believe this to simply be an inefficient and inexperienced way to go about this. Given that I've only worked with Spring for a handful of days, I'm 
sure there's a better solution out there. For now, it enables *some* basic double querying, however all single queries work just fine. I provide an example of this in the video.

Files Referenced: 
src/main/java/com/benlu/demo/controller/UserController.java
src/main/java/com/benlu/demo/repository/UserRepository.java
