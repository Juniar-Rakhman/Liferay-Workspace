package com.rcs.training.event.publisher.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.rcs.training.event.publisher.constants.EventPublisherPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;
import javax.xml.namespace.QName;

/**
 * @author jrakhman
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=EventPublisher",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EventPublisherPortletKeys.EVENT_PUBLISHER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supported-publishing-event=message;http://www.rithm.nl",
	},
	service = Portlet.class
)
public class EventPublisherPortlet extends MVCPortlet {

	@ProcessAction(name = "processEvent")
	public void process(ActionRequest request, ActionResponse response) {
		String sampleText = ParamUtil.getString(request, "sampleText", "");
		QName qName = new QName("http://www.rithm.nl", "ipc-text");
		response.setEvent(qName, sampleText);
	}
}