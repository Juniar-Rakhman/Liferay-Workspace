package com.rcs.liferay.hello.uppercase.impl;

import com.liferay.portal.kernel.util.StringUtil;
import com.rcs.liferay.hello.api.HelloService;

import org.osgi.service.component.annotations.Component;

/**
 * @author jrakhman
 */
@Component(
	immediate = true,
	property = {
		"service.ranking:Integer=100"
	},
	service = HelloService.class
)
public class HelloUppercaseServiceImpl implements HelloService {
	@Override
	public String sayHello(String what) {
		return StringUtil.upperCase(what);
	}
}