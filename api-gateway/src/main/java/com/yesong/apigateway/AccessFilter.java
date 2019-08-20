package com.yesong.apigateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {
    private final static Logger log = Logger.getLogger(AccessFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String accessToken = request.getParameter("accessToken");
        log.info("token "+accessToken);
        if(accessToken == null){
            ctx.setSendZuulResponse(false);
            ctx.setResponseBody("token fail");
            ctx.setResponseStatusCode(500);
            return null;
        }
        if(!accessToken.equals("yesong")){
            ctx.setSendZuulResponse(false);
            ctx.setResponseBody("token fail");
            ctx.setResponseStatusCode(500);
            return null;
        }
        return null;

    }
}
