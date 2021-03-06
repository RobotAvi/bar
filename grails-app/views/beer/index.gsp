<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'beer.label', default: 'Beer')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>

<a href="#list-beer" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                           default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><g:link action="table">Show table</g:link></li>
        <li><g:link action="json">Get Json For Element #6</g:link></li>
        <li><g:link action="get3d">Show beers in 3d</g:link></li>
    </ul>
    <ul>
        <li><g:link action="fill">Random fill</g:link></li>
        <li><g:link action="clear">Clear Beers</g:link></li>
        <li><g:link action="clearAll">Clear Beers and Members</g:link></li>
    </ul>
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-beer" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <f:table collection="${beerList}"/>

    <div class="pagination">
        <g:paginate total="${beerCount ?: 0}"/>
    </div>
</div>
</body>
</html>