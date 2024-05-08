# MyDentist
This is a dental clinic Management System to organize and facilitate daily office work in dental clinics, built in the form of a GUI desktop application developed in **Java** using **Sqlite** as its database. The GUI was designed using **Swing** and the database connectivity was managed using **JDBC API**.

This application can be used by small dental clinics to easily manage a clinic of all their,

* Supervisors 
*	Receptionists 
*	Patients 
*	Doctors

## Features of the Application
-	This application Supports two user types:
  
1.	Supervisors
2.	Receptionists

**Supervisors can:**

*	Manage receptionists (Add receptionist, Update receptionist, Delete receptionist, Search receptionists record).
*	Manage doctors (Add doctor, Update doctor, Delete doctor, Search doctors record).
*	Manage supervisors (Add supervisor, Update supervisor, Delete supervisor, Search supervisors record).
*	Search patients record.
*	Search appointments record.
*	Search invoices record.
*	Search Revenues.

**Receptionists can:**
*	Manage patients data (Add patient data, Update patient data, Delete patient data, Search patients record).
*	Manage appointments (Booking an appointment, Update appointments, Delete appointments, Search appointments record).
*	Search invoices record.

***Note:***

*1. When an appointment booked, automatically an invoice generated for this appointment with all data.*

*2. When an appointment updated, automatically the invoice for this appointment will be updated.*

*3. When an appointment deleted, automatically the invoice for this appointment will be deleted.*

## Application Preview
### **Login Page**

Here the users enter their username and password and select user type "Supervisor or Receptionist", Then the login page takes in the credentials entered by the user and verifies with the database.

![Login Page](/Screenshots/LoginPage.png)


### **Supervisors Dashboard - Home Page**

This page will show up after a successful login when users select "Supervisor" as user type, It will show supervisor info "Name, Last Name, Username, User Type".

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Homepage.png)


### **Supervisors Dashboard – Patients Page**

In this page you will see patients record and you can search specific patient by entering patient ID.

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Patients%20Page.png)


### **Supervisors Dashboard – Appointments Page**

In this page you can choose how you want to search an appointment.

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Appointments%20Page.png)


### **Supervisors Dashboard – Appointments Page – Search by doctor name Page**

In this page you can search an appointment by doctor name and "Date or Time or Both".

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Appointments%20Page%20-%20Search%20By%20Doctor%20Name.png)


### **Supervisors Dashboard – Appointments Page – Search by appointment ID Page**

In this page you can search an appointment by appointment ID, and you can see all cancelled/current appointments.

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Appointments%20Page%20-%20Search%20By%20Appointment%20ID.png)


### **Supervisors Dashboard – Appointments Page – Search by date and service Page**

In this page you can see all appointments for selected date/service, you can search appointment for specific date and service, and also you can search appointment for specific date and time.

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Appointments%20Page%20-%20Search%20By%20Date%20And%20Service.png)


### **Supervisors Dashboard – Appointments Page – Search by patient ID Page**

In this page you can see all appointments for selected patient "Patient ID", you can search appointment for specific patient "Patient ID" and date, you can search appointment for specific patient "Patient ID" and doctor name, and also you can search appointment for specific patient "Patient ID" and date and doctor name.

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Appointments%20Page%20-%20Search%20By%20Patient%20ID.png)


### **Supervisors Dashboard – Appointments Page – Search by receptionist name Page**

In this page you can see all appointments added/updated/cancelled by selected receptionist name.

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Appointments%20Page%20-%20Search%20By%20Receptionist%20Name.png)


### **Supervisors Dashboard – Invoices Page**

In this page you can choose how you want to search an invoice.

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Invoices%20Page.png)


### **Supervisors Dashboard – Invoices Page – Search by doctor name Page**

In this page you can search an invoice by doctor name and "Date or Time or Both".

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Invoices%20Page%20-%20Search%20By%20Doctor%20Name.png)


### **Supervisors Dashboard – Invoices Page – Search by invoice ID Page**

In this page you can search an invoice by invoice ID, and you can see all cancelled/current invoices.

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Invoices%20Page%20-%20Search%20By%20Invoice%20ID.png)


### **Supervisors Dashboard – Invoices Page – Search by date and service Page**

In this page you can see all invoices for selected date/service, you can search invoice for specific date and service, and also you can search invoice for specific date and time.

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Invoices%20Page%20-%20Search%20By%20Date%20And%20Service.png)


### **Supervisors Dashboard – Invoices Page – Search by patient ID Page**

In this page you can see all invoices for selected patient "Patient ID", you can search invoice for specific patient "Patient ID" and date, you can search invoice for specific patient "Patient ID" and doctor name, and also you can search invoice for specific patient "Patient ID" and date and doctor name.

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Invoices%20Page%20-%20Search%20By%20Patient%20ID.png)


### **Supervisors Dashboard – Invoices Page – Search by receptionist name Page**

In this page you can see all invoices added/updated/cancelled by selected receptionist name.

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Invoices%20Page%20-%20Search%20By%20Receptionist%20Name.png)


### **Supervisors Dashboard – Revenues Page**

In this page you can choose if you want to search revenues or search revenues for specific date.

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Revenues%20Page.png)


### **Supervisors Dashboard – Revenues Page – Day revenues Page**

In this page you can search revenues for specific date.

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Revenues%20Page%20-%20Day%20Revenues%20Page.png)


### **Supervisors Dashboard – Revenues Page – Search revenues Page**

Work in progress.

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Revenues%20Page%20-%20Search%20Revenues%20Page.png)


### **Supervisors Dashboard – Staff Page**

In this page you can choose to enter supervisors main page to modify data for specific supervisor, or to enter receptionists main page to modify data for specific receptionist, or to enter doctors main page to modify data for specific doctor.

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Staff%20Page.png)


### **Supervisors Dashboard – Staff Page – Supervisors main Page**

In this page you can choose to add/update/delete a supervisor, or to see supervisors record.

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Staff%20Page%20-%20Supervisors%20Main%20Page.png)


### **Supervisors Dashboard – Staff Page – Supervisors main Page – Add supervisor Page**

In this page you can add new supervisor. 

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Staff%20Page%20-%20Supervisors%20Main%20Page%20-%20Add%20Supervisor%20Page.png)


### **Supervisors Dashboard – Staff Page – Supervisors main Page – Update supervisor Page**

In this page you can update data for a specific supervisor.

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Staff%20Page%20-%20Supervisors%20Main%20Page%20-%20Update%20Supervisor%20Page.png)


### **Supervisors Dashboard – Staff Page – Supervisors main Page – Delete supervisor Page**

In this page you can delete a specific supervisor.

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Staff%20Page%20-%20Supervisors%20Main%20Page%20-%20Delete%20Supervisor%20Page.png)


### **Supervisors Dashboard – Staff Page – Supervisors main Page – Supervisors record Page**

In this page you can see all supervisors, you can search for a specific supervisor by supervisor ID, and you can see supervisors added/updated by selected supervisor name. 

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Staff%20Page%20-%20Supervisors%20Main%20Page%20-%20Supervisors%20Record%20Page.png)


### **Supervisors Dashboard – Staff Page – Receptionists main Page**

In this page you can choose to add/update/delete a receptionist, or to see receptionists record.

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Staff%20Page%20-%20Receptionists%20Main%20Page.png)


### **Supervisors Dashboard – Staff Page – Receptionists main Page – Add receptionist Page**

In this page you can add new receptionist. 

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Staff%20Page%20-%20Receptionists%20Main%20Page%20-%20Add%20Receptionist%20Page.png)


### **Supervisors Dashboard – Staff Page – Receptionists main Page – Update receptionist Page**

In this page you can update data for a specific receptionist.

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Staff%20Page%20-%20Receptionists%20Main%20Page%20-%20Update%20Receptionist%20Page.png)


### **Supervisors Dashboard – Staff Page – Receptionists main Page – Delete receptionist Page**

In this page you can delete a specific receptionist.

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Staff%20Page%20-%20Receptionists%20Main%20Page%20-%20Delete%20Receptionist%20Page.png)


### **Supervisors Dashboard – Staff Page – Receptionists main Page – Receptionists record Page**

In this page you can see all receptionists, you can search for a specific receptionist by receptionist ID, and you can see receptionists added/updated by selected supervisor name. 

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Staff%20Page%20-%20Receptionists%20Main%20Page%20-%20Receptionists%20Record%20Page..png)


### **Supervisors Dashboard – Staff Page – Doctors main Page**

In this page you can choose to add/update/delete a doctor, or to see doctors record.

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Staff%20Page%20-%20Doctors%20Main%20Page.png)


### **Supervisors Dashboard – Staff Page – Doctors main Page – Add doctor Page**

In this page you can add new doctor. 

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Staff%20Page%20-%20Doctors%20Main%20Page%20-%20Add%20Doctor%20Page.png)


### **Supervisors Dashboard – Staff Page – Doctors main Page – Update doctor Page**

In this page you can update data for a specific doctor.

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Staff%20Page%20-%20Doctors%20Main%20Page%20-%20Update%20Doctor%20Page.png)


### **Supervisors Dashboard – Staff Page – Doctors main Page – Delete doctor Page**

In this page you can delete a specific doctor.

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Staff%20Page%20-%20Doctors%20Main%20Page%20-%20Delete%20Doctor%20Page.png)


### **Supervisors Dashboard – Staff Page – Doctors main Page – Doctors record Page**

In this page you can see all doctors, you can search for a specific doctor by doctor ID, and you can see doctors added/updated by selected supervisor name. 

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Staff%20Page%20-%20Doctors%20Main%20Page%20-%20Doctors%20Record%20Page.png)


### **Supervisors Dashboard – Developer Page**

In this page you can see developer picture and info (Name, EMail, Phone NO, Facebook, and Twitter).

![Supervisors Dashboard](/Screenshots/Supervisors%20Dashboard%20-%20Developer%20Page.png)


### **Receptionists Dashboard - Home Page**

This page will show up after a successful login when users select "Receptionist" as user type, It will show receptionist info "Name, Last Name, Username, User Type".

![Supervisors Dashboard](/Screenshots/Receptionists%20Dashboard%20-%20Homepage.png)


### **Receptionists Dashboard – Patients Page**

In this page you can choose to add/update/delete patient, or to see patients record.

![Supervisors Dashboard](/Screenshots/Receptionists%20Dashboard%20-%20Patients%20Page.png)


### **Receptionists Dashboard – Patients Page – Add patient Page**

In this page you can add new patient.

![Supervisors Dashboard](/Screenshots/Receptionists%20Dashboard%20-%20Patients%20Page%20-%20Add%20Patient%20Page.png)


### **Receptionists Dashboard – Patients Page – Update patient Page**

In this page you can update data for a specific patient.

![Supervisors Dashboard](/Screenshots/Receptionists%20Dashboard%20-%20Patients%20Page%20-%20Update%20Patient%20Page.png)


### **Receptionists Dashboard – Patients Page – Delete patient Page**

In this page you can delete a specific patient.

![Supervisors Dashboard](/Screenshots/Receptionists%20Dashboard%20-%20Patients%20Page%20-%20Delete%20Patient%20Page.png)


### **Receptionists Dashboard – Patients Page – Patients record Page**

In this page you will see patients record and you can search specific patient by entering patient ID.

![Supervisors Dashboard](/Screenshots/Receptionists%20Dashboard%20-%20Patients%20Page%20-%20Patients%20Record%20Page.png)


### **Receptionists Dashboard – Appointments Page**

In this page you can choose to add “Book”/update/delete appointment, or to see appointments record.

![Supervisors Dashboard](/Screenshots/Receptionists%20Dashboard%20-%20Appointments%20Page.png)


### **Receptionists Dashboard – Appointments Page – Add appointment Page**

In this page you can add new appointment.

![Supervisors Dashboard](/Screenshots/Receptionists%20Dashboard%20-%20Appointments%20Page%20-%20Add%20Appointment%20Page.png)


### **Receptionists Dashboard – Appointments Page – Update appointment Page**

In this page you can update data for a specific appointment.

![Supervisors Dashboard](/Screenshots/Receptionists%20Dashboard%20-%20Appointments%20Page%20-%20Update%20Appointment%20Page.png)


### **Receptionists Dashboard – Appointments Page – Cancel appointment Page**

In this page you can cancel a specific appointment.

![Supervisors Dashboard](/Screenshots/Receptionists%20Dashboard%20-%20Appointments%20Page%20-%20Cancel%20Appointment%20Page.png)


### **Receptionists Dashboard – Appointments Page – Appointments record Page**

In this page you can choose how you want to search an appointment.

![Supervisors Dashboard](/Screenshots/Receptionists%20Dashboard%20-%20Appointments%20Page%20-%20Appointments%20Record%20Page.png)


### **Receptionists Dashboard – Appointments Page – Appointments record Page – Search by doctor name Page**

In this page you can search an appointment by doctor name and "Date or Time or Both".

![Supervisors Dashboard](/Screenshots/Receptionists%20Dashboard%20-%20Appointments%20Page%20-%20Appointments%20Record%20Page%20-%20Search%20By%20Doctor%20Name%20Page.png)


### **Receptionists Dashboard – Appointments Page – Appointments record Page – Search by appointment ID Page**

In this page you can search an appointment by appointment ID, and you can see all cancelled/current appointments.

![Supervisors Dashboard](/Screenshots/Receptionists%20Dashboard%20-%20Appointments%20Page%20-%20Appointments%20Record%20Page%20-%20Search%20By%20Appointment%20ID%20Page..png)


### **Receptionists Dashboard – Appointments Page – Appointments record Page – Search by date and service Page**

In this page you can see all appointments for selected date/service, you can search appointment for specific date and service, and also you can search appointment for specific date and time.

![Supervisors Dashboard](/Screenshots/Receptionists%20Dashboard%20-%20Appointments%20Page%20-%20Appointments%20Record%20Page%20-%20Search%20By%20Date%20And%20Service%20Page.png)


### **Receptionists Dashboard – Appointments Page – Appointments record Page – Search by patient ID Page**

In this page you can see all appointments for selected patient "Patient ID", you can search appointment for specific patient "Patient ID" and date, you can search appointment for specific patient "Patient ID" and doctor name, and also you can search appointment for specific patient "Patient ID" and date and doctor name.

![Supervisors Dashboard](/Screenshots/Receptionists%20Dashboard%20-%20Appointments%20Page%20-%20Appointments%20Record%20Page%20-%20Search%20By%20Patient%20ID%20Page.png)


### **Receptionists Dashboard – Invoices Page**

In this page you can choose how you want to search an invoice.

![Supervisors Dashboard](/Screenshots/Receptionists%20Dashboard%20-%20Invoices%20Page.png)


### **Receptionists Dashboard – Invoices Page – Search by doctor name Page**

In this page you can search an invoice by doctor name and "Date or Time or Both".

![Supervisors Dashboard](/Screenshots/Receptionists%20Dashboard%20-%20Invoices%20Page%20-%20Search%20By%20Doctor%20Name%20Page.png)


### **Receptionists Dashboard – Invoices Page – Search by invoice ID Page**

In this page you can search an invoice by invoice ID, and you can see all cancelled/current invoices.

![Supervisors Dashboard](/Screenshots/Receptionists%20Dashboard%20-%20Invoices%20Page%20-%20Search%20By%20Invoice%20ID%20Page.png)


### **Receptionists Dashboard – Invoices Page – Search by date and service Page**

In this page you can see all invoices for selected date/service, you can search invoice for specific date and service, and also you can search invoice for specific date and time.

![Supervisors Dashboard](/Screenshots/Receptionists%20Dashboard%20-%20Invoices%20Page%20-%20Search%20By%20Date%20And%20Service%20Page.png)


### **Receptionists Dashboard – Invoices Page – Search by patient ID Page**

In this page you can see all invoices for selected patient "Patient ID", you can search invoice for specific patient "Patient ID" and date, you can search invoice for specific patient "Patient ID" and doctor name, and also you can search invoice for specific patient "Patient ID" and date and doctor name.

![Supervisors Dashboard](/Screenshots/Receptionists%20Dashboard%20-%20Invoices%20Page%20-%20Search%20By%20Patient%20ID%20Page.png)


### **Receptionists Dashboard – Developer Page**

In this page you can see developer picture and info (Name, EMail, Phone NO, Facebook, and Twitter).

![Supervisors Dashboard](/Screenshots/Receptionists%20Dashboard%20-%20Developer%20Page.png)


## Technologies Used

The following are the technologies that have been used in the development of this project.

*	JDK 8
*	Sqlite 3 (for database)
*	Java Swing (for the GUI designer)
*	Eclipse IDE
*	SQLite Studio


## Source Code

The software code has been divided into four different packages:

*	Data Access Object (DAO): Contains the data access layer of the software that interacts directly with the database and its tables. Used for retrieval and modification of data.
*	Data Transfer Object (DTO): Contains the data transfer layer that allows the data to be transferred between the data access layer and the UI layer.
*	Database: Contains the ConnectionFactory class that retrieves the database connection and verifies user credentials for the application.
*	User Interface (UI): Contains all the GUI classes making up the interface layer of the software.
*	User Interface Icons (UI.Icons): Contains all icons used in this project.


## Work-in-Progress
This project is a work in progress and more features are yet to be added with new technologies.
