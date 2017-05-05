
package com.ness.controller;


import com.ness.entity.Party;
import com.ness.serviceImpl.PartyServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;


@Controller
@RequestMapping("/")
public class PartyController {

    @Autowired
    private PartyServiceImpl partyService;
    
   

    @RequestMapping(value = "/party/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Party> getPartyById(@PathVariable("id") Long id) {
        Party party = partyService.getPartyById(id);
        return new ResponseEntity<Party>(party, HttpStatus.OK);
    }

    @RequestMapping(value = "/party", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Party>> getAllPartys() {
        List<Party> list = partyService.getAllPartys();
        return new ResponseEntity<List<Party>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/party", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addParty(@RequestBody Party party, UriComponentsBuilder builder) {
        boolean flag = partyService.addParty(party);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/party/{id}").buildAndExpand(party.getPartyId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        }
    }

    @RequestMapping(value = "/party/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Party> updateParty(@RequestBody Party party) {
        partyService.updateParty(party);
        return new ResponseEntity<Party>(party, HttpStatus.OK);
    }

    @RequestMapping(value = "/party/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteParty(@PathVariable("id") Long id) {
        partyService.deleteParty(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
