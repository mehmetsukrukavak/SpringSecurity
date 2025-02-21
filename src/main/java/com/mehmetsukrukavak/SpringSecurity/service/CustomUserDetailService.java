package com.mehmetsukrukavak.SpringSecurity.service;

import com.mehmetsukrukavak.SpringSecurity.model.User;
import com.mehmetsukrukavak.SpringSecurity.model.UserPrincipal;
import com.mehmetsukrukavak.SpringSecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       User user =  repo.findByUsername(username);
       if (user == null) {
           throw new UsernameNotFoundException(username + " not found");
       }
        return new UserPrincipal(user);
    }
}
