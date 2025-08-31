package com.supsp.shop.model.ums.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.supsp.springboot.core.annotations.DBEntity;
import com.supsp.springboot.core.annotations.DataId;
import com.supsp.springboot.core.annotations.EntityColumn;
import com.supsp.springboot.core.annotations.SensitiveData;
import com.supsp.springboot.core.enums.AuthMemberType;
import com.supsp.springboot.core.enums.EnableStatus;
import com.supsp.springboot.core.model.BaseModelEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author com.supsp
 * @since 2025-08-31 17:59
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("ums_member")
@Schema(name = "UmsMember", description = "用户")
@DBEntity()
@SensitiveData
public class UmsMember extends BaseModelEntity<UmsMember> {

    @Serial
    private static final long serialVersionUID = 5321720764255685498L;

    @TableId(value = "id", type = IdType.AUTO)
    // @TableField(value = "id", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @EntityColumn(select = false, defaultSelect = false)
    @JsonIgnore
    private Long id;

    @Schema(title = "用户ID", accessMode = Schema.AccessMode.READ_ONLY)
    @TableField(value = "member_id", updateStrategy = FieldStrategy.NEVER)
    @DataId(value = "member_id")
    @EntityColumn(select = true, defaultSelect = true, isDataId = true)
    private Long memberId;

    @Schema(title = "用户类型 none:默认; tenant:租户; merchant:商家; consumer:消费者; api:API; ")
    @TableField(value = "member_type")
    @EntityColumn(select = true, defaultSelect = true)
    private AuthMemberType memberType;

    @Schema(title = "姓名")
    @TableField(value = "member_name")
    @EntityColumn(select = true, defaultSelect = true)
    private String memberName;

    @Schema(title = "身份证号")
    @TableField(value = "member_idnumber")
    @EntityColumn(select = true, defaultSelect = true)
    private String memberIdnumber;

    @Schema(title = "联系手机号")
    @TableField(value = "member_phone")
    @EntityColumn(select = true, defaultSelect = true)
    private String memberPhone;

    @Schema(title = "备注")
    @TableField(value = "member_memo")
    @EntityColumn(select = true, defaultSelect = true)
    private String memberMemo;

    @Schema(title = "头像")
    @TableField(value = "member_avatar")
    @EntityColumn(select = true, defaultSelect = true)
    private Long memberAvatar;

    @Schema(title = "系统数据")
    @TableField(value = "is_system")
    @EntityColumn(select = true, defaultSelect = true)
    private Short isSystem;

    @Schema(title = "启用状态")
    @TableField(value = "enable_status")
    @EntityColumn(select = true, defaultSelect = true)
    private EnableStatus enableStatus;

    @Schema(title = "创建时间", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY)
    @TableField(value = "created_at", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @EntityColumn(select = true, defaultSelect = true)
    private LocalDateTime createdAt;

    @Schema(title = "创建人类型", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY)
    @TableField(value = "created_member_type", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @EntityColumn(select = true, defaultSelect = false)
    private AuthMemberType createdMemberType;

    @Schema(title = "创建人ID", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY)
    @TableField(value = "created_member_id", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @EntityColumn(select = true, defaultSelect = false)
    private Long createdMemberId;

    @Schema(title = "创建人姓名", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY)
    @TableField(value = "created_member_name", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @EntityColumn(select = true, defaultSelect = false)
    private String createdMemberName;

    @Schema(title = "创建人账号", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY)
    @TableField(value = "created_member_account", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @EntityColumn(select = true, defaultSelect = false)
    private String createdMemberAccount;

    @Schema(title = "创建人IP", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY)
    @TableField(value = "created_member_ip", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @EntityColumn(select = true, defaultSelect = false)
    private String createdMemberIp;

    @Schema(title = "创建人组织ID", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY)
    @TableField(value = "created_org_id", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @EntityColumn(select = true, defaultSelect = false)
    private Long createdOrgId;

    @Schema(title = "创建人组织", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY)
    @TableField(value = "created_org_name", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @EntityColumn(select = true, defaultSelect = false)
    private String createdOrgName;

    @Schema(title = "创建人门店ID", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY)
    @TableField(value = "created_store_id", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @EntityColumn(select = true, defaultSelect = false)
    private Long createdStoreId;

    @Schema(title = "创建人门店", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY)
    @TableField(value = "created_store_name", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @EntityColumn(select = true, defaultSelect = false)
    private String createdStoreName;

    @Schema(title = "更新时间", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY)
    @TableField(value = "updated_at", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @EntityColumn(select = true, defaultSelect = true)
    private LocalDateTime updatedAt;

    @Schema(title = "更新人类型", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY)
    @TableField(value = "updated_member_type", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @EntityColumn(select = true, defaultSelect = false)
    private AuthMemberType updatedMemberType;

    @Schema(title = "更新人ID", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY)
    @TableField(value = "updated_member_id", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @EntityColumn(select = true, defaultSelect = false)
    private Long updatedMemberId;

    @Schema(title = "更新人姓名", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY)
    @TableField(value = "updated_member_name", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @EntityColumn(select = true, defaultSelect = false)
    private String updatedMemberName;

    @Schema(title = "更新人账号", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY)
    @TableField(value = "updated_member_account", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @EntityColumn(select = true, defaultSelect = false)
    private String updatedMemberAccount;

    @Schema(title = "更新人IP", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY)
    @TableField(value = "updated_member_ip", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @EntityColumn(select = true, defaultSelect = false)
    private String updatedMemberIp;

    @Schema(title = "创建人组织ID", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY)
    @TableField(value = "updated_org_id", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @EntityColumn(select = true, defaultSelect = false)
    private Long updatedOrgId;

    @Schema(title = "创建人组织", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY)
    @TableField(value = "updated_org_name", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @EntityColumn(select = true, defaultSelect = false)
    private String updatedOrgName;

    @Schema(title = "创建人门店ID", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY)
    @TableField(value = "updated_store_id", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @EntityColumn(select = true, defaultSelect = false)
    private Long updatedStoreId;

    @Schema(title = "创建人门店", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY)
    @TableField(value = "updated_store_name", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @EntityColumn(select = true, defaultSelect = false)
    private String updatedStoreName;

    @Schema(title = "删除状态", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY, hidden = true)
    @TableField(value = "deleted", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @TableLogic
    @JsonIgnore
    @EntityColumn(select = false, defaultSelect = false)
    private Short deleted;

    @Schema(title = "删除时间", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY, hidden = true)
    @TableField(value = "deleted_at", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @JsonIgnore
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @EntityColumn(select = false, defaultSelect = false)
    private LocalDateTime deletedAt;

    @Schema(title = "删除人类型", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY, hidden = true)
    @TableField(value = "deleted_member_type", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @JsonIgnore
    @EntityColumn(select = false, defaultSelect = false)
    private AuthMemberType deletedMemberType;

    @Schema(title = "删除人ID", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY, hidden = true)
    @TableField(value = "deleted_member_id", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @JsonIgnore
    @EntityColumn(select = false, defaultSelect = false)
    private Long deletedMemberId;

    @Schema(title = "删除人姓名", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY, hidden = true)
    @TableField(value = "deleted_member_name", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @JsonIgnore
    @EntityColumn(select = false, defaultSelect = false)
    private String deletedMemberName;

    @Schema(title = "删除人账号", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY, hidden = true)
    @TableField(value = "deleted_member_account", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @JsonIgnore
    @EntityColumn(select = false, defaultSelect = false)
    private String deletedMemberAccount;

    @Schema(title = "删除者IP", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY, hidden = true)
    @TableField(value = "deleted_member_ip", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @JsonIgnore
    @EntityColumn(select = false, defaultSelect = false)
    private String deletedMemberIp;

    @Schema(title = "创建人组织ID", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY)
    @TableField(value = "deleted_org_id", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @EntityColumn(select = true, defaultSelect = false)
    private Long deletedOrgId;

    @Schema(title = "创建人组织", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY)
    @TableField(value = "deleted_org_name", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @EntityColumn(select = true, defaultSelect = false)
    private String deletedOrgName;

    @Schema(title = "创建人门店ID", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY)
    @TableField(value = "deleted_store_id", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @EntityColumn(select = true, defaultSelect = false)
    private Long deletedStoreId;

    @Schema(title = "创建人门店", description = "无需前端设置", accessMode = Schema.AccessMode.READ_ONLY)
    @TableField(value = "deleted_store_name", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @EntityColumn(select = true, defaultSelect = false)
    private String deletedStoreName;

    public static final String ID = "id";

    public static final String MEMBER_ID = "member_id";

    public static final String MEMBER_TYPE = "member_type";

    public static final String MEMBER_NAME = "member_name";

    public static final String MEMBER_IDNUMBER = "member_idnumber";

    public static final String MEMBER_PHONE = "member_phone";

    public static final String MEMBER_MEMO = "member_memo";

    public static final String MEMBER_AVATAR = "member_avatar";

    public static final String IS_SYSTEM = "is_system";

    public static final String ENABLE_STATUS = "enable_status";

    public static final String CREATED_AT = "created_at";

    public static final String CREATED_MEMBER_TYPE = "created_member_type";

    public static final String CREATED_MEMBER_ID = "created_member_id";

    public static final String CREATED_MEMBER_NAME = "created_member_name";

    public static final String CREATED_MEMBER_ACCOUNT = "created_member_account";

    public static final String CREATED_MEMBER_IP = "created_member_ip";

    public static final String CREATED_ORG_ID = "created_org_id";

    public static final String CREATED_ORG_NAME = "created_org_name";

    public static final String CREATED_STORE_ID = "created_store_id";

    public static final String CREATED_STORE_NAME = "created_store_name";

    public static final String UPDATED_AT = "updated_at";

    public static final String UPDATED_MEMBER_TYPE = "updated_member_type";

    public static final String UPDATED_MEMBER_ID = "updated_member_id";

    public static final String UPDATED_MEMBER_NAME = "updated_member_name";

    public static final String UPDATED_MEMBER_ACCOUNT = "updated_member_account";

    public static final String UPDATED_MEMBER_IP = "updated_member_ip";

    public static final String UPDATED_ORG_ID = "updated_org_id";

    public static final String UPDATED_ORG_NAME = "updated_org_name";

    public static final String UPDATED_STORE_ID = "updated_store_id";

    public static final String UPDATED_STORE_NAME = "updated_store_name";

    public static final String DELETED = "deleted";

    public static final String DELETED_AT = "deleted_at";

    public static final String DELETED_MEMBER_TYPE = "deleted_member_type";

    public static final String DELETED_MEMBER_ID = "deleted_member_id";

    public static final String DELETED_MEMBER_NAME = "deleted_member_name";

    public static final String DELETED_MEMBER_ACCOUNT = "deleted_member_account";

    public static final String DELETED_MEMBER_IP = "deleted_member_ip";

    public static final String DELETED_ORG_ID = "deleted_org_id";

    public static final String DELETED_ORG_NAME = "deleted_org_name";

    public static final String DELETED_STORE_ID = "deleted_store_id";

    public static final String DELETED_STORE_NAME = "deleted_store_name";


    @Override
    public Serializable pkVal() {
        return this.id;
    }
}
