package com.supsp.shop.controller.admin.ums;

import com.supsp.shop.model.ums.controller.UmsMemberBaseController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/ums/member")
@Tag(name = "AdminUmsMember", description = "用户 [管理端]")
@Slf4j
public class UmsMemberController extends UmsMemberBaseController {

}
