# sdt-toy-simulator

It is a java library for weather simulation. This library was implemented using Yahoo Weather API. The simulator takes the input from a text file, which contains the WOEID codes for different locations and outputs the data in the below form:

Location|Lattitude,Longitude,Elevation|Time|Condition|Temperature|Pressure|humidity

where,

Location refers to the location for which WOEID is given,

Lattitude,Longitude,Elevation - are comma separated triple set showing the lattitude,longitude and elevation of the location

Time - which is in ISO 8601 format date time

Condition - Either this is Rain,Sunny and Snow

Temperature - which is in C

Pressure - which is in hpa

Humidity - which is in %

How to run the simulator:
Build the project by the following commands

$ mvn compile
$ mvn clean package
$ java -jar "<path to this jar> - \target\sdt-toy-simulator-2.0.3-SNAPSHOT-jar-with-dependencies.jar" "<path - of - input text file"

Input:

The input for the simulator is a text file - A list with set of locations or lat,long values. For Example refer to the below sample Input:

22.54994,88.37158
7.0077,100.47053
hyderabad
55.74164,37.60506
dubai
punjab
32.1685,-95.66919
Sydney
Melbourne

Output

