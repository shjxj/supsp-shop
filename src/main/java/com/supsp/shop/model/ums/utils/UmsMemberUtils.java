package com.supsp.shop.model.ums.utils;

import com.supsp.shop.model.ums.entity.UmsMember;
import com.supsp.shop.model.ums.model.UmsMemberModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.supsp.springboot.core.exceptions.ModelException;

/**
 * <p>
 * 用户 Utils
 * </p>
 *
 * @author com.supsp
 * @since 2025-08-31 17:59
 */
@Component
@Slf4j
public class UmsMemberUtils {

    private static UmsMemberModel umsMemberModel;

    public UmsMemberUtils(UmsMemberModel umsMemberModel) {
        UmsMemberUtils.umsMemberModel = umsMemberModel;
    }

    public static UmsMember detail(long id) throws ModelException {
        return umsMemberModel.detail(id);
    }

}
