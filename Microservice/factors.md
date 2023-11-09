# Factors

## Used Factors:

### Factor 1: Codebase
For the first factor I used one code base which I tracked in a version control system (Git).

### Factor 2: Dependencies
The dependencies were isolated and declared in the build.gradle

### Factor 3: Config
The configurations were stored in the application.properties and application-dev.yaml (Normally only one version should be used. Either .yaml or .properties)

### Factor 4: Backing Services
Backing services like a database can be simply added by adding the required information like url username and password to the application-dev.yaml.

### Factor 6: Processes
Since this application is stateless it fulfills this factor. It is using a in memory db, but this gets automatically replaced by adding the properties which were commented in the application-dev.yaml

### Factor 7: Port Binding
This application was bound to port 9090 and this can be changed by editing the server.port property

### Factor 9: Disposability
Since it's a small application it is easily start able and shuts down gracefully. A docker file is added to create a docker image. Check the readme.md to see how to start the container.

### Factor 11: Logs
Logs are written into the console when using the application.

## Solutions for unused factors:

### Factor 5: Build, release, run
At work, we use a git pipeline for these steps. In the pipeline after the build we create a docker image with a tag and push it to our registry. After we push it to a registry we change the tag in a different repository. ArgoCD (a CD Tool) is watching that other repository and notices if the tag was changed. If the tag was changed it pulls the image from our registry and rebuilds our kubernetes pod with the running docker container using the appropriate image and tag.

### Factor 8: Concurrency
Adding more processes should be easily possible due to the statelessness of this application.

### Factor 10: Dev/Prod Parity
If this app would additionally have a prod environment we would have to create a application-prod.yml, which should be low effort and keep parity low. I was unsure about this one so i added it here.

