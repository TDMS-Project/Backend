package com.blogs.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogs.pojos.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, Integer> {
    // Change 'findByName' to 'findByRoleName'
    Role findByRoleName(String roleName);
}
