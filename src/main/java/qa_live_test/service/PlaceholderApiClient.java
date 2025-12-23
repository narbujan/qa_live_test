package qa_live_test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import qa_live_test.http.ApiClient;
import tools.jackson.databind.JsonNode;

@Component
@RequiredArgsConstructor
public class PlaceholderApiClient {
	private final ApiClient apiClient;

	public JsonNode getPost(int postId) {
		return apiClient.placeholderApiWebClient()
				.get()
				.uri("/posts/{postId}", postId)
				.retrieve()
				.bodyToMono(JsonNode.class)
				.block();
	}
}
