package com.clarkamurray.pbs.service;

import com.clarkamurray.pbs.config.AbstractTableService;
import com.clarkamurray.pbs.repository.UserRepository;
import com.clarkamurray.pbs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserService extends AbstractTableService<User, Long> implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        Collection<? extends GrantedAuthority> authorities = getAuthorities();
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    private Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("READ_AUTHORITY"));
        return authorities;
    }

//    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
//        return getGrantedAuthorities(getPrivileges(user));
//    }
//
//    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        for (String privilege : privileges) {
//            authorities.add(new SimpleGrantedAuthority(privilege));
//        }
//        return authorities;
//    }
//
//    private List<String> getPrivileges(User user) {
//        List<String> result = new ArrayList<>();
//        result.add("USER");
////        for(Privilege p : user.getPrivileges()) {
////            result.add(p.getName());
////        }
////        for (Role role : user.getRoles()) {
////            for(Privilege p : role.getPrivileges()){
////                result.add(p.getName());
////            }
////        }
//        return result;
//    }

}
