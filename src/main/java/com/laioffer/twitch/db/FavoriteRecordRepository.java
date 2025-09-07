package com.laioffer.twitch.db;

import com.laioffer.twitch.db.entity.FavoriteRecordEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface FavoriteRecordRepository extends ListCrudRepository<FavoriteRecordEntity, Long> {
    // SELECT * FROM favorite_records WHERE user_id = :userId
    List<FavoriteRecordEntity> findAllByUserId(Long userId);

    // SELECT * FROM favorite_records WHERE user_id EXISTS and item_id EXISTS
    boolean existsByUserIdAndItemId(Long userId, Long itemId);

    @Query("SELECT item_id FROM favorite_records WHERE user_id = :userId")
    List<Long> findFavoriteItemIdsByUserId(Long userId);

    @Modifying
    @Query("DELETE FROM favorite_records WHERE user_id = :userId AND item_id = :itemId")
    void delete(Long userId, Long itemId);
}
