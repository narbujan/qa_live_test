package qa_live_test.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.RequiredArgsConstructor;
import qa_live_test.context.PageContext;

@RequiredArgsConstructor
public class Hooks {

	private final PageContext pageContext;

	@Before("@ui")
	public void beforeUiScenario() {
		pageContext.startBrowserSession();
	}

	@After("@ui")
	public void afterUiScenario() {
		pageContext.closeBrowserSession();
	}
}
