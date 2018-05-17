#!/bin/bash

LIBS_DIR=libs/
LESSON_DATA_DIR=lesson_data


# prepare libs
mkdir -p ${LIBS_DIR}

pushd ${LIBS_DIR}
if [ ! -f algs4.jar ]; then
    wget https://algs4.cs.princeton.edu/code/algs4.jar
fi
popd

function prepareLesson() {
    LESSON_DIR=${1}
    LESSON_TEST_ARCHIVE=${2}.zip

    if [ ! -f ${LESSON_DIR}/run.sh ]; then
        cp run_template.sh ${LESSON_DIR}/run.sh
    fi
    mkdir -p ${LESSON_DIR}/${LESSON_DATA_DIR}
    pushd ${LESSON_DIR}/${LESSON_DATA_DIR}
    if [ ! -f ${LESSON_TEST_ARCHIVE} ]; then
        wget http://coursera.cs.princeton.edu/algs4/testing/${LESSON_TEST_ARCHIVE}
        unzip ${LESSON_TEST_ARCHIVE}
    fi
    popd
}

# prepare lesson data
prepareLesson 01-percolation percolation-testing
prepareLesson 02-queues queues
