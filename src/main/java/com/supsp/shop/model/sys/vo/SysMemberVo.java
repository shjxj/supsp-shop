package com.supsp.shop.model.sys.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.supsp.shop.model.sys.entity.SysMember;
import com.supsp.springboot.core.annotations.DbVo;
import com.supsp.springboot.core.annotations.DbVoField;
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
 * 用户 VO
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
@Schema(name = "SysMemberVo", description = "用户 Vo")
public class SysMemberVo
        extends BaseEntityVo<SysMember> implements IEntityVo<SysMember> {

    @Serial
    private static final long serialVersionUID = 4164015837221042815L;

    /**
     * unix 时间戳  [无需前端设置]
     */
    @Schema(title = "unix 时间戳", description = "无需前端设置")
    @DbVoField(exists = false)
    @JsonIgnore
    private Long currentTimestamp;


    @Schema(title = "用户ID")
    @DbVoField(property = "memberId", column = "member_id")
    private Long memberId;

    @Schema(title = "姓名")
    @DbVoField(property = "memberName", column = "member_name")
    private String memberName;

    @Schema(title = "身份证号")
    @DbVoField(property = "memberIdnumber", column = "member_idnumber")
    private String memberIdnumber;

    @Schema(title = "联系手机号")
    @DbVoField(property = "memberPhone", column = "member_phone")
    private String memberPhone;

    @Schema(title = "备注")
    @DbVoField(property = "memberMemo", column = "member_memo")
    private String memberMemo;

    @Schema(title = "头像")
    @DbVoField(property = "memberAvatar", column = "member_avatar")
    private Long memberAvatar;

    @Schema(title = "系统数据")
    @DbVoField(property = "isSystem", column = "is_system")
    private Short isSystem;

    @Schema(title = "启用状态")
    @DbVoField(property = "enableStatus", column = "enable_status")
    private EnableStatus enableStatus;

    @Schema(title = "商户ID")
    @DbVoField(property = "merchantId", column = "merchant_id")
    private Long merchantId;

    @Schema(title = "租户ID")
    @DbVoField(property = "tenantId", column = "tenant_id")
    private Long tenantId;

}
