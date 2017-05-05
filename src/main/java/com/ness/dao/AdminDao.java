package com.ness.dao;
import com.ness.daoImpl.AdminDaoImpl;
import com.ness.entity.Admin;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class AdminDao implements AdminDaoImpl {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
    @Override
    public List<Admin> getAllAdmins() {
        String hql = "FROM Admin as a ORDER BY a.adminId";
        return (List<Admin>) hibernateTemplate.find(hql);
    }

    @Override
    public Admin getAdminById(Integer id) {
        return hibernateTemplate.get(Admin.class, id);
    }

    @Override
    public void addAdmin(Admin admin) {
        hibernateTemplate.save(admin);
    }

    @Override
    public void updateAdmin(Admin admin) {
        Admin a = getAdminById(admin.getAdminId());
        a.setUsername(admin.getUsername());
        a.setPassword(admin.getPassword());

        hibernateTemplate.update(a);
    }

    @Override
    public void deleteAdmin(Integer id) {
        hibernateTemplate.delete(getAdminById(id));
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean adminExists(String username, String password) {
        String hql = "FROM Admin as a WHERE a.username = ? and a.password = ?";
        List<Admin> admin = (List<Admin>) hibernateTemplate.find(hql, username, password);
        return admin.size() > 0 ? true : false;
    }

}
