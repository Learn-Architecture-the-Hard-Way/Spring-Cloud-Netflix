#!/bin/bash

PART=3
BASE_DIR=$PWD

cd $BASE_DIR/p$PART-api
mvn clean install -DskipTests

cd $BASE_DIR/p$PART-spring-boot-A
mvn clean package -DskipTests

cd $BASE_DIR/p$PART-spring-boot-B
mvn clean package -DskipTests
