package com.rhialtothemarvellous.newangelesrivalrandomizer;

public enum Corp implements CorpOrFederalist, CorpOrUnused {
    GLOBALSEC(R.string.corp_globalsec),
    HAASBIOROID(R.string.corp_haasbioroid),
    JINTEKI(R.string.corp_jinteki),
    MELANGE(R.string.corp_melange),
    NBN(R.string.corp_nbn),
    WEYLAND(R.string.corp_weyland);
    
    private final int stringID;
    
    Corp(int stringID) {
        this.stringID = stringID;
    }
    
    public int getStringID() {
        return this.stringID;
    }
}
