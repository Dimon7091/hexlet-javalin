@import org.example.hexlet.dto.users.UserPage
@param UserPage page


@template.layout.page(
content = @`
    <h2>ID юзера: ${page.getUser().getId()}</h2>
    <h1>Имя: ${page.getUser().getName()}</h1>
    <h3>Email: ${page.getUser().getEmail()}</h3>
    <a href="/users/${page.getUser().getId()}/edit" class="btn btn-primary" >Редактировать</a>
    <a href="/users/${page.getUser().getId()}/delete" class="btn btn-primary" >Удалить</a>
`
)