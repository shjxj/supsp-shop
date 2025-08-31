package com.supsp.shop.model.sys.params.SysAccount;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.supsp.shop.model.sys.entity.SysAccount;
import com.supsp.springboot.core.annotations.DbRequest;
import com.supsp.springboot.core.model.BaseEntityRequest;
import com.supsp.springboot.core.model.IEntityRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;

/**
 * <p>
 * 登录账号 查询
 * </p>
 *
 * @author com.supsp
 * @since 2025-08-27 22:34
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Slf4j
@DbRequest
@Schema(name = "SysAccountRequest", description = "登录账号 查询")
public class SysAccountRequest
        extends BaseEntityRequest<SysAccountParams, SysAccountFilter, SysAccount> implements IEntityRequest<SysAccountParams, SysAccountFilter, SysAccount> {

    @Serial
    private static final long serialVersionUID = 865803329509573947L;

    /**
     * unix 时间戳 [无需前端设置]
     */
    @Schema(title = "unix 时间戳", description = "无需前端设置")
    @JsonIgnore
    private Long currentTimestamp;

}
