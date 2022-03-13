package emlakburada;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import emlakburada.dto.request.BannerRequest;

import emlakburada.dto.response.BannerResponse;
import emlakburada.exception.BannerNotFoundException;
import emlakburada.model.Banner;

import emlakburada.repository.BannerRepository;
import emlakburada.service.BannerService;

@SpringBootTest
class EmlakBuradaBannerApplicationTests {

	@InjectMocks
	private BannerService bannerService;
	
	@Mock
	private BannerRepository bannerRepository;
	

	
	@Test
	void getAllBannerTest() {
		assertThrows(BannerNotFoundException.class, () -> {
			List<BannerResponse> response =bannerService.getAllBanners();
			assertNull(response);
		}, "Banners Not Found");
	}
	
	@Test
	void saveBannerTest() {
		BannerRequest bannerRequest=prapreBannerRequest();
		
		Banner banner=bannerRepository.saveBanner(any());
	
		Mockito
		.when(bannerRepository.saveBanner(banner))
		.thenReturn(banner);
		
		
		assertDoesNotThrow(() ->{
			BannerResponse bannerResponse= bannerService.saveBanner(bannerRequest);
			assertEquals("İstanbul", bannerResponse.getAddress());
			
		});
	
	}



	private BannerRequest prapreBannerRequest() {
		BannerRequest req=new BannerRequest();
		req.setAddress(null);
		req.setAdvertNo(3);
		req.setPhone("1213134");
		req.setTotal(55);
		return null;
	}

}
