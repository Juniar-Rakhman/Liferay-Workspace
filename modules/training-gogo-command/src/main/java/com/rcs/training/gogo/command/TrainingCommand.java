package com.rcs.training.gogo.command;

import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    immediate = true,
    property = {
        "osgi.command.scope=blade", //the namespace
        "osgi.command.function=portalStats" //the command
    },
    service = Object.class
)
public class TrainingCommand {

    @Reference
    private UserLocalService userLocalService;

    @Reference
    private GroupLocalService groupLocalService;

    public UserLocalService getUserLocalService() {
        return userLocalService;
    }

    public void setUserLocalService(UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    public void portalStats() {
        System.out.println("# of users : " + getUserLocalService().getUsersCount());
        System.out.println("# of groups : " + groupLocalService.getGroupsCount());
    }

}
