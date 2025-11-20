
@template.layout.page(
content = @`
    <form action="/users" method="post">
        <div style="margin: 10px">
            <label>
                Имя
                <input type="text" name="name" />
            </label>
        </div>
        <div style="margin: 10px">
            <label>
                Email
                <input type="email" required name="email" />
            </label>
        </div>
        <div style="margin: 10px">
            <label>
                Пароль
                <input type="password" required name="password" />
            </label>
        </div>
        <div style="margin: 10px">
            <label>
                Подтверждение пароля
                <input type="password" required name="passwordConfirmation" />
            </label>
        </div>
        <input type="submit" value="Зарегистрировать" />
    </form>
`
)
