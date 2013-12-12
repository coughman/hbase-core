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

import java.util.ArrayList;
import java.util.List;

import com.cloudera.cdk.data.DatasetReader;
import com.cloudera.cdk.data.DatasetRepositories;
import com.cloudera.cdk.data.Key;
import com.cloudera.cdk.data.RandomAccessDataset;
import com.cloudera.cdk.data.RandomAccessDatasetRepository;
import com.cloudera.cdk.hbase.data.PartyAddress;
import com.cloudera.cdk.hbase.data.PartyAgreement;

/**
 * Read the party objects from the parties dataset by key lookup, and by scanning.
 */

public class PartyAgreementDatasetService {

  public PartyAgreement get(String party_id, String agreement_id) throws Exception {

    // Construct an HBase dataset repository using the local HBase database
    RandomAccessDatasetRepository repo =
        DatasetRepositories.openRandomAccess("repo:hbase:localhost.localdomain");

    // Load the parties dataset
    RandomAccessDataset<PartyAgreement> partyAgreements = repo.load("party_agreement");

    // Get an accessor for the dataset and look up a party by id
    Key key = new Key.Builder(partyAgreements)
                    .add("party_id", party_id)
                    .add("agreement_id", agreement_id)
                    .build();
                    
    return partyAgreements.get(key);

  }

  public List<PartyAgreement>  scan(String partyId) throws Exception {
    List<PartyAgreement> ls=new ArrayList<PartyAgreement>(); 

    // Construct an HBase dataset repository using the local HBase database
    RandomAccessDatasetRepository repo =
        DatasetRepositories.openRandomAccess("repo:hbase:localhost.localdomain");

    // Load the party_address dataset
    RandomAccessDataset<PartyAgreement> partyAgreements = repo.load("party_agreement");

    // Get a reader for the dataset and read all the users
    DatasetReader<PartyAgreement> reader = partyAgreements.newReader();
    try {
      reader.open();
      for (PartyAgreement partyAgreement : reader) {
        if(partyAgreement.getPartyId().toString().equals(partyId)){
          ls.add(partyAgreement);
        }
      }
    } finally {
      reader.close();
    }
    return ls;
  }

}