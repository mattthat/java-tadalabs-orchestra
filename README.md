# tadalabs-java-orchestra

All the instruments play when they're mapped to functions

### local runtime
```bash

# docker pull lambci/lambda
# ./gradlew clean build
# docker run --net=host -i -e AWS_REGION=local  --rm -v "$PWD/build/docker":/var/task lambci/lambda:java8 org.tadalabs.orchestra.lambda.SQSDrivenRequestHandler $(cat src/main/resources/aws/sqs/sqs-event.json)

```
