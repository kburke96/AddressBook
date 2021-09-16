# AddressBook

An Address Book application which stores Person and Address objects in an in-memory database. Worked on over the course of about 4 hours.

## Features

* Java 11
* Spring Boot 2.5.4 with the following dependencies:
    * HyperSQL - for in-memory data storage
    * Spring Data JPA - for database access and persistence
* Maven

# Pre-requisites
* Java 11

# Running the application

1. Clone the repository from GitHub
```bash
git clone https://github.com/kburke96/AddressBook.git
```
2. Run the application using the Maven wrapper
```bash
./mvnw spring-boot:run
```

# Using the application
When the application loads, the user is presented with a menu interface. 
Input an integer between 1 and 9 to select an option.

```bash
-- Address Book Main Menu --
Please select an option:
1 - Add a person
2 - Edit a person
3 - Delete a person
4 - Add an address to a person
5 - Edit an address
6 - Delete an address
7 - List Persons
8 - Count Persons
9 - Exit

```

# Bugs

This application was developed over about 4 hours so some bugs exist.

These include:
* The delete address option (6) does not work. This is due to the Address and Person objects being tightly coupled with a One to One mapping. When option 6 is selected, a message is displayed to gracefully let the user know that this option is not yet supported.


# Future Enhancements
* Add a set of unit tests to ensure business logic functions correctly.
* Add a Many-to-One relationship between Address and Person, as per the requirements.
* The current architecture of the project lends itself to being easily enhanced in future. For example:
    * A persistent data storage option, such as PostgresQL or MongoDB, could be added in place of HSQL. Because JPA is used, the code that is accessing the database would not need to be changed. 
    * A Controller layer could be added to turn this application into a web service (REST or RPC). Communicating via HTTP and JSON would allow multiple remote clients to access and update the data stored. 
