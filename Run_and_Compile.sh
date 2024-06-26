#!/bin/bash

# Create the output directory if it doesn't exist
mkdir -p out

# Compile all Java files in the src/main/java directory
javac -d out $(find src/main/java -name "*.java")

# Run the MMTranslator class
java -cp out org.mncomp.mmtranslator.MMTranslator
