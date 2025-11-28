@import org.example.hexlet.dto.MainPage
@param MainPage page

@template.layout.page(
    content = @`
    <h1>Добро пожаловать!</h1>
    <p>Это главная страница.</p>
    @if(!page.getVisited())
        <h2> Это сообщение показывается только один раз. Если вы хотите увидеть его снова, сотрите куки</h2>
    @endif
`
)

