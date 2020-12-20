package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 敏感词汇过滤器
 */
@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {
    private List<String> list = new ArrayList<String>();//敏感词汇集合

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        list.addAll(Arrays.asList("坏蛋", "混蛋", "傻瓜", "蠢货"));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//        // 动态代理
//        ServletRequest req=(ServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                // 增强getParameter方法
//                // 判断是否是getParameter方法
//                if(method.getName().equals("getParameter")){
//                    //增强返回值
//                    //获取返回值
//                    String returnVal = (String)method.invoke(request, args);
//                    if(returnVal!=null){
//                        for (String s : list) {
//                            if(returnVal.contains(s)){
//                                returnVal=returnVal.replaceAll(s,"***");
//                            }
//                        }
//                    }
//                    return returnVal;
//                }
//                return method.invoke(request,args);
//            }
//        });
        // 静态代理
        ServletRequestProxy requestProxy = new ServletRequestProxy((HttpServletRequest) request);
        filterChain.doFilter(requestProxy, response);
    }

    @Override
    public void destroy() {

    }
}
