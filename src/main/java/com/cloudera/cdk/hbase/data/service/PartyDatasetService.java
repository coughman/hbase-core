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
package com.cloudera.cdk.hbase.data.service;

import org.kitesdk.data.Key;
import org.kitesdk.data.RandomAccessDataset;

import com.cloudera.cdk.hbase.data.avro.Party;

/**
 * Read the party objects from the parties dataset by key lookup, and by
 * scanning.
 */
public class PartyDatasetService extends AbstractHBaseService {

	public Party get(String id) throws Exception {
		
		// Load the parties dataset
		RandomAccessDataset<Party> parties = repo.load("party");

		// Get an accessor for the dataset and look up a party by id
		Key key = new Key.Builder(parties).add("id", id).build();
		return parties.get(key);

	}

}
