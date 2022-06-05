<#import "parts/common.ftl" as c>

<@c.page>
    <h5>${username}</h5>
    <form method="post" xmlns="http://www.w3.org/1999/html" action="/user/profile">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Пароль: </label>
            <div class="col-sm-7">
                <input type="password" name="password" class="form-control" placeholder="Пароль"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Email: </label>
            <div class="col-sm-7">
                <input type="email" name="email" class="form-control" placeholder="some@some.com" value="${email!''}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Номер телефона: </label>
            <div class="col-sm-7">
                <input type="tel" name="tel" pattern="+375-([0-9]{2})-[0-9]{7}" class="form-control" placeholder="+375291111111" value="${tel!''}"/>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-primary" type="submit">Сохранить</button>
    </form>
</@c.page>