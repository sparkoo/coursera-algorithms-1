#!/bin/bash

set -x
set -e

# write here directory inside lesson data zip archive
LESSON_DATA_DIR=

source ../setAndCompile.sh

# run whatever here. example:
# ${JAVA} -cp "${ALGS4JAR}${SEP}${OUT_DIR}" InteractivePercolationVisualizer 10

# zip _ src/*.java