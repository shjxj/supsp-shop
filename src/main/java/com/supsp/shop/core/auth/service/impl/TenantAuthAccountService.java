package com.supsp.shop.core.auth.service.impl;

import com.supsp.springboot.core.auth.IAuthAccountService;
import com.supsp.springboot.core.auth.IPassportService;
import com.supsp.springboot.core.auth.impl.BaseAuthAccountService;
import com.supsp.springboot.core.exceptions.AuthException;
import com.supsp.springboot.core.interfaces.IAuthAccount;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("tenantAuthAccount")
@Slf4j
public class TenantAuthAccountService extends BaseAuthAccountService implements IAuthAccountService {

    @Resource(name = "tenantPassportService")
    private IPassportService passportService;

    @Override
    public IAuthAccount getCurrentAuthAccount() throws AuthException {
        return super.getCurrentAuthAccount();
    }
}
