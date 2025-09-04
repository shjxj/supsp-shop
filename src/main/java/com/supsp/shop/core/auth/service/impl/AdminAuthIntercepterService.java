package com.supsp.shop.core.auth.service.impl;

import com.supsp.springboot.core.auth.IAuthAccountService;
import com.supsp.springboot.core.auth.IAuthIntercepterService;
import com.supsp.springboot.core.auth.impl.BaseAuthIntercepterService;
import com.supsp.springboot.core.consts.DataKeys;
import com.supsp.springboot.core.threads.GlobalData;
import com.supsp.springboot.core.vo.auth.AuthAccount;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("adminAuthIntercepter")
@Slf4j
public class AdminAuthIntercepterService extends BaseAuthIntercepterService implements IAuthIntercepterService {

    @Resource(name = "adminAuthAccount")
    private IAuthAccountService authAccountService;

    @Override
    public void preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        AuthAccount authAccount = null;
        try {
            authAccount = (AuthAccount) authAccountService.getAuthAccount();
        } catch (Exception e) {
            log.error(
                    "adminAccountService error: ",
                    e
            );
        }
//        log.debug(
//                """
//                        \n■■■■■ Admin Auth Interceptor
//                        adminAuthAccount: {}
//                        """,
//                JsonUtil.toJSONString(authAccount)
//        );
        GlobalData.set(DataKeys.AUTH_ACCOUNT_ADMIN, authAccount);
    }
}
