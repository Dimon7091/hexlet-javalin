@import org.example.hexlet.dto.courses.CoursesPage

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

                <h2><a href="/courses/${course.getId()}">${course.getName()}</a></h2>
                <p>${course.getDescription()}</p>

        @endfor
    @endif
    <div>

           @if (page.getCurrentPage() > 1)
               <a href="/courses/?page=${page.getCurrentPage() - 1}" class="btn btn-primary">&lt Предыдущая страница</a>
           @endif
           <span class="btn btn-primary" style="font-size: 20px;">${page.getCurrentPage()}</span>
           @if (page.getCurrentPage() < page.getTotalPages())
               <a href="/courses/?page=${page.getCurrentPage() + 1}" class="btn btn-primary">Следующая страница &gt</a>
           @endif

    </div>
`
)






