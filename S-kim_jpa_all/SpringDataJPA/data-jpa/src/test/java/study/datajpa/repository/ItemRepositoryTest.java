package study.datajpa.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.entity.Item;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Rollback(value = false)
class ItemRepositoryTest {
    @Autowired ItemRepository itemRepository;
    @Test
    @DisplayName("")
    public void save() throws Exception {
        //given
        Item item = new Item("A");
        itemRepository.save(item);
    }
}