package com.rhialtothemarvellous.newangelesrivalrandomizer;

public enum Federalist implements CorpOrFederalist {
    FEDERALIST(R.string.federalist);
    
    private final int stringID;
    
    Federalist(int stringID) {
        this.stringID = stringID;
    }
    
    @Override
    public int getStringID() {
        return this.stringID;
    }
}
