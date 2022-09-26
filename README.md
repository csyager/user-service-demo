# user-service
A microservice managing user data 
___

### Building and deploying
* Build the docker image:  
```./gradlew bootBuildImage```
* Tag it:  
```docker tag {IMAGE_ID} 373669830907.dkr.ecr.us-east-1.amazonaws.com/doctransfer/user-service:latest```
* Push it:
```docker push 373669830907.dkr.ecr.us-east-1.amazonaws.com/doctransfer/user-service:latest```
* Delete and rebuild deployment
``` kubectl rollout restart deployment user-service ```