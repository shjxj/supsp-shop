package com.supsp.shop.controller.admin.sys;

import com.supsp.shop.model.sys.controller.SysMemberBaseController;
import com.supsp.springboot.core.auth.annotations.RequiresRoles;
import com.supsp.springboot.core.consts.Constants;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/sys/member")
@Tag(name = "AdminSysMember", description = "用户 [管理端]")
@Slf4j
@RequiresRoles(
        value = {
                Constants.PERMISSION_ROLE_ADMIN,
                Constants.PERMISSION_ROLE_TENANT,
                Constants.PERMISSION_ROLE_MERCHANT,
                Constants.PERMISSION_ROLE_CONSUMER,
                Constants.PERMISSION_ROLE_API,
                Constants.PERMISSION_ROLE_USER
        }
)
public class SysMemberController extends SysMemberBaseController {

}
