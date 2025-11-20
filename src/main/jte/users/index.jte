@import org.example.hexlet.dto.UsersPage
@param UsersPage  page

@template.layout.page(
content = @`

    <h1>Пользователи</h1>

    @if(page.getUsers().isEmpty())
        <p>Пока не добавлено ни одного пользователя</p>
    @else
        @for(var user : page.getUsers())

            <h2><a href="/users/show.jte${user.getId()}">${user.getName()} ${user.getEmail()}</a></h2>
        @endfor
    @endif
`
)