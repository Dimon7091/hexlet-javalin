@import org.example.hexlet.dto.users.UsersPage
@param UsersPage  page

@template.layout.page(
content = @`

    <h1>Пользователи</h1>

    @if(page.getUsers().isEmpty())
        <p>Пока не добавлено ни одного пользователя</p>
    @else
        <ul>
            @for(var user : page.getUsers())
                <li>
                    <h2><a href="/users/${user.getId()}">Имя: ${user.getName()} <br> Email: ${user.getEmail()}</a></h2>
                </li>
            @endfor
        </ul>
    @endif
`
)