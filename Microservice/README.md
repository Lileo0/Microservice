# Calculator
Microservice for "Software Entwicklung"

## How to start the programm:


First build the module Microservice which is contained in this same folder.

Then build the project in gradle and set the active profile to "dev". This should make sure that the application-dev.yaml is used for the environment properties.

After starting the application it is waiting for requests on the port 9090.

Here is an example Request:

![img.png](../img.png)

curl --location "http://localhost:9090/api/calc" --header "Content-Type: application/json" --data "{ \"number1\": 1, \"number2\": 2, \"operation\": \"+\" }"

The following command is used for building the docker image.

docker build -t calculator:1 .

The following command is used for starting a container with the application.

docker run -p 9090:9090 calculator:1 .


# Notes:

Currently, the microservice is using an in memory h2 database, and it can be started. If you want to bind your own database to it please edit/uncomment the database settings in the application-dev.yaml file and add your own parameters. 

In the microservice module is a docker-compose.yml file which creates a database for you. As of now i did not manage somehow to bind the database to this application, due to some errors with the authentication, but maybe it works for you.

Nonetheless, it works with the h2 database and the ability to include an external database was mainly just to show how to do it but since this application doesn't use it either way I won't continue to try and bind an external database to it.

Additional Ideas: Requests and results could be saved in the database as a history.