package com.rcs.training.portlet.jsr286;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class JSR286Portlet implements Portlet {

    @Override
    public void init(PortletConfig config) throws PortletException {
        System.out.println("Inside init()");
    }

    @Override
    public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException {
        System.out.println("Inside processAction()");
    }

    @Override
    public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        System.out.println("Inside render()");

//        PrintWriter printWriter = response.getWriter();
//        printWriter.write("I'M PICKLE RIIIIIICK!!");

        String path = "/META-INF/resources/view.jsp";
        PortletSession portletSession = request.getPortletSession();
        PortletContext portletContext = portletSession.getPortletContext();
        PortletRequestDispatcher portletRequestDispatcher = portletContext.getRequestDispatcher(path);

        if (portletRequestDispatcher == null) {
            System.err.println(path + "is not valid");
        } else {
            portletRequestDispatcher.include(request, response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("Inside destroy()");
    }
}