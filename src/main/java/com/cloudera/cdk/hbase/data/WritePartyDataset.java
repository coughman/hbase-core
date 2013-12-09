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

import com.cloudera.cdk.data.DatasetRepositories;
import com.cloudera.cdk.data.RandomAccessDataset;
import com.cloudera.cdk.data.RandomAccessDatasetRepository;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * Write some party objects to the parties dataset using Avro specific records.
 */
public class WritePartyDataset extends Configured implements Tool {

  @Override
  public int run(String[] args) throws Exception {

    // Construct an HBase dataset repository using the local HBase database
    RandomAccessDatasetRepository repo =
        DatasetRepositories.openRandomAccess("repo:hbase:localhost.localdomain");

    // Load the parties dataset
    RandomAccessDataset<Party> parties = repo.load("parties");

    // Get an accessor for the dataset and write some parties to it
    parties.put(party("1", "aaa"));
    parties.put(party("2", "bbb"));
    parties.put(party("3", "ccc"));
    parties.put(party("4", "ddd"));

    return 0;
  }

  private static Party party(String id, String description) {
    return Party.newBuilder()
        .setId(id)
        .setDescription(description)
        .setCreated(System.currentTimeMillis())
        .build();
  }

  public static void main(String... args) throws Exception {
    int rc = ToolRunner.run(new WritePartyDataset(), args);
    System.exit(rc);
  }
}
