<%--
  Created by IntelliJ IDEA.
  User: dbadu
  Date: 2021-04-03
  Time: 22:13
--%>

<%@ page contentType="text/html;charset=UTF-8" %>

<sec:ifAllGranted roles="ROLE_USER">
    </sec:ifAllGranted>
<li class="header">HEADER</li>
<li><a href="${createLink(controller: 'home' ,  action: 'index')}"><i class="fa fa-dashboard"></i> <span>Index</span></a></li>
<li><a href="/dashboard"><i class="fa fa-dashboard"></i> <span>Dashboard</span></a></li>