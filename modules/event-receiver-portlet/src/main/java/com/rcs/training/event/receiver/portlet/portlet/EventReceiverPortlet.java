package com.rcs.training.event.receiver.portlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.rcs.training.event.receiver.portlet.constants.EventReceiverPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessEvent;

/**
 * @author jrakhman
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=EventReceiver",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + EventReceiverPortletKeys.EVENT_RECEIVER,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user",
                "javax.portlet.supported-processing-event=ipc-text;http://www.rithm.nl",
        },
        service = Portlet.class
)
public class EventReceiverPortlet extends MVCPortlet {

    @ProcessEvent(qname = "{http://www.rithm.nl}ipc-text")
    public void handleProcessedMessage(EventRequest request, EventResponse response) {
        Event event = request.getEvent();
        String message = (String) event.getValue();
        response.setRenderParameter("messageReceived", message);
    }

}