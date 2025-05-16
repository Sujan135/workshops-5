package com.yearup.contract;

public class ContractDataManager {

    public void saveContract(Contract contract) {

        String filePath = "src/resources/contracts.csv";
        StringBuilder line = new StringBuilder();

        if (contract instanceof SalesContract) {
            SalesContract sale = (SalesContract) contract;

        } else  if (contract instanceof LeaseContract) {
            LeaseContract lease = (LeaseContract) contract;
        }

    }
}
