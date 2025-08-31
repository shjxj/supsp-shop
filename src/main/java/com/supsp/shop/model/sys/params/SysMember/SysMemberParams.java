package com.supsp.shop.model.sys.params.SysMember;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.supsp.shop.model.sys.entity.SysMember;
import com.supsp.springboot.core.annotations.DbParamField;
import com.supsp.springboot.core.annotations.DbParams;
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
 * 用户 查询参数
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
@Schema(name = "SysMemberParams", description = "用户 查询参数")
public class SysMemberParams extends BaseEntityParams<SysMember> implements IEntityParams<SysMember> {

    @Serial
    private static final long serialVersionUID = -2593046606821944307L;

    /**
     * unix 时间戳 [无需前端设置]
     */
    @Schema(title = "unix 时间戳", description = "无需前端设置")
    @JsonIgnore
    private Long currentTimestamp;


    @Schema(title = "用户ID")
    @DbParamField(property = "memberId", column = "member_id", type = QueryType.eq)
    private Long memberId;

    @Schema(title = "姓名")
    @DbParamField(property = "memberName", column = "member_name", type = QueryType.eq)
    private String memberName;

    @Schema(title = "身份证号")
    @DbParamField(property = "memberIdnumber", column = "member_idnumber", type = QueryType.eq)
    private String memberIdnumber;

    @Schema(title = "联系手机号")
    @DbParamField(property = "memberPhone", column = "member_phone", type = QueryType.eq)
    private String memberPhone;

    @Schema(title = "备注")
    @DbParamField(property = "memberMemo", column = "member_memo", type = QueryType.eq)
    private String memberMemo;

    @Schema(title = "头像")
    @DbParamField(property = "memberAvatar", column = "member_avatar", type = QueryType.eq)
    private Long memberAvatar;

    @Schema(title = "系统数据")
    @DbParamField(property = "isSystem", column = "is_system", type = QueryType.eq)
    private Short isSystem;

    @Schema(title = "商户ID")
    @DbParamField(property = "merchantId", column = "merchant_id", type = QueryType.eq)
    private Long merchantId;

    @Schema(title = "租户ID")
    @DbParamField(property = "tenantId", column = "tenant_id", type = QueryType.eq)
    private Long tenantId;

}
