# NoteTakingApp

## Besart Kaiku & Sergey Arustamyan

## Download the APK
[Download APK](https://github.com/cc231005/NoteTakingApp/blob/main/app/release/app-release.apk)

## Initial app concept content
![Problem](https://github.com/user-attachments/assets/aa0880d3-b0ff-4b5e-91ec-0780ebdfd70e)
![Solution](https://github.com/user-attachments/assets/b53f0c70-efe7-4842-bdac-e73631f94f81)
![Description](https://github.com/user-attachments/assets/65f4c358-627e-4c12-b4bc-90948968cbe9)
![Use Case](https://github.com/user-attachments/assets/159a7423-8f2d-4bdd-b181-e058634b5316)
![Target User](https://github.com/user-attachments/assets/984a7de2-58f1-4ef5-a6c0-4d34264ecccf)
![Mockups with a user flow](https://github.com/user-attachments/assets/1223daf8-333a-4abc-a402-03d12b3f493d)


## Initial database design
Initially we had a plan to create a database with the following design(We created the database design with the help of tutor):

![Database design](https://github.com/user-attachments/assets/1ede420c-272f-416c-a247-db33d9875b5b)


# Comment from team members

## Sergey Arustamyan
In the beginning together with Besart we've planned the initial concept of the expense splitting app and I've sketched out mockups with user flow for it. Then since I wasn't so good at Android Coding in the beginning of CCL3 I was doing the android course and also preparing the usability test plan. While I was creating the usability test plan it was Besart who was working on code and he was mainly working on UI. Then after Besart started to work with databases issues with gradle started to appear which I tried to resolve together with tutor. We managed to reslove the issues with gradle but there were still issues left related to libraries that were related to database. Since it was last day we could get a help of tutors and there was a chance that we're not going to manage to create the app we've planned before on our own until the deadline we've finally decided to create a note taking app instead which was much simpler to do. Since I've had experience of creating similar apps for the assignments of Mobile Coding class I've managed to create a note taking app until presentation and used apps that I've created before as a reference which helped me to do it so quickly. The note taking app has basic CRUD functionality and as extra features it has a capability to attach images to the notes and also a capability to search notes.

## Besart Kaiku
As every CCL there is a bit of stress if wether the plan is going to go like we initiated it. In the beginning everything went smooth, however things started to go south close to the end of the CCL. Both me and Sergey weren't that experienced with kotlin and android development so we thought that we could go slowly and make the app presistent. In my opinion the first idea was quite nice. The ERD model was also done, but we couldn't come to put this idea into work. Due to the lack of experience we ran into some issues with the code and the project up to that point was all burnt to the ground. I will take this CCL as an oppurtunity to grow and make better decisions in the future. 

### Screenshots of final note taking app
![photo_2025-01-24_03-58-18](https://github.com/user-attachments/assets/36141df7-d26a-4d25-8243-4041f7122015)
![photo_2025-01-24_03-58-15](https://github.com/user-attachments/assets/bc904b61-62e8-4f70-a845-fde614a1683d)
![photo_2025-01-24_03-58-20](https://github.com/user-attachments/assets/d7d48dab-eaf5-444a-9e06-7291678bb5c4)



# Usability Test

## Initial Usability Test Plan

### Usability Test Design

#### Target User:
The target audience includes young adults (20–40 years old) such as:
-	Frequent travelers who need to split travel costs.
-	Event organizers managing group expenses.
-	Families and roommates sharing household costs.

#### Goals with the System:
Users aim to:
1.	Create and manage trips/events to organize shared expenses.
2.	Add and track expenses with detailed records (e.g., who paid, amounts, date).
3.	Understand their balances and settle debts with minimal transactions.
4.	Keep the process simple, fast, and accurate.

#### Experimental Questions:
1.	How efficiently can users create trips, add participants, and set up expense-sharing events?
2.	Are users able to add and modify expenses without confusion or errors?
3.	Can users understand and use the "transactions" feature to settle debts effectively?
4.	How satisfied are users with the app interface, particularly its usability and clarity?
   
#### Variables:
-	Independent Variables: User familiarity with finance/expense-sharing apps.
-	Dependent Variables:
    - Time to complete key tasks (e.g., adding an expense, marking  transactions as settled).
    - User satisfaction scores (via post-task questionnaires).


#### Methods for Data Collection
1. Task Performance Metrics: Collect time on task
2. Post-Task Questionnaire: Use a Likert scale to assess user satisfaction after completing each task.
3. Interviews: Conduct follow-up interviews to gain qualitative insights into the users’ experiences and preferences.

#### Description of How the Data Will Be Used to Answer the Questions
The collected data will be analyzed as follows:
- Quantitative Analysis: Task performance metrics will be analyzed to determine the time, efficiency. 
- Qualitative Analysis: Responses from the post-task questionnaire and interviews will provide insights into user satisfaction and any issues they encountered. The qualitative feedback will help interpret the quantitative results and highlight areas for improvement.


### Test Protocol

In the beginning we ask from the participants their permission to record their screens while doing the tasks. After they agree we tell them the tasks that they’re going to do. At the end when they finish all their tasks we ask them to answer the interview questions and to fill in SUS questionnaire.


## Changed Usability Test Plan

### Usability Test Design

#### Target User:
The target audience includes individuals aged 20–30, such as:
- Students needing to manage class notes.
- Professionals organizing to-do lists and work-related information.
- General users who prefer simple note-taking.

#### Goals with the System:
Users aim to:
1.	Create, update, and delete notes with ease.
2.	Attach relevant images to notes.
3.	Search for notes quickly and accurately.
4.	Enjoy an intuitive and fast interface for basic CRUD operations.


#### Experimental Questions:
1.	Are users able to efficiently create and update notes?
2.	Are users able to attach images and search for notes without confusion?
3.	Can users delete notes without errors?
4.	How satisfied are users with the app interface, particularly its usability and clarity?

   
#### Variables:
- Independent Variables: Age.
- Dependent Variables:
    - Time to complete key tasks (e.g., creating a note, attaching an image, searching).
    - User satisfaction scores (via post-task questionnaires).
 

#### Methods for Data Collection
1.	Task Performance Metrics: Measure time taken to complete key tasks.
2.	Post-Task Questionnaire: Use a Likert scale to assess user satisfaction after completing tasks.
3.	Interviews: Conduct follow-up interviews to gain qualitative insights into users’ experiences and preferences.


#### Description of How the Data Will Be Used
- Quantitative Analysis: Task performance metrics will help evaluate the efficiency of key tasks.
- Qualitative Analysis: Post-task questionnaire responses and interviews will provide insights into user satisfaction, highlighting areas for improvement.


### Test Protocol
1.	Participants will be asked for permission to record their screens.
2.	Participants will be guided through the following tasks:
    1.	Create a new note with Title - “Grocery” and Content - “Apples”.
    2.	Edit an existing note by changing/adding an image.
    3.	Search the query “device” in the search bar.
3.	After completing the tasks, participants will fill out a SUS questionnaire and answer interview questions.


# Usability Test Results

## Sample Makeup
We collected our users for the study from among fellow students. Overall 5 people participated in the usability test.

Age
- Mean: 22.2
- Min: 20  Max: 25
- Standard Deviation: 1.92

![Boxplot of Participant Age](https://github.com/user-attachments/assets/fc504399-d255-456b-905f-90b2baf8d57d)


## Task Completion Time (TCT)

Statistics for Task 1 CT :
- Min: 15 
- Max: 30 
- Mean: 21.8 
- Standard Deviation: 6.06

Statistics for Task2 CT :
- Min: 11 
- Max: 23 
- Mean: 14.2 
- Standard Deviation: 4.97 

Statistics for Task3 CT :
- Min: 7 
- Max: 20 
- Mean: 11 
- Standard Deviation: 5.2


![Boxplots of Task Completion Times](https://github.com/user-attachments/assets/3d75ecad-6ef0-4eaa-a264-f83822f1aa1c)




## System Usability Scale (SUS)

SUS Statistics:
- Min: 77.5
- Max: 90
- Mean: 85.14
- Standard Deviation: 5.72


![Boxplot of SUS Scores](https://github.com/user-attachments/assets/67e947c0-f79e-4185-b108-5fa4eb9022d1)


## SUS Scores by Age
![Scatterplot of SUS Scores by Age](https://github.com/user-attachments/assets/8ebf9746-2c89-4802-8bd2-441da55e75b2)


## TCT by Age
![Scatterplot of Task Completion Time by Age](https://github.com/user-attachments/assets/891764ce-d1f7-4a46-a633-a22412d63071)


## Feedback from participants
- Very straightforward and easy to understand. Has one simple purpose.
- Very simple and easy
- Due to its simplicity, I had no difficulties with navigation.

## We made updates because of the following feedback
- Question: Were there any moments where you felt frustrated or stuck while using the platform?
- Answer: The lack of FocusManager. When I type something, I expect the keyboard to go away when I tap somewhere else on the screen.

This feedback was very helpful because it allowed us to add so basic functionality that we forgot to add on our own but thanks to the feedback we fixed that usability issue.

[Download Old Version Where There Is No FocusManager](https://github.com/cc231005/NoteTakingApp/blob/main/app/old_release/app-release.apk)

You can download the updated version of the app with FocusManager at the top of this documentation.

## Conclusion
Usability tests showed that app is straightforward and intuitive which leads to tasks being completed very quickly. Users can navigate in the app easilty because for most people it's already familiar app and they know the placement and functionalities that that kind of apps are capable of. Quick task completion corellates with above mentioned experimental question - Are users able to efficiently create and update notes?
