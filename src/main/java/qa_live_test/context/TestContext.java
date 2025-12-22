package qa_live_test.context;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class TestContext {

	private String message;
}
