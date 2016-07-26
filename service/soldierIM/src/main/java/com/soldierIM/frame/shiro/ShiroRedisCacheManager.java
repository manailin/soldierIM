package com.wowtour.frame.shiro;

import org.apache.shiro.cache.AbstractCacheManager;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

import com.wowtour.frame.utils.redis.cache.ICache;

/**
 * shiro session管理
 * 
 * @author bear
 *
 */
public class ShiroRedisCacheManager extends AbstractCacheManager {
	private ICache cache;

	@SuppressWarnings("rawtypes")
	@Override
	protected Cache createCache(String cacheName) throws CacheException {
		return new ShiroRedisCache<String, Object>(cacheName, cache);
	}

	public ICache getCache() {
		return cache;
	}

	public void setCache(ICache cache) {
		this.cache = cache;
	}

}
