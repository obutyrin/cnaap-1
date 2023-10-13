package com.demo.profile.MadeInWroclaw.delegator.config;

import com.demo.profile.MadeInWroclaw.helper.impl.MadeinwroclawServiceHelperImpl;
import com.gringotts.foundation.core.utils.future.FutureUtils;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.gringotts.foundation", "com.demo.profile.MadeInWroclaw"})
public class TestConfiguration {

  @MockBean public FutureUtils futureUtils;

  @SpyBean public MadeinwroclawServiceHelperImpl madeinwroclawServiceHelperImpl;
}
