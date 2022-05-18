package com.group31.bestmovies.Webservice.Service;

import com.group31.bestmovies.Model.UserModel;
import com.group31.bestmovies.Model.UserRole;
import com.group31.bestmovies.Repository.IUserRepository;
import com.group31.bestmovies.Repository.IUserRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService implements UserDetailsService {
    private final IUserRepository userRepository;
    private final IUserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(UserModel userModel) {
        userModel.setUserPassword(passwordEncoder.encode(userModel.getUserPassword()));
        userRepository.save(userModel);
        addRoleToUser(userModel.getUserEmail(), "role_user");
    }

    private void addRoleToUser(String userEmail, String roleName) {
        UserModel user = userRepository.findByUserEmail(userEmail);
        UserRole userRole = userRoleRepository.findByRoleName(roleName);
        user.getUserRoles().add(userRole);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userRepository.findByUserEmail(username);
        if (userModel == null) {
            throw new UsernameNotFoundException("Username is not found");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        userModel.getUserRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });

        return new User(userModel.getUserEmail(), userModel.getUserPassword(), authorities);
    }
}
