package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Etudiant;

public class Gestiondb implements IGestion{
	Connection cnx;

	public Gestiondb() {
		System.out.println("jawher");
		try {
			Class.forName("com.mysql.jdbc.Driver");//chargement du driver
			String url ="jdbc:mysql://localhost:3308/tp1";
			
			cnx=DriverManager.getConnection(url,"root","");
		}catch(ClassNotFoundException e) {
			System.out.println("erreur de chargement du driver ");
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println ("erreur autre que le chargement du driver");
			e.printStackTrace();
		}

	}

	@Override
	public List<Etudiant> getAllEtudiant() {
		List<Etudiant> lo=new ArrayList<Etudiant>();
		PreparedStatement prst;
		try {
			
			prst = cnx.prepareStatement("select * from etudiant ");
			
			
			
			ResultSet rs =prst.executeQuery();
			while (rs.next())
			{
				lo.add(new Etudiant( rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			}
			return lo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addEtudiant(Etudiant c) {
		String req="insert into etudiant(num,nom,prenom,tel)values(?,?,?,?)";
		try {
			PreparedStatement prst=cnx.prepareStatement(req);
			prst.setInt(1,c.getId());
			prst.setString(2,c.getNom());
			prst.setString(3,c.getPrenom());
			prst.setString(4,c.getNum_telephone());
			prst.executeUpdate();
		} 
		catch (SQLException e) {
			
			System.out.println("erreur d'insertion du groupe a la base ");
			e.printStackTrace();
		}
		catch(Exception e1)
		{
			System.out.println("autre erreur a l'insertion du groupe a la base ");
		}
		
	}

	@Override
	public void deleteEtudiant(int num) {
		try {
			PreparedStatement prst=cnx.prepareStatement("DELETE FROM etudiant WHERE num=?");
			prst.setInt(1,num);
			prst.executeUpdate();
		} 
		catch (SQLException e) {
			
			System.out.println("erreur d'insertion du groupe a la base ");
			e.printStackTrace();
		}
		catch(Exception e1)
		{
			System.out.println("autre erreur a l'insertion du groupe a la base ");
		}
		
		
	}

	@Override
	public boolean verif(String user, String mp) {
		boolean b=false;
		PreparedStatement prst;
		try {
			
			prst = cnx.prepareStatement("select * from compte ");
			
			ResultSet rs =prst.executeQuery();
			while(rs.next())
			{
				System.out.println("false");
				if((rs.getString(2).equals(user))&&  (rs.getString(3).equals(mp))) {
					
					return true;
				}
			}
			System.out.println(b);
			
			
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage()); 
			
		}
		
	return b;
		}
	

}
