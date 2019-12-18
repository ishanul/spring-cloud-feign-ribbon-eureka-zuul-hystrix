package com.example.ishan.netflixzuulapigateway;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLogginFilter extends ZuulFilter{

	private Logger logger = LoggerFactory.getLogger(ZuulLogginFilter.class);
	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {} uri {}", request, request.getRequestURI());
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

}
