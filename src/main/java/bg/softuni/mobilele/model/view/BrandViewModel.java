package bg.softuni.mobilele.model.view;

import java.util.List;

public class BrandViewModel {

    private String name;
    private List<ModelViewModel> models;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<ModelViewModel> getModels() {
        return models;
    }

    public void setModels(List<ModelViewModel> models) {
        this.models = models;
    }

    public BrandViewModel(String name, List<ModelViewModel> models) {
        this.name = name;
        this.models = models;
    }

    @Override
    public String toString() {
        return "BrandViewModel{" +
                "name='" + name + '\'' +
                ", models=" + models +
                '}';
    }
}
