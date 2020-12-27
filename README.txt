OnlineTest.java contains the source code.

It takes information of questions from input.txt file in the given format.
first line contains question
second line to fifth line contains option for the question as it is a multiple choice question
now sixth line contains correct option in serial number of the option likw 1, 2,3 ,4.
we have asume or we can say it was given in question to make 10 question based mcq, so we have taken length of the array 
used in the source code as 10. File should contain atleast 10 question because our code is on the assumption that admin 
have already put some rubish questions in input.txt file, but yes he can change the question in the excuted version of code.


It takes information for registered student from details.txt whose format is:-
Username
Password
In the code we have given a functionality to add to register new student and store his details in details.txt for future login.

Slight description before excuting the code:-

1) unzip the folder.
2) open this folder in terminal or command prompt.
3) run the command javac OnlineTest.java
4) run the command java OnlineTest
5) we have used same interface for admin and student login.
6) we assume that before any student can login, Admin should verify the question,
   that's why we have disabled Login button until Admin login through Admin login
   and verify the question.
7) Admin can login with USERNAME:- ADMIN  and PASSWORD IIITA.
8) Now interface which contains the editable questions appears.Admin can modify if he want.
9) After admins verification student can register or login if he had already registered.
10) After any student login, an interface with questions,options,serial no.,
    timer,time,stopwatch appears,with an option of next and bookmark if he want.
11) if he answer the questions before time,he has to click Result button to get the marks out of 10.
12) if he did'nt answer all question and did not pressed result button before 3 hours,his answers will be saved and pane 
    with marks out of 10 is shown to him.

This source file has been developed in java 13.1 version thus it may not run in lesser version of jdk. So kindly install java 13.1 or higher 
for running this source code.

Thanking You
whole team

team-shubham soni ,Ashish patel


