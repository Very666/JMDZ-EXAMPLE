package com.gfyw.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    /**
     * 返回一个字符串代表过滤器的类型:
     * pre：可以在请求被路由之前调用
     * routing：在路由请求时候被调用
     * post：在routing和error过滤器之后被调用
     * error：处理请求时发生错误时被调用
     */
    public String filterType() {
        return "pre";
    }

    @Override
    /**
     * 通过int值来定义过滤器的执行顺序
     */
    public int filterOrder() {
        return 0;
    }

    @Override
    /**
     * 返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关
     */
    public boolean shouldFilter() {
        return true;
    }

    @Override
    /**
     * 过滤器的具体逻辑
     */
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        //对没有token的请求过滤
        Object accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            log.warn("access token is empty");
            // zuul过滤该请求，不对其进行路由
            ctx.setSendZuulResponse(false);
            //设置返回的错误码
            ctx.setResponseStatusCode(401);
            //返回body内容进行编辑
            //ctx.setResponseBody(body);
            return null;
        }
        log.info("access token ok");
        return null;
    }
}