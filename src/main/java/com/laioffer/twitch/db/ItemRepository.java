package com.laioffer.twitch.db;

import com.laioffer.twitch.db.entity.ItemEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface ItemRepository extends ListCrudRepository<ItemEntity, Long> {

    // SELECT * FROM items WHERE twitch_id = :twitchId
    // Determine the conditions by the method/func name
    ItemEntity findByTwitchId(String twitchId);
}
