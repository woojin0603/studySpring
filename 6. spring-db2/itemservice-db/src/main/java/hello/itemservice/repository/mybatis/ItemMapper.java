package hello.itemservice.repository.mybatis;

import hello.itemservice.domain.Item;
import hello.itemservice.repository.ItemSearchCond;
import hello.itemservice.repository.ItemUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ItemMapper {

    void save(Item item);

    void update(@Param("id") Long id, @Param("updateParam")ItemUpdateDto updateParam);

   // @Select("select id, item_name, price, quantity from item where id=#{id}") // xml과 충돌나면 에러 발생시킴(둘중 하나만)
    Optional<Item> findById(Long id);

    List<Item> findAll(ItemSearchCond itemSearch);
}

