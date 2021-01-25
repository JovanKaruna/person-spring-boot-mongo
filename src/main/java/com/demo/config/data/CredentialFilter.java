package com.demo.config.data;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class CredentialFilter extends OncePerRequestFilter {

	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			FilterChain filterChain) throws ServletException, IOException {
		Credential.setStoreId(httpServletRequest.getParameter("storeId"));
		Credential.setChannelId(httpServletRequest.getParameter("channelId"));
		Credential.setClientId(httpServletRequest.getParameter("clientId"));
		Credential.setRequestId(httpServletRequest.getParameter("requestId"));
		Credential.setUsername(httpServletRequest.getParameter("username"));
		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}
}
