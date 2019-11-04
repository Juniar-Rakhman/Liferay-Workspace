package com.rcs.liferay.hello.impl;

import com.rcs.liferay.hello.api.HelloService;
import org.osgi.service.component.annotations.Component;

/**
 * @author jrakhman
 */
@Component(
	immediate = true,
	property = {
	},
	service = HelloService.class
)
public class HelloServiceImpl implements HelloService {
	@Override
	public String sayHello(String what) {
		return "Hello " + what + " " + what;
	}
}