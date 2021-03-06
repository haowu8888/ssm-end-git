package com.service.impl;

import com.dao.UsersDao;
import com.domain.Users;
import com.github.pagehelper.PageHelper;
import com.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersDao usersDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersDao.findByName(username);
        User user = new User(users.getUsername(), users.getPassword(), getAuthority(users.getRole()));
       // User user1 = new User(users.getUsername(), users.getPassword(),users.getStatus()==9?true:false,true,true,true, getAuthority(users.getRole()));
        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(int role) {
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        if (role==1)
            authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
        if (role==99){
            authorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return authorityList;
    }

    @Override
    public List<Users> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        return usersDao.findAll();
    }

    @Override
    public void saveUsers(Users users) {
        //进行密码加密
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        usersDao.saveUsers(users);
    }

    @Override
    public void updateUsers(Users users) {
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        usersDao.updateUsers(users);
    }

    @Override
    public void deleteUsers(Integer id) {
        usersDao.deleteUsers(id);
    }

    @Override
    public Users findById(Integer id) {
        Users users=usersDao.findById(id);
        return users;
    }


}
