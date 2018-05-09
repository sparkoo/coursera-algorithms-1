#!/bin/bash

set -x

JAVA=java
JAVAC=javac

OUT_DIR=out/
LIBS_DIR=../libs
DATA_DIR=lesson_data/percolation
ALGS4JAR=${LIBS_DIR}/algs4.jar

rm -rf ${OUT_DIR}
mkdir -p ${OUT_DIR}

javac -cp ${ALGS4JAR} -d out src/*.java ${DATA_DIR}/*.java

ls -l out


#java -cp "${ALGS4JAR};${OUT_DIR}" InteractivePercolationVisualizer 1
# java -cp "${ALGS4JAR};${OUT_DIR}" PercolationVisualizer ${DATA_DIR}/input1.txt
 java -cp "${ALGS4JAR};${OUT_DIR}" PercolationStats 200 100
