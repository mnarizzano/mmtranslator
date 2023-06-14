# Mealy Machine Translator

## Design Requirement Specification Document

DIBRIS – Università di Genova. Scuola Politecnica, Corso di Ingegneria del Software 80154


<div align='right'> <b> Authors </b> <br> Massimo Narizzano <br>  </div>

### REVISION HISTORY

| Version | Data | Author(s)| Notes |
| ---------|------|--------|------  |
| 1 | 12/04/23 | Massimo Narizzano | First Versionn of the document|
| 2 | 13/04/23 | Massimo Narizzano | Completed the second Use casem, added the Use case diagram|
| 3 | 03/05/23 | Massimo Narizzano | Added the UML Diagrams|
| 3 | 11/05/23 | Fatemeh Ozgoli-Romina Adhami | Added the Intro - Description|

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
    <summary>   The purpose of this Design Requirements Specification (DRS) document is to outline the functionalities of a system that translates Mealy Machines, represented as graphs, from one format to another
    </summary> 
The project aims to develop a software tool capable of reading Mealy Machines in one format and translating them into another format. Specifically, the two formats currently known are the dot format and the Kiss2 format.
</details>
    
### <a name="purpose"></a> 1.1 Purpose and Scope
<details> 
    <summary> The purpose of the software system is to provide MNcomp employees with a tool that enables them to create Mealy Machines using the familiar OldChip Designer tool while ensuring compatibility with the new chips produced by NewChip Company </summary>
    <p>The tool should be capable of reading Mealy Machines stored in dot format and translating them into Kiss2 format, and vice versa. The scope of the project includes the development of the translation tool and the implementation of the required functionalities to perform the format conversions.
    </p>
</details>

### <a name="def"></a> 1.2 Definitions
<details> 
    <summary> The Difinitions is structured as follows:
    </summary>
    <p> Mealy Machine: A Deterministic Finite State Automaton that has output values determined by both its current state and the current inputs. It is used to model and control the behavior of embedded systems.
Dot Format: A text-based format used to represent Mealy Machines, designed using the OldChip Designer tool. It contains information about the graph structure and the relationships between input and output signals.
Kiss2 Format: A text-based format used to represent Mealy Machines, designed using the NewChip Designer tool. It includes information about the graph structure as well as the classification of signals as input or output variables.
OldChip Designer: A tool developed by OldChip Company and used by MNcomp employees to design Mealy Machines for programming chips.
NewChip Designer: A tool developed by NewChip Company that allows users to design Mealy Machines, which can be loaded into the new chips produced by NewChip Company.</p>
    
| First Header  | Second Header |
| ------------- | ------------- |
| Content Cell  | Content Cell  |
| Content Cell  | Content Cell  |
    
</details>

### <a name="overview"></a> 1.3 Document Overview
<details> 
    <summary> This DRS document is structured as follows:
    </summary>
    <p>This sub section should describe ...</p>
</details>

### <a name="biblio"></a> 1.4 Bibliography
<details> 
    <summary> The bibliography section is structed as follows:
    </summary>
    <p>Wikipedia's links: 
      <br>
     https://en.wikipedia.org/wiki/Mealy_machine
        <br>
     https://en.wikipedia.org/wiki/DOT_%28graph_description_language%29</p>
     <br>
    Papers:
     <br>
    - Abdel-Hamid, Amr T., Mohamed Zaki, and Sofiene Tahar. "A tool converting finite state machine to VHDL." Canadian Conference on Electrical and Computer Engineering 2004 (IEEE Cat. No. 04CH37513). Vol. 4. IEEE, 2004.
     
</details>

## <a name="description"></a> 2 Project Description

### <a name="project-intro"></a> 2.1 Project Introduction 
<details> 
    <summary>  The goal of this project is to develop a software tool that facilitates the translation of Mealy Machines from one format to another.
    </summary>
    <p> Mealy Machines are graphical representations used to control the behavior of programmable chips.
        <br> MNcomp, an enterprise that programs chips for household machines, currently uses the OldChip Designer tool provided by OldChip Company to design Mealy Machines in the dot format. However, with the emergence of a promising new chip produced by NewChip Company, MNcomp desires to utilize the new chips while still using the familiar OldChip Designer tool.

To achieve this goal, the project aims to create a software tool that can read Mealy Machines stored in the dot format and translate them into the Kiss2 format, which is compatible with the new chips produced by NewChip Company. Additionally, the tool should also be able to convert Mealy Machines from Kiss2 format to dot format, ensuring bidirectional compatibility.</p> 
</details>

### <a name="tech"></a> 2.2 Technologies used

<details> 
    <summary> The overall architecture of the software tool will utilize a combination of programming languages and frameworks </summary>
    <p>The specific technologies to be employed in the development of the tool will be determined based on factors such as compatibility, performance, and ease of use. Possible technologies that may be utilized include:

Programming Languages: Java <br>
File Parsing and Manipulation: parser libraries <br>
Graph Visualization: <br>
Version Control: Git and GitHub for collaborative development and source code management
    </p>
</details>

### <a name="constraints"></a> 2.3 Assumption and Constraint 
<details> 
    <summary> The project is based on the following assumptions and constraints:
    </summary>
    <p>
        Assumption 1: The Mealy Machines designed using the OldChip Designer tool and the NewChip Designer tool are functionally equivalent, despite having different user interfaces. <br>
Assumption 2: The input and output signals of the Mealy Machines have unique names and occur in the input files. <br>
Constraint 1: The translation tool must be able to process Mealy Machines stored in the dot format and convert them accurately to the Kiss2 format. <br>
Constraint 2: The translation tool should also be capable of converting Mealy Machines from the Kiss2 format to the dot format while preserving the input/output signal information. <br>
Constraint 3: The translation tool should provide an intuitive and user-friendly interface for MNcomp employees to interact with, simplifying the conversion process. <br>
Constraint 4: The translation tool should ensure compatibility with the existing systems and infrastructure at MNcomp, including the chip programming workflow and file management practices. <br>
These assumptions and constraints will guide the development process of the software tool, ensuring that it meets the specific requirements and expectations of MNcomp.</p>
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
    system name "absolute path to the MM in dot format" "absolute path to the kiss2 file" "list of input signals separated by comma" "list of output signals separated by comma"</p>
</details>

### <a name="data"></a>  3.3 System Data
<details> 
    <summary> The system deals with two main data formats: dot format and Kiss2 format, which represent Mealy Machines.
    </summary>
    Dot Format: <br>
    
The dot format is a textual representation of a Mealy Machine in a graph structure. It consists of a set of nodes representing the states of the machine and edges representing the transitions between states. Each node and edge can have additional properties and labels associated with them. In the dot format, the Mealy Machine is defined using a specific syntax and conventions. To manage and manipulate the data in the dot format, the system will utilize data structures such as graphs or adjacency lists to represent the Mealy Machine. These data structures will capture the relationships between states and transitions, along with associated properties and labels. Additionally, the system will parse and extract relevant information from the dot format, such as state names, input/output signal names, and transition conditions <br>
    Kiss2 Format: <br>

    The Kiss2 format is another textual representation of a Mealy Machine. It maintains additional information about the variables, specifically indicating if a signal is an input or an output variable. The Kiss2 format provides a structured way to represent the Mealy Machine, including input/output variable declarations and transition conditions.

Similar to the dot format, the system will need to handle the data in the Kiss2 format during the translation process. It will employ suitable data structures to represent the Mealy Machine and manage the variables' input/output information.
    <br>
   
  By managing and manipulating the data in both the dot and Kiss2 formats effectively, the system can facilitate the translation process and ensure the correctness and compatibility of the Mealy Machines between the two formats.  
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
    <p>First we describe the Static structure of the system, such as Class/Object Diagram, and then we describe the dynamic behaviour of the system. </p>
</details>

### <a name="sd"></a>  4.1 Structural Diagrams
<details> 
    <summary> Here we describe two different type of view of the system, class and Object Diagram
    </summary>
</details>

#### <a name="cd"></a>  4.1.1 Class diagram
<details> 
    <summary> This section describe the class diagram of the system.
    </summary>
    
![Class Diagram](imgs/class.jpg "Class Diagram")

</details>

##### <a name="cd-description"></a>  4.1.1.1 Class Description
<details> 
    <summary> Put a summary of the section
    </summary>
    <p>This sub section should describe ...</p>
</details>

#### <a name="od"></a>  4.1.2 Object diagram
<details> 
    <summary> Put a summary of the section
    </summary>
    <p>This sub section should describe ...</p>
    
![Object Diagram](imgs/object.jpg "Class Diagram")

</details>

#### <a name="dm"></a>  4.2 MM2Kiss translation
<details> 
    <summary> 
    In this section we define the dynamic model for mm to kiss translation
    </summary>
    <p>This sub section should describe ...</p>

    
![ACtivity Diagram](imgs/activity.jpg "Activity")

</details>
