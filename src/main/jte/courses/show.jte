@import org.example.hexlet.dto.courses.CoursePage
@param CoursePage page


@template.layout.page(
content = @`
    <h2>ID курса: ${page.getCourse().getId()}</h2>
    <h1>${page.getCourse().getName()}</h1>
    <h3>${page.getCourse().getDescription()}</h3>
    <a href="/courses">Ко всем курсам</a>
`
)