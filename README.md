# demo-complaints-stats
Receiving demo-componts

## Dockerize
See [working example](https://www.dontpanicblog.co.uk/2016/07/08/building-tagging-and-pushing-docker-images-with-maven/)
for building the docker image. The example refers to [github](https://github.com/hotblac/spanners/blob/master/pom.xml) for code.

See [docker and java](https://hub.docker.com/_/java/) documentation

In order to build the docker image:
* the docker daemon must be started
* a rabbitmq instance must be running, the maven test will fail otherwise

Building is executed by
``` 
$ mvn clean package docker:build
```