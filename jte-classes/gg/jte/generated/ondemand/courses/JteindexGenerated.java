package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursesPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "courses/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,4,4,6,6,11,11,11,11,11,11,11,11,11,15,15,17,17,18,18,20,20,20,20,20,20,20,21,21,21,23,23,24,24,27,27,28,28,28,28,29,29,30,30,30,31,31,32,32,32,32,33,33,36,36,36,43,43,43,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursesPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <h1>Курсы по програмированию</h1>\n\n    <form action=\"/courses\" method=\"get\">\n        <label for=\"search\">Поиск</label>\n        <input type=\"search\" required name=\"term\"");
				var __jte_html_attribute_0 = page.getTerm();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">\n        <input type=\"submit\" value=\"Искать\">\n    </form>\n\n    ");
				if (page.getCourses().isEmpty()) {
					jteOutput.writeContent("\n        <p>Пока не добавлено ни одного курса</p>\n    ");
				} else {
					jteOutput.writeContent("\n        ");
					for (var course : page.getCourses()) {
						jteOutput.writeContent("\n\n                <h2><a href=\"/courses/");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(course.getId());
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\">");
						jteOutput.setContext("a", null);
						jteOutput.writeUserContent(course.getName());
						jteOutput.writeContent("</a></h2>\n                <p>");
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(course.getDescription());
						jteOutput.writeContent("</p>\n\n        ");
					}
					jteOutput.writeContent("\n    ");
				}
				jteOutput.writeContent("\n    <div>\n\n           ");
				if (page.getCurrentPage() > 1) {
					jteOutput.writeContent("\n               <a href=\"/courses/?page=");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(page.getCurrentPage() - 1);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\" class=\"btn btn-primary\">&lt Предыдущая страница</a>\n           ");
				}
				jteOutput.writeContent("\n           <span class=\"btn btn-primary\" style=\"font-size: 20px;\">");
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(page.getCurrentPage());
				jteOutput.writeContent("</span>\n           ");
				if (page.getCurrentPage() < page.getTotalPages()) {
					jteOutput.writeContent("\n               <a href=\"/courses/?page=");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(page.getCurrentPage() + 1);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\" class=\"btn btn-primary\">Следующая страница &gt</a>\n           ");
				}
				jteOutput.writeContent("\n\n    </div>\n");
			}
		});
		jteOutput.writeContent("\n\n\n\n\n\n\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursesPage page = (CoursesPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
