package com.supsp.shop.core.auth.service.impl;

import com.supsp.springboot.core.auth.IAuthAccountService;
import com.supsp.springboot.core.auth.IPassportService;
import com.supsp.springboot.core.auth.impl.BaseAuthAccountService;
import com.supsp.springboot.core.enums.AuthMemberType;
import com.supsp.springboot.core.exceptions.AuthException;
import com.supsp.springboot.core.helper.AuthCommon;
import com.supsp.springboot.core.interfaces.IAuthAccount;
import com.supsp.springboot.core.vo.auth.AuthAccount;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

@Service("adminAuthAccount")
@Slf4j
public class AdminAuthAccountService extends BaseAuthAccountService implements IAuthAccountService {

    @Resource(name = "adminPassportService")
    private IPassportService passportService;

    @Override
    public IAuthAccount getCurrentAuthAccount() throws AuthException {
        AuthMemberType authMemberType = AuthCommon.authMemberType(request);
        if (authMemberType == null || !authMemberType.equals(AuthMemberType.admin)) {
            return null;
        }
        try {
            AuthAccount account = (AuthAccount) AuthCommon.adminAuthAccount();
            if (ObjectUtils.isNotEmpty(account)) {
                return account;
            }
            return passportService.auth(request);
        } catch (Exception e) {
//            log.error("AdminAccountService getCurrentAuthAccount exception", e);
        }
        return null;
    }
}
