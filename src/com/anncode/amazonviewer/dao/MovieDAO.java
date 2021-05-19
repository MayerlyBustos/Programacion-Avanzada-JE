package com.anncode.amazonviewer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.anncode.amazonviewer.db.IDBConnection;
import com.anncode.amazonviewer.model.Film;
import com.anncode.amazonviewer.model.Movie;

import static com.anncode.amazonviewer.db.DataBase.*; 

public interface MovieDAO extends IDBConnection {
	
	default Movie setMovieViewed(Movie movie) {
		try (Connection connecion = connectToDB()){
			Statement statement = connecion.createStatement();
			String query = "INSERT INTO " + TVIEWED + " (" + TVIEWED_IDMATERIAL + ", " + TVIEWED_IDELEMENT + ", " + TVIEWED_IDUSER + ", " + TVIEWED_FECHA +") " +
			" VALUES(" + ID_TMATERIALS[0] + ", " + movie.getId() + ", " + TUSER_IDUSUARIO + ", " + TVIEWED_FECHA+ ")";
			if(statement.executeUpdate(query) > 0) {
				System.out.println("Se marcó en Visto!");
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return movie;
	}
	
	default ArrayList<Movie> read(){
		ArrayList<Movie> movies = new ArrayList();
		try {
			Connection connecion = connectToDB();
			String query = "SELECT * FROM " + TMOVIE;
			PreparedStatement preparedStatement = connecion.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Movie movie = new Movie(
						rs.getString(TMOVIE_TITLE),
						rs.getString(TMOVIE_GENRE),
						rs.getString(TMOVIE_CREATOR), 
						Integer.valueOf(rs.getString(TMOVIE_DURATION)),
						Short.valueOf(rs.getString(TMOVIE_YEAR)));
				movie.setId(Integer.valueOf(rs.getString(TMOVIE_ID)));
				movie.setViewed(getMovieViewed(preparedStatement, connecion, Integer.valueOf(rs.getString(TMOVIE_ID))));
				movies.add(movie);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return movies;
	}
	
	private boolean getMovieViewed(PreparedStatement preparedStatement, Connection connecion, int id_movie) {
		boolean viewed = false;
		String query = "SELECT * FROM " + TVIEWED + 
				" WHERE " + TVIEWED_IDMATERIAL + "= ?" + 
				" AND " + TVIEWED_IDELEMENT + "= ?" +				
				" AND " + TVIEWED_IDUSER + "= ?" +
				" AND " + TVIEWED_FECHA + "= ?";
		
		ResultSet rs = null;
		try {
			preparedStatement = connecion.prepareStatement(query);
			preparedStatement.setInt(1, ID_TMATERIALS[0]);
			preparedStatement.setInt(2, id_movie);
			preparedStatement.setInt(3, TUSER_IDUSUARIO);
			preparedStatement.setString(4, TVIEWED_FECHA);
			
			
			rs = preparedStatement.executeQuery();
			viewed = rs.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viewed;
	}
}
