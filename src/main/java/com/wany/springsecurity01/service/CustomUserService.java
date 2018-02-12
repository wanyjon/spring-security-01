package com.wany.springsecurity01.service;

import com.wany.springsecurity01.bean.SysUser;
import com.wany.springsecurity01.dao.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class CustomUserService implements UserDetailsService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        System.out.println("s:"+username);
        System.out.println("username:"+user.getUsername()+";password:"+user.getPassword());
        return user;
    }

    public void save(SysUser user) {
        System.out.println(passwordEncoder);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        sysUserRepository.save(user);
    }
}
