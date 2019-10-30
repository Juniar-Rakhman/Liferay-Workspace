package com.rcs.liferay.command;

import com.rcs.liferay.hello.api.HelloService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author jrakhman
 */
@Component(
        immediate = true,
        property = {
        		"osgi.command.function=say",
				"osgi.command.scope=custom"
        },
        service = Object.class
)
public class HelloWorldCommand {

	@Reference
	private HelloService helloService;


	public void say(String what) {
		System.out.println(helloService.sayHello(what));
	}
}