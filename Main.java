// Клас WebPage
class WebPage {
    String title;
    String header;
    String content;
    String footer;
}

class WebPageBuilder {
    WebPage webPage = new WebPage();

    void setTitle(String title) {
        webPage.title = title;
    }

    void setHeader(String header) {
        webPage.header = header;
    }

    void setContent(String content) {
        webPage.content = content;
    }

    void setFooter(String footer) {
        webPage.footer = footer;
    }

    WebPage getResult() {
        return webPage;
    }
}


class WebPageDirector {
    WebPageBuilder builder;

    WebPageDirector(WebPageBuilder builder) {
        this.builder = builder;
    }

    void createArticle(String content) {
        builder.setTitle("Static Article");
        builder.setHeader("Static Header");
        builder.setContent(content);
        builder.setFooter("Static Footer");
    }

    void createForm(String title, String fields) {
        builder.setTitle(title);
        builder.setContent("Form Fields: " + fields);
    }
}

public class Main {
    public static void main(String[] args) {
        WebPageBuilder builder = new WebPageBuilder();
        WebPageDirector director = new WebPageDirector(builder);

        director.createArticle("Article Content");
        WebPage articlePage = builder.getResult();
        System.out.println("Article Page: " + articlePage.title + ", " + articlePage.header + ", " + articlePage.content + ", " + articlePage.footer);

        director.createForm("Form Page", "Username, Password, Email");
        WebPage formPage = builder.getResult();
        System.out.println("Form Page: " + formPage.title + ", " + formPage.header + ", " + formPage.content + ", " + formPage.footer);
    }
}
