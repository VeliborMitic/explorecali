package com.example.ec;


import com.example.ec.domain.Difficulty;
import com.example.ec.domain.Region;
import com.example.ec.services.TourPackageService;
import com.example.ec.services.TourService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

/**
 * Created by Ext-MayukhG on 7/25/2018.
 */
@SpringBootApplication
public class ExplorecaliApplication implements CommandLineRunner {
    private TourService tourService;
    private TourPackageService tourPackageService;
    public static void main(String[] args) {
        SpringApplication.run(ExplorecaliApplication.class, args);
    }
    @Autowired
    public ExplorecaliApplication(TourService tourService, TourPackageService tourPackageService) {
        this.tourService = tourService;
        this.tourPackageService = tourPackageService;
    }

    @Override
    public void run(String... args) throws Exception {
        tourPackageService.createTourPackage("BC", "Backpack cal");
        tourPackageService.createTourPackage("CC", "California calm");
        tourPackageService.createTourPackage("CH", "California Hot springs");
        tourPackageService.createTourPackage("CY", "Cycle California");
        tourPackageService.createTourPackage("DS", "From Desert to Sea");
        tourPackageService.createTourPackage("KC", "Kids California");
        tourPackageService.createTourPackage("NW", "Nature Watch");
        tourPackageService.createTourPackage("SC", "Snowboard Cali");
        tourPackageService.createTourPackage("TC", "Taste of California");
        tourPackageService.lookup().forEach(tourPackage -> System.out.println(tourPackage));
        TourFromFile.importTours().forEach(t ->tourService.createTour(t.title, t.description, t. blurb, t.price,
                t.length, t.bullets, t.keywords, t.packageType, Difficulty.valueOf(t.difficulty),
                Region.findByLabel(t.region)));
        System.out.println("Number of tours:" + tourService.total());
        tourService.lookup().forEach(tour -> System.out.println(tour));
    }

    static class TourFromFile {
        private String packageType,title,blurb,description,bullets,difficulty,length,region,keywords;
        private Integer price;
        static List<TourFromFile> importTours() throws IOException {
            return new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY).
                    readValue(TourFromFile.class.getResourceAsStream("/ExploreCalifornia.json"),
                            new TypeReference<List<TourFromFile>>(){});
        }
    }
}
