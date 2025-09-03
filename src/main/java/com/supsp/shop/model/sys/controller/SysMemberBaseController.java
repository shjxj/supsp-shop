package com.supsp.shop.model.sys.controller;

import com.supsp.shop.model.sys.entity.SysMember;
import com.supsp.shop.model.sys.mapper.SysMemberMapper;
import com.supsp.shop.model.sys.model.SysMemberModel;
import com.supsp.shop.model.sys.params.SysMember.SysMemberRequest;
import com.supsp.shop.model.sys.service.action.ISysMemberActionService;
import com.supsp.shop.model.sys.service.impl.SysMemberServiceImpl;
import com.supsp.springboot.core.annotations.ApiIdempotent;
import com.supsp.springboot.core.base.ActionResult;
import com.supsp.springboot.core.base.PagerData;
import com.supsp.springboot.core.config.ValidGroup;
import com.supsp.springboot.core.exceptions.ModelException;
import com.supsp.springboot.core.model.BaseModelController;
import com.supsp.springboot.core.vo.TagInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.annotation.Nullable;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 用户 控制器
 * </p>
 *
 * @author com.supsp
 * @since 2025-08-27 22:34
 */
@RestController
@Slf4j
public abstract class SysMemberBaseController extends BaseModelController<SysMemberModel, SysMemberServiceImpl, SysMemberMapper, SysMember> {

    @Resource
    protected ISysMemberActionService sysMemberActionService;

    /**
     * 新建
     *
     * @param data
     * @return
     * @throws ModelException
     */
    @PostMapping("/create")
    @Operation(summary = "新建")
    @ApiIdempotent
    public ActionResult create(
            @Parameter(description = "数据", name = "data")
            @Validated({ValidGroup.Insert.class}) @RequestBody SysMember data
    ) throws ModelException {
        return this.model.create(data);
    }

    /**
     * 编辑
     *
     * @param id
     * @param data
     * @return
     * @throws ModelException
     */
    @PostMapping("/edit/{id}")
    @Operation(summary = "编辑")
    @ApiIdempotent
    public ActionResult edit(
            @Parameter(description = "ID", name = "id", required = true)
            @PathVariable(value = "id") long id,
            @Parameter(description = "数据", name = "data")
            @Validated({ValidGroup.Update.class}) @RequestBody SysMember data
    ) throws ModelException {
        return this.model.edit(id, data);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     * @throws ModelException
     */
    @GetMapping("/detail/{id}")
    @Operation(summary = "详情")
    public SysMember detail(
            @Parameter(description = "ID", name = "id", required = true)
            @PathVariable(value = "id") long id
    ) throws ModelException {
        return this.model.detail(id);
    }

    /**
     * 分页列表
     *
     * @param entityRequest
     * @return
     * @throws ModelException
     */
    @PostMapping("/list")
    @Operation(summary = "分页列表")
    public PagerData<SysMember> list(
            @Parameter(description = "查询信息", name = "entityRequest")
            @Nullable @RequestBody SysMemberRequest entityRequest
    ) throws ModelException {
        return this.model.queryList(entityRequest);
    }

    /**
     * 查询列表
     *
     * @param entityRequest
     * @return
     * @throws ModelException
     */
    @PostMapping("/query")
    @Operation(summary = "查询列表")
    public List<SysMember> query(
            @Parameter(description = "查询信息", name = "query")
            @Nullable @RequestBody SysMemberRequest entityRequest
    ) throws ModelException {
        return this.model.query(entityRequest);
    }

    /**
     * 启用
     *
     * @param id
     * @return
     * @throws ModelException
     */
    @GetMapping("/enable/{id}")
    @Operation(summary = "启用")
    @ApiIdempotent
    public ActionResult enable(
            @Parameter(description = "ID", name = "id", required = true)
            @PathVariable(value = "id") long id
    ) throws ModelException {
        return this.model.enable(id);
    }

    /**
     * 批量启用
     *
     * @param idList
     * @return
     * @throws ModelException
     */
    @PostMapping("/batch/enable")
    @Operation(summary = "批量启用")
    @ApiIdempotent
    public ActionResult batchEnable(
            @Parameter(description = "ID列表", name = "idList", required = true)
            @Nullable @RequestBody Set<Long> idList
    ) throws ModelException {
        return this.model.batchEnable(idList);
    }

    /**
     * 禁用
     *
     * @param id
     * @return
     * @throws ModelException
     */
    @GetMapping("/disable/{id}")
    @Operation(summary = "禁用")
    @ApiIdempotent
    public ActionResult disable(
            @Parameter(description = "ID", name = "id", required = true)
            @PathVariable(value = "id") long id
    ) throws ModelException {
        return this.model.disable(id);
    }

    /**
     * 批量禁用
     *
     * @param idList
     * @return
     * @throws ModelException
     */
    @PostMapping("/batch/disable")
    @Operation(summary = "批量禁用")
    @ApiIdempotent
    public ActionResult batchDisable(
            @Parameter(description = "ID列表", name = "idList", required = true)
            @Nullable @RequestBody Set<Long> idList
    ) throws ModelException {
        return this.model.batchDisable(idList);
    }

    /**
     * 显示
     *
     * @param id
     * @return
     * @throws ModelException
     */
    @GetMapping("/show/{id}")
    @Operation(summary = "显示")
    @ApiIdempotent
    public ActionResult show(
            @Parameter(description = "ID", name = "id", required = true)
            @PathVariable(value = "id") long id
    ) throws ModelException {
        return this.model.show(id);
    }

    /**
     * 批量显示
     *
     * @param idList
     * @return
     * @throws ModelException
     */
    @PostMapping("/batch/show")
    @Operation(summary = "批量显示")
    @ApiIdempotent
    public ActionResult batchShow(
            @Parameter(description = "ID列表", name = "idList", required = true)
            @Nullable @RequestBody Set<Long> idList
    ) throws ModelException {
        return this.model.batchShow(idList);
    }

    /**
     * 隐藏
     *
     * @param id
     * @return
     * @throws ModelException
     */
    @GetMapping("/hidden/{id}")
    @Operation(summary = "隐藏")
    @ApiIdempotent
    public ActionResult hidden(
            @Parameter(description = "ID", name = "id", required = true)
            @PathVariable(value = "id") long id
    ) throws ModelException {
        return this.model.hidden(id);
    }

    /**
     * 批量隐藏
     *
     * @param idList
     * @return
     * @throws ModelException
     */
    @PostMapping("/batch/hidden")
    @Operation(summary = "批量隐藏")
    @ApiIdempotent
    public ActionResult batchHidden(
            @Parameter(description = "ID列表", name = "idList", required = true)
            @Nullable @RequestBody Set<Long> idList
    ) throws ModelException {
        return this.model.batchHidden(idList);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws ModelException
     */
    @GetMapping("/delete/{id}")
    @Operation(summary = "删除")
    @ApiIdempotent
    public ActionResult delete(
            @Parameter(description = "ID", name = "id", required = true)
            @PathVariable(value = "id") long id
    ) throws ModelException {
        return this.model.delete(id);
    }

    /**
     * 批量删除
     *
     * @param idList
     * @return
     * @throws ModelException
     */
    @PostMapping("/batch/delete")
    @Operation(summary = "批量删除")
    @ApiIdempotent
    public ActionResult batchDelete(
            @Parameter(description = "ID列表", name = "idList", required = true)
            @Nullable @RequestBody Set<Long> idList
    ) throws ModelException {
        return this.model.batchDelete(idList);
    }

    /**
     * 设置排序权重
     *
     * @param id
     * @param order
     * @return
     * @throws ModelException
     */
    @PostMapping("/set/order/{id}")
    @Operation(summary = "设置排序权重")
    @ApiIdempotent
    public ActionResult setOrder(
            @Parameter(description = "ID", name = "id", required = true)
            @PathVariable(value = "id") long id,
            @Parameter(description = "order", name = "排序", required = true)
            @RequestBody int order
    ) throws ModelException {
        return this.model.setOrder(id, order);
    }

    /**
     * 批量设置排序权重
     *
     * @param data
     * @return
     * @throws ModelException
     */
    @PostMapping("/batch/set/order")
    @Operation(summary = "批量设置排序权重")
    @ApiIdempotent
    public ActionResult batchSetOrder(
            @Parameter(description = "批量排序数据", name = "data", required = true)
            @Nullable @RequestBody HashMap<Long, Integer> data
    ) throws ModelException {
        return this.model.batchSetOrder(data);
    }

    /**
     * 保存数据标签
     *
     * @param id
     * @param tags
     * @return
     * @throws ModelException
     */
    @PostMapping("/tag/save/{id}")
    @Operation(summary = "保存数据标签")
    @ApiIdempotent
    public ActionResult saveTags(
            @Parameter(description = "ID", name = "id", required = true)
            @PathVariable(value = "id") long id,
            @Parameter(description = "tags", name = "标签", required = true)
            @RequestBody List<String> tags
    ) throws ModelException {
        return this.doSaveOjbectTags(id, tags);
    }

    /**
     * 获取数据标签
     *
     * @param id
     * @return
     * @throws ModelException
     */
    @GetMapping("/tag/get/{id}")
    @Operation(summary = "获取数据标签")
    public List<String> getTags(
            @Parameter(description = "ID", name = "id", required = true)
            @PathVariable(value = "id") long id
    ) throws ModelException {
        return this.doGetOjbectTags(id);
    }

    /**
     * 获取数据可用标签
     *
     * @param id
     * @return
     * @throws ModelException
     */
    @GetMapping("/tag/list/{id}")
    @Operation(summary = "获取数据可用标签")
    public List<TagInfo> getTagList(
            @Parameter(description = "ID", name = "id", required = true)
            @PathVariable(value = "id") long id
    ) throws ModelException {
        return this.doGetObjectTagList(id);
    }

}