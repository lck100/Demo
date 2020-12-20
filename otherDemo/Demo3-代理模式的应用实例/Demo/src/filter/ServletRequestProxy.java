package filter;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.*;

public class ServletRequestProxy implements HttpServletRequest {
    private HttpServletRequest target;

    public ServletRequestProxy(HttpServletRequest target) {
        this.target = target;
    }


    @Override
    public String getAuthType() {
        return target.getAuthType();
    }

    @Override
    public Cookie[] getCookies() {
        return target.getCookies();
    }

    @Override
    public long getDateHeader(String s) {
        return target.getDateHeader(s);
    }

    @Override
    public String getHeader(String s) {
        return target.getHeader(s);
    }

    @Override
    public Enumeration<String> getHeaders(String s) {
        return target.getHeaders(s);
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        return target.getHeaderNames();
    }

    @Override
    public int getIntHeader(String s) {
        return target.getIntHeader(s);
    }

    @Override
    public String getMethod() {
        return target.getMethod();
    }

    @Override
    public String getPathInfo() {
        return target.getPathInfo();
    }

    @Override
    public String getPathTranslated() {
        return target.getPathTranslated();
    }

    @Override
    public String getContextPath() {
        return target.getContextPath();
    }

    @Override
    public String getQueryString() {
        return target.getQueryString();
    }

    @Override
    public String getRemoteUser() {
        return target.getRemoteUser();
    }

    @Override
    public boolean isUserInRole(String s) {
        return target.isUserInRole(s);
    }

    @Override
    public Principal getUserPrincipal() {
        return target.getUserPrincipal();
    }

    @Override
    public String getRequestedSessionId() {
        return target.getRequestedSessionId();
    }

    @Override
    public String getRequestURI() {
        return target.getRequestURI();
    }

    @Override
    public StringBuffer getRequestURL() {
        return target.getRequestURL();
    }

    @Override
    public String getServletPath() {
        return target.getServletPath();
    }

    @Override
    public HttpSession getSession(boolean b) {
        return target.getSession(b);
    }

    @Override
    public HttpSession getSession() {
        return target.getSession();
    }

    @Override
    public String changeSessionId() {
        return target.changeSessionId();
    }

    @Override
    public boolean isRequestedSessionIdValid() {
        return target.isRequestedSessionIdValid();
    }

    @Override
    public boolean isRequestedSessionIdFromCookie() {
        return target.isRequestedSessionIdFromCookie();
    }

    @Override
    public boolean isRequestedSessionIdFromURL() {
        return target.isRequestedSessionIdFromURL();
    }

    @Override
    public boolean isRequestedSessionIdFromUrl() {
        return target.isRequestedSessionIdFromUrl();
    }

    @Override
    public boolean authenticate(HttpServletResponse httpServletResponse) throws IOException, ServletException {
        return target.authenticate(httpServletResponse);
    }

    @Override
    public void login(String s, String s1) throws ServletException {
        target.login(s, s1);
    }

    @Override
    public void logout() throws ServletException {
        target.logout();
    }

    @Override
    public Collection<Part> getParts() throws IOException, ServletException {
        return target.getParts();
    }

    @Override
    public Part getPart(String s) throws IOException, ServletException {
        return target.getPart(s);
    }

    @Override
    public <T extends HttpUpgradeHandler> T upgrade(Class<T> aClass) throws IOException, ServletException {
        return target.upgrade(aClass);
    }

    @Override
    public Object getAttribute(String s) {
        return target.getAttribute(s);
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        return target.getAttributeNames();
    }

    @Override
    public String getCharacterEncoding() {
        return target.getCharacterEncoding();
    }

    @Override
    public void setCharacterEncoding(String s) throws UnsupportedEncodingException {
        target.setCharacterEncoding(s);
    }

    @Override
    public int getContentLength() {
        return target.getContentLength();
    }

    @Override
    public long getContentLengthLong() {
        return target.getContentLengthLong();
    }

    @Override
    public String getContentType() {
        return target.getContentType();
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return target.getInputStream();
    }

    @Override
    public String getParameter(String s) {
        List<String> list = new ArrayList<String>();//敏感词汇集合
        list.addAll(Arrays.asList("坏蛋", "混蛋", "傻瓜", "蠢货"));
        String returnVal = target.getParameter(s);
        if (returnVal != null) {
            for (String str : list) {
                if (returnVal.contains(str)) {
                    returnVal = returnVal.replaceAll(str, "***");
                }
            }
        }
        return returnVal;
    }

    @Override
    public Enumeration<String> getParameterNames() {
        return target.getParameterNames();
    }

    @Override
    public String[] getParameterValues(String s) {
        return target.getParameterValues(s);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return target.getParameterMap();
    }

    @Override
    public String getProtocol() {
        return target.getProtocol();
    }

    @Override
    public String getScheme() {
        return target.getScheme();
    }

    @Override
    public String getServerName() {
        return target.getServerName();
    }

    @Override
    public int getServerPort() {
        return target.getServerPort();
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return target.getReader();
    }

    @Override
    public String getRemoteAddr() {
        return target.getRemoteAddr();
    }

    @Override
    public String getRemoteHost() {
        return target.getRemoteHost();
    }

    @Override
    public void setAttribute(String s, Object o) {
        target.setAttribute(s, o);
    }

    @Override
    public void removeAttribute(String s) {
        target.removeAttribute(s);
    }

    @Override
    public Locale getLocale() {
        return target.getLocale();
    }

    @Override
    public Enumeration<Locale> getLocales() {
        return target.getLocales();
    }

    @Override
    public boolean isSecure() {
        return target.isSecure();
    }

    @Override
    public RequestDispatcher getRequestDispatcher(String s) {
        return target.getRequestDispatcher(s);
    }

    @Override
    public String getRealPath(String s) {
        return target.getRealPath(s);
    }

    @Override
    public int getRemotePort() {
        return target.getRemotePort();
    }

    @Override
    public String getLocalName() {
        return target.getLocalName();
    }

    @Override
    public String getLocalAddr() {
        return target.getLocalAddr();
    }

    @Override
    public int getLocalPort() {
        return target.getLocalPort();
    }

    @Override
    public ServletContext getServletContext() {
        return target.getServletContext();
    }

    @Override
    public AsyncContext startAsync() throws IllegalStateException {
        return target.startAsync();
    }

    @Override
    public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
        return target.startAsync(servletRequest, servletResponse);
    }

    @Override
    public boolean isAsyncStarted() {
        return target.isAsyncStarted();
    }

    @Override
    public boolean isAsyncSupported() {
        return target.isAsyncSupported();
    }

    @Override
    public AsyncContext getAsyncContext() {
        return target.getAsyncContext();
    }

    @Override
    public DispatcherType getDispatcherType() {
        return target.getDispatcherType();
    }
}
