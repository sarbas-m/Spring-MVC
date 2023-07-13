

package com.faith.demo.repository;

import com.faith.demo.entity.Role;

import java.util.List;

public interface IRoleDao {

    List<Role> getAllRoles();

    Role getRoleById(int id);

    void addRole(Role role);

    void updateRole(Role role);

    void deleteRole(int id);
}

