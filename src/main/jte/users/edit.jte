@import org.example.hexlet.dto.users.UserPage
@param UserPage page

@template.layout.page(
content = @`
    <form action="/users/${page.getUser().getId()}" method="post">
        <div>
            <label>
                Имя
                <input type="text" name="name" value="${page.getUser().getName()}" />
            </label>
        </div>
        <div>
            <label>
                Email
                <input type="email" required name="email" value="${page.getUser().getEmail()}" />
            </label>
        </div>
        <div>
            <label>
                Пароль
                <input type="password" required name="password" />
            </label>
        </div>
        <div>
            <label>
                Подтверждение пароля
                <input type="password" required name="passwordConfirmation" />
            </label>
        </div>
        <input type="submit" value="Обновить" />
    </form>
`
)