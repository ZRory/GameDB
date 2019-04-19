/**
 * 
 */
package vip.rory.gamedb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @fileName: AppConfig.java
 * @describe:
 * @author: Rory
 * @date: 2018年7月16日
 * @version: 1.0.0
 */
@Configuration
public class AppConfig {

	@Value("${appConfig.sourceUrl}")
	private String sourceUrl;

	/**
	 * @return the sourceUrl
	 */
	public String getSourceUrl() {
		return sourceUrl;
	}

	/**
	 * @param sourceUrl the sourceUrl to set
	 */
	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

}
