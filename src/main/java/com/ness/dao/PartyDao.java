package com.ness.dao;
import com.ness.daoImpl.PartyDaoImpl;
import com.ness.entity.Party;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class PartyDao implements PartyDaoImpl {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
    @Override
    public List<Party> getAllPartys() {
        String hql = "FROM Party as a ORDER BY a.partyId";
        return (List<Party>) hibernateTemplate.find(hql);
    }

    @Override
    public Party getPartyById(Long id) {
        return hibernateTemplate.get(Party.class, id);
    }

    @Override
    public void addParty(Party party) {
        hibernateTemplate.save(party);
    }

    @Override
    public void updateParty(Party party) {
     //   Party a = getPartyById(party.getPartyId());
     //   a.setPartyName(party.getPartyName());
     

      //  hibernateTemplate.update(a);
    }

    @Override
    public void deleteParty(Long id) {
        hibernateTemplate.delete(getPartyById(id));
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean partyExists(String partyname) {
        String hql = "FROM Party as a WHERE a.partyName = ?";
        List<Party> party = (List<Party>) hibernateTemplate.find(hql, partyname);
        return party.size() > 0 ? true : false;
    }

}
