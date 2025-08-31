package com.supsp.shop.model.sys.utils;

import com.supsp.shop.model.sys.entity.SysAccount;
import com.supsp.shop.model.sys.model.SysAccountModel;
import com.supsp.springboot.core.exceptions.ModelException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 登录账号 Utils
 * </p>
 *
 * @author com.supsp
 * @since 2025-08-27 22:34
 */
@Component
@Slf4j
public class SysAccountUtils {

    private static SysAccountModel sysAccountModel;

    public SysAccountUtils(SysAccountModel sysAccountModel) {
        SysAccountUtils.sysAccountModel = sysAccountModel;
    }

    public static SysAccount detail(long id) throws ModelException {
        return sysAccountModel.detail(id);
    }

}
