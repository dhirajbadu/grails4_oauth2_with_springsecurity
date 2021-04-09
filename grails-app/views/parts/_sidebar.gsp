<%--
  Created by IntelliJ IDEA.
  User: dbadu
  Date: 2021-04-03
  Time: 22:13
--%>

<%@ page contentType="text/html;charset=UTF-8" %>

<li class="header">HEADER</li>

<sec:ifAllGranted roles="ROLE_SYSTEM">
    <g:render template="/parts/sidebar-system"/>
</sec:ifAllGranted>

<sec:ifAllGranted roles="ROLE_SUPER_ADMIN">
    <g:render template="/parts/sidebar-superadmin"/>
</sec:ifAllGranted>

<sec:ifAllGranted roles="ROLE_ADMIN">
    <g:render template="/parts/sidebar-admin"/>
</sec:ifAllGranted>