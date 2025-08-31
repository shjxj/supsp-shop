package com.supsp.shop.model.ums.service.impl.action;

import com.supsp.shop.model.ums.model.UmsMemberModel;
import com.supsp.shop.model.ums.service.action.IUmsMemberActionService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 Action 服务实现类
 * </p>
 *
 * @author com.supsp
 * @since 2025-08-31 17:59
 */
@Service
@Slf4j
public class UmsMemberActionServiceImpl implements IUmsMemberActionService {

    @Resource
    private UmsMemberModel umsMemberModel;

}
