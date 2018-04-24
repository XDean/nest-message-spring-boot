package xdean.spring.message.nest;

import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableConfigurationProperties
public class NestMessageConfiguration extends MessageSourceAutoConfiguration {
  @Bean
  @ConfigurationProperties(prefix = "xdean.message.nest")
  public NestMessageSourceProperties nestMessageSourceProperties() {
    return new NestMessageSourceProperties();
  }

  @Bean
  @Primary
  public NestMessageSource nestMessageSource() {
    return new NestMessageSource(this.messageSource());
  }
}
