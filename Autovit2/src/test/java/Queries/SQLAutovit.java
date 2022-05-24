package Queries;

import DataBase.DataBase;
import Objects.ReqSpecificationsObject;
import Objects.FindedSpecificationsObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLAutovit {
    ResultSet Result;
    DataBase dataBase;

    public SQLAutovit (DataBase dataBase){
        this.dataBase=dataBase;
    }

    public int getNumberRows() throws SQLException {
        String select = "select count(*) from searchfor";
        PreparedStatement Prepare= dataBase.Connection.prepareStatement(select);
        Result=Prepare.executeQuery();
        int countNumber=0;
        if(Result.next()){
            countNumber=Result.getInt(1);
        }
        return countNumber;
    }

    //Brand
    public void SelectBrand(ReqSpecificationsObject reqSpecificationsObject, String TabelName, int id) throws SQLException {
        String Select = "select * from " + TabelName + " where idsearchfor=" + id + "";
        PreparedStatement Prepare = dataBase.Connection.prepareStatement(Select);
        Result = Prepare.executeQuery();
        while (Result.next()) {
            reqSpecificationsObject.setBrand(Result.getString(2));
        }
    }

    //Model
    public void SelectModel(ReqSpecificationsObject reqSpecificationsObject, String TabelName, int id) throws SQLException {
        String Select = "select * from " + TabelName + " where idsearchfor=" + id + "";
        PreparedStatement Prepare = dataBase.Connection.prepareStatement(Select);
        Result = Prepare.executeQuery();
        while (Result.next()) {
            reqSpecificationsObject.setModel(Result.getString(3));
        }
    }

    //Pricemin
    public void SelectPricemin(ReqSpecificationsObject reqSpecificationsObject, String TabelName, int id) throws SQLException {
        String Select = "select * from " + TabelName + " where idsearchfor=" + id + "";
        PreparedStatement Prepare = dataBase.Connection.prepareStatement(Select);
        Result = Prepare.executeQuery();
        while (Result.next()) {
            reqSpecificationsObject.setPricemin(Result.getString(4));
        }
    }

    //Pricemax
    public void SelectPricemax(ReqSpecificationsObject reqSpecificationsObject, String TabelName, int id) throws SQLException {
        String Select = "select * from " + TabelName + " where idsearchfor=" + id + "";
        PreparedStatement Prepare = dataBase.Connection.prepareStatement(Select);
        Result = Prepare.executeQuery();
        while (Result.next()) {
            reqSpecificationsObject.setPricemax(Result.getString(5));
        }
    }

    //Yearmin
    public void SelectYearmin(ReqSpecificationsObject reqSpecificationsObject, String TabelName, int id) throws SQLException {
        String Select = "select * from " + TabelName + " where idsearchfor=" + id + "";
        PreparedStatement Prepare = dataBase.Connection.prepareStatement(Select);
        Result = Prepare.executeQuery();
        while (Result.next()) {
            reqSpecificationsObject.setYearmin(Result.getString(6));
        }
    }

    //Yearmax
    public void SelectYearmax(ReqSpecificationsObject reqSpecificationsObject, String TabelName, int id) throws SQLException {
        String Select = "select * from " + TabelName + " where idsearchfor=" + id + "";
        PreparedStatement Prepare = dataBase.Connection.prepareStatement(Select);
        Result = Prepare.executeQuery();
        while (Result.next()) {
            reqSpecificationsObject.setYearmax(Result.getString(7));
        }
    }

    //Fuel
    public void SelectFuel(ReqSpecificationsObject reqSpecificationsObject, String TabelName, int id) throws SQLException {
        String Select = "select * from " + TabelName + " where idsearchfor=" + id + "";
        PreparedStatement Prepare = dataBase.Connection.prepareStatement(Select);
        Result = Prepare.executeQuery();
        while (Result.next()) {
            reqSpecificationsObject.setFuel(Result.getString(8));
        }
    }

    //Insert
    public void InsertAbout(FindedSpecificationsObject findedSpecificationsObject, String TabelName) throws SQLException {
        String Insert = "insert into " + TabelName + " values (?, ?, ?, ?, ?, ?, ?, ?) ";
        PreparedStatement Prepare = dataBase.Connection.prepareStatement(Insert);
        Prepare.setString(1, findedSpecificationsObject.getTitle());
        Prepare.setString(2, findedSpecificationsObject.getAbout());
        Prepare.setString(3, findedSpecificationsObject.getEngine());
        Prepare.setString(4, findedSpecificationsObject.getKm());
        Prepare.setString(5, findedSpecificationsObject.getProdYear());
        Prepare.setString(6, findedSpecificationsObject.getLoc());
        Prepare.setString(7, findedSpecificationsObject.getPrice());
        Prepare.setString(8, findedSpecificationsObject.getLink());
        Prepare.execute();
    }

}

