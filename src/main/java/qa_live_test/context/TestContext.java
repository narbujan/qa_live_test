package qa_live_test.context;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import tools.jackson.databind.JsonNode;

@Setter
@Getter
@Component
public class TestContext {

	private String message;
	private JsonNode post;
}
