# Car Rental Project

## About the Project

This project is a comprehensive car rental system that I developed using Java and Swing technologies. The project is designed to manage daily operations of car rental businesses and provides powerful backend functionality with a user-friendly interface.

## Technologies Used

### Swing Technology

Java Swing library was chosen for the user interface in this project. Swing is an ideal choice for developing desktop applications and provides all necessary components for creating user-friendly interfaces. The project uses buttons, text fields, tables, menus, and various other interface elements.

## Project Architecture

The project was developed using layered architecture principles and consists of five main modules:

### • Entity Module

Contains classes representing database tables:

- **User**: User authentication and role management (id, username, password, role)
- **Brand**: Car brand information
- **Model**: Car model information linked to brands
- **Car**: Vehicle details (model_id, color, km, plate) and Model/Brand relationships
- **Book**: Reservation information with customer details, dates, and pricing

### • DAO (Data Access Object) Module

Classes managing database access operations:

- **UserDao**: User authentication and management
- **BrandDao**: Brand CRUD operations
- **ModelDao**: Model CRUD operations
- **CarDao**: Vehicle CRUD operations
- **BookDao**: Reservation CRUD operations

### • Business Module

Classes managing business logic:

- **UserManager**: User authentication and authorization
- **BrandManager**: Brand business operations
- **ModelManager**: Model business operations
- **CarManager**: Vehicle business operations
- **BookManager**: Reservation business operations

### • View Module

User interface components:

- **LoginView**: User login screen
- **AdminView**: Administrative panel for system management
- **BrandView**: Brand management interface
- **ModelView**: Model management interface
- **CarView**: Vehicle management interface
- **BookingView**: Reservation management interface
- **Layout**: Common layout components

### • Core Module

Essential utility classes:

- **Db**: Database connection and configuration
- **Helper**: Utility methods and common functions
- **ComboItem**: ComboBox item wrapper for UI components

## Project Features

The car rental system I developed includes the following core features:

1. **User Authentication**: Login system with role-based access control
2. **Brand Management**: Add, edit, delete car brands
3. **Model Management**: Manage car models linked to brands
4. **Vehicle Registration System**: Registration of all company vehicles in the system
5. **License Plate Information**: Maintenance of license plate information for each vehicle
6. **Vehicle Listing**: Listing of suitable and available vehicles according to specific criteria
7. **Reservation System**: Complete reservation system with customer information, date selection, and pricing

Users can check vehicle availability for specific date ranges, search based on criteria such as "Renault Clio" or "Volkswagen Polo", and make reservations from suitable vehicles.

## Project Goals

This project aims to enable car rental businesses to:

- Track vehicles
- View availability status
- Manage the business through a comprehensive administrative interface

## Technical Requirements

- **JDK Version**: Minimum JDK 8
- **Database**: MySQL/PostgreSQL support
- **UI Framework**: Java Swing
- **Architecture**: Layered architecture with Entity-DAO-Business-View pattern

## Installation and Setup

1. Ensure JDK 8 or higher version is installed
2. Configure your database connection in the `core.Db` class
3. Run the application from `App.java`
4. Access the system using the login interface
