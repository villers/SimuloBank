package com.instic.services;

import com.instic.entity.User;

/**
 * Created by mickaelvillers on 21/03/2017.
 */
public interface UserService {
    User findByLogin(String login);
    User findByEmail(String email);
    void save(User user);
}
