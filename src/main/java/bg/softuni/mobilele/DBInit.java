package bg.softuni.mobilele;

import bg.softuni.mobilele.model.entities.*;
import bg.softuni.mobilele.model.entities.enums.EngineEnum;
import bg.softuni.mobilele.model.entities.enums.ModelCategoryEnum;
import bg.softuni.mobilele.model.entities.enums.TransmissionEnum;
import bg.softuni.mobilele.model.entities.enums.UserRoleEnum;
import bg.softuni.mobilele.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Component
public class DBInit implements CommandLineRunner {
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private OfferRepository offerRepository;
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private UserRoleRepository userRoleRepository;

    public DBInit(ModelRepository modelRepository,
                  BrandRepository brandRepository,
                  OfferRepository offerRepository,
                  UserRepository userRepository,
                  PasswordEncoder passwordEncoder,
                  UserRoleRepository userRoleRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
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

        ModelEntity fiestaModel = initFiesta(fordBrand);
        initEscort(fordBrand);
        initNC750S(hondaBrand);
        createFiestaOffer(fiestaModel);

        initUsers();
    }

    private void initUsers() {

        UserRoleEntity adminRole = new UserRoleEntity().setRole(UserRoleEnum.ADMIN);
        UserRoleEntity userRole = new UserRoleEntity().setRole(UserRoleEnum.USER);

        userRoleRepository.saveAll(List.of(adminRole, userRole));

        UserEntity admin = new UserEntity();
        admin.setFirstName("Кирил");
        admin.setLastName("Димитров");
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("topsecret")).
        setUserRoles(List.of(adminRole, userRole));
        setCurrentTimestamps(admin);

        UserEntity pesho = new UserEntity();
        pesho.setFirstName("Петър");
        pesho.setLastName("Иванов");
        pesho.setUsername("pesho");
        pesho.setPassword(passwordEncoder.encode("topsecret")).
                setUserRoles(List.of(userRole));
        setCurrentTimestamps(pesho);

        userRepository.saveAll(List.of(admin, pesho));
    }

    private void createFiestaOffer(ModelEntity modelEntity) {
        OfferEntity fiestaOffer = new OfferEntity();

        fiestaOffer.setEngine(EngineEnum.GASOLINE);
        fiestaOffer.setImageUrl("https://cdn.motors.al/data/fb/cc/2010-ford-fiesta-128.jpg");
        fiestaOffer.setMileage(40000);
        fiestaOffer.setPrice(BigDecimal.valueOf(10000));
        fiestaOffer.setYear(2019);
        fiestaOffer.setDescription("Malko karana. Samo mezhdu blokovete. Inache pazena v garazh. :)");
        fiestaOffer.setTransmission(TransmissionEnum.MANUAL);
        fiestaOffer.setModel(modelEntity);

        setCurrentTimestamps(fiestaOffer);

        offerRepository.save(fiestaOffer);
    }

    private ModelEntity initNC750S(BrandEntity hondaBrand) {
        ModelEntity nc750s = new ModelEntity();

        nc750s.setName("NC750S");
        nc750s.setCategory(ModelCategoryEnum.MOTORCYCLE);
        nc750s.setImageUrl("https://mcn-images.bauersecure.com/wp-images/4207/615x0/honda_nc750x_08.jpg");
        nc750s.setStartYear(2016);
        nc750s.setBrand(hondaBrand);

        setCurrentTimestamps(nc750s);

        return modelRepository.save(nc750s);
    }

    ;

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
