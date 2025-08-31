package com.supsp.shop.model.sys.params.SysMember;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.supsp.shop.model.sys.entity.SysMember;
import com.supsp.springboot.core.annotations.DbFilter;
import com.supsp.springboot.core.model.BaseEntityFilter;
import com.supsp.springboot.core.model.IEntityFilter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;

/**
 * <p>
 * 用户 查询筛选
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
@DbFilter
@Schema(name = "SysMemberFilter", description = "用户 查询筛选")
public class SysMemberFilter extends BaseEntityFilter<SysMember> implements IEntityFilter<SysMember> {

    @Serial
    private static final long serialVersionUID = -1740123903872466161L;

    /**
     * unix 时间戳 [无需前端设置]
     */
    @Schema(title = "unix 时间戳", description = "无需前端设置")
    @JsonIgnore
    private Long currentTimestamp;
}