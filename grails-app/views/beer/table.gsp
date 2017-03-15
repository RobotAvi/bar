<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'beer.label', default: 'Beer')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>

<div class="nav" role="navigation">
    <ul>
        <li><g:link action="clearAll">Show table</g:link></li>
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

    <table class='table'>
        <thead>
        <tr>
            <td>Giver</td>
            <td>Receiver</td>
            <td>Amount</td>
        </tr>
        </thead>
        <tbody>
        <g:each in="${beerList}" var="item">
            <tr>
                <td>${item.giver.name?.encodeAsHTML()}</td>
                <td>${item.receiver.name?.encodeAsHTML()}</td>
                <td>${item.amount?.encodeAsHTML()}</td>
            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${beerCount ?: 0}"/>
    </div>
</div>
</body>
</html>