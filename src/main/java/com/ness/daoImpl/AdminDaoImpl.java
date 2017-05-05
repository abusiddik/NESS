
package com.ness.daoImpl;

import com.ness.entity.Admin;
import java.util.List;


public interface AdminDaoImpl {
 List<Admin> getAllAdmins();

    Admin getAdminById(Integer id);

    void addAdmin(Admin admin);

    void updateAdmin(Admin admin);

    void deleteAdmin(Integer id);

    boolean adminExists(String username, String password);
}
