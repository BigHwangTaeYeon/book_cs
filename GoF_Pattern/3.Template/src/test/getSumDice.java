package test;

public class getSumDice extends ArticleTemplate {

    private int sum;

    public getSumDice(getItemArticle item) {
        super(item);
    }

    @Override
    protected void one() {
        item.setItem();
    }

    @Override
    protected void two() {
        int[] itemNum = (int[]) item.getItem();
        for (int i = 0; i < itemNum.length; i++) {
            this.sum += itemNum[i];
        }
    }

    @Override
    protected void three() {
        System.out.println("Total Dice Num : " + sum);
    }
    
}
