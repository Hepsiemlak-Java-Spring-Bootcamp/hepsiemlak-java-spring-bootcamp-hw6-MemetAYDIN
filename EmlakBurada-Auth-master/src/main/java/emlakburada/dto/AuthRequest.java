package emlakburada.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthRequest {

	public AuthRequest() {
		// TODO Auto-generated constructor stub
	}
	private String email;
	private String password;

}
