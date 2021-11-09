#!/bin/bash
javac Lab1.java
echo "Manifest-Version: 1.0" > MANIFEST.MF
echo "Main-Class: Lab1" >> MANIFEST.MF
jar cmf MANIFEST.MF Lab1.jar Lab1.class
java -jar Lab1.jar
rm MANIFEST.MF Lab1.jar Lab1.class
