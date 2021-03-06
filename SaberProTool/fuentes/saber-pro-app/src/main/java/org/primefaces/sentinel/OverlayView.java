package org.primefaces.sentinel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="overlayView")
@ViewScoped
public class OverlayView implements Serializable {
    
    private List<Car> cars;
    private Car selectedCar;
    private List<String> images;
   
    @ManagedProperty("#{carService}")
    private CarService service;
    
    @PostConstruct
    public void init() {
        cars = service.createCars(10); 
        images = new ArrayList<String>();
         
        images.add("nature1.jpg");
        images.add("nature2.jpg");
        images.add("nature3.jpg");
        images.add("nature4.jpg");
    }
    
    public void destroyWorld() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "System Error", "Please try again later.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Car getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }

    public CarService getService() {
        return service;
    }

    public void setService(CarService service) {
        this.service = service;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
    
}

