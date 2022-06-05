<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Автоград</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <#if isWorker || isAdmin || isUser || isDirector>
                <li class="nav-item">
                    <a class="nav-link" href="/orders">Заказы</a>
                </li>
            </#if>
            <#if isDirector>
            <li class="nav-item">
                <a class="nav-link" href="/user">Список пользователей</a>
            </li>
            </#if>
<#--            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/">Employers</a>
                </li>
            </#if>-->
            <#if isUser || isAdmin || isDirector>
                <li class="nav-item">
                    <a class="nav-link" href="/user/profile">Профиль</a>
                </li>
            </#if>
            <li class="nav-item">
                <a class="nav-link" href="/services">Услуги</a>
            </li>
        </ul>

        <div class="navbar-text mr-3">${name}</div>
        <#if isWorker || isAdmin || isUser || isDirector>
            <@l.logout/>
        <#else>
            <form action="/login" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button class="btn btn-primary">Войти</button>
            </form>
        </#if>

    </div>
</nav>