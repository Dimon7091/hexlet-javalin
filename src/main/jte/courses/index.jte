@import org.example.hexlet.dto.CoursesPage

@param CoursesPage page

@template.layout.page(
    content = @`
    <h1>Курсы по програмированию</h1>

    <form action="/courses" method="get">
        <label for="search">Поиск</label>
        <input type="search" required name="term" value="${page.getTerm()}">
        <input type="submit" value="Искать">
    </form>

    @if(page.getCourses().isEmpty())
        <p>Пока не добавлено ни одного курса</p>
    @else
        @for(var course : page.getCourses())

                <h2><a href="/courses/{id}${course.getId()}">${course.getName()}</a></h2>
                <p>${course.getDescription()}</p>

        @endfor
    @endif`
)






