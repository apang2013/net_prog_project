#!/bin/bash
#
 # Student:    Trung Nguyen, Yat Shing Pang
 # Email:      tnguyen2013@my.fit.edu, apang2013@my.fit.edu
 # Course:     CSE 4232
 # Project:    GOSSIP P2P, Milestone 5
#
path=$(pwd)
library="$path/library/commons-cli-1.3.1.jar"
cd source

javac -d "$path/bin" -cp .:$library *.java
