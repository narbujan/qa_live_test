package qa_live_test.context;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import qa_live_test.configuration.PlaywrightConfiguration;
import qa_live_test.service.BrowserSessionManager;

@Component
@RequiredArgsConstructor
@Getter
public class PageContext {

	private final BrowserSessionManager sessionManager;
	private final PlaywrightConfiguration playwrightConfiguration;
	private final TestContext testContext;

	private Playwright playwright;
	private Browser browser;
	private BrowserContext browserContext;
	private Page page;

	public void startBrowserSession() {
		if (page != null) {
			return;
		}

		initializePlaywright();
		initializeBrowser();
		initializeBrowserContext();
		initializePage();
	}

	private void initializePlaywright() {
		if (playwright == null) {
			playwright = sessionManager.createPlaywright();
		}
	}

	private void initializeBrowser() {
		if (browser == null) {
			browser = sessionManager.createBrowser(playwright);
		}
	}

	private void initializeBrowserContext() {
		if (browserContext == null) {
			browserContext = sessionManager.createBrowserContext(
					browser,
					playwrightConfiguration.getUrl()
			);
		}
	}

	private void initializePage() {
		if (page == null) {
			page = createPage(browserContext);
		}
	}

	private Page createPage(BrowserContext browserContext) {
		double timeout = getTimeout();
		Page newPage = browserContext.newPage();
		newPage.setDefaultTimeout(timeout);
		newPage.setDefaultNavigationTimeout(timeout);
		return newPage;
	}

	private double getTimeout() {
		var duration = playwrightConfiguration.getTimeout();
		return duration.toMillis();
	}

	public void closeBrowserSession() {
		close(page, () -> page = null);
		close(browserContext, () -> browserContext = null);
		close(browser, () -> browser = null);
		close(playwright, () -> playwright = null);
	}

	private void close(AutoCloseable resource, Runnable nullifier) {
		if (resource != null) {
			try {
				resource.close();
			} catch (Exception ignored) {
			} finally {
				nullifier.run();
			}
		}
	}
}
