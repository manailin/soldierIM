package com.wowtour.frame.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

public class EhcacheLoginMatcher extends HashedCredentialsMatcher {

//	private final Cache<String, AtomicInteger> passwordCache; // 原子

//	public EhcacheLoginMatcher(CacheManager cacheManager) {
//		passwordCache = cacheManager.getCache("passwordCache");
//	}

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token,
			AuthenticationInfo info) {
		return true;
	}
}
