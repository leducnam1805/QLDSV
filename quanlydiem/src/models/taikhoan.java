package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class taikhoan {
	
	private int id;
	private String username;
	private String password;
	private String email;
	roles role;
	
}
