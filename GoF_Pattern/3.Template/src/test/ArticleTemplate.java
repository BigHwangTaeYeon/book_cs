package test;

public abstract class ArticleTemplate {
    protected getItemArticle item;

    public ArticleTemplate(getItemArticle item) {
        this.item = item;
    }

    public final void display() {
        one();
        two();
        three();
    }

    protected abstract void one();
    protected abstract void two();
    protected abstract void three();

}
