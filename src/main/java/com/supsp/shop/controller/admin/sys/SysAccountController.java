package com.supsp.shop.controller.admin.sys;

import com.supsp.shop.model.sys.controller.SysAccountBaseController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/sys/account")
@Tag(name = "AdminSysAccount", description = "登录账号 [管理端]")
@Slf4j
public class SysAccountController extends SysAccountBaseController {

}
