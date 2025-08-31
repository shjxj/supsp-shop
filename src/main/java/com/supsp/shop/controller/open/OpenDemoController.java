package com.supsp.shop.controller.open;

import com.supsp.springboot.core.base.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/open/demo")
@Tag(name = "OpenDemo", description = "Demo")
@Slf4j
public class OpenDemoController extends BaseController {

    @GetMapping("/ping")
    @Operation(summary = "Ping")
    public String ping() {
        return "pong";
    }

}
