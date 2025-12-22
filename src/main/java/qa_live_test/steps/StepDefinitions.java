package qa_live_test.steps;

import qa_live_test.context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@RequiredArgsConstructor
@Slf4j
public class StepDefinitions {

	private final TestContext testContext;

	@Given("I have saved the message {string} in test context")
	public void iHaveSavedTheMessageInTestContext(String message) {
		testContext.setMessage(message);
	}

	@When("I change the message to {string} in test context")
	public void iChangeTheMessageToInTestContext(String message) {

		testContext.setMessage(message)
		;
	}

	@Then("the message is displayed")
	public void theMessageIsDisplayed() {
		log.info("Lets show the message {}", testContext.getMessage());
	}

	@And("the message should be {string}")
	public void theMessageShouldBe(String message) {
		assertEquals(message, testContext.getMessage()
		);
	}

	@And("the message should not be {string}")
	public void theMessageShouldNotBe(String message) {
		assertNotEquals(message, testContext.getMessage());
	}
}
