package com.ness.serviceImpl;

import com.ness.entity.Party;
import java.util.List;

public interface PartyServiceImpl {

    List<Party> getAllPartys();

    Party getPartyById(Long id);

    boolean addParty(Party party);

    void updateParty(Party party);

    void deleteParty(Long id);
}
