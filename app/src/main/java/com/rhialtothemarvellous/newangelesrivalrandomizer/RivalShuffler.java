package com.rhialtothemarvellous.newangelesrivalrandomizer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RivalShuffler {
    public Map<CorpOrUnused, CorpOrFederalist> shuffle(List<Corp> selectedCorps) {
        int numCards = selectedCorps.size() + 1;
        
        // Prepare the return value
        Map<CorpOrUnused, CorpOrFederalist> result = new HashMap<>(numCards);
        
        // Get LSH and RHS arrays
        CorpOrUnused[] players = selectedCorps.toArray(new CorpOrUnused[numCards]);
        players[numCards - 1] = Unused.UNUSED;
        
        CorpOrFederalist[] rivals = selectedCorps.toArray(new CorpOrFederalist[numCards]);
        rivals[numCards - 1] = Federalist.FEDERALIST;
        
        // Shuffle the RHS
        do {
            shuffleArray(rivals);
        } while (!isValidShuffle(players, rivals));
        
        for (int i = 0; i < numCards; i++) {
            result.put(players[i], rivals[i]);
        }
        
        return result;
    }
    
    private boolean isValidShuffle(CorpOrUnused[] players, CorpOrFederalist[] rivals) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == rivals[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    private void shuffleArray(Object[] array) {
        Random random = new Random();
        int index;
        Object a;
    
        for (int i = array.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            a = array[index];
            array[index] = array[i];
            array[i] = a;
        }
    }
}
