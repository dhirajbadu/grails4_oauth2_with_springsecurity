<%--
  Created by IntelliJ IDEA.
  User: dbadu
  Date: 2021-04-03
  Time: 22:21
--%>

<%@ page contentType="text/html;charset=UTF-8" %>

<li class="user-header">
    <img src="/resources/img/user-512.png" class="img-circle" alt="User Image">

    <p>
        <sec:loggedInUserInfo field='username'/>
        <sec:ifAllGranted roles="ROLE_SYSTEM">
            <br>System
        </sec:ifAllGranted>
        <sec:ifAllGranted roles="ROLE_SUPER_ADMIN">
            <br>Super Admin
        </sec:ifAllGranted>
        <sec:ifAllGranted roles="ROLE_ADMIN">
            <br>Admin
        </sec:ifAllGranted>
        <sec:ifAllGranted roles="ROLE_DATAENTRY">
            <br>Data Entry
        </sec:ifAllGranted>
    <%--<small>Member since Nov. 2012</small>--%>
    </p>
</li>
<!-- Menu Body -->
%{--<sec:authorize access="hasAuthority('Agent')">
    <li class="user-body">
        <div class="row">
            <div class="col-xs-4 text-center">
                <a href="${pageContext.request.contextPath}/agentinfo/user/profile">Profile</a>
            </div>
            <%--<div class="col-xs-4 text-center">
                <a href="#">Sales</a>
            </div>
            <div class="col-xs-4 text-center">
                <a href="#">Friends</a>
            </div>--%>
        </div>
        <!-- /.row -->
    </li>
</sec:authorize>--}%
<!-- Menu Footer-->
<li class="user-footer">
    <div class="pull-left">
        <a href="/user/changepassword" class="btn btn-default btn-flat">Change Password</a>
    </div>

    <div class="pull-right">
        %{--<a href="${createLink(controller: 'logout')}" class="btn btn-default btn-flat">Sign out</a>--}%
        <g:form controller="logout">
            <g:submitButton class="btn btn-default btn-flat" name="Submit" value="Sign out" style="color:gray"/>
        </g:form>
    </div>
</li>
