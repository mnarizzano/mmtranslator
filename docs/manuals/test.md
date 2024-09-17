## Instructions for Running Tests

To run the tests for this project, follow these steps:

### Step 1: Clone the Repository

First, clone the repository to your local machine using the following command:

```bash
git clone [https://github.com/mnarizzano/mmtranslator/edit/FatemeOzgoli]
cd mmtranslator-FatemeOzgoli
```
Run the repository using the Run_and_compile.sh file.
### Step 2: Maven
Make sure you have Maven installed on your system. You can check if Maven is installed by running:
```bash
mvn -v
```
If you don't have Maven already installed in your system, Follow the following steps:  
**On macOS:**  
Install [Homebrew](https://brew.sh/) if you haven't already done. You can install Homebrew by pasting the following command in your Terminal:
   ```bash
   /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
brew install maven
```
**On Windows:**
1.	Download Maven from the official Maven website.
2.	Extract the downloaded ZIP file to a directory, for example: C:\Program Files\Apache\maven.
3.	Add the bin directory of the extracted folder to your PATH environment variable:
		•	Right-click on This PC > Properties > Advanced system settings > Environment Variables.
  •	Under System Variables, find Path and click Edit.  
  •	Add the path to the bin directory of Maven, e.g., C:\Program Files\Apache\maven\bin.  
  •	Click OK to save changes.

**On Linux:**
```bash
sudo apt update
sudo apt install maven
```

Verify that Maven is installed with this command:
```bash
mvn -v
```
### Step 3: Run Maven Commands to Verify Project Setup	  
1.Navigate to the root directory of your project (where the pom.xml file is located).  
2.	Run the following commands:  
•	To clean the project (remove previously compiled files):
```bash
mvn clean
```
•	To compile the project (compile source code):
```bash
mvn compile
```
To run the tests :
 ```bash
 mvn test
```
