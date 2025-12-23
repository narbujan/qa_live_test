package qa_live_test.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Getter
@Configuration
@ConfigurationProperties(prefix = "http.placeholder-api")
public class PlaceholderApiConfig {
	private String url;
}
