package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class sinhvien {

	private int maSV;
	private String tenSV;
	private String diaChi;
	private int sdt;
	private String email;
	Lop lop;
	
}
