package bg.softuni.mobilele.web;

import bg.softuni.mobilele.model.entities.BaseEntity;
import bg.softuni.mobilele.model.entities.BrandEntity;
import bg.softuni.mobilele.model.entities.ModelEntity;
import bg.softuni.mobilele.model.entities.enums.ModelCategoryEnum;
import bg.softuni.mobilele.repository.BrandRepository;
import bg.softuni.mobilele.repository.ModelRepository;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
public class DBInit implements CommandLineRunner {
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public DBInit(ModelRepository modelRepository, BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        BrandEntity fordBrand = new BrandEntity();
        fordBrand.setName("Ford");
        setCurrentTimestamps(fordBrand);

        BrandEntity hondaBrand = new BrandEntity();
        hondaBrand.setName("Honda");
        setCurrentTimestamps(hondaBrand);

        brandRepository.saveAll(List.of(fordBrand, hondaBrand));

        initFiesta(fordBrand);
        initEscort(fordBrand);
        initNC750S(hondaBrand);
    }

    private ModelEntity initNC750S(BrandEntity hondaBrand){
        ModelEntity nc750s = new ModelEntity();

        nc750s.setName("NC750S");
        nc750s.setCategory(ModelCategoryEnum.MOTORCYCLE);
        nc750s.setImageUrl("https://mcn-images.bauersecure.com/wp-images/4207/615x0/honda_nc750x_08.jpg");
        nc750s.setStartYear(2016);
        nc750s.setBrand(hondaBrand);

        setCurrentTimestamps(nc750s);

        return modelRepository.save(nc750s);
    };
    private ModelEntity initEscort(BrandEntity fordBrand) {
        ModelEntity escort = new ModelEntity();

        escort.setName("Escort");
        escort.setCategory(ModelCategoryEnum.CAR);
        escort.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/Ford_Escort_MkI_1100_1972.JPG/280px-Ford_Escort_MkI_1100_1972.JPG");
        escort.setStartYear(1967);
        escort.setEndYear(1975);
        escort.setBrand(fordBrand);

        setCurrentTimestamps(escort);

        return modelRepository.save(escort);
    }
    private ModelEntity initFiesta(BrandEntity fordBrand) {
        ModelEntity fiesta = new ModelEntity();

        fiesta.setName("Fiesta");
        fiesta.setCategory(ModelCategoryEnum.CAR);
        fiesta.setImageUrl("https://assets-eu-01.kc-usercontent.com/fb793c58-315a-0196-d3af-7c9c2613d52c/9130c127-53c4-4a50-973a-1484a4e0d26d/fiestaheader.jpg");
        fiesta.setStartYear(2010);
        fiesta.setBrand(fordBrand);

        setCurrentTimestamps(fiesta);

        return modelRepository.save(fiesta);
    }

    private static void setCurrentTimestamps(BaseEntity baseEntity) {

        baseEntity.setCreated(Instant.now());
        baseEntity.setUpdated(Instant.now());
    }
}
