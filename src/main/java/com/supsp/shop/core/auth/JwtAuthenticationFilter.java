package com.supsp.shop.core.auth;

import com.supsp.shop.core.auth.service.IAdminPassportService;
import com.supsp.shop.model.sys.entity.SysMember;
import com.supsp.shop.model.sys.model.SysMemberModel;
import com.supsp.springboot.core.config.CoreProperties;
import com.supsp.springboot.core.enums.AccountType;
import com.supsp.springboot.core.utils.JwtUtil;
import com.supsp.springboot.core.utils.StrUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final SysMemberModel sysMemberModel;

    private final IAdminPassportService adminPassportService;

    public JwtAuthenticationFilter(JwtUtil jwtUtil,
                                   SysMemberModel sysMemberModel,
                                   IAdminPassportService adminPassportService) {
        this.jwtUtil = jwtUtil;
        this.sysMemberModel = sysMemberModel;
        this.adminPassportService = adminPassportService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String token = adminPassportService.authToken(request);
        if (token != null && jwtUtil.validateToken(token)) {
            String account = jwtUtil.extractLoginAccount(token);
            AccountType accountType = jwtUtil.extractAccountType(token);
            String loginPwd = jwtUtil.extractLoginPwd(token);
            Long memberId = jwtUtil.extractMemberId(token);

            log.debug(
                    """
                            
                            account: {}
                            accountType: {}
                            loginPwd: {}
                            memberId: {}
                            """,
                    account,
                    accountType,
                    loginPwd,
                    memberId
            );

            SysMember member = null;
            try {
                member = sysMemberModel.detail(memberId);
            } catch (Exception e) {
                throw new ServletException("认证失败");
            }

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            member,
                            null,
                            List.of(() -> "ROLE_USER"));

            authentication.setDetails(
                    new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    private String parseJwt(HttpServletRequest request) {

        String headerAuth = request.getHeader(CoreProperties.tokenAdminHeaderName());
        if (StrUtils.isNotBlank(headerAuth)) {
            return headerAuth;
        }
        return null;
    }

}
