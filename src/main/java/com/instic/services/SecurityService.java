package com.instic.services;

/**
 * Created by mickaelvillers on 21/03/2017.
 */
public interface SecurityService {
    String findLoggedInLogin();

    void autologin(String login, String password);
}