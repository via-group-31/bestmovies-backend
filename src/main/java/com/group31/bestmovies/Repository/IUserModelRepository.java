package com.group31.bestmovies.Repository;

import com.group31.bestmovies.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserModelRepository extends JpaRepository<UserModel, Long> {
    UserModel findByUsername(String username);
}
