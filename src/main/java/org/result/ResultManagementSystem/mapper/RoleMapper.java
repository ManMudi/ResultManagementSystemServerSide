package org.result.ResultManagementSystem.mapper;

import org.result.ResultManagementSystem.dto.RoleDto;
import org.result.ResultManagementSystem.entity.Role;

public class RoleMapper {

    public static RoleDto mapToRoleDto(Role role){
        return new RoleDto(
                role.getId(),
                role.getName()
        );

    }

    public static Role mapToRole(RoleDto roleDto){
        Role role=new Role();
        role.setId(roleDto.getId());
        role.setName(roleDto.getName());
        return role;
    }

}
