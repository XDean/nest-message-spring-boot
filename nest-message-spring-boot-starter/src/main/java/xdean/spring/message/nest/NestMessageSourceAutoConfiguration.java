package xdean.spring.message.nest;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import xdean.spring.auto.AutoSpringFactories;
import xdean.spring.message.nest.NestMessageSourceAutoConfiguration.ResourceBundleCondition;

@Configuration
@Conditional(ResourceBundleCondition.class)
@ConditionalOnMissingBean(value = MessageSource.class, search = SearchStrategy.CURRENT)
@AutoConfigureBefore(MessageSourceAutoConfiguration.class)
@AutoSpringFactories(EnableAutoConfiguration.class)
@EnableConfigurationProperties
public class NestMessageSourceAutoConfiguration extends NestMessageConfiguration {

  protected static class ResourceBundleCondition extends MessageSourceAutoConfiguration.ResourceBundleCondition {
  }
}
