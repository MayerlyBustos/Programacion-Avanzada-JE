package com.anncode.amazonviewer.db;

public class DataBase {

	public static final String URL 		= "jdbc:mysql://localhost:3306/";
	public static final String DB		= "amazonviewer";
	public static final String USER 	= "amazonviewer";
	public static final String PASSWORD = "amazonviewer";
	
	public static final String TMOVIE 			= "movie";
	public static final String TMOVIE_ID 		= "id";
	public static final String TMOVIE_TITLE 	= "title";
	public static final String TMOVIE_GENRE 	= "genre";
	public static final String TMOVIE_CREATOR 	= "creator";
	public static final String TMOVIE_DURATION 	= "duration";
	public static final String TMOVIE_YEAR 		= "year";
	
	public static final String TUSER 		= "user";
	public static final int TUSER_IDUSUARIO = 1;
	
	public static final String TVIEWED 				= "viewed";
	public static final String TVIEWED_IDMATERIAL 	= "id_material";
	public static final String TVIEWED_IDELEMENT 	= "id_element";
	public static final String TVIEWED_IDUSER 		= "id_user";
	public static final String TVIEWED_FECHA 		= "fecha";
	
	
	public static final String TMATERIAL 		= "material";
	public static final int[]  ID_TMATERIALS 	= {1,2,3,4,5};
	
	
	public static final String TBOOK 				= "book";
	public static final String TBOOK_ID				= "id";
	public static final String TBOOK_TITLE 			= "title";
	public static final String TBOOK_EDITORIAL 		= "editorial";
	public static final String TBOOK_EDITION_DATE 	= "edition_date";
	public static final String TBOOK_AUTHORS 		= "authors";
	
	public static final String TSERIE			= "serie";
	public static final String TSERIE_ID	= "id";
	public static final String TSERIE_GENRE		= "genre";
	public static final String TSERIE_YEAR		= "year";	
	public static final String TSERIE_CREATOR	= "creator";
	public static final String TSERIE_DURATION	= "duration";
	
	public static final String TCHAPTER				= "chapter";
	public static final String TCHAPTER_ID			= "id";
	public static final String TCHAPTER_TITLE 		= "title";
	public static final String TCHAPTER_YEAR		= "year";
	public static final String TCHAPTER_CREATOR		= "creator";
	public static final String TCHAPTER_DURATION	= "duration";
	
	public static final String TMAGAZINE 				= "megazine";
	public static final String TMAGAZINE_ID 			= "id";
	public static final String TMAGAZINE_TITLE 			= "title";
	public static final String TMAGAZINE_EDITORIAL		= "editorial";
	public static final String TMAGAZINE_EDITION_DATE 	= "edition_date";
	public static final String TMAGAZINE_AUTHORS 		= "authors";
	
	
}
