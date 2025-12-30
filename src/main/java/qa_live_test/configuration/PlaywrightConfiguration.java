package qa_live_test.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Data
@Configuration
@ConfigurationProperties(prefix = "playwright")
public class PlaywrightConfiguration {
	private String wsEndpoint;
	private Duration timeout;
	private String url;
}