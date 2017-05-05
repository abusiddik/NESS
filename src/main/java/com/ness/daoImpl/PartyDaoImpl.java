
package com.ness.daoImpl;

import com.ness.entity.Party;
import java.util.List;


public interface PartyDaoImpl {
 List<Party> getAllPartys();

    Party getPartyById(Long id);

    void addParty(Party party);

    void updateParty(Party party);

    void deleteParty(Long id);

    boolean partyExists(String partyname);
}
