package com.application.product.product.service;

import com.application.product.product.entity.User;
import com.application.product.product.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsServices implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    public User createUser(User user){
      return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user=userRepository.findByUsername(username);
        if(user.isEmpty()) throw new UsernameNotFoundException("User Not Found ");
        return user.;
    }
}
