package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.SQLException;

public class InformationDAO {

	java.sql.Connection cnx;

	java.sql.PreparedStatement stmt;
	ResultSet res;

	public InformationDAO() throws ClassNotFoundException, SQLException {
		cnx = MySqlManager.getConnection();
	}

	public List<Information> FindInformationByNom(String Depart, String Arrivee,String Date)
	{
		String query = "SELECT * FROM vols"
				+ " WHERE (`depart` LIKE ? AND `arrivee` LIKE ?)"
				+ " AND `date` LIKE ? AND `disponibilite` IS TRUE ;";
		
		try
		{
			stmt = cnx.prepareStatement(query);
			stmt.setString(1, Depart.toLowerCase());
			stmt.setString(2, Arrivee.toLowerCase());
			stmt.setString(3, Date);
			
			List<Information> infos = new ArrayList<Information>();
			res = stmt.executeQuery();
			while (res.next())
			{
				Information info =  new Information(
						res.getInt(1),
						res.getString(2),
						res.getString(3),
						res.getString(4),
						res.getBoolean(5)
						);
				System.out.println("DAO info : " + info);

				infos.add(info);
				
				//return List<>
			}
			System.out.println("Informations List :" + Information.ListToString(infos));
			if(infos.isEmpty())
				return null;
			return infos;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
