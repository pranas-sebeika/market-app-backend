package sebeikapranas.backend.service;

import org.springframework.stereotype.Service;
import sebeikapranas.backend.entity.Role;
import sebeikapranas.backend.entity.constants.Roles;
import sebeikapranas.backend.repository.RoleRepository;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getRoleByName(Roles roles) {
        return roleRepository.findByType(roles.toString());
    }
}
