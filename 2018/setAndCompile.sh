#!/bin/bash

JAVA=java
JAVAC=javac

SEP=":"

OS=`uname -s`
case "$OS" in
  Linux )
    SEP=":"
    ;;
  Windows* | CYGWIN* )
    SEP=";"
    ;;
  * )
    echo "Unrecognized system!"
    exit 1;
    ;;
esac

OUT_DIR=out/
LIBS_DIR=../libs
DATA_DIR=lesson_data/${LESSON_DATA_DIR}
ALGS4JAR=${LIBS_DIR}/algs4.jar

rm -rf ${OUT_DIR}
mkdir -p ${OUT_DIR}

javac -cp ${ALGS4JAR} -d out src/*.java ${DATA_DIR}/*.java

ls -l out
