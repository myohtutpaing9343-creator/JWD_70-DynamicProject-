package Respority;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.CategoryBean;
import Model.MovieBean;

public class CategoryRespority {

	public List<CategoryBean> getAllCategorise(){
		List<CategoryBean> catList=new ArrayList<CategoryBean>();
		String sql="SELECT * FROM category";
		
		try(Connection con =DBConnection.getcConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		) {
			//ps.setInt(1, categoryId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			CategoryBean obj=new CategoryBean();
			obj.setId(rs.getInt("id"));
			obj.setTitle(rs.getString("name"));
		
		catList.add(obj);
		}
		} catch (SQLException e) {
		System.out.println("get user rows error"+ e.getMessage());
		}
		return catList;
		}
}
