package com.supsp.shop.model.ums.model;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.supsp.springboot.core.annotations.Cacher;
import com.supsp.springboot.core.annotations.DbModel;
import com.supsp.springboot.core.consts.Constants;
import com.supsp.springboot.core.base.*;
import com.supsp.springboot.core.enums.DataScope;
import com.supsp.springboot.core.enums.EnableStatus;
import com.supsp.springboot.core.exceptions.ExceptionCodes;
import com.supsp.springboot.core.enums.ShowStatus;
import com.supsp.springboot.core.exceptions.ModelException;
import com.supsp.springboot.core.model.IEntityParams;
import com.supsp.springboot.core.model.*;
import com.supsp.springboot.core.utils.CommonUtils;
import com.supsp.springboot.core.utils.StrUtils;
import com.supsp.shop.model.ums.entity.UmsMember;
import com.supsp.shop.model.ums.mapper.UmsMemberMapper;
import com.supsp.shop.model.ums.params.UmsMember.UmsMemberRequest;
import com.supsp.shop.model.ums.params.UmsMember.UmsMemberParams;
import com.supsp.shop.model.ums.params.UmsMember.UmsMemberFilter;
import com.supsp.shop.model.ums.service.impl.UmsMemberServiceImpl;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 用户 MODEL
 * </p>
 *
 * @author com.supsp
 * @since 2025-08-31 17:59
 */
@Component
@Slf4j
@DbModel(scope = DataScope.False, tag = true)
@Cacher(scope = DataScope.False)
public class UmsMemberModel
        extends BaseEntityModel<UmsMemberServiceImpl, UmsMemberMapper, UmsMember>
        implements IEntityModel<UmsMemberServiceImpl, UmsMemberMapper, UmsMember> {

    /**
     * 名称是否存在
     * 
     * @param name
     * @param id
     * @return
     */
    public long countByName(
            @NotBlank String name,
            long id
    ) {
        QueryWrapper<UmsMember> queryWrapper = this.getQueryWrapper();
//        if (hasColumn("member_name")) {
//            queryWrapper.eq("member_name", name);
//        }
            queryWrapper.eq("member_name", name);
        if (id > 0) {
            queryWrapper.ne(UmsMember.MEMBER_ID, id);
        }
        return this.service.count(queryWrapper);
    }

    /**
     * 名称是否存在
     * 
     * @param name
     * @return
     */
    public long countByName( 
            @NotBlank String name
    ) {
        return this.countByName(name, 0);
    }

    /**
     * 编码是否存在
     * 
     * @param code
     * @param id
     * @return
     */
    public long countByCode( 
            @NotBlank String code,
            long id
    ) {
        QueryWrapper<UmsMember> queryWrapper = this.getQueryWrapper();
//        if (hasColumn("member_code")) {
//            queryWrapper.eq("member_code", code);
//        }
            queryWrapper.eq("member_code", code);
        if (id > 0) {
            queryWrapper.ne(UmsMember.MEMBER_ID, id);
        }
        return this.service.count(queryWrapper);
    }

    /**
     * 编码是否存在
     * 
     * @param code
     * @return
     */
    public long countByCode( 
            @NotBlank String code
    ) {
        return this.countByCode(code, 0);
    }

    /**
     * 新建
     * 
     * @param data
     * @return
     * @throws ModelException
     */
    @Override
    @Transactional(rollbackFor = {ModelException.class})
    public ActionResult create( 
                UmsMember data
    ) throws ModelException {
        if (data == null) {
            throw new ModelException(ExceptionCodes.PARAMS_EMPTY);
        }

//        if (StrUtils.isBlank(data.getMemberCode())) {
//            data.setMemberCode(CommonUtils.randomCode());
//        }
//
//        if (!ValidateMatch.isBaseCode(data.getMemberCode())) {
//            throw new ModelException(ValidateMatch.MSG_BASE_CODE, ExceptionCodes.PARAM_ERROR);
//        }
//
//        if (this.countByCode(data.getMemberCode()) > 0) {
//            throw new ModelException("相同编码已存在", ExceptionCodes.DATA_ALREADY_EXISTS);
//        }
//
//        if (this.countByName(data.getMemberName()) > 0) {
//            throw new ModelException("名称已存在", ExceptionCodes.DATA_ALREADY_EXISTS);
//        }
//
        data.setMemberId(this.applyID());

//        if (!CommonUtils.isOrderSort(data.getOrderSort())) {
//            data.setOrderSort(Constants.DEFAULT_ORDER);
//        }
//
//        if (data.getEnableStatus() == null) {
//            data.setEnableStatus(EnableStatus.enable);
//        }
//
//        if (data.getShowStatus() == null) {
//            data.setShowStatus(ShowStatus.show);
//        }

//        data.setIsSystem(null);

        boolean result = this.service.save(data);
        if (!result) {
            return ActionResult.fail();
        }

        return ActionResult.success(data.getMemberId(), data.getId());
    }

    /**
     * 编辑
     * 
     * @param id
     * @param data
     * @return
     * @throws ModelException
     */
    @Override
    @Transactional(rollbackFor = {ModelException.class})
    public ActionResult edit( 
                long id,
                UmsMember data
    ) throws ModelException {
        if (CommonUtils.isNotID(id)) {
            throw new ModelException(ExceptionCodes.PARAM_ERROR);
        }
        if (data == null) {
            throw new ModelException(ExceptionCodes.PARAMS_EMPTY);
        }

        QueryWrapper<UmsMember> queryWrapper = this.getQueryWrapper();
        queryWrapper.eq(UmsMember.MEMBER_ID, id);
        UmsMember entity = this.service.getOne(queryWrapper);
        if (entity == null) {
            throw new ModelException(ExceptionCodes.DATA_NOT_EXIST);
        }

//        if (StrUtils.isBlank(data.getMemberCode())) {
//            data.setMemberCode(CommonUtils.randomCode());
//        }
//
//        if (!ValidateMatch.isBaseCode(data.getMemberCode())) {
//            throw new ModelException(ValidateMatch.MSG_BASE_CODE, ExceptionCodes.PARAM_ERROR);
//        }
//
//        if (this.countByCode(data.getMemberCode(), id) > 0) {
//            throw new ModelException("相同编码已存在", ExceptionCodes.DATA_ALREADY_EXISTS);
//        }
//
//        if (this.countByName(data.getMemberName(), id) > 0) {
//            throw new ModelException("名称已存在", ExceptionCodes.DATA_ALREADY_EXISTS);
//        }
//        data.setMemberId(null);
        data.setMemberId(entity.getMemberId());
//        data.setIsSystem(null);

//        if (!CommonUtils.isOrderSort(data.getOrderSort())) {
//            data.setOrderSort(entity.getOrderSort());
//        }
//
//        if (data.getEnableStatus() == null) {
//            data.setEnableStatus(entity.getEnableStatus());
//        }
//
//        if (data.getShowStatus() == null) {
//            data.setShowStatus(entity.getShowStatus());
//        }

        UpdateWrapper<UmsMember> updateWrapper = this.getUpdateWrapper();
        updateWrapper.eq(UmsMember.MEMBER_ID, id);

        if (!this.service.update(data, updateWrapper)) {
            return ActionResult.fail();
        }

//        return ActionResult.success(true);
        return ActionResult.success(entity.getMemberId(), entity.getId());
    }

    /**
     * 详情
     *
     * @param id
     * @return
     * @throws ModelException
     */
    @Cacher
    @Override
    public UmsMember detail(long id) throws ModelException {
        if (CommonUtils.isNotID(id)) {
            throw new ModelException(ExceptionCodes.PARAMS_EMPTY);
        }

        QueryWrapper<UmsMember> queryWrapper = this.getQueryWrapper();
        queryWrapper.eq(UmsMember.MEMBER_ID, id);
        wrapperSelectByColumn(queryWrapper, this.getAllSelectColumnList());

        return this.service.getOne(queryWrapper, false);
    }


    /**
     * 关键字查询
     *
     * @param wrapper
     * @param params
     */
    @Override
    public void wrapperKeyword(QueryWrapper<UmsMember> wrapper, @Nullable IEntityParams<UmsMember> params) {
        if (params == null || wrapper == null || StrUtils.isBlank(params.getKeyword())) {
            return;
        }
    }

    /**
     * 查询 Wrapper
     * 
     * @param entityRequest
     * @return
     */
    @Cacher
    @Override
    public <R extends BaseEntityRequest<? extends BaseEntityParams<UmsMember>, ? extends BaseEntityFilter<UmsMember>, UmsMember>> QueryWrapper<UmsMember> queryWrapper( 
                @Nullable R entityRequest
    ) {
        QueryWrapper<UmsMember> queryWrapper = this.getQueryWrapper();
        // params
        UmsMemberParams params = entityRequest != null ? ((UmsMemberParams) entityRequest.getParams()) : null;
        if (params != null) {

            this.wrapperParamsBase(queryWrapper, params);
        }

        // filter
        UmsMemberFilter filter = entityRequest != null ? ((UmsMemberFilter) entityRequest.getFilter()) : null;
        if (filter != null) {
            this.wrapperFilterBase(queryWrapper, filter);
        }

        // sorter
        this.wrapperSorter(
                queryWrapper,
                entityRequest != null ? entityRequest.getSorter()  : null
        );
        if (this.hasColumn(Constants.COLUMNS_ORDER_SORT)) {
            queryWrapper.orderByDesc(Constants.COLUMNS_ORDER_SORT);
        }
        if (this.hasColumn(Constants.COLUMNS_ID)) {
            queryWrapper.orderByDesc(Constants.COLUMNS_ID);
        }

        return queryWrapper;
    }

    /**
     * 分页列表
     * 
     * @param entityRequest
     * @param <R>
     * @return
     * @throws ModelException
     */
    @Cacher
    @Override
    public <R extends BaseEntityRequest<? extends BaseEntityParams<UmsMember>, ? extends BaseEntityFilter<UmsMember>, UmsMember>> PagerData<UmsMember> queryList( 
                @Nullable R entityRequest
    ) throws ModelException {
        return queryList(this.queryWrapper(entityRequest), entityRequest);
    }

    /**
     * 查询列表
     * 
     * @param entityRequest
     * @param <R>
     * @return
     * @throws ModelException
     */
    @Cacher
    @Override
    public <R extends BaseEntityRequest<? extends BaseEntityParams<UmsMember>, ? extends BaseEntityFilter<UmsMember>, UmsMember>> List<UmsMember> query( 
                @Nullable R entityRequest
    ) throws ModelException {
        return query(this.queryWrapper(entityRequest), entityRequest);
    }

    /**
     * 设置启用状态
     * 
     * @param id
     * @param status
     * @return
     * @throws ModelException
     */
    @Override
    @Transactional(rollbackFor = {ModelException.class})
    public ActionResult setEnableStatus( 
                long id,
                EnableStatus status
    ) throws ModelException {
        if (CommonUtils.isNotID(id)) {
            throw new ModelException(ExceptionCodes.PARAM_ERROR);
        }

        if (
                StrUtils.isBlank(this.getDataIdColumn())
                        || CommonUtils.isEmpty(this.getFieldsColumn())
                        || !this.hasColumn(Constants.COLUMNS_ENABLE_STATUS)
        ) {
            return ActionResult.fail();
        }

        UpdateWrapper<UmsMember> updateWrapper = this.getUpdateWrapper();
        updateWrapper.eq(UmsMember.MEMBER_ID, id);

        if (this.hasColumn(Constants.COLUMNS_IS_SYSTEM)) {
            updateWrapper.eq(Constants.COLUMNS_IS_SYSTEM, Constants.SHORT_ZERO);
        }

        updateWrapper.set(Constants.COLUMNS_ENABLE_STATUS, status);

        if (!this.service.update(updateWrapper)) {
            return ActionResult.fail();
        }

        return ActionResult.success(true);
    }

    /**
     * 批量设置启用状态
     * 
     * @param idList
     * @param status
     * @return
     * @throws ModelException
     */
    @Override
    @Transactional(rollbackFor = {ModelException.class})
    public ActionResult batchSetEnableStatus( 
                Set<Long> idList,
                EnableStatus status
    ) throws ModelException {
        if (CommonUtils.isEmpty(idList)) {
            throw new ModelException(ExceptionCodes.PARAMS_EMPTY);
        }

        if (
                StrUtils.isBlank(this.getDataIdColumn())
                        || CommonUtils.isEmpty(this.getFieldsColumn())
                        || !this.hasColumn(Constants.COLUMNS_ENABLE_STATUS)
        ) {
            return ActionResult.fail();
        }

        UpdateWrapper<UmsMember> updateWrapper = this.getUpdateWrapper();
        updateWrapper.in(UmsMember.MEMBER_ID, idList);

        if (this.hasColumn(Constants.COLUMNS_IS_SYSTEM)) {
            updateWrapper.eq(Constants.COLUMNS_IS_SYSTEM, Constants.SHORT_ZERO);
        }

        updateWrapper.set(Constants.COLUMNS_ENABLE_STATUS, status);

        if (!this.service.update(updateWrapper)) {
            return ActionResult.fail();
        }

        return ActionResult.success(true);
    }

    /**
     * 启用
     * 
     * @param id
     * @return
     * @throws ModelException
     */
    @Override
    @Transactional(rollbackFor = {ModelException.class})
     public ActionResult enable( 
                long id
    ) throws ModelException {
        return this.setEnableStatus(id, EnableStatus.enable);
    }

    /**
     * 批量启用
     * 
     * @param idList
     * @return
     * @throws ModelException
     */
    @Override
    @Transactional(rollbackFor = {ModelException.class})
     public ActionResult batchEnable( 
                Set<Long> idList
    ) throws ModelException {
        return this.batchSetEnableStatus(idList, EnableStatus.enable);
    }

    /**
     * 禁用
     * 
     * @param id
     * @return
     * @throws ModelException
     */
    @Override
    @Transactional(rollbackFor = {ModelException.class})
                public ActionResult disable( 
                long id
    ) throws ModelException {
        return this.setEnableStatus(id, EnableStatus.disable);
    }

    /**
     * 批量禁用
     * 
     * @param idList
     * @return
     * @throws ModelException
     */
    @Override
    @Transactional(rollbackFor = {ModelException.class})
    public ActionResult batchDisable( 
                Set<Long> idList
    ) throws ModelException {
        return this.batchSetEnableStatus(idList, EnableStatus.disable);
    }

    /**
     * 设置显示状态
     * 
     * @param id
     * @param status
     * @return
     * @throws ModelException
     */
    @Override
    @Transactional(rollbackFor = {ModelException.class})
    public ActionResult setShowStatus( 
                long id,
                ShowStatus status
    ) throws ModelException {
        if (CommonUtils.isNotID(id)) {
            throw new ModelException(ExceptionCodes.PARAM_ERROR);
        }

        if (
                StrUtils.isBlank(this.getDataIdColumn())
                        || CommonUtils.isEmpty(this.getFieldsColumn())
                        || !this.hasColumn(Constants.COLUMNS_SHOW_STATUS)
        ) {
            return ActionResult.fail();
        }

        UpdateWrapper<UmsMember> updateWrapper = this.getUpdateWrapper();
        updateWrapper.eq(UmsMember.MEMBER_ID, id);

//        if (this.hasColumn(Constants.COLUMNS_IS_SYSTEM)) {
//            updateWrapper.eq(Constants.COLUMNS_IS_SYSTEM, Constants.SHORT_ZERO);
//        }

        updateWrapper.set(Constants.COLUMNS_SHOW_STATUS, status);

        if (!this.service.update(updateWrapper)) {
            return ActionResult.fail();
        }

        return ActionResult.success(true);
    }

    /**
     * 批量设置显示状态
     * 
     * @param idList
     * @param status
     * @return
     * @throws ModelException
     */
    @Override
    @Transactional(rollbackFor = {ModelException.class})
    public ActionResult batchSetShowStatus( 
                Set<Long> idList,
                ShowStatus status
    ) throws ModelException {
        if (CommonUtils.isEmpty(idList)) {
            throw new ModelException(ExceptionCodes.PARAMS_EMPTY);
        }

        if (
                StrUtils.isBlank(this.getDataIdColumn())
                        || CommonUtils.isEmpty(this.getFieldsColumn())
                        || !this.hasColumn(Constants.COLUMNS_SHOW_STATUS)
        ) {
            return ActionResult.fail();
        }

        UpdateWrapper<UmsMember> updateWrapper = this.getUpdateWrapper();
        updateWrapper.in(UmsMember.MEMBER_ID, idList);

//        if (this.hasColumn(Constants.COLUMNS_IS_SYSTEM)) {
//            updateWrapper.eq(Constants.COLUMNS_IS_SYSTEM, Constants.SHORT_ZERO);
//        }

        updateWrapper.set(Constants.COLUMNS_SHOW_STATUS, status);

        if (!this.service.update(updateWrapper)) {
            return ActionResult.fail();
        }

        return ActionResult.success(true);
    }

    /**
     * 显示
     * 
     * @param id
     * @return
     * @throws ModelException
     */
    @Override
    @Transactional(rollbackFor = {ModelException.class})
    public ActionResult show( 
                long id
    ) throws ModelException {
        return this.setShowStatus(id, ShowStatus.show);
    }

    /**
     * 批量显示
     * 
     * @param idList
     * @return
     * @throws ModelException
     */
    @Override
    @Transactional(rollbackFor = {ModelException.class})
    public ActionResult batchShow( 
                Set<Long> idList
    ) throws ModelException {
        return this.batchSetShowStatus(idList, ShowStatus.show);
    }

    /**
     * 隐藏
     * 
     * @param id
     * @return
     * @throws ModelException
     */
    @Override
    @Transactional(rollbackFor = {ModelException.class})
    public ActionResult hidden( 
                long id
    ) throws ModelException {
        return this.setShowStatus(id, ShowStatus.hidden);
    }

    /**
     * 批量隐藏
     * 
     * @param idList
     * @return
     * @throws ModelException
     */
    @Override
    @Transactional(rollbackFor = {ModelException.class})
    public ActionResult batchHidden( 
                Set<Long> idList
    ) throws ModelException {
        return this.batchSetShowStatus(idList, ShowStatus.hidden);
    }

    /**
     * 删除
     * 
     * @param id
     * @return
     * @throws ModelException
     */
    @Override
    @Transactional(rollbackFor = {ModelException.class})
    public ActionResult delete( 
                long id
    ) throws ModelException {
        if (CommonUtils.isNotID(id)) {
            throw new ModelException(ExceptionCodes.PARAM_ERROR);
        }

        QueryWrapper<UmsMember> queryWrapper = this.getQueryWrapper();
        queryWrapper.eq(UmsMember.MEMBER_ID, id);

        if (this.hasColumn(Constants.COLUMNS_IS_SYSTEM)) {
            queryWrapper.eq(Constants.COLUMNS_IS_SYSTEM, Constants.SHORT_ZERO);
        }

        this.service.remove(queryWrapper);

        return ActionResult.success(true);
    }

    /**
     * 批量删除
     * 
     * @param idList
     * @return
     * @throws ModelException
     */
    @Override
    @Transactional(rollbackFor = {ModelException.class})
    public ActionResult batchDelete( 
                Set<Long> idList
    ) throws ModelException {
        if (CommonUtils.isEmpty(idList)) {
            throw new ModelException(ExceptionCodes.PARAMS_EMPTY);
        }

        QueryWrapper<UmsMember> queryWrapper = this.getQueryWrapper();
        queryWrapper.in(UmsMember.MEMBER_ID, idList);

        if (this.hasColumn(Constants.COLUMNS_IS_SYSTEM)) {
            queryWrapper.eq(Constants.COLUMNS_IS_SYSTEM, Constants.SHORT_ZERO);
        }

        this.service.remove(queryWrapper);

        return ActionResult.success(true);
    }

    /**
     * 设置排序权重
     * 
     * @param id
     * @param order
     * @return
     * @throws ModelException
     */
    @Override
    @Transactional(rollbackFor = {ModelException.class})
    public ActionResult setOrder( 
                long id,
                int order
    ) throws ModelException {
        if (CommonUtils.isNotID(id)) {
            throw new ModelException(ExceptionCodes.PARAM_ERROR);
        }

        if (order < 0) {
            throw new ModelException(ExceptionCodes.PARAM_ERROR);
        }

        if (
                StrUtils.isBlank(this.getDataIdColumn())
                        || CommonUtils.isEmpty(this.getFieldsColumn())
                        || !this.hasColumn(Constants.COLUMNS_ORDER_SORT)
        ) {
            return ActionResult.fail();
        }

        UpdateWrapper<UmsMember> updateWrapper = this.getUpdateWrapper();
        updateWrapper.eq(UmsMember.MEMBER_ID, id);
        updateWrapper.set(Constants.COLUMNS_ORDER_SORT, order);

        if (!this.service.update(updateWrapper)) {
            return ActionResult.fail();
        }

        return ActionResult.success(true);
    }

    /**
     * 批量设置排序权重
     * 
     * @param data
     * @return
     * @throws ModelException
     */
    @Override
    @Transactional(rollbackFor = {ModelException.class})
    public ActionResult batchSetOrder( 
                HashMap<Long, Integer> data
    ) throws ModelException {
        if (CommonUtils.isEmpty(data)) {
            throw new ModelException(ExceptionCodes.PARAMS_EMPTY);
        }

        if (
                StrUtils.isBlank(this.getDataIdColumn())
                        || CommonUtils.isEmpty(this.getFieldsColumn())
                        || !this.hasColumn(Constants.COLUMNS_ORDER_SORT)
        ) {
            return ActionResult.fail();
        }

        for (Map.Entry<Long, Integer> entry : data.entrySet()) {
            if (
                    entry.getKey() == null
                            || entry.getKey().compareTo(0L) < 1
                            || entry.getValue() == null
                            || entry.getValue() < 0
            ) {
                continue;
            }

            UpdateWrapper<UmsMember> updateWrapper = this.getUpdateWrapper();
            updateWrapper.eq(UmsMember.MEMBER_ID, entry.getKey());

            updateWrapper.set(Constants.COLUMNS_ORDER_SORT, entry.getValue());

            if (!this.service.update(updateWrapper)) {
                throw new ModelException(ExceptionCodes.SYSTEM_ERROR);
            }
        }

        return ActionResult.success(true);
    }

}
