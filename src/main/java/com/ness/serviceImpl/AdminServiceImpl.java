package com.ness.serviceImpl;

import com.ness.entity.Admin;
import java.util.List;

public interface AdminServiceImpl {

    List<Admin> getAllAdmins();

    Admin getAdminById(Integer id);

    boolean addAdmin(Admin admin);

    void updateAdmin(Admin admin);

    void deleteAdmin(Integer id);
}
