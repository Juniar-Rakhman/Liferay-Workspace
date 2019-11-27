<%@ include file="/init.jsp" %>

<%
	String sampleText = (String) renderRequest.getParameter("messageReceived");
%>

<aui:form>
	<aui:input name="receivedText" label="Received Text : " readOnly="true" value="<%=sampleText %>"/>
</aui:form>