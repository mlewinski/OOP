package com.pk;

import java.util.Arrays;

/**
 * Created by mlewinski on 10/29/17.
 */
public class StopWithTransfer extends Stop{
    protected String[] Transfers;

    public StopWithTransfer(){
        super("-", null, 0, 0);
        Transfers = null;
    }

    public StopWithTransfer(String Name, String... transfers){
        super(Name);
        AssignTransfers(transfers);
    }
    public StopWithTransfer(String Name, String Next, int meters, int minutes, String... transfers){
        super(Name, Next, meters, minutes);
        AssignTransfers(transfers);
    }

    private void AssignTransfers(String... transfers){
        if(transfers.length!=0){
            Transfers = new String[transfers.length];
            Arrays.copyOf(transfers, transfers.length);
        }
    }

    @Override
    public String toString(){
        String s = super.toString();
        String r = "Transfers : \n";
        int i = 0;
        for(String t : Transfers) r+=(i+" - "+t);
        return s+r;
    }
}
