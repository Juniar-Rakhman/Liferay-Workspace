package com.rcs.liferay.command;

import com.rcs.liferay.hello.api.HelloService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

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


	private HelloService helloService;


	public void say(String what) {
		System.out.println(helloService.sayHello(what));
	}

	@Reference(policy = ReferencePolicy.DYNAMIC,
			policyOption = ReferencePolicyOption.GREEDY,
			cardinality = ReferenceCardinality.MANDATORY)
	protected void setHelloService(HelloService helloService) {
		System.out.println("Set hello service : " + helloService.getClass().getName());
		this.helloService = helloService;
	}

	protected void unsetHelloService(HelloService helloService) {
		System.out.println("Unset hello service : " + helloService.getClass().getName());
		if (helloService == this.helloService) {
			this.helloService = null;
		}
	}
}