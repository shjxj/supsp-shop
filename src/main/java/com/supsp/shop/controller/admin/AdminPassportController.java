package com.supsp.shop.controller.admin;

import com.supsp.shop.core.auth.service.IAdminPassportService;
import com.supsp.shop.core.auth.vo.LoginData;
import com.supsp.shop.core.auth.vo.LoginParams;
import com.supsp.springboot.core.exceptions.ModelException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/passport")
@Tag(name = "AdminPassport", description = "通行证")
@Slf4j
public class AdminPassportController {

    @Resource
    private IAdminPassportService adminPassportService;

    @PostMapping("/login")
    @Operation(summary = "登录")
    public LoginData login(
            @RequestBody LoginParams params
    ) throws ModelException {
        return adminPassportService.login(params);
    }

    @PostMapping("/auth")
    @Operation(summary = "获取登录信息")
    public LoginData auth() throws ModelException {
        return adminPassportService.auth();
    }

}
