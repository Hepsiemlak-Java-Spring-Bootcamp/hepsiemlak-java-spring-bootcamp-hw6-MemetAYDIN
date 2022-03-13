package emlakburada;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import emlakburada.dto.AuthRequest;
import emlakburada.dto.AuthResponse;
import emlakburada.entity.User;
import emlakburada.repository.AuthRepository;
import emlakburada.service.AuthService;
import emlakburada.util.JwtUtil;

@SpringBootTest
public class AuthServiceTest {
	

	@InjectMocks
	private AuthService authService;
	
	@Mock
	private AuthRepository authRepository;
	
	@Mock
	private JwtUtil jwtUtil;
	
	@Test()
	void getTokenAuthTest() {
		AuthRequest authRequest=prepareAuthRquest();
		User user=authRepository.findByEmail(authRequest.getEmail());
		
		
		Mockito
		.when(authRepository.findByEmail(authRequest.getEmail()))
		.thenReturn(user);
		AuthResponse authResponse=new AuthResponse(jwtUtil.generateToken(user));
		
		assertEquals("aaaa@aaa.com", authResponse.getToken());
		try {
			verify(authService).getToken(authRequest);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private AuthRequest prepareAuthRquest() {
		AuthRequest req=new AuthRequest();
		req.setEmail("aaaa@aaa.com");
		req.setPassword("123456");
		return null;
	}

	private List<User> getToken() {
		// TODO Auto-generated method stub
		return null;
	}

}
