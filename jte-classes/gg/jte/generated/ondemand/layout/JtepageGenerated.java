package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,30,30,30,30,38,38,38,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content) {
		jteOutput.writeContent("\n<!doctype html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\">\n    <title>Моё Приложение</title>\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\n    <style>\n        body { font-family: Arial, sans-serif; margin: 20px; }\n        header { background: #f0f0f0; padding: 10px; border-bottom: 1px solid #ccc; }\n        nav a { margin-right: 15px; text-decoration: none; color: #333; }\n        main { margin: 20px 0; }\n        footer { text-align: center; margin-top: 20px; font-size: 0.9em; color: #666; }\n    </style>\n</head>\n<body>\n<header>\n    <nav>\n        <a href=\"/\">Главная</a> |\n        <a href=\"/courses/build\">Создать курс</a> |\n        <a href=\"/courses\">Курсы</a> | |\n        <a href=\"/users/build\">Создать пользователя</a> |\n        <a href=\"/users\">Все пользователи</a>\n    </nav>\n</header>\n\n<main>\n    <div class=\"content\">\n        ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n    </div>\n</main>\n<footer class=\"footer\">\n    <p>&copy; 2025 Приложение на JTE. Автор: Мой профиль на GitLab - <a href=\"https://gitlab.com/username\" target=\"_blank\">gitlab.com/username</a></p>\n</footer>\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		render(jteOutput, jteHtmlInterceptor, content);
	}
}
