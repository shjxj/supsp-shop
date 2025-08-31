package com.supsp.shop.model.ums.params.UmsMember;

import com.supsp.springboot.core.annotations.DbRequest;
import com.supsp.shop.model.ums.params.UmsMember.UmsMemberFilter;
import com.supsp.shop.model.ums.params.UmsMember.UmsMemberParams;
import com.supsp.springboot.core.model.BaseEntityRequest;
import com.supsp.springboot.core.model.IEntityRequest;
import com.supsp.shop.model.ums.entity.UmsMember;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serial;

/**
 * <p>
 * 用户 查询
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
@Slf4j
@DbRequest
@Schema(name = "UmsMemberRequest", description = "用户 查询")
public class UmsMemberRequest
        extends BaseEntityRequest<UmsMemberParams, UmsMemberFilter, UmsMember> implements IEntityRequest<UmsMemberParams, UmsMemberFilter, UmsMember> {

    @Serial
    private static final long serialVersionUID = 6148440859280011047L;

    /**
     * unix 时间戳 [无需前端设置]
     */
    @Schema(title = "unix 时间戳", description = "无需前端设置")
    @JsonIgnore
    private Long currentTimestamp;

}
