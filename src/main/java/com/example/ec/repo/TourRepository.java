package com.example.ec.repo;

import com.example.ec.domain.Difficulty;
import com.example.ec.domain.Region;
import com.example.ec.domain.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;
import java.util.List;

/**
 * Created by Ext-MayukhG on 7/26/2018.
 */

public interface TourRepository extends PagingAndSortingRepository<Tour, Integer> {
    //basic
    Page<Tour> findByTourPackageCode(@Param("code") String code, Pageable pageable);
    Tour findByTitle(@Param("title") String title);
    List<Tour> findByPrice(@Param("price") Integer price);
    Collection<Tour> findByDifficulty(@Param("difficulty") Difficulty difficulty);

    //intermediate
    List<Tour> findByTourPackageCodeAndRegion(@Param("code") String code, @Param("region") Region region);
    List<Tour> findByRegionIn(@Param("regions") List<Region> regions);
    List<Tour> findByPriceLessThan(@Param("maxPrice") Integer maxPrice);
    List<Tour> findByKeywordsContains(@Param("keyword") String keyword);
    List<Tour> findByTourPackageCodeAndBulletsLike(@Param("code") String code, @Param("searchString") String searchString);
//    List<Tour> findByTourPackageCodeAndDifficultyAndRegionAndPriceLessThan(String code, Difficulty difficulty, Region region, Integer maxPrice);

    //advanced
    @Query("Select t from Tour t where t.tourPackage.code = ?1 " +
    " and t.difficulty = ?2 and t.region = ?3 and t.price <=?4 ")
    List<Tour> findByTourPackageCodeAndDifficultyAndRegionAndPriceLessThan(String code, Difficulty difficulty, Region region, Integer maxPrice);

    @Override
    @RestResource(exported = false)
    <S extends Tour> S save(S entity);

    @Override
    @RestResource(exported = false)
    <S extends Tour> Iterable<S> save(Iterable<S> entities);

    @Override
    @RestResource(exported = false)
    void delete(Integer integer);

    @Override
    @RestResource(exported = false)
    void delete(Tour entity);

    @Override
    @RestResource(exported = false)
    void delete(Iterable<? extends Tour> entities);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
