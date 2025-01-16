package DAO;

import Database.ConnectionJDBC;
import Model.SearchModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOSearch implements DAOInterface<SearchModel> {
    public static DAOSearch getInstance(){
        return new DAOSearch();
    }
    @Override
    public int insert(SearchModel textFieldOfSearchModel) {
        return 0;
    }

    @Override
    public int delete(SearchModel textFieldOfSearchModel) {
        return 0;
    }

    @Override
    public int update(SearchModel textFieldOfSearchModel) {
        return 0;
    }

    @Override
    public int insertRegister(SearchModel textFieldOfSearchModel) {
        return 0;
    }

    @Override
    public int search(SearchModel textFieldOfSearchModel) {

        return 0;
    }
}
