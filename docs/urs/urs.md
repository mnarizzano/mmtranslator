
### User Requirements Specification Document
### Mealy Machine Translator
##### DIBRIS – Università di Genova. Scuola Politecnica, Software Engineering Course 80154


**VERSION : 1.0**

**Authors**  
Massimo Narizzano

**REVISION HISTORY**

| Version    | Date        | Authors      | Notes        |
| ----------- | ----------- | ----------- | ----------- |
| 1.0 | 27/02/2023 | Massimo Narizzano| Given a first description of the project. Completed section 1|
| 1.1 | 01/03/2023 | Massimo Narizzano| Completed section 2|


# Table of Contents

1. [Introduction](#p1)
	1. [Document Scope](#sp1.1)
	2. [Definitios and Acronym](#sp1.2) 
	3. [References](#sp1.3)
2. [System Description](#p2)
	1. [Context and Motivation](#sp2.1)
	2. [Project Objectives](#sp2.2)
3. [Requirement](#p3)
 	1. [Stakeholders](#sp3.1)
 	2. [Functional Requirements](#sp3.2)
 	3. [Non-Functional Requirements](#sp3.3)
  
  

<a name="p1"></a>

## 1. Introduction

<a name="sp1.1"></a>
This document is a simple example of a User Requirements Documents that is used as running example in the Software Engineering class at University of Genoa, course number 80154. It describes the functionality of a simple software that translate a Mealy machine from a format to another format.

### 1.1 Document Scope

<a name="sp1.2"></a>
This document is provided to the students of the SE-80154 course as an example of User Requirements documents. It shows how requirements can be written and which are the main errors in writing specifications. It may contains errors that are presents for didactical reasons. 

### 1.2 Definitios and Acronym


| Acronym				| Definition | 
| ------------------------------------- | ----------- | 
| SE23                                  | Software Engineering course, 2023 at university of Genoa|
| SE-80154                              | Software Engineering course, 2023 at university of Genoa, 80154 is its ID number|
| MM                                    | [Mealy Machine](https://en.wikipedia.org/wiki/Mealy_machine) is formalism used to synthetize models of systems|
| DOT                                   | [Graph Description language](https://en.wikipedia.org/wiki/DOT_%28graph_description_language%29) Is a text language used to describe graphs.|
| GRAPHVIZ                              | [Graphviz](https://www.graphviz.org/) is open source graph visualization software. Can be used to visualize the MM in DOT format|
| KISS                                  |[Kiss2 format](https://automata.cs.ru.nl/BenchmarkCircuits/Kiss) |


<a name="sp1.3"></a>

### 1.3 References 

<a name="p2"></a>

1. [Mealy Machine](https://en.wikipedia.org/wiki/Mealy_machine)
2. [DOT](https://en.wikipedia.org/wiki/DOT_%28graph_description_language%29)
3. [Graphviz](https://www.graphviz.org/) 


## 2. System Description

<a name="sp2.15"></a>

In this document we describe the functionalities of a system that translate a mealy machine, essentially a graph, from a format to another. At the moment two are the format known, dot format and kiss format. So the idea is to develop a software that can read a format in input and translate the MM in the other format. 

### 2.1 Context

<a name="sp2.2"></a>
Mealy machines are Deterministic Finite State Automata that have also output at any tick of the clock. Modern CPUs, computers, cell phones, digital clocks and basic electronic devices/machines have some kind of finite state machine to control it. Simple software systems, particularly ones that can be represented using regular expressions, can be modeled as finite state machines. There are many such simple systems, such as vending machines or basic electronics.
[Mealy Machines](https://en.wikipedia.org/wiki/Mealy_machine) are a type of automata that are uesd to model some kind of Embedded Systems. They can be described as a finite-state machine whose output values are determined both by its current state and the current inputs. In figure can be found a visual example of a Mealy machine.

![Example of Mealy Machine](imgs/acc.jpg "Example of a mealy machine")

It represents a system with two states (0,1) and three variables : act, deact are input boolean signals while flag is an output boolean signal. Each arrow on the graph represents the relations between input and output signals. So for example on state 0 the self arrow has the label (!act & !deact / !flag) meaning that if the system is on state 0 and both the imput signals (act,deact) are false then the output signal must be set to false.

### 2.2 Motivations (what is the problem?)
Given its semplicity, Mealy Machine is a powerfull formalism to describe systems. In the last 20 years we testify the growing use of MM expecially in the field of circuit synthesis and Verification. As a consequence many benchmarks and tools reading MM have been constructed. Unluckly, since a MM is a graph, many different syntax have been used to describe such systems, such as for example [Kiss2 format](https://automata.cs.ru.nl/BenchmarkCircuits/Kiss), or [dot](https://en.wikipedia.org/wiki/DOT_%28graph_description_language%29) format. In other word if any reasercher want to develop a tools that take in input/get in output a MM he must write different parser/writer in order to cope with all these formats. All these different MM formats can discourage the use of such a formalism.


### 2.2 Project Objectives 

<a name="p3"></a>

The project objective is to create a translator that given a MM machine in a format (for example dot) allows the user to choose a new format (for example KISS) and then to automatically translate it in this format.  In particular we want a GUI application and eventually a command line tool that allow the user to translate the input file into another format. It should be possible somehow to deal with the possibility of adding new formats on the fly by providing just a parser and a writer.

## 3. Requirements

| Priorità | Significato | 
| --------------- | ----------- | 
| M | **Mandatory:**   |
| D | **Desiderable:** |
| O | **Optional:**    |
| E | **future Enhancement:** |

<a name="sp3.1"></a>

### 3.1 Stakeholders

<a name="sp3.2"></a>


### 3.2 Functional Requirements 

| ID | Descrizione | Priorità |
| --------------- | ----------- | ---------- | 
| 1.0 |  The System should be able to load a MM in dot format|M|
| 1.0 |  The System should be able to load a MM in kiss format|D|
| 1.0 |  The System should be able to display a loaded MM text format |M|
| 1.0 |  The System should be able to display a loaded MM in a graphic way, such as a directed connected graph |M|
| 1.0 |  The System could load a list of comma separated symbols representing input system variables|D|
| 1.0 |  If the system takes in input a set of comma separated symbols as input system variables, they should also appear in the kiss output format, according to that format |D|
| 1.0 |  The System could load a list of comma separated symbols representing output system variables|D|
| 1.0 |  If the system takes in input a set of comma separated symbols as input system variables, they should also appear in the kiss input format, according to that format |D|
| 1.0 |  The System should be able to save a mealy machine in kiss format according to |M|
| 1.0 |  If the system takes in input a set of comma separated symbols as output system variables, they should also appear in the kiss output format, according to that format |D|
| 1.0 |  The System should allow the user to modify the diplayed text|M|
| 1.0 |  The System should convert a loaded MM in dot format in a MM in KISS format|M|
| 1.0 |  The System should save a displayed text MM into the proper format |M|
| 1.0 |  The System should be accessible by command line tool for batch work|M|
| 1.0 |  The System should have also a GUI to interact with |M|












<a name="sp3.3"></a>
### 3.2 Non-Functional Requirements 
 
| ID | Descrizione | Priorità |
| --------------- | ----------- | ---------- | 
| 1.0 | XXXXX |M|
