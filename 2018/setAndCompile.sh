#!/bin/bash

JAVA=java
JAVAC=javac

SEP=";"

OUT_DIR=out/
LIBS_DIR=../libs
DATA_DIR=lesson_data/${LESSON_DATA_DIR}
ALGS4JAR=${LIBS_DIR}/algs4.jar

rm -rf ${OUT_DIR}
mkdir -p ${OUT_DIR}

javac -cp ${ALGS4JAR} -d out src/*.java ${DATA_DIR}/*.java

ls -l out
