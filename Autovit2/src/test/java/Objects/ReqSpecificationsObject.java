package Objects;

public class ReqSpecificationsObject {

    //Incapsulation
    private String Brand;
    private String Model;
    private String Pricemin;
    private String Pricemax;
    private String Yearmin;
    private String Yearmax;
    private String Fuel;

    public ReqSpecificationsObject(){}

    public String getBrand(){
        return Brand;
    }

    public void setBrand (String brand){
        Brand = brand;
    }

    public String getModel(){
        return Model;
    }

    public void setModel (String model){
        Model = model;
    }

    public String getPricemin(){
        return Pricemin;
    }

    public void setPricemin (String pricemin){
        Pricemin = pricemin;
    }

    public String getPricemax(){
        return Pricemax;
    }

    public void setPricemax (String pricemax){
        Pricemax = pricemax;
    }

    public String getYearmin(){
        return Yearmin;
    }

    public void setYearmin (String yearmin){
        Yearmin = yearmin;
    }

    public String getYearmax(){
        return Yearmax;
    }

    public void setYearmax (String yearmax){
        Yearmax = yearmax;
    }

    public String getFuel(){
        return Fuel;
    }

    public void setFuel (String fuel){
        Fuel = fuel;
    }

}
