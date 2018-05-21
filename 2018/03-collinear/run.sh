#!/bin/bash

set -x

# write here directory inside lesson data zip archive
LESSON_DATA_DIR=collinear

source ../setAndCompile.sh

# run whatever here. example:
${JAVA} -cp "${ALGS4JAR}${SEP}${OUT_DIR}" Point ${DATA_DIR}/rs1423.txt
