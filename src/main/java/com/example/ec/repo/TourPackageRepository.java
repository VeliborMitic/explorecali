package com.example.ec.repo;

import com.example.ec.domain.TourPackage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by Ext-MayukhG on 7/26/2018.
 */
@RepositoryRestResource(collectionResourceRel = "packages", path = "packages")
public interface TourPackageRepository extends CrudRepository<TourPackage, String> {
    TourPackage findByName(@Param("name") String name);

    @Override
    @RestResource(exported = false)
    <S extends TourPackage> S save(S entity);

    @Override
    @RestResource(exported = false)
    <S extends TourPackage> Iterable<S> save(Iterable<S> entities);

    @Override
    @RestResource(exported = false)
    void delete(String s);

    @Override
    @RestResource(exported = false)
    void delete(TourPackage entity);

    @Override
    @RestResource(exported = false)
    void delete(Iterable<? extends TourPackage> entities);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
