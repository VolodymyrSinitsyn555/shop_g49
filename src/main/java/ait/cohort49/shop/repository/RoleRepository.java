package ait.cohort49.shop.repository;

import ait.cohort49.shop.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findRoleByTitle(String title);
}
