package gg.jte.generated.ondemand.courses;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "courses/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,2,2,19,19,19,20,20,20,20,20,20};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <form action=\"/courses\" method=\"post\">\n        <div style=\"margin: 10px\">\n            <label>\n                Имя\n                <input type=\"text\" name=\"name\" />\n            </label>\n        </div>\n        <div style=\"margin: 10px\">\n            <label>\n                 <textarea id=\"description\" name=\"description\" rows=\"4\" cols=\"50\">\n\n                 </textarea>\n            </label>\n        </div>\n        <input type=\"submit\" value=\"Создать\" />\n    </form>\n");
			}
		});
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
