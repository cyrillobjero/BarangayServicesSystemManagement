 - Barangay Services Management System - User Operation Guide - 

This ultimate guide provides a step-by-step walkthrough of how to interact with the system console interface, manage residents, submit requests, process payments, and generate system reports.

 System Startup & Automatic Setup
When you first execute the application via the main entry point (`com.barangay.ui.Main`), the system automatically runs an initialization script to set up a baseline simulation environment:
1. **Mock Data Generation:** The system automatically registers two sample residents: *John Lloyd* and *Lyniel Ranches*.
2. **Automated Submissions:** The system simulates a sample `Document Request` for a Barangay Clearance.
3. **Payment Clearances:** It executes test clearing simulations through Cash and GCash processing models.

Once the initialization prints finish, the interactive **Main Menu** console loop will appear.


- Step-by-Step Menu Operations -

 1. Main Menu Navigation
The root interface allows you to navigate into nested operational submenus by typing the corresponding number and pressing `Enter`:
* Type `1` for the **Resident Menu**
* Type `2` for the **Request Menu**
* Type `3` for the **Payment Menu**
* Type `4` for the **Report Menu**
* Type `0` to safely terminate the program loop.

 2. Managing Residents (Option 1)
From the Main Menu, type `1` to open the **Resident Menu**.

 A. Viewing Current Residents
* Type `2` to display a list of all currently registered residents. 
* The system will fetch records from the `ResidentRepository` and display details using custom overridden `toString()` text blocks.

 B. Registering a New Resident
* Type `1` to trigger the form processing engine.
* Follow the interactive terminal prompts step-by-step:
  1. Enter a unique **Resident ID** (e.g., `RES003`).
  2. Input the resident's **First Name** and **Last Name**.
  3. Enter the resident's **Age** (Must be a positive integer greater than zero).
  4. Type the resident's specific home **Address**.
* Upon successful input validation, the system will output `Resident added successfully.`


 3. Dispatching Document Requests (Option 2)
From the Main Menu, type `2` to open the **Request Menu**.

 A. Submitting a New Document/Clearance Request
* Type `1` to run the dispatcher engine.
* Select the desired document category:
  * `1` for standard **Document Requests** (e.g., Certificate of Residency).
  * `2` for formal **Clearance Requests**.
  * `3` for **Indigency Requests**.
* Provide the required administrative tags:
  * Enter a unique **Request ID** (e.g., `REQ101`).
  * Enter the corresponding **Resident ID** of the applicant (e.g., `RES001`).
  * Type a brief description or purpose for the record request.
* The system launches the tracking lifecycle, setting the request state initially to `PENDING`.

 B. Tracking an Existing Request Status
* Type `2` to run the tracking search utility.
* Input the exact **Request ID** you wish to check.
* The program will search the collection using functional stream predicates and output the current lifecycle state (`PENDING`, `APPROVED`, or `RELEASED`).


 4. Simulating Payment Collections (Option 3)
From the Main Menu, type `3` to navigate to the **Payment Menu**.

* Choose your transaction processing method:
  * Type `1` for **Cash Payment**.
  * Type `2` for **GCash Payment**.
  * Type `3` for **Card Payment**.
* Enter the structural validation inputs:
  * Input the target **Request ID** requiring settlement.
  * Input the numeric **Amount** to clear.
* The system utilizes specific interface clearing models to process the payment and updates the workflow status state machine.


 5. Accessing Live Summaries & Reports (Option 4)
From the Main Menu, type `4` to entry the **Report Menu**.

* Choose your console dashboard display mode:
  * Type `1` to print the **Transaction Report**. This displays a complete chronological list of transaction logs sorted logically by the engine.
  * Type `2` to print **Resident Reports**. This generates an aggregate overview of the registered community profiles currently handled within the temporary collections arrays.


 Input Safety Features & Error Trapping
The application features a robust stability framework designed to intercept improper values gracefully without unhandled crashes:
* **Data Format Safety:** If you accidentally input letters or non-numeric strings when prompted for numerical values (such as Age or Payment Amount), the system triggers custom parsing catch filters, rejects the action with a warning message, and preserves application stability.
* **Active Validation Logic:** Empty strings or negative monetary values are explicitly caught and rejected via active business logic constraints, preventing corrupted entries from entering the repository.