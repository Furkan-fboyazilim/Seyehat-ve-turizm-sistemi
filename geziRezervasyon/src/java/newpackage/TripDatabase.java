package newpackage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TripDatabase {

    Connection con;

    public TripDatabase(Connection con) {
        this.con = con;
    }

    //for register trip 
    public boolean saveTrip(Trip trip) {
        boolean set = false;
        try {
            //Insert register data to database
            String query = "insert into triptable(name,triptype,day,price,date,description) values(?,?,?,?,?,?)";

            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setString(1, trip.getName());
            pt.setString(2, trip.getTriptype());
            pt.setString(3, trip.getDay());
            pt.setString(4, trip.getPrice());
            pt.setString(5, trip.getDate());
            pt.setString(6, trip.getDescription());

            pt.executeUpdate();
            set = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return set;
    }

    public boolean saveBasket(Trip trip) {
        boolean set = false;
        try {
            //Insert register data to database
            String query = "insert into rezerverdtrip(name,triptype,day,price,date,description,girenid,kisi) values(?,?,?,?,?,?,?,?)";

            PreparedStatement pt = this.con.prepareStatement(query);

            pt.setString(1, trip.getName());
            pt.setString(2, trip.getTriptype());
            pt.setString(3, trip.getDay());
            pt.setString(4, trip.getPrice());
            pt.setString(5, trip.getDate());
            pt.setString(6, trip.getDescription());
            pt.setString(7, trip.getKisiId());
            pt.setString(8, trip.getKisi());

            pt.executeUpdate();
            set = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return set;
    }

    //user login
    public List<Trip> selectTrip() {

        List<Trip> trp = new ArrayList<>();

        try {
            String query = "select * from triptable";
            PreparedStatement pst = this.con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String triptype = rs.getString("triptype");
                String day = rs.getString("day");
                String price = rs.getString("price");
                String date = rs.getString("date");
                String description = rs.getString("description");

                Trip row = new Trip(id, name, triptype, day, price, date, description);
                trp.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return trp;
    }

    public List<Trip> ListTrip(int id) {

        List<Trip> trp = new ArrayList<>();

        try {
            String query = "select * from triptable where id=6";
            PreparedStatement pst = this.con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
//               int id = rs.getInt("id");
                String name = rs.getString("name");
                String triptype = rs.getString("triptype");
                String day = rs.getString("day");
                String price = rs.getString("price");
                String date = rs.getString("date");
                String description = rs.getString("description");

                Trip row = new Trip(id, name, triptype, day, price, date, description);
                trp.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return trp;
    }
    //rezervasyon yapılmış turlar

    public List<Trip> ListTripKisi(String giren) {

        List<Trip> trp = new ArrayList<>();

        try {
            String query = "select * from rezerverdtrip where girenid=" + giren + "";
            PreparedStatement pst = this.con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String triptype = rs.getString("triptype");
                String day = rs.getString("day");
                String price = rs.getString("price");
                String date = rs.getString("date");
                String description = rs.getString("description");
                String kisiid = rs.getString("girenid");
                String kisi = rs.getString("kisi");

                Trip row = new Trip(id, name, triptype, day, price, date, description, kisiid, kisi);
                trp.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return trp;
    }
    //    delete books from database

    public void deleteTrip(int id) {
        try {

            String query = "delete from triptable where id=?";
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setInt(1, id);
            pt.execute();

        } catch (Exception ex) {
            ex.printStackTrace();;
        }
    }
    // delete rezerve

    public void deleteRezerveTrip(int id) {
        try {

            String query = "delete from rezerverdtrip where id=?";
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setInt(1, id);
            pt.execute();

        } catch (Exception ex) {
            ex.printStackTrace();;
        }
    }

    public void deleteRezerveTripGiren(int id) {
        try {

            String query = "delete from rezerverdtrip where girenid=?";
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setInt(1, id);
            pt.execute();

        } catch (Exception ex) {
            ex.printStackTrace();;
        }
    }

    //    eidt book information
    public boolean editTrip(Trip trip) {

        try {
            String query = "update triptable set name=?, triptype=?, day=?, price=? ,date=?,description=? where id=?";
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setString(1, trip.getName());
            pt.setString(2, trip.getTriptype());
            pt.setString(3, trip.getDay());
            pt.setString(4, trip.getPrice());
            pt.setString(5, trip.getDate());
            pt.setString(6, trip.getDescription());
            pt.setInt(7, trip.getId());
            pt.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public boolean editRezerveTrip(Trip trip) {

        try {
            String query = "update rezerverdtrip set kisi=? where id=?";
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setString(1, trip.getKisi());

            pt.setInt(2, trip.getId());
            pt.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    //    get single book information in edit page
    public Trip getSingleTrip(int id) {
        Trip bk = null;

        try {
            String query = "select * from triptable where id=? ";

            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                int bid = rs.getInt("id");
                String name = rs.getString("name");
                String triptype = rs.getString("triptype");
                String day = rs.getString("day");
                String price = rs.getString("price");
                String date = rs.getString("date");
                String description = rs.getString("description");
                bk = new Trip(bid, name, triptype, day, price, date, description);
            }
        } catch (Exception ex) {
            ex.printStackTrace();;
        }
        return bk;
    }

    public Trip getSinglRezerveTrip(int id) {
        Trip bk = null;

        try {
            String query = "select * from rezerverdtrip where id=? ";

            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                int bid = rs.getInt("id");
                String name = rs.getString("name");
                String triptype = rs.getString("triptype");
                String day = rs.getString("day");
                String price = rs.getString("price");
                String date = rs.getString("date");
                String description = rs.getString("description");
                String kisiId = rs.getString("girenid");
                String kisi = rs.getString("kisi");
                bk = new Trip(bid, name, triptype, day, price, date, description, kisiId, kisi);
            }
        } catch (Exception ex) {
            ex.printStackTrace();;
        }
        return bk;
    }

}
