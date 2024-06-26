# Mealy Machine Translator

## Design Requirement Specification Document




### REVISION HISTORY



## Table of Content

1. [Introduction](#intro)
    1. [Purpose and Scope](#purpose)  
    2. [Definitions](#def)
    3. [Document Overview](#overview)
    4. [Bibliography](#biblio)
2. [Project Description](#description)
    1. [Project Introduction](#project-intro)
    2. [Technologies used](#tech)
    3. [Assumptions and Constraints](#constraints)
3. [System Overview](#system-overview)
    1. [System Architecture](#architecture)
    2. [System Interfaces](#interfaces)
    3. [System Data](#data)
        1. [System Inputs](#inputs)
        2. [System Outputs](#outputs)
4. [System Module 1](#sys-module-1)
    1. [Structural Diagrams](#sd)
        1. [Class Diagram](#cd)
            1. [Class Description](#cd-description)
        2. [Object Diagram](#od)
        3. [Dynamic Models](#dm)
5. [System Module 2](#sys-module-2)
   1. ...

##  <a name="intro"></a>  1 Introduction
<details>
    <summary> The design specification document reflects the design and provides directions to the builders and coders of the product.</summary> 
    Through this document, designers communicate the design for the product to which the builders or coders must comply. The design specification should state how the design will meet the requirements.
</details>
    
### <a name="purpose"></a> 1.1 Purpose and Scope
<details> 
    <summary> The goal of this section is to describe the purpose of this document and intended audience  </summary>
    <p>This sub section should describe ...</p>
</details>

### <a name="def"></a> 1.2 Definitions
<details> 
    <summary> Put a summary of the section
    </summary>
    <p>This sub section should describe ...</p>
    
| First Header  | Second Header |
| ------------- | ------------- |
| Content Cell  | Content Cell  |
| Content Cell  | Content Cell  |
    
</details>

### <a name="overview"></a> 1.3 Document Overview
<details> 
    <summary> Explain how is organized the document
    </summary>
    <p>This sub section should describe ...</p>
</details>

### <a name="biblio"></a> 1.4 Bibliography
<details> 
    <summary> Put a summary of the section
    </summary>
    <p>This sub section should describe ...</p>
</details>

## <a name="description"></a> 2 Project Description

### <a name="project-intro"></a> 2.1 Project Introduction 
<details> 
    <summary>  Describe at an high level what is the goal of the project and a possible solution
    </summary>
    <p>The goal of the project is to develop a translator of a MM in dot format into a kiss2 format. The system should take as input a file representing the MM in dot format, a list of Input signals, given for the order, as well as a list of output signals. As a result the system must output into a file the same MM with different format.</p> 
</details>

### <a name="tech"></a> 2.2 Technologies used

<details> 
    <summary> Description of the overall architecture. </summary>
    <p>Graphical representation of the system architecture.  May be composed by multiple diagrams depending on the differences in the environment
specifications    </p>
</details>

### <a name="constraints"></a> 2.3 Assumption and Constraint 
<details> 
    <summary> Put a summary of the section
    </summary>
    <p>This sub section should describe ...</p>
</details>

## <a name="system-overview"></a>  3 System Overview
<details>
    <summary> The user through the user interface should be able to translate a given MM as input. Here we show the use case diagram and some of the scenarios that must be implemented. Warning this is an example and may not be complete.
    </summary>
    
![Use Case Diagram](imgs/use-case.jpg "Use Case Diagram")
    <p> ....</p>
      
| Use Case      | 1.0           |
| ------------- | ------------- |
| Name          | mm2kiss       |
| Actors        | Generic User  |    
| Entry Point   | (i) MM dot file. <br> (ii) List of Input Signals <br> (iii) List of Output Signals   |
| Exit  Point   | File where  the translated MM must be stored |
| Event Flow    | (1) User invoke the system by command line <br> (2) User provide a valid path to an input MM in dot format <br> (3) User provide a list of symbols representing the input signals <br> (4) User provide a list of symbols representing the output signals <br> (5) User provide a valid path to an empty file where the system should store the output MM <br> (6) System validates the input MM <br> (7) System validates the list of input signals<br> (8) System valdiates the list of output signals <br> (9) System validates the output file <br> (10) System correctly parse the input file and store the MM in memory<br> (11) System write the MM in memory into the output file |
    
    
| Use Case      | 2.0           |
| ------------- | ------------- |
| Name          | kiss2mm       |
| Actors        | Generic User  |    
| Entry Point   | MM kiss2 file  |
| Exit  Point   | (i) File where  the translated MM must be stored. <br> (ii) List of Input Signals. <br> (iii) List of Output Signals |
| Event Flow    | (1) User invoke the system by command line <br> (2) User provide a valid path to an input MM in kiss2 format <br> (3) User provide a valid path to an empty file where the system should store the output MM <br> (4) System validates the input MM <br> (5) System validates the output file <br> (6) System correctly parse the input file and store the MM in memory<br> (7) System write the MM into the output file <br> (8) System write the list of Input Signal into the standard input. <br> (9) System write the List of output signals into the standard input| 

</details>


### <a name="architecture"></a>  3.1 System Architecture
<details> 
    <summary> In this section we describe the overll and high level structure of the system. In particular we describe all the modules that compose the system.
    </summary>
    <p>This system is composed by a single module that translate a MM in dot format into a kiss2 format</p>
    
![System Architecture](imgs/framework.jpg "System Architecture")    
    
</details>

### <a name="interfaces"></a>  3.2 System Interfaces
<details> 
    <summary> The system should use a command line interface.
    </summary>
    <p>Here we describe the syntax that the system must use. In particular we try to keep the syntax as simpler as possible. For this reason we define an interface like this:
    systemname "absolute path to the MM in dot format" "absolute path to the kiss2 file" "list of input signals separated by comma" "list of output signals separated by comma"</p>
</details>

### <a name="data"></a>  3.3 System Data
<details> 
    <summary> In this section we describe the inputs and their format.    
    </summary>
</details>

#### <a name="inputs"></a>  3.3.1 System Inputs
<details> 
    <summary> Here we describe the command line inputs of the sistem. </summary>
  <p> The inputs of the system are : </p>
    <ul> 
        <li> Absolute path to the input file: The file should not be empty and should describe a valid MM into a valid [dot](https://en.wikipedia.org/wiki/DOT_%28graph_description_language%29) Format.</li>
        <li> Absolute path to the output file: The file should be empty and it will contain the final result of the translation  </li>
        <li> List of string names separated by comma: They represent the input signal list. Each signal is represented by a string tha contains both letters and numbers. It should not contains any other symbol.</li>
        <li> List of string names separated by comma: They represent the output signal list. Each signal is represented by a string tha contains both letters and numbers. It should not contains any other symbol.</li>
    </ul>
</details>

#### <a name="outputs"></a>  3.3.2 System Ouputs
<details> 
    <summary> Here we describe the command line output of the sistem. </summary>
  <p> The system has only one output and should be the translation of the MM from dot to kiss2 format. The translation should be written into the file given in input to the system.</p>
</details>

## <a name="sys-module-1"></a>  4 Mealy Machine Translator
<details> 
    <summary> Here we describe the structure of the system. 
    </summary>
    <p>First we describe the Static structure of the system, such as the Class/Object Diagram, and then we describe the dynamic behavior of the system. </p>
</details>

### <a name="sd"></a>  4.1 Structural Diagrams
<details> 
    <summary> Here we describe two different types of view of the system, class, and Object Diagram
    </summary>
</details>

#### <a name="cd"></a>  4.1.1 Class diagram
<details> 
    <summary> This section describes the class diagram of the system.
    </summary>
    
![Class Diagram](imgs/class2.jpg)

</details>

##### <a name="cd-description"></a>  4.1.1.1 Class Description
<details> 
    <summary> The MealyMachineTranslator class is responsible for translating Mealy Machines between the dot format and the Kiss2 format. It handles the conversion process and manages the necessary data structures and operations.
    </summary>
    <p>Description:

Properties:
* dotFile: A string representing the path to the input file containing a Mealy Machine in dot format.
* kiss2File: A string representing the path to the output file where the translated Mealy Machine in Kiss2 format will be written.
Methods:
* translateToKiss2(): This method reads the Mealy Machine from the dotFile, performs the necessary transformations, and generates the equivalent Kiss2 format. The translated Mealy Machine is then saved to the kiss2File.
* translateToDot(): This method reads the Mealy Machine from the kiss2File, performs the necessary transformations, and generates the equivalent dot format. The translated Mealy Machine is then saved to the dotFile.
* validateInput(): This method checks the validity of the input files (dotFile and kiss2File) and ensures they exist and are accessible.
* extractSignals(): This method extracts the list of input and output signals from the Mealy Machine in dot format and Kiss2 format, respectively.
* updateInputSignals(signals: List[str]): This method updates the list of input signals in the Mealy Machine to match the provided signals list.
* updateOutputSignals(signals: List[str]): This method updates the list of output signals in the Mealy Machine to match the provided signals list.
Dependencies:
* DotFileParser: A helper class responsible for parsing and extracting information from Mealy Machine files in dot format.
* Kiss2FileParser: A helper class responsible for parsing and extracting information from Mealy Machine files in Kiss2 format.
* DotFileWriter: A helper class responsible for writing Mealy Machine files in dot format.
* Kiss2FileWriter: A helper class responsible for writing Mealy Machine files in Kiss2 format.
</p>
</details>

#### <a name="od"></a>  4.1.2 Object diagram
<details> 
    <summary> we have three objects: MealyMachine, State, and Transition. The MealyMachine object represents the overall structure of the mealy machine and contains lists of states, inputs, and outputs. Each state objects has a name and a list of transitions associated with it. Each transition objects represents a transition between states and contains information about the input, output, and next state.
    </summary>
    <p>This sub section should describe ...</p>
    
![Object Diagram](imgs/Object.jpg)

</details>

#### <a name="dm"></a>  4.2 MM2Kiss translation
<details> 
    <summary> 
    User interacts with the TranslationTool object.
    </summary>
    <p>
User provides input file path containing the Mealy Machine in dot format and output file path for the translated KISS format.
TranslationTool object receives the input file path and output file path.
TranslationTool reads the input file, parsing the Mealy Machine in dot format.
TranslationTool extracts the necessary information from the dot file, including the states, transitions, inputs, and outputs.
TranslationTool performs the necessary translation logic to convert the Mealy Machine from dot format to KISS format.
TranslationTool generates the translated KISS file with the converted Mealy Machine.
TranslationTool writes the KISS file to the specified output file path.
The translation process is completed, and the TranslationTool object provides feedback or confirmation to the user.</p>

    
![ACtivity Diagram](imgs/activity.jpg "Activity")

</details>
