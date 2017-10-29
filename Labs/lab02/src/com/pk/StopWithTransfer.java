package com.pk;

import java.util.Arrays;

/**
 * Created by mlewinski on 10/29/17.
 */
public class StopWithTransfer extends Stop{
    protected String[] Transfers;

    StopWithTransfer(){
        super("-", null, 0, 0);
        Transfers = null;
    }

    private void AssignTransfers(String... transfers){
        if(transfers.length!=0){
            Transfers = new String[transfers.length];
            Arrays.copyOf(transfers, transfers.length);
        }
    }
}
