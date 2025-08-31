package com.supsp.shop.model.sys.params.SysAccount;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.supsp.shop.model.sys.entity.SysAccount;
import com.supsp.springboot.core.annotations.DbParamField;
import com.supsp.springboot.core.annotations.DbParams;
import com.supsp.springboot.core.enums.AccountType;
import com.supsp.springboot.core.enums.QueryType;
import com.supsp.springboot.core.model.BaseEntityParams;
import com.supsp.springboot.core.model.IEntityParams;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;

/**
 * <p>
 * 登录账号 查询参数
 * </p>
 *
 * @author com.supsp
 * @since 2025-08-27 22:34
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Slf4j
@DbParams
@Schema(name = "SysAccountParams", description = "登录账号 查询参数")
public class SysAccountParams extends BaseEntityParams<SysAccount> implements IEntityParams<SysAccount> {

    @Serial
    private static final long serialVersionUID = -8790462379117367504L;

    /**
     * unix 时间戳 [无需前端设置]
     */
    @Schema(title = "unix 时间戳", description = "无需前端设置")
    @JsonIgnore
    private Long currentTimestamp;


    @Schema(title = "账号ID")
    @DbParamField(property = "accountId", column = "account_id", type = QueryType.eq)
    private Long accountId;

    @Schema(title = "用户ID")
    @DbParamField(property = "memberId", column = "member_id", type = QueryType.eq)
    private Long memberId;

    @Schema(title = "account")
    @DbParamField(property = "accountType", column = "account_type", type = QueryType.eq)
    private AccountType accountType;

    @Schema(title = "登录账号")
    @DbParamField(property = "loginAccount", column = "login_account", type = QueryType.eq)
    private String loginAccount;

    @Schema(title = "登录密码")
    @DbParamField(property = "loginPwd", column = "login_pwd", type = QueryType.eq)
    private String loginPwd;

    @Schema(title = "系统数据")
    @DbParamField(property = "isSystem", column = "is_system", type = QueryType.eq)
    private Short isSystem;

}
