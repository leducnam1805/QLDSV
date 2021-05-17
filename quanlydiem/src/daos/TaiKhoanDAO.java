package daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.roles;
import models.taikhoan;
import utils.DBConnectionUtils;

public class TaiKhoanDAO extends AbstractDAO{

	public List<taikhoan> findAll() {
		con = DBConnectionUtils.getConnection();
		List<taikhoan> taiKhoanList = new ArrayList<taikhoan>();
		String sql = "SELECT"
				+ " tk.id as tkID,"
				+ " tk.username as tkUser,"
				+ " tk.password as tkPass,"
				+ " tk.email as tkEmail,"
				+ " tk.role as tkRole,"
				+ " r.role as rRole"
				+ " FROM taikhoan as tk"
				+ " INNER JOIN roles as r ON tk.role = r.id";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				taikhoan objTK = new taikhoan(rs.getInt("tkID"),
						rs.getString("tkUser"),
						rs.getString("tkPass"),
						rs.getString("tkEmail"),
						new roles(rs.getInt("tkRole"),
								rs.getString("rRole")));
				taiKhoanList.add(objTK);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return taiKhoanList;
	}

	public int add(taikhoan objTK) {
		con = DBConnectionUtils.getConnection();
		int result = 0;
		String sql = "INSERT INTO taikhoan(username,password,email,role) VALUE(?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, objTK.getUsername());
			pst.setString(2, objTK.getPassword());
			pst.setString(3, objTK.getEmail());
			pst.setInt(4, objTK.getRole().getId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public taikhoan findUsernameANDPass(String username, String pass) {
		con = DBConnectionUtils.getConnection();
		String sql = "SELECT"
				+ " tk.id as tkID,"
				+ " tk.username as tkUser,"
				+ " tk.password as tkPass,"
				+ " tk.email as tkEmail,"
				+ " tk.role as tkRole,"
				+ " r.role as rRole"
				+ " FROM taikhoan tk"
				+ " INNER JOIN roles as r ON r.id = tk.role"
				+ " WHERE username = ? AND password = ?";
		taikhoan objUser = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, pass);
			rs = pst.executeQuery();
			if(rs.next()) {
				objUser = new taikhoan(rs.getInt("tkID"),
						rs.getString("tkUser"),
						rs.getString("tkPass"),
						rs.getString("tkEmail"),
						new roles(rs.getInt("tkRole"),
								rs.getString("rRole")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return objUser;
	}

	public taikhoan viewAll(String username) {
		con = DBConnectionUtils.getConnection();
		String sql = "SELECT"
				+ " tk.id as tkID,"
				+ " tk.username as tkUser,"
				+ " tk.password as tkPass,"
				+ " tk.email as tkEmail,"
				+ " tk.role as tkRole,"
				+ " r.role as rRole"
				+ " FROM taikhoan as tk"
				+ " INNER JOIN roles as r ON r.id = tk.role"
				+ " WHERE username = ?";
		taikhoan objUser = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, username);
			rs = pst.executeQuery();
			if(rs.next()) {
				objUser = new taikhoan(rs.getInt("tkID"),
						rs.getString("tkUser"),
						rs.getString("tkPass"),
						rs.getString("tkEmail"),
						new roles(rs.getInt("tkRole"),
								rs.getString("rRole")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return objUser;
	}

}
