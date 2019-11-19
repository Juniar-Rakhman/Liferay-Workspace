package com.rcs.training.simple.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.rcs.training.simple.portlet.constants.SimpleMVCPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name" + SimpleMVCPortletKeys.SIMPLEMVC,  //Portlet we're listening to
                "mvc.command.name=handleForm" //Action we're listening for
        }
)
public class HandleFormMVCActionCommand implements MVCActionCommand {
    @Override
    public boolean processAction(
            ActionRequest actionRequest, ActionResponse actionResponse)
            throws PortletException {

        handleActionCommand(actionRequest);

        return true;
    }

    private void handleActionCommand(ActionRequest actionRequest) {

        System.out.println("HandleFormMVCActionCommand.doProcessAction()");

        String backgroundColor = actionRequest.getParameter("backgroundColor");

        System.out.println("backgroundColor = " + backgroundColor);

    }
}