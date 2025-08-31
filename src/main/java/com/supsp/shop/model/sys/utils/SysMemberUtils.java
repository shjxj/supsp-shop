package com.supsp.shop.model.sys.utils;

import com.supsp.shop.model.sys.entity.SysMember;
import com.supsp.shop.model.sys.model.SysMemberModel;
import com.supsp.springboot.core.exceptions.ModelException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 用户 Utils
 * </p>
 *
 * @author com.supsp
 * @since 2025-08-27 22:34
 */
@Component
@Slf4j
public class SysMemberUtils {

    private static SysMemberModel sysMemberModel;

    public SysMemberUtils(SysMemberModel sysMemberModel) {
        SysMemberUtils.sysMemberModel = sysMemberModel;
    }

    public static SysMember detail(long id) throws ModelException {
        return sysMemberModel.detail(id);
    }

}
