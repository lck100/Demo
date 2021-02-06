package com.demo.shiro.realm;

import com.demo.domain.User;
import com.demo.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    // 完成授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    // 完成认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // authenticationToken是主体传过来的认证信息，如果使用的是UsernamePasswordToken，那么可以转换成该类型
        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        // 1.获取用户输入的用户名
        String username=token.getUsername();// token.getPrincipal();也是获取相同的用户名
        // 2.通过用户名从数据库中查询用户信息
        User user = userService.selectUserByUsername(username);
        // 3.判断查询到的用户信息是否有效
        if(user==null){
            throw new UnknownAccountException();
        }
        if(0==user.getState()){// 用户状态为0，表示该用户被禁用了
            throw new DisabledAccountException();
        }
        // 4.返回用户认证信息
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(
                username,// 可以是用户名，也可以是用户信息
                user.getPassword(),// 用户密码
                ByteSource.Util.bytes(username),// 为密码加的盐
                getName());// 固定写法，是一个名字
        return info;
    }

    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("123456", "root");// 获取密码“123456”加盐后的值
        System.out.println(md5Hash.toString());
    }
}
