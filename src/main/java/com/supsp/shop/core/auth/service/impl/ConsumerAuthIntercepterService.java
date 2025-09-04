package com.supsp.shop.core.auth.service.impl;

import com.supsp.springboot.core.auth.IAuthAccountService;
import com.supsp.springboot.core.auth.IAuthIntercepterService;
import com.supsp.springboot.core.auth.impl.BaseAuthIntercepterService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("consumerAuthIntercepter")
@Slf4j
public class ConsumerAuthIntercepterService extends BaseAuthIntercepterService implements IAuthIntercepterService {

    @Resource(name = "consumerAuthAccount")
    private IAuthAccountService authAccountService;

    @Override
    public void preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    }
}
