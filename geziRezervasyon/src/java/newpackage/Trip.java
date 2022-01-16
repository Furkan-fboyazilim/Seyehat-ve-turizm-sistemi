package newpackage;

public class Trip {

    int id;
    String name;
    String triptype;
    String day;
    String price;
    String date;
    String description;
    String kisiId;
    String kisi;

    public Trip() {
    }

    public Trip(int id, String name, String triptype, String day, String price, String date, String description) {
        this.id = id;
        this.name = name;
        this.triptype = triptype;
        this.day = day;
        this.price = price;
        this.date = date;
        this.description = description;
    }

    public Trip(int id, String kisi) {
        this.id = id;
        this.kisi = kisi;
    }

    public Trip(int id, String name, String triptype, String day, String price, String date, String description, String kisiId, String kisi) {
        this.id = id;
        this.name = name;
        this.triptype = triptype;
        this.day = day;
        this.price = price;
        this.date = date;
        this.description = description;
        this.kisiId = kisiId;
        this.kisi = kisi;
    }

    public Trip(String name, String triptype, String day, String price, String date, String description, String kisiId, String kisi) {

        this.name = name;
        this.triptype = triptype;
        this.day = day;
        this.price = price;
        this.date = date;
        this.description = description;
        this.kisiId = kisiId;
        this.kisi = kisi;
    }

    public Trip(String name, String triptype, String day, String price, String date, String description) {
        this.name = name;
        this.triptype = triptype;
        this.day = day;
        this.price = price;
        this.date = date;
        this.description = description;
    }

//    Trip(String id, String name, String triptype, String day, String price, String date, String description) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    public Trip(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTriptype() {
        return triptype;
    }

    public void setTriptype(String triptype) {
        this.triptype = triptype;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKisi() {
        return kisi;
    }

    public void setKisi(String kisi) {
        this.kisi = kisi;
    }

    public String getKisiId() {
        return kisiId;
    }

    public void setKisiId(String kisiId) {
        this.kisiId = kisiId;
    }

}
