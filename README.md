# typing-speed-test
Website where you can check your typing skills: wpm (words per minute) and accuracy.

# In this Project I am using following tools and languages:
1. Java Spring Boot
2. MS SQL
3. HTML
4. CSS
5. React
6. Docker

# Website Features:
1. On this website users can test their typing skills on components like wpm (words per minute)
   and accuracy.
2. User can Sign In or Sign Up. If user is not signed in his/her test results nor Personal best 
   are not going to be saved.
3. While Signing Up user should create password with more than 8 characters, thus username and email
   which are not already in the system.
4. On this website user can choose three test categories: easy, medium and hard, as well as test
   duration: 15s, 30s, 60s and 120s.

# For launching the project you need to follow these steps:
1. If you have not downloaded node.js in your computer yet: visit page "https://nodejs.org/en/download" and download it for your environment;
2. Open up docker and leave it open for this project; 
3. Open intelliJ terminal and run following command from the root directory:
    1. ```compose up db -d```
    2. Then wait some time (maximum 5s) so that docker can start up
4. Open TypingSpeedTestApplication.java and press run button on current file;
5. After step 3 wait some time to make sure Backend is done doing setup tasks (maximum 5s);
    1. After step number 4 you should see new container running in your Docker;
6. Then open up InteliJ terminal, stand on Frontend folder and run the command:
    1. ```npm run dev```
7. If step number 5 does not work run these commands:
    1. ```npm install```
    2. ```npm run dev```
8. In terminal you are going to see website link. Click on that link and enjoy "Typing Speed Test" in your default browser;