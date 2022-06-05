<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>

    <h1>Список заказов</h1>

    <#if isDirector || isAdmin || isWorker>
        <h2>Найти заказы по id пользователя</h2>
        <form action="/ordersByOwnerId" method="post">
            <div class="form-group">
            <input type="text" name="ownerIdToFindOrders" placeholder="id" class="form-control"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}" class="form-control"/>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Поиск</button>
            </div>
        </form>
    </#if>

        <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
           aria-controls="collapseExample">
            Добавить новый заказ
        </a>
        <div class="collapse" id="collapseExample">
            <div class="form-group mt-3">
                <form action="/addOrder" method="post">
                    <div class="form-group">
                        <input type="text" name="markOfCar" placeholder="Марка машины" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <input type="text" name="modelOfBody" placeholder="Модель машины" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <input type="text" name="vinNumber" placeholder="VIN номер" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <input type="text" name="carMileage" placeholder="Пробег" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <input type="text" name="nameOfOwner" placeholder="Имя владельца" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <input type="text" name="surnameOfOwner" placeholder="Фамилия владельца" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <input type="text" name="orderPhoneNumber" placeholder="Номер телефона" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <input type="text" name="description" placeholder="Описание неисправности" class="form-control"/>
                    </div>

                    <input type="hidden" name="_csrf" value="${_csrf.token}" class="form-control"/>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Добавить</button>
                    </div>
                </form>
            </div>
        </div>


    <table class="table mt-3">
    <thead class="thead-dark">
    <tr align="center">
        <th scope="col">#</th>
        <th scope="col">Id</th>
        <th scope="col">Марка машины</th>
        <th scope="col">Модель машины</th>
        <th scope="col">VIN номер</th>
        <th scope="col">Пробег</th>
        <th scope="col">Имя владельца</th>
        <th scope="col">Фамилия владельца</th>
        <th scope="col">Номер телефона</th>
        <th scope="col">Статус заказа</th>
        <th scope="col">Детали</th>

        <#if isAdmin || isWorker || isDirector>
            <th scope="col">Рабочий статус</th>
            <th scope="col">Редактировать заказ</th>
            <#if isAdmin || isDirector>
                <th scope="col">Удалить заказ</th>
            </#if>
        </#if>

    </tr>
    </thead>
    <tbody>
    <#list orders as order>
        <div>
            <tr>
                <th scope="row"><b>${order.id}</b></th>
                <td><strong>${order.orderOwnerId}</strong></td>
                <td><strong>${order.markOfCar}</strong></td>
                <td><strong>${order.modelOfBody}</strong></td>
                <td><strong>${order.vinNumber}</strong></td>
                <td><strong>${order.carMileage}</strong></td>
                <td><strong>${order.nameOfOwner}</strong></td>
                <td><strong>${order.surnameOfOwner}</strong></td>
                <td><strong>${order.orderPhoneNumber}</strong></td>
                <td><strong>${order.orderStatusForClient}</strong></td>
                <td><strong><a href="/order/info/${order.id}" style="color:blue">Инфо</a></strong></td>

                <#if isAdmin || isWorker || isDirector>
                    <td><strong>${order.orderStatusForService}</strong></td>
                    <td><strong><a href="/order/edit/${order.id}" style="color:blue">Редактировать</a></strong></td>
                    <#if isAdmin || isDirector>
                    <td><strong><a href="/order/delete/${order.id}" style="color:red">Удалить</a></strong></td>
                    </#if>
                    <#--<td><a href="/flight/${flight.id}">Edit</a></td>-->
                </#if>
            </tr>
        </div>
    <#else>

    </#list>

</@c.page>