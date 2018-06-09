#!/bin/bash

set -x
set -e

# write here directory inside lesson data zip archive
LESSON_DATA_DIR=kdtree

source ../setAndCompile.sh

# run whatever here. example:
#${JAVA} -cp "${ALGS4JAR}${SEP}${OUT_DIR}" PointSET ${DATA_DIR}/input10.txt
#${JAVA} -cp "${ALGS4JAR}${SEP}${OUT_DIR}" KdTree ${DATA_DIR}/input10.txt
${JAVA} -cp "${ALGS4JAR}${SEP}${OUT_DIR}" NearestNeighborVisualizer ${DATA_DIR}/input10.txt
${JAVA} -cp "${ALGS4JAR}${SEP}${OUT_DIR}" RangeSearchVisualizer ${DATA_DIR}/input10.txt

zip kdtree src/*.java