package qa_live_test.http;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import qa_live_test.config.PlaceholderApiConfig;

@Component
@RequiredArgsConstructor
public class ApiClient {

	private final PlaceholderApiConfig placeholderApiConfig;

	@Bean
	public WebClient placeholderApiWebClient() {
		return WebClient.builder()
				.baseUrl(placeholderApiConfig.getUrl())
				.build();
	}
}
