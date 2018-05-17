#!/bin/bash

set -x

LESSON_DATA_DIR=percolation
source ../setAndCompile.sh

#${JAVA} -cp "${ALGS4JAR}${SEP}${OUT_DIR}" InteractivePercolationVisualizer 10
${JAVA} -cp "${ALGS4JAR}${SEP}${OUT_DIR}" PercolationVisualizer ${DATA_DIR}/input10.txt
#${JAVA} -cp "${ALGS4JAR}${SEP}${OUT_DIR}" PercolationStats 200 100
