package com.example.ec.services;

import com.example.ec.domain.TourPackage;
import com.example.ec.repo.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ext-MayukhG on 7/26/2018.
 */
@Service
public class TourPackageService {
    private TourPackageRepository tourPackageRepository;
    @Autowired
    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }
    public TourPackage createTourPackage(String code, String name) {
        if(!tourPackageRepository.exists(code)) {
            tourPackageRepository.save(new TourPackage(code, name));
        }
        return null;
    }
    public Iterable<TourPackage> lookup(){
        return tourPackageRepository.findAll();
    }
    public long total() {
        return tourPackageRepository.count();
    }
}
