# CDK HBase Example

This example shows basic usage of the CDK Data API for working with a dataset stored in
 HBase.

## Pre-requisites

Make sure ports 2181 (ZooKeeper) and 60000, 60020 (HBase Master and Region Server) are
enabled for port forwarding, as described on the
[CDK Examples page](https://github.com/cloudera/cdk-examples).

## Running

Build the code with:

```bash
mvn compile
```

Then create the dataset with:

```bash
mvn cdk:create-dataset
```

Write some data to it:

```bash
mvn exec:java -Dexec.mainClass="com.cloudera.cdk.examples.data.WriteUserDataset"
```

Once we have created a dataset and written some data to it, the next thing to do is to
read it back. We can do this with the `ReadUserDataset` program.

```bash
mvn exec:java -Dexec.mainClass="com.cloudera.cdk.examples.data.ReadUserDataset"
```

You can also have a look at the raw data in HBase by typing `hbase shell` in a terminal
(e.g. on the QuickStart VM) followed by:

```bash
list # show the tables
scan 'users' # dump all rows and columns
```

Finally, delete the dataset:

```bash
mvn cdk:delete-dataset
```

## Schema Evolution

Over time, the user model will likely change, as new properties are added,
and old ones are no longer used. Schemas can be updated to a new version,
as long as certain schema evolution rules are followed. We can see this by trying an
update that is not allowed. Start by re-creating the dataset and writing some data:

```bash
mvn cdk:create-dataset
mvn exec:java -Dexec.mainClass="com.cloudera.cdk.examples.data.WriteUserDataset"
```

The copy the contents of _src/main/avro/user.avsc.invalid-migration_ to
_src/main/avro/user.avsc_, and try to update the dataset's schema:

```bash
mvn cdk:update-dataset
```

The command will fail with an error, since adding a new field without a default is not
allowed.

Next copy the contents of _src/main/avro/user.avsc.valid-migration_ (which specifies a
default for the new field) to _src/main/avro/user.avsc_,
and try to update the dataset's schema:

```bash
mvn cdk:update-dataset
```

This time it should succeed. Updating a dataset is an idempotent operation,
so you can run it again without it having any further effect. This is useful when you
want to make sure that you are using the latest version of the schema in your workspace.

Recompile the code so that the generated `User` class has
the new field, then run the `ReadUserDataset` program. It should show the new field,
age, with its default value (0) for each entity.

```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.cloudera.cdk.examples.data.ReadUserDataset"
```

You can also try changing `WriteUserDataset` to set the new field and check that it runs,
and that the new entities can be read back.

```bash
mvn exec:java -Dexec.mainClass="com.cloudera.cdk.examples.data.WriteUserDataset"
mvn exec:java -Dexec.mainClass="com.cloudera.cdk.examples.data.ReadUserDataset"
```

Finally, delete the dataset:

```bash
mvn cdk:delete-dataset
```
