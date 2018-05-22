#!/bin/bash

set -x

# write here directory inside lesson data zip archive
LESSON_DATA_DIR=collinear

source ../setAndCompile.sh

# run whatever here. example:
${JAVA} -ea -cp "${ALGS4JAR}${SEP}${OUT_DIR}" Point
${JAVA} -ea -cp "${ALGS4JAR}${SEP}${OUT_DIR}" BruteCollinearPoints ${DATA_DIR}/input100.txt
