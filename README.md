# GUI-Based Desktop Application for To-Do List Management

## Project Overview
This project is a Java-based GUI desktop application designed for managing a personal to-do list. The application allows users to create, update, delete, and organize tasks efficiently. It features an intuitive user interface built using JavaFX, developed in IntelliJ IDEA with Gradle for dependency management.

## Features
- **Task Management**:
  - Add new tasks with a description and a due date.
  - Edit existing tasks (modify description and due date).
  - Mark tasks as complete or incomplete.
  - Remove tasks individually or clear the entire list.
- **Filtering and Display**:
  - View all tasks.
  - Filter and display only incomplete tasks.
  - Filter and display only completed tasks.
- **Persistence**:
  - Save the task list to external storage.
  - Load a saved task list from external storage.
- **Help and Documentation**:
  - A built-in help screen providing instructions on how to use the application.
  - This `README.md` serves as an additional reference guide.

## How to Run the Application
### **Prerequisites**

- **Java 11+**
- **IntelliJ IDEA (or preferred Java IDE)**
- **Gradle**

&nbsp;&nbsp;Ensure you have the above installed on your system before proceeding to run the application.

### Steps to Run
1. **Clone the Repository**:
   ```sh
   > git clone https://github.com/e4s70f3d3n/gui-based-task-manager.git
   > cd gui-based-task-manager
   ```
2. **Build and Run**:
   - Open the project in IntelliJ IDEA.
   - Ensure Gradle is installed and configured.
   - Run the `Main.java` file inside `src/main/java/ucf/assignments/`.

## Project Structure
```
/idea/           - Contains IntelliJ project configuration files
/uml/            - Contains the project's UML diagrams and design artifacts
/gradle/         - Contains Gradle build system files
/src/
    ├── `main/java/ucf/assignments/`   - Contains the application source code
    ├── `test/java/ucf/assignments/`   - Contains the JUnit test cases corresponding to the source code in `main/java/ucf/assignments/`
.gitignore       
build.gradle     - Contains the Gradle build configuration
settings.gradle  - Contains the project's Gradle settings
README.md        - Contains relevant project documentation (i.e., the file you're reading currently ;P)
```

## Testing
- The application includes **JUnit 5** tests for all core functionalities.
- Run tests using:
  ```sh
  > ./gradlew test
  ```
- Ensure all test cases pass before submitting.

## Notes
- The GUI was designed using **JavaFX SceneBuilder**, and `.fxml` files are stored in the `resources/` directory.
- Code follows **Oracle/Google Java coding standards**.
- The application is designed for **single-user task management** with potential for future enhancements, such as multi-user support and task prioritization.

---
**Developed for UCF COP 3330 Assignment 4 Part 2**  
© 2021-2025 Annalisa Vitulli

