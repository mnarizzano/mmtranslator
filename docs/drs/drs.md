# Mealy Machine Translator

## Design Requirement Specification Document

DIBRIS – Università di Genova. Scuola Politecnica, Corso di Ingegneria del Software 80154


<div align='right'> <b> Authors </b> <br> Massimo Narizzano <br>  </div>

### REVISION HISTORY

| Version | Data | Author(s)| Notes |
| ---------|------|--------|------  |
| 1 | 12/04/23 | Massimo Narizzano | First Versionn of the document|
| 2 | 13/04/23 | Massimo Narizzano | Completed the second Use casem, added the Use case diagram|
2

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
    <summary> Put a summary of the section
    </summary>
    <p>This sub section should describe ...</p>
</details>

### <a name="interfaces"></a>  3.2 System Interfaces
<details> 
    <summary> Put a summary of the section
    </summary>
    <p>This sub section should describe ...</p>
</details>

### <a name="data"></a>  3.3 System Data
<details> 
    <summary> Put a summary of the section
    </summary>
    <p>This sub section should describe ...</p>
</details>

#### <a name="inputs"></a>  3.3.1 System Inputs
<details> 
    <summary> Put a summary of the section
    </summary>
    <p>This sub section should describe ...</p>
</details>

#### <a name="outputs"></a>  3.3.2 System Ouputs
<details> 
    <summary> Put a summary of the section
    </summary>
    <p>This sub section should describe ...</p>
</details>

## <a name="sys-module-1"></a>  4 System Module 1
<details> 
    <summary> Put a summary of the section
    </summary>
    <p>This sub section should describe ...</p>
</details>

### <a name="sd"></a>  4.1 Structural Diagrams
<details> 
    <summary> Put a summary of the section
    </summary>
    <p>This sub section should describe ...</p>
</details>

#### <a name="cd"></a>  4.1.1 Class diagram
<details> 
    <summary> Put a summary of the section
    </summary>
    <p>This sub section should describe ...</p>
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
</details>

#### <a name="dm"></a>  4.2 Dynamic Models
<details> 
    <summary> Put a summary of the section
    </summary>
    <p>This sub section should describe ...</p>
</details>
