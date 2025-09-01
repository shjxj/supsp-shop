package com.supsp.shop.core.auth.service.impl;

import com.supsp.shop.model.sys.entity.SysAccount;
import com.supsp.shop.model.sys.entity.SysMember;
import com.supsp.shop.model.sys.model.SysAccountModel;
import com.supsp.shop.model.sys.model.SysMemberModel;
import com.supsp.springboot.core.auth.IPassportService;
import com.supsp.springboot.core.auth.impl.BasePassportService;
import com.supsp.springboot.core.config.CoreProperties;
import com.supsp.springboot.core.enums.AuthMemberType;
import com.supsp.springboot.core.enums.EnableStatus;
import com.supsp.springboot.core.enums.LoginType;
import com.supsp.springboot.core.exceptions.ExceptionCodes;
import com.supsp.springboot.core.exceptions.ModelException;
import com.supsp.springboot.core.utils.*;
import com.supsp.springboot.core.vo.auth.AuthAccount;
import com.supsp.springboot.core.vo.auth.AuthMember;
import com.supsp.springboot.core.vo.auth.LoginData;
import com.supsp.springboot.core.vo.auth.LoginParams;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("apiPassportService")
@Slf4j
public class ApiPassportServiceImpl extends BasePassportService implements IPassportService {

    @Resource
    private SysMemberModel sysMemberModel;

    @Resource
    private SysAccountModel sysAccountModel;

    @Resource
    private HttpServletRequest request;

    @Resource
    private HttpServletResponse response;

    @Resource
    private JwtUtil jwtUtil;

    @Override
    public LoginData login(LoginParams params) throws ModelException {
        if (params == null) {
            throw new ModelException("登录数据有误", ExceptionCodes.PARAMS_EMPTY);
        }

        if (params.getLoginType() == null) {
            // throw new ModelException("登录方式有误", ExceptionCodes.PARAM_ERROR);
            params.setLoginType(LoginType.account);
        }

        switch (params.getLoginType()) {
            case account -> {
                return accountLogin(params);
            }
            case mobile -> {
                return mobileLogin(params);
            }
            case qr -> {
                return qrLogin(params);
            }
        }

        throw new ModelException("登录失败", ExceptionCodes.PARAM_ERROR);
    }

    protected LoginData accountLogin(LoginParams params) throws ModelException {
        if (params == null) {
            throw new ModelException("登录数据有误", ExceptionCodes.PARAMS_EMPTY);
        }
        if (StrUtils.isBlank(params.getAccount())) {
            throw new ModelException("请输入登录账号", ExceptionCodes.PARAMS_EMPTY);
        }
        if (StrUtils.isBlank(params.getPassword())) {
            throw new ModelException("请输入登录密码", ExceptionCodes.PARAMS_EMPTY);
        }

        SysAccount account = sysAccountModel.getByAccount(params.getAccount());
        if (account == null) {
            throw new ModelException("登录账号或密码错误", ExceptionCodes.PARAMS_EMPTY);
        }

        if (account.getEnableStatus() == null || !account.getEnableStatus().equals(EnableStatus.enable)) {
            throw new ModelException("登录账号或密码错误", ExceptionCodes.PARAMS_EMPTY);
        }

        if (
                StrUtils.isNotBlank(account.getLoginPwd())
                        && !CryptUtils.checkpw(
                        params.getPassword().toUpperCase(),
                        account.getLoginPwd()
                )
        ) {
            throw new ModelException("登录账号或密码错误", ExceptionCodes.PARAMS_EMPTY);
        }

        // !CryptUtils.checkpw(params.getPassword(), account.getLoginPwd())

        SysMember member = sysMemberModel.detail(account.getMemberId());
        if (member == null) {
            throw new ModelException("登录用户信息异常", ExceptionCodes.PARAMS_EMPTY);
        }
        if (member.getEnableStatus() == null || !member.getEnableStatus().equals(EnableStatus.enable)) {
            throw new ModelException("用户已被禁用，请联系管理员", ExceptionCodes.PARAMS_EMPTY);
        }
        member.setAccount(account);

        AuthMember authMember = new AuthMember();
        authMember.setMemberId(account.getMemberId());
        authMember.setAccountType(account.getAccountType());
        authMember.setLoginAccount(account.getLoginAccount());
        authMember.setLoginPwd(account.getLoginPwd());

        String token = jwtUtil.generateToken(authMember);
        String sid = request.getHeader(CoreProperties.tokenAdminHeaderName());
        if (StrUtils.isBlank(sid) || sid.length() < 64) {
            sid = CommonUtils.randomAuthSid(
                    AuthMemberType.admin.getCode()
            );
            response.setHeader(CoreProperties.tokenAdminHeaderName(), sid);
        }
        String key = jwtUtil.tokenKeyName(
                AuthMemberType.admin,
                sid
        );
        String saveToken = CryptUtils.encrypt(token);
        RedisUtils.set(
                key,
                saveToken,
                CoreProperties.AUTH_REFRESH_EXPIRES * 60L
        );

        LoginData result = new LoginData();
        result.setMemberId(member.getMemberId());
        result.setToken(token);
        result.setSid(sid);
//        result.setMemberId(member.getMemberId());
//        result.setMemberId(member.getMemberId());

        return result;
    }

    protected LoginData mobileLogin(LoginParams params) throws ModelException {
        if (params == null) {
            throw new ModelException("登录数据有误", ExceptionCodes.PARAMS_EMPTY);
        }


        return null;
    }

    protected LoginData qrLogin(LoginParams params) throws ModelException {
        if (params == null) {
            throw new ModelException("登录数据有误", ExceptionCodes.PARAMS_EMPTY);
        }


        return null;
    }

    @Override
    public String authToken(HttpServletRequest servletRequest) {
        HttpServletRequest httpServletRequest = servletRequest;
        if (httpServletRequest == null) {
            httpServletRequest = request;
        }

        String sid = httpServletRequest.getHeader(CoreProperties.tokenAdminHeaderName());
        if (StrUtils.isBlank(sid)) {
            return null;
        }
        String key = jwtUtil.tokenKeyName(AuthMemberType.admin, sid);
        String token = RedisUtils.get(key);
        return CryptUtils.decrypt(token);
    }

    @Override
    public AuthAccount auth(HttpServletRequest servletRequest) throws ModelException {
        HttpServletRequest httpServletRequest = servletRequest;
        if (httpServletRequest == null) {
            httpServletRequest = request;
        }

        String token = authToken(httpServletRequest);


        String sid = request.getHeader(CoreProperties.tokenAdminHeaderName());

        return null;
    }
}
