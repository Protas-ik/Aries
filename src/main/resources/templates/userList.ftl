<#import "parts/common.ftl" as c>

<@c.page>

    <h1>Список пользователей</h1>

    <table class="table mt-3">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Имя</th>
            <th scope="col">Роль</th>
            <th scope="col">Редактировать</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td><a href="/user/${user.id}">редактировать</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>