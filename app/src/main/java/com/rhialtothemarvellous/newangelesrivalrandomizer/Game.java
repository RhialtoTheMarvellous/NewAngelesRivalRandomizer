package com.rhialtothemarvellous.newangelesrivalrandomizer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Stores state information about a game of New Angeles.
 */
public class Game implements Serializable {
    private final ArrayList<Corp> mPlayers;
    private final HashMap<CorpOrUnused, CorpOrFederalist> mRivals;

    public Game(List<Corp> players) {
        mPlayers = new ArrayList<>(players);

        RivalShuffler shuffler = new RivalShuffler();

        mRivals = shuffler.shuffle(players);
    }
    
    /**
     * Get the list of Corps playing in this game.
     */
    public List<Corp> getPlayers() {
        return mPlayers;
    }
    
    /**
     * Get a specified Corp's current rival card.
     */
    public CorpOrFederalist getRival(Corp player) {
        return mRivals.get(player);
    }
    
    /**
     * Get the current unused rival card.
     */
    public CorpOrFederalist getUnusedCard() {
        return mRivals.get(Unused.UNUSED);
    }
    
    /**
     * Switch a specified Corp's current rival card with the unused card.
     */
    public void thomasHaas(Corp player) {
        // TODO
    }
}
