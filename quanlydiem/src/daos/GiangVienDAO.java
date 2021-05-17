package daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.giangvien;
import utils.DBConnectionUtils;

public class GiangVienDAO extends AbstractDAO{

	public List<giangvien> findAll() {
		con = DBConnectionUtils.getConnection();
		List<giangvien> giangvienList = new ArrayList<giangvien>();
		String sql = "select gv.maGV as gvMa,"
				+ " gv.tenGV as gvTen,"
				+ " gv.diaChi as gvDC,"
				+ " gv.sdt as gvSDT,"
				+ " gv.email as gvEmail"
				+ " from giangvien as gv";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				giangvien objGV = new giangvien(rs.getString("gvMa"),
						rs.getString("gvTen"),
						rs.getString("gvDC"),
						rs.getInt("gvSDT"),
						rs.getString("gvEmail"));
				giangvienList.add(objGV);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return giangvienList;
	}

	public int add(giangvien objGV) {
		con = DBConnectionUtils.getConnection();
		int result = 0;
		String sql ="INSERT INTO giangvien(maGV,tenGV,diaChi,sdt,email) VALUE(?,?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, objGV.getMaGV());
			pst.setString(2, objGV.getTenGV());
			pst.setString(3, objGV.getDiaChi());
			pst.setInt(4, objGV.getSdt());
			pst.setString(5, objGV.getEmail());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	
	
}
