package com.supsp.shop.model.sys.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.supsp.shop.model.sys.entity.SysAccount;
import com.supsp.springboot.core.annotations.DbVo;
import com.supsp.springboot.core.annotations.DbVoField;
import com.supsp.springboot.core.enums.AccountType;
import com.supsp.springboot.core.enums.EnableStatus;
import com.supsp.springboot.core.model.BaseEntityVo;
import com.supsp.springboot.core.model.IEntityVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;

/**
 * <p>
 * 登录账号 VO
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
@DbVo
@Schema(name = "SysAccountVo", description = "登录账号 Vo")
public class SysAccountVo
        extends BaseEntityVo<SysAccount> implements IEntityVo<SysAccount> {

    @Serial
    private static final long serialVersionUID = -5220379644444151927L;

    /**
     * unix 时间戳  [无需前端设置]
     */
    @Schema(title = "unix 时间戳", description = "无需前端设置")
    @DbVoField(exists = false)
    @JsonIgnore
    private Long currentTimestamp;


    @Schema(title = "账号ID")
    @DbVoField(property = "accountId", column = "account_id")
    private Long accountId;

    @Schema(title = "用户ID")
    @DbVoField(property = "memberId", column = "member_id")
    private Long memberId;

    @Schema(title = "account")
    @DbVoField(property = "accountType", column = "account_type")
    private AccountType accountType;

    @Schema(title = "登录账号")
    @DbVoField(property = "loginAccount", column = "login_account")
    private String loginAccount;

    @Schema(title = "登录密码")
    @DbVoField(property = "loginPwd", column = "login_pwd")
    private String loginPwd;

    @Schema(title = "系统数据")
    @DbVoField(property = "isSystem", column = "is_system")
    private Short isSystem;

    @Schema(title = "启用状态")
    @DbVoField(property = "enableStatus", column = "enable_status")
    private EnableStatus enableStatus;

}
