package com.instic.services;

import com.instic.entity.User;

/**
 * Created by mickaelvillers on 21/03/2017.
 */
public interface UserService {
    void save(User user);

    User findByLogin(String login);
}
