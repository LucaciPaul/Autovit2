package Objects;

public class FindedSpecificationsObject {

    //Incapsulation
    private String About;
    private String Engine;
    private String Km;
    private String ProdYear;
    private String Loc;
    private String Price;
    private String Link;
    private String Title;

    public FindedSpecificationsObject(){}

    public String getAbout() {
        if(About == null){
            About="";
        }
        return About;
    }

    public void setAbout(String about) {
        About = about;
    }

    public String getEngine() {
        if(Engine == null){
            Engine ="";
        }
        return Engine;
    }

    public void setEngine(String engine) {
        Engine = engine;
    }

    public String getKm() {
        if(Km == null){
            Km = "";
        }
        return Km;
    }

    public void setKm(String km) {
        Km = km;
    }

    public String getProdYear() {
        if(ProdYear == null){
            ProdYear = "";
        }
        return ProdYear;
    }

    public void setProdYear(String prodyear) {
        ProdYear = prodyear;
    }

    public String getLoc() {
        if(Loc == null){
            Loc ="";
        }
        return Loc;
    }

    public void setLoc(String loc) {
        Loc = loc;
    }

    public String getPrice() {
        if(Price == null){
            Price = "";
        }
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getLink() {
        if(Link == null){
            Link ="";
        }
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getTitle() {
        if(Title == null){
            Title="";
        }
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
