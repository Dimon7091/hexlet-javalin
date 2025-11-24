@import org.example.hexlet.dto.BuildCoursePage
@param BuildCoursePage page

@template.layout.page(
content = @`

    @if(page.getErrors() != null && page.getErrors().containsKey("name"))
        <ul>
            @for(var error : page.getErrors().get("name"))
                <li style="color: red;">${error.getMessage()}</li>
            @endfor
        </ul>
    @endif
    @if(page.getErrors() != null && page.getErrors().containsKey("description"))
        <ul>
            @for(var error : page.getErrors().get("description"))
                <li style="color: red;">${error.getMessage()}</li>
            @endfor
        </ul>
    @endif

    <form action="/courses" method="post">
        <div style="margin: 10px">
            <label>
                Имя
                <input type="text" name="name" value="${page.getName()}"/>
            </label>
        </div>
        <div style="margin: 10px">
            <label>
                 Описание
                 <textarea id="description" name="description" rows="4" cols="50">
                     ${page.getDescription()}
                 </textarea>
            </label>
        </div>
        <input type="submit" value="Создать" />
    </form>
`
)
