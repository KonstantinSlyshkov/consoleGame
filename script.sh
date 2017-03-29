#!/bin/bash
BUILD_NUMBER=$(curl -v -X POST https://circleci.com/api/v1.1/project/github/konstantinslyshkov/webApplication/tree/master?circle-token=79420eb9943f598fcc19f7b7becf408031d39ae0 | grep -m 2 -Po '\"build_num\" : \K[0-9]+' | tail -n 1 )

echo build number $BUILD_NUMBER of tests started 

while true
do
OUTCOME=$(curl -s "https://circleci.com/api/v1.1/project/github/konstantinslyshkov/webApplication/${BUILD_NUMBER}?circle-token=79420eb9943f598fcc19f7b7becf408031d39ae0" | sed -n 's/\"outcome\"[[:space:]]:[[:space:]]\"//p' | sed s'/\",$//' | tail -n 1)
echo $OUTCOME test
if [[ $OUTCOME =~ .*failed.* ]]; then
	echo build number $BUILD_NUMBER failed; 
	break;
elif [ $OUTCOME == *success.* ]; then
    echo build number $BUILD_NUMBER completed succesfully;
	break;
elif [ $OUTCOME == *cancelled.* ]; then
    echo build number $BUILD_NUMBER cancelled;
	break;
else 
	sleep 5;
fi
done









