
package com.ness.controller;


import com.ness.entity.Admin;
import com.ness.serviceImpl.AdminServiceImpl;
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
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;
    
   

    @RequestMapping(value = "/admin/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Admin> getAdminById(@PathVariable("id") Integer id) {
        Admin admin = adminService.getAdminById(id);
        return new ResponseEntity<Admin>(admin, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> list = adminService.getAllAdmins();
        return new ResponseEntity<List<Admin>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addAdmin(@RequestBody Admin admin, UriComponentsBuilder builder) {
        boolean flag = adminService.addAdmin(admin);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/admin/{id}").buildAndExpand(admin.getAdminId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        }
    }

    @RequestMapping(value = "/admin/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) {
        adminService.updateAdmin(admin);
        return new ResponseEntity<Admin>(admin, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteAdmin(@PathVariable("id") Integer id) {
        adminService.deleteAdmin(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
