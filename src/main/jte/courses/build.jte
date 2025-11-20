@template.layout.page(
content = @`
    <form action="/courses" method="post">
        <div style="margin: 10px">
            <label>
                Имя
                <input type="text" name="name" />
            </label>
        </div>
        <div style="margin: 10px">
            <label>
                 <textarea id="description" name="description" rows="4" cols="50">

                 </textarea>
            </label>
        </div>
        <input type="submit" value="Создать" />
    </form>
`
)
