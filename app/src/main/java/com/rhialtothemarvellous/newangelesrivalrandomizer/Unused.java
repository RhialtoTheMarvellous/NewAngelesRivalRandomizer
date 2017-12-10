package com.rhialtothemarvellous.newangelesrivalrandomizer;

public enum Unused implements CorpOrUnused {
    UNUSED(R.string.unused);
    
    private final int stringID;
    
    Unused(int stringID) {
        this.stringID = stringID;
    }
    
    @Override
    public int getStringID() {
        return this.stringID;
    }
}
