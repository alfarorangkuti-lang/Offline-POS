package com.example.practinepos.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Update;
import androidx.room.Delete;
import androidx.room.Query;
import java.util.List;

@Dao
public interface ItemDao {
    @Insert
    void insert(ItemEntity item);

    @Update
    void update(ItemEntity item);

    @Delete
    void delete(ItemEntity item);

    @Query("SELECT * FROM categories")
    List<ItemEntity> getAllCategories();
}
