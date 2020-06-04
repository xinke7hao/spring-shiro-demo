package com.tuliu.demo.springshiro.config;

import com.tuliu.demo.springshiro.service.ShiroAuthService;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xuyanbo
 * @date 2020/6/4
 */
@Configuration
public class ShiroConfig {

    /**
     * 基本配置
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(org.apache.shiro.mgt.SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //登录
        shiroFilterFactoryBean.setLoginUrl("/tologin");
        //首页
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //错误页面，认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        //页面权限控制
        shiroFilterFactoryBean.setFilterChainDefinitionMap(shiroFilterMap());
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        return shiroFilterFactoryBean;
    }

    private static Map<String, String> shiroFilterMap() {
        LinkedHashMap<String, String> filters = new LinkedHashMap<>();
        //对所有用户认证
        filters.put("/static/**", "anon");
        filters.put("/login", "anon");
        filters.put("/logout", "logout");
        //对所有页面进行认证
        filters.put("/**", "authc");
        return filters;
    }

    /**
     * web应用管理配置
     *
     * @param shiroRealm
     * @param cacheManager
     * @param manager
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager(Realm shiroRealm, CacheManager cacheManager, RememberMeManager manager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setCacheManager(cacheManager);
        securityManager.setRememberMeManager(manager);
        securityManager.setRealm(shiroRealm);
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    /**
     * session过期控制
     *
     * @return
     * @author fuce
     * @Date 2019年11月2日 下午12:49:49
     */
    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
        // 设置session过期时间3600(毫秒)
        defaultWebSessionManager.setGlobalSessionTimeout(60 * 60 * 1000);
        return defaultWebSessionManager;
    }

    /**
     * 加密算法
     *
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //MD5加密
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        //加密次数
        hashedCredentialsMatcher.setHashIterations(1);
        return hashedCredentialsMatcher;
    }

    /**
     * 记住我的配置
     *
     * @return
     */
    @Bean
    public RememberMeManager rememberMeManager() {
        Cookie cookie = new SimpleCookie("rememberMe");
        //通过js脚本将无法读取到cookie信息
        cookie.setHttpOnly(true);
        //cookie有效期
        cookie.setMaxAge(60 * 60 * 24);
        CookieRememberMeManager manager = new CookieRememberMeManager();
        manager.setCookie(cookie);
        return manager;
    }

    /**
     * 缓存配置
     *
     * @return
     */
    @Bean
    public CacheManager cacheManager() {
        //使用内存缓存
        MemoryConstrainedCacheManager cacheManager = new MemoryConstrainedCacheManager();
        return cacheManager;
    }

    /**
     * 配置realm，用于认证和授权
     *
     * @param hashedCredentialsMatcher
     * @return
     */
    @Bean
    public AuthorizingRealm shiroRealm(HashedCredentialsMatcher hashedCredentialsMatcher) {
        ShiroAuthService shiroRealm = new ShiroAuthService();
        //校验密码用到的算法
//        shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return shiroRealm;
    }

    /**
     * 启用shiro注解
     * 加入注解的使用，不加入这个注解不生效
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(org.apache.shiro.mgt.SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

}
