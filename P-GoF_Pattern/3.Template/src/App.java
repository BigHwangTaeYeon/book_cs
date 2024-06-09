import test.ArticleTemplate;
import test.getItemToDice;
import test.getSumDice;

public class App {
    public static void main(String[] args) throws Exception {

        // String title = "디자인 패턴";
        // ArrayList<String> content = new ArrayList<String>();
        // content.add("AAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        // content.add("BBBBBBBBBBBBBBBBBBBBBBBBBBBB");
        // content.add("CCCCCCCCCCCCCCCCCCCCCCCCCC");
        // content.add("DDDDDDDDDDDDDDDDDDDDD");
        // String footer = "2022.01.01, BigHwang Developer";

        // System.out.println();

        // Article article = new Article(title, content, footer);
        // System.out.println("[CASE - 1]");
        // DisplayArticleTemplate style = new SimpleDisplayArticle(article);
        // style.display();

        // System.out.println();

        // style = new CaptionDisplayArticle(article);
        // style.display();

        ArticleTemplate article = new getSumDice(new getItemToDice(3));
        article.display();

    }
}
