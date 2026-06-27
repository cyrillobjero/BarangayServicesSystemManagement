 - What is our project? -

Our project is a **Barangay Services Management System**. It is a text-based (console) computer program designed to show how a real local barangay office can digitize and automate its daily paperwork and administrative tasks.

Because this is an advanced programming exam, the system doesn't connect to a real database server; instead, it safely holds all information temporarily in the computer's memory using Java Collections (like lists and tables) while the program is running.

#  What are the main things our program can do? #

The application is split into core engines and interactive business tasks:

1. 
**Resident Registration:** It acts like a digital logbook where you can type in and save a new resident's profile (Name, Age, Address).

2. 
**Document Dispatcher:** It allows residents to apply for official community documents like Barangay Certificates, Clearances, or Indigency papers.

3. 
**Payment Simulation:** It simulates a cashier counter where a user can pay for their requested documents using different methods like Cash or GCash.

4. 
**Lifecycle Tracking:** It tracks the progress of a document request from the moment it is submitted (**Pending**), to when it is signed (**Approved**), and finally when it is given to the resident (**Released**).

5. 
**Dashboard Reporting:** It provides a live summary screen that instantly counts how many residents are registered and logs every transaction chronologically so nothing gets lost.


#  How did we build it? (The Smart Programming Stuff) #

To get high marks on this exam, we designed the code to follow strict **Object-Oriented Programming (OOP)** rules:

**Encapsulation (Safety Rails):** We don't let anyone corrupt our data. For example, if a user tries to type a negative number for a payment or leaves a name completely blank, our program actively catches the error, blocks it, and explains what went wrong without crashing.

**Inheritance & Abstraction (Blueprints):** We created a master blueprint class called BarangayService. Then, specific document requests (like ClearanceRequest) simply inherit from that master blueprint so we don't have to rewrite code over and over again.

**Polymorphism (Flexibility):** We created a shared rules framework for payments. This means the system can automatically adjust its handling logic depending on whether a resident decides to clear their balance using physical Cash or a digital GCash account.

**Clean Layering (Packages):** To keep things organized, our code is split into three clean folders: **Models** (which holds raw data), **Services** (which does the heavy math and logic calculations), and **UI** (which controls the menus that the user interacts with).