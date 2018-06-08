#!/bin/bash

set -x

# write here directory inside lesson data zip archive
LESSON_DATA_DIR=8puzzle

source ../setAndCompile.sh

# run whatever here. example:
#${JAVA} -cp "${ALGS4JAR}${SEP}${OUT_DIR}" Board ${DATA_DIR}/../../testBoard.txt
#${JAVA} -cp "${ALGS4JAR}${SEP}${OUT_DIR}" Board ${DATA_DIR}/puzzle00.txt
#${JAVA} -cp "${ALGS4JAR}${SEP}${OUT_DIR}" Solver ${DATA_DIR}/puzzle04.txt
${JAVA} -cp "${ALGS4JAR}${SEP}${OUT_DIR}" Solver ${DATA_DIR}/puzzle04.txt

zip 8puzzle src/*.java