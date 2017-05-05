package com.ness.service;
import com.ness.serviceImpl.AdminServiceImpl;
import com.ness.daoImpl.AdminDaoImpl;
import com.ness.entity.Admin;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements AdminServiceImpl {

    @Autowired
    private AdminDaoImpl adminDao;

    @Override
    public List<Admin> getAllAdmins() {
        return adminDao.getAllAdmins();
    }
    
    @Override
    public Admin getAdminById(Integer id) {
        Admin obj = adminDao.getAdminById(id);
        return obj;
    }
    
    @Override
    public boolean addAdmin(Admin admin) {
        if (adminDao.adminExists(admin.getUsername(), admin.getPassword())) {
            return false;
        } else {
            adminDao.addAdmin(admin);
            return true;
        }
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminDao.updateAdmin(admin);
    }
    
    @Override
    public void deleteAdmin(Integer id) {
        adminDao.deleteAdmin(id);
    }
    
}
