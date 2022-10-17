package DAO;

import java.util.ArrayList;
import java.util.List;

public class Information {
	private int id;
	private String depart;
	private String arrivee;
	private String date;
	private boolean disponibilite;
	
	
	
	
	public Information(int id ,String depart, String arrivee,String date,boolean disponibilite)
	{
		super();
		this.id = id;
		this.depart = depart;
		this.arrivee = arrivee;
		this.date = date;
		this.disponibilite = disponibilite;
	}
	public Information(String depart, String arrivee,String date,boolean disponibilite)
	{
		super();
		this.depart = depart;
		this.arrivee = arrivee;
		this.date = date;
		this.disponibilite = disponibilite;
	}
	public Information(String depart, String arrivee,String date)
	{
		super();
		this.depart = depart;
		this.arrivee = arrivee;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getArrivee() {
		return arrivee;
	}

	public void setArrivee(String arrivee) {
		this.arrivee = arrivee;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}

	@Override
	public String toString() {
		return depart+":"+arrivee+":"+date+":"+disponibilite;
	}

	public static String ListToString(List<Information> infos)
	{
		if(infos == null || infos.isEmpty())
			return null;
		String message ="";
		for(Information f: infos)
		{
			message += f.toString();
			
			message += ";";
		}
		
		return message;
	}
	public static List<Information> StringToList(String infos)
	{
		List<Information> info = new ArrayList<Information>();
		
		for(String row: infos.split(";"))
		{
			String[] columns = row.split(":");
			Information n = new Information(columns[0],columns[1], columns[2],Boolean.parseBoolean(columns[3]));
			info.add(n);
		}
		
		return info;
	}
	
	
}
