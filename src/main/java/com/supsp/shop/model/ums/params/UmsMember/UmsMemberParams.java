package com.supsp.shop.model.ums.params.UmsMember;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.supsp.shop.model.ums.entity.UmsMember;
import com.supsp.springboot.core.annotations.DbParamField;
import com.supsp.springboot.core.annotations.DbParams;
import com.supsp.springboot.core.enums.AuthMemberType;
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
 * @since 2025-08-31 17:59
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Slf4j
@DbParams
@Schema(name = "UmsMemberParams", description = "用户 查询参数")
public class UmsMemberParams extends BaseEntityParams<UmsMember> implements IEntityParams<UmsMember> {

    @Serial
    private static final long serialVersionUID = 7618733046791180907L;

    /**
     * unix 时间戳 [无需前端设置]
     */
    @Schema(title = "unix 时间戳", description = "无需前端设置")
    @JsonIgnore
    private Long currentTimestamp;


    @Schema(title = "用户ID")
    @DbParamField(property = "memberId", column = "member_id", type = QueryType.eq)
    private Long memberId;

    @Schema(title = "用户类型 none:默认; tenant:租户; merchant:商家; consumer:消费者; api:API; ")
    @DbParamField(property = "memberType", column = "member_type", type = QueryType.eq)
    private AuthMemberType memberType;

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

}
