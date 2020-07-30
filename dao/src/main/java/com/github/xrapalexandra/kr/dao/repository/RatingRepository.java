package com.github.xrapalexandra.kr.dao.repository;

import com.github.xrapalexandra.kr.dao.entity.RatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatingRepository extends JpaRepository<RatingEntity, Integer> {

    List<RatingEntity> findByProductId(Integer productId);

    @Query(value = "select AVG (r.mark) a from rating r group by product_id having product_id = :productId", nativeQuery = true)
    Double getAvgByProduct(@Param("productId") Integer productId);
}
