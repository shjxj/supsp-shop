package com.supsp.shop.core.auth.service;

import com.supsp.shop.core.auth.vo.LoginData;
import com.supsp.shop.core.auth.vo.LoginParams;
import com.supsp.springboot.core.exceptions.ModelException;
import jakarta.servlet.http.HttpServletRequest;

public interface IAdminPassportService {

    LoginData login(LoginParams params) throws ModelException;

    String authToken(HttpServletRequest servletRequest);

    LoginData auth() throws ModelException;
}
