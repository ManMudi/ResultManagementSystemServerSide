package org.result.ResultManagementSystem.service.impl;

import lombok.AllArgsConstructor;
import org.result.ResultManagementSystem.dto.RoleDto;
import org.result.ResultManagementSystem.entity.Role;
import org.result.ResultManagementSystem.mapper.RoleMapper;
import org.result.ResultManagementSystem.repository.RoleRepository;
import org.result.ResultManagementSystem.service.RoleService;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoleServiceImple implements RoleService {

    private RoleRepository roleRepository;
    @Override
    public RoleDto createRole(RoleDto roleDto) {
        Role role= RoleMapper.mapToRole(roleDto);
        Role role1=roleRepository.save(role);
        return RoleMapper.mapToRoleDto(role1);
    }
}
