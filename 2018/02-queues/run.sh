#!/bin/bash

set -x

# write here directory inside lesson data zip archive
LESSON_DATA_DIR=queues

source ../setAndCompile.sh

# run whatever here. example:
# ${JAVA} -cp "${ALGS4JAR}${SEP}${OUT_DIR}" InteractivePercolationVisualizer 10

${JAVA} -cp "${ALGS4JAR}${SEP}${OUT_DIR}" Deque
# ${JAVA} -cp "${ALGS4JAR}${SEP}${OUT_DIR}" RandomizedQueue
# ${JAVA} -cp "${ALGS4JAR}${SEP}${OUT_DIR}" Permutation 3 < ${DATA_DIR}/distinct.txt