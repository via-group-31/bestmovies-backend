package com.group31.bestmovies.Repository;

import com.group31.bestmovies.Model.Movie;
import com.group31.bestmovies.Model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findByRoleName(String roleName);
}
