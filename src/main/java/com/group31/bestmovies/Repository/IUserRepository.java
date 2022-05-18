package com.group31.bestmovies.Repository;

import com.group31.bestmovies.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByUserEmail(String userEmail);
}
