<#assign
    know = Session.SPRING_SECURITY_CONTEXT??
>

<#if know>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
        isUser = user.isRoleUser()
        isAdmin = user.isRoleAdministrator()
        isWorker = user.isRoleWorker()
        isDirector = user.isRoleDirector()
    >
<#else>
    <#assign
        name = "гость"
        isUser = false
        isAdmin = false
        isWorker = false
        isDirector = false
    >
</#if>