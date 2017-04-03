#!/bin/bash
echo 'Waiting for instances to be up and running'
sleep 10s
token=$1
BUILD_NUMBER=$(curl -v -X POST "https://circleci.com/api/v1.1/project/github/KonstantinSlyshkov/getftpfeedswithnotifications/tree/master?circle-token=${token}" | grep -m 2 -Po '\"build_num\" : \K[0-9]+' | tail -n 1 )

echo build number $BUILD_NUMBER of tests started 

while true
do
OUTCOME=$(curl -s "https://circleci.com/api/v1.1/project/github/KonstantinSlyshkov/getftpfeedswithnotifications/${BUILD_NUMBER}?circle-token=${token}" | sed -n 's/\"outcome\"[[:space:]]:[[:space:]]\"//p' | sed s'/\",$//' | tail -n 1)
if [[ $OUTCOME =~ .*failed.* ]]; then
	echo ERROR: Functional tests build number $BUILD_NUMBER failed; 
	exit 1;
elif [[ $OUTCOME =~ .*success.* ]]; then
    echo INFO: Functional tests build number $BUILD_NUMBER completed successfully;
	break;
elif [[ $OUTCOME == .*cancelled.* ]]; then
    echo WARNING: Functional tests build number $BUILD_NUMBER was cancelled;
	exit 126;
else 
	sleep 5;
fi
done









