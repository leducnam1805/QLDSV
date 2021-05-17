package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Lop {
	
	private int maLop;
	private String tenLop;
	Khoa khoa;
	
}
