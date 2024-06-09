public abstract class DisplayArticleTemplate {
    // 파생 클레스에서 접근 가능
    protected Article article;

    public DisplayArticleTemplate(Article article) {
        this.article = article;
    }
    // 단계 순서 정해짐
    public final void display() {
        title();
        content();
        footer();
    }

    protected abstract void title();
    protected abstract void content();
    protected abstract void footer();
}
