package com.swingapplication.foofast.controllers;

import com.swingapplication.foofast.daos.userDAO.IUserDAO;
import com.swingapplication.foofast.daos.userDAO.UserDAO;
import com.swingapplication.foofast.dtos.responses.ListUserResponse;
import com.swingapplication.foofast.dtos.responses.UserResponse;
import com.swingapplication.foofast.mappers.UserMapper;
import lombok.extern.log4j.Log4j2;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class UserController {

    private final IUserDAO userDAO;
    private final UserMapper userMapper;

    public UserController() {
        this.userDAO = new UserDAO();
        userMapper = UserMapper.getInstance();
    }

    public ListUserResponse getAllUsers(String key, int pageSize) {
        int totalUsers = userDAO.countUsersByKey(key);
        log.info(totalUsers);
        int totalPages = (int) Math.ceil((double) totalUsers / (pageSize == 0 ? 10 : pageSize));

        return ListUserResponse.builder()
                .totalPages(0)
                .userResponses(userDAO.findAll()
                        .stream()
                        .map(userMapper::mapToUserResponse)
                        .collect(Collectors.toList()))
                .build();
        // In case no elements are found, return an empty list
    }
}
