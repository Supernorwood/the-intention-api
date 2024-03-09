#!/bin/bash

##

set -e

set -x

##

rm -rf target/

mvn install 

##

java -jar target/agent-eight-api-1.0.jar
