<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>

    <#if isAdmin || isDirector>
        <form action="/order_save_after_redirect_for_client" method="post">
            <h4>Текущий статус заказа для клиента : ${order.orderStatusForClient}</h4>
            <h4>Текущий статус заказа для клиента :</h4>
            <select class="custom-select mb-3" type="text" id="inputGroupSelect01" name="orderStatusAfterEdit"
                    placeholder="orderStatusAfterEdit">
                <option value="READY">READY</option>
                <option value="IN_PROGRESS">IN_PROGRESS</option>
                <option value="TAKEN">TAKEN</option>
                <option value="NOT_READY">NOT_READY</option>
            </select>
            <input type="hidden" value="${order.id}" name="orderId">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <button type="submit" class="btn btn-primary">Сохранить</button>
        </form>
    </#if>

    <#if isWorker || isDirector>
        <form action="/order_save_after_redirect_for_Employers" method="post">
            <h4>Текущий статус заказа для работников : ${order.orderStatusForService}</h4>
            <h4>Текущий статус заказа для работников :</h4>
            <select class="custom-select mb-3" type="text" id="inputGroupSelect01" name="orderStatusAfterEdit"
                    placeholder="orderStatusAfterEdit">
                <option value="READY">READY</option>
                <option value="IN_PROGRESS">IN_PROGRESS</option>
                <option value="TAKEN">TAKEN</option>
                <option value="NOT_READY">NOT_READY</option>
            </select>
            <input type="hidden" value="${order.id}" name="orderId">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <button type="submit" class="btn btn-primary">Сохранить</button>
        </form>
    </#if>

</@c.page>