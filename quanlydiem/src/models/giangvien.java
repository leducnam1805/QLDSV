package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class giangvien {

	private String maGV;
	private String tenGV;
	private String diaChi;
	private int sdt;
	private String email;
	
}
