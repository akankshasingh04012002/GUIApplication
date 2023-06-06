# User Registration Application

The User Registration Application is a Scala-based graphical user interface (GUI) application that allows users to register by providing their personal information. The application also integrates with a database to store and retrieve user registration data. This README file provides an overview of the application, its features, and instructions for setting it up and running it on your local machine.


## Prerequisites
Before running the application, ensure that you have the following prerequisites:

Scala SDK installed on your system

ScalaFX library added as a dependency in your project

IDE or Scala build tool (sbt) for running the application

Database integrated(e.g., MySQL, PostgreSQL, SQLite)

## Features

Registration Confirmation Page: Users are prompted with a registration confirmation page where they can choose whether to proceed with the registration process.

User Registration Form: Users can fill in their personal information, including first name, last name, email, and phone number, to complete the registration.

Database Integration: The application connects with a database to store and retrieve user registration data.

Success Page: Upon successful registration, users are presented with a success page displaying a confirmation message.

Error Handling: If any errors occur during the registration process, users are redirected to an error page with relevant error messages.

## Getting Started

To get started with the user registration application, follow these steps:

Clone the project repository to your local machine.

Create a database and configure the necessary database connection parameters. Update the database connection details in the application code.
Make sure that the required dependencies are configured properly.

Build the project to resolve dependencies if necessary.

Run the GuiApp object to start the application.

## Customization

The User Registration Application provides several customization options that you can modify according to your needs:

UI Styling: You can customize the appearance of UI components by modifying the CSS styles defined in the code. Update the font size, color, background color, etc., to match your desired design.

Database Integration: Depending on your preferred database, you may need to modify the database connection parameters and adapt the code to interact with your specific database system.

Error Handling: If you want to enhance the error handling logic, you can modify the error handling methods to handle specific error cases and provide more detailed error messages.

Feel free to explore the code and make any necessary modifications to customize the application according to your requirements.

## Conclusion
The User Registration Application is a user-friendly ScalaFX GUI application that allows users to register by providing their personal information. It integrates with a database for data storage and retrieval. With customization options and clear instructions, it provides a robust solution for managing user registrations.








