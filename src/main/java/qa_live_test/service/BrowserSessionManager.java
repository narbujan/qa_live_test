package qa_live_test.service;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BrowserSessionManager {

	public Playwright createPlaywright() {
		return Playwright.create();
	}

	public Browser createBrowser(Playwright playwright) {
		return playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false)
		);
	}

	public BrowserContext createBrowserContext(Browser browser, String baseUrl) {
		return browser.newContext(new Browser.NewContextOptions()
				.setBaseURL(baseUrl)
				.setViewportSize(1920, 1000)
		);
	}
}
