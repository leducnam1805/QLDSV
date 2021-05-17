package daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.NienKhoa;
import utils.DBConnectionUtils;

public class NienKhoaDAO extends AbstractDAO{

	public List<NienKhoa> findAll() {
		con = DBConnectionUtils.getConnection();
		List<NienKhoa> nienKhoaList = new ArrayList<NienKhoa>();
		String sql = "SELECT nk.maNK as nkMa, nk.tenNK as nkTen  FROM nienkhoa as nk";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				NienKhoa objNK = new NienKhoa(rs.getString("nkMa"), rs.getString("nkTen"));
				nienKhoaList.add(objNK);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return nienKhoaList;
	}

	public int add(NienKhoa objNK) {
		con = DBConnectionUtils.getConnection();
		int result = 0;
		String sql = "INSERT INTO nienkhoa(maNK,tenNK) VALUE(?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, objNK.getMaNK());
			pst.setString(2, objNK.getTenNK());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
