package com.supsp.shop.model.sys.service.impl.action;

import com.supsp.shop.model.sys.model.SysMemberModel;
import com.supsp.shop.model.sys.service.action.ISysMemberActionService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 Action 服务实现类
 * </p>
 *
 * @author com.supsp
 * @since 2025-08-27 22:34
 */
@Service
@Slf4j
public class SysMemberActionServiceImpl implements ISysMemberActionService {

    @Resource
    private SysMemberModel sysMemberModel;

}
