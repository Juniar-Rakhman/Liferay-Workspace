<%@ include file="/init.jsp" %>

<portlet:actionURL var="actionUrl" name="processEvent"/>

<aui:form method="post" action="${actionUrl}">

    <aui:input name="sampleText" label="Sample Text"/>

    <aui:button-row>
        <aui:button type="submit" value="Send"/>
    </aui:button-row>

</aui:form>