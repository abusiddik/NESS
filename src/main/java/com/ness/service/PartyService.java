package com.ness.service;
import com.ness.serviceImpl.PartyServiceImpl;
import com.ness.daoImpl.PartyDaoImpl;
import com.ness.entity.Party;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyService implements PartyServiceImpl {

    @Autowired
    private PartyDaoImpl partyDao;

    @Override
    public List<Party> getAllPartys() {
        return partyDao.getAllPartys();
    }
    
    @Override
    public Party getPartyById(Long id) {
        Party obj = partyDao.getPartyById(id);
        return obj;
    }
    
    @Override
    public boolean addParty(Party party) {
        if (partyDao.partyExists(party.getPartyName())) {
            return false;
        } else {
            partyDao.addParty(party);
            return true;
        }
    }

    @Override
    public void updateParty(Party party) {
        partyDao.updateParty(party);
    }
    
    @Override
    public void deleteParty(Long id) {
        partyDao.deleteParty(id);
    }
    
}
