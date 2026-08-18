package Respority;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.MovieBean;

public class MovieListRespority {

	public List<MovieBean> getAllCategorise(int categoryId) {
		List<MovieBean> movList = new ArrayList<MovieBean>();
		String sql = "SELECT * FROM mydb.movie where category_id=?;";

		try (Connection con = DBConnection.getcConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, categoryId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MovieBean obj = new MovieBean();
				obj.setId(rs.getInt("Id"));
				obj.setTitle(rs.getString("title"));
				obj.setDescription(rs.getString("description"));
				obj.setDuration(rs.getString("duration"));
				obj.setRelease_year(rs.getDate("release_year").toLocalDate());
				obj.setCategoryId(rs.getInt("category_id"));
				movList.add(obj);
			}
		} catch (SQLException e) {
			System.out.println("get user rows error" + e.getMessage());
		}
		return movList;
	}

	public int RentMovie(int member_id, int movie_id) {
		int i = 0;

		String sql = "insert into movie_rented(member_id,movie_id)values(?,?)";

		try (Connection con = DBConnection.getcConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, member_id);
			ps.setInt(2, movie_id);

			i = ps.executeUpdate();
			System.out.println("i :" + i);
		} catch (SQLException e) {
			System.out.println("movie_rented error :" + e.getMessage());
		}

		return i;

	}
}
