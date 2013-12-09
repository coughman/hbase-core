hbase-core
==========


clone, compile and install the Cloudera CDK using:

git clone https://github.com/cloudera/cdk.git
mvn compile -Dmaven.test.skip=true
mvn install 

then on hbase-core run the following:

mvn compile -Dmaven.test.skip=true
mvn cdk:create-dataset
mvn exec:java -Dexec.mainClass="com.cloudera.cdk.examples.data.WritePartyDataset"
mvn exec:java -Dexec.mainClass="com.cloudera.cdk.examples.data.ReadPartyDataset"


 
