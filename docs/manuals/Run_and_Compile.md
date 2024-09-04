# Mealy Machine Translator Project 


## Prerequisites 

1. Make sure that you have the following softares installed on your computer:

- Java Development Kit (JDK) 20, you can download it from [Oracle’s website](https://www.oracle.com/java/technologies/javase/jdk20-archive-downloads.html) or [OpenJDK](https://jdk.java.net/20/)
- Java Runtime Environment (JRE), Although JDK already includes the JRE.
 2. Download a Text edior or IDE (optional but recommended):
	•	You can use any text editor (VS Code, Sublime Text) or IDE (IntelliJ IDEA, Eclipse, NetBeans) for better code management and navigation. 

### Compile the Project

1. Clone the Project
    ```bash
     git clone https://github.com/mnarizzano/mmtranslator/tree/main.git


3. Navigate to the root directory of where you cloned the project :
    ```bash
     cd mmtranslator


4. Ensure execute permissions for the  compile.sh  script
   ```bash

    chmod +x compile.sh


5. Run and compile the compile script to compile the source code and generate the necessary artifacts.
    ```bash
       ./compile.sh

You can also run the application separately by using the command provided in this script below:
 ```bash
    java -cp out org.mncomp.mmtranslator.MMTranslator
