import java.util.HashMap;

public class ItemFactory extends Factory {
    private class ItemData {
        int maxCount;
        int currentCount;

        ItemData(int maxCount) {
            this.maxCount = maxCount;
        }
    }

    private HashMap<String, ItemData> repository;

    public ItemFactory() {
        repository = new HashMap<String, ItemData>();
        repository.put("sword", new ItemData(3));
        repository.put("shield", new ItemData(2));
        repository.put("bow", new ItemData(1));
    }

    @Override
    public boolean isCreatable(String name) {
        ItemData itemData = repository.get(name);
        if (itemData == null) {
            System.out.println(name + "은 알 수 없는 아이템입니다.");
            return false;
        } else if (itemData.currentCount >= itemData.maxCount) {
            System.out.println(name + "은 품절 아이템입니다.");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Item createItem(String name) {
        Item item = null;
        switch (name) {
            case "sword":
                item = new Sword();
                break;
            case "shield":
                item = new Shield();
                break;
            case "bow":
                item = new Bow();
                break;
        }
        return item;
    }

    @Override
    public void postprocessItem(String name) {
        ItemData itemData = repository.get(name);
        if (itemData != null)
            itemData.currentCount++;
    }
    
}
