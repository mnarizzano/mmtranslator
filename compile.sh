#!/bin/bash

# Set the root directory of your project
PROJECT_DIR="/home/west/Desktop/fatemeh/mmtranslator"

# Create the target directory if it doesn't exist
mkdir -p "$PROJECT_DIR/target"

# Compile the source code and place the compiled classes in the target directory
find "$PROJECT_DIR/src/main/java" -name "*.java" -print | xargs javac -d "$PROJECT_DIR/target" -cp "$PROJECT_DIR/src/main/java"

# Compile the source code
javac -d target -cp src/main/java src/main/java/org/mncomp/mmtranslator/MMTranslator.java

# Create the jar file
jar cfe MMTranslator.jar org.mncomp.mmtranslator.MMTranslator -C target .