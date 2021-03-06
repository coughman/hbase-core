/**
 * Copyright 2013 Cloudera Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cloudera.cdk.hbase.data;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.log4j.Logger;
import org.kitesdk.data.DatasetReader;
import org.kitesdk.data.DatasetRepositories;
import org.kitesdk.data.Key;
import org.kitesdk.data.RandomAccessDataset;
import org.kitesdk.data.RandomAccessDatasetRepository;

import com.cloudera.cdk.hbase.data.avro.Party;

/**
 * Read the party objects from the parties dataset by key lookup, and by scanning.
 */
public class ReadPartyDataset extends Configured implements Tool {
	Logger logger = Logger.getLogger(WriteAddressDataset.class);

  @Override
  public int run(String[] args) throws Exception {
	  if (args.length < 1)
	  {
		  logger.error("Please pass the HBase repo URI in the form repo:hbase:zk1,zk2,zk3");
		  throw new IllegalArgumentException("HBase URI is requred: repo:hbase:zk1,zk2,zk3");
	  }
	  else 
		  logger.info("using hbase repo URI: " + args[0]);
	  
    // Construct an HBase dataset repository
    RandomAccessDatasetRepository repo =
        DatasetRepositories.openRandomAccess(args[0]);
    
    // Load the party dataset
    RandomAccessDataset<Party> parties = repo.load("party");

    // Get an accessor for the dataset and look up a party by id
    Key key = new Key.Builder(parties).add("id", "1").build();
    Key key2 = new Key.Builder(parties).add("id", "9").build();
    System.out.println(parties.get(key));
    System.out.println(parties.get(key2));
    
    // Get a reader for the dataset and read all the users
    DatasetReader<Party> reader = parties.newReader();
    try {
      reader.open();
      for (Party party : reader) {
        System.out.println(party);
      }
    } finally {
      reader.close();
    }

    return 0;
  }

  public static void main(String... args) throws Exception {
    int rc = ToolRunner.run(new ReadPartyDataset(), args);
    System.exit(rc);
  }
}
