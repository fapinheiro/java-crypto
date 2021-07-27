# java-crypto
A project for Java cyber security stack

# Compile
mvn clean package

# Run
cd .\target

java -jar java-crypto-<version>.jar

The command generate the file `jssecacerts`. Just place it in the security folder of you Java distribution. Commonly in Windows `C:\Program Files\Java\openjdk-11\lib\security`. 
