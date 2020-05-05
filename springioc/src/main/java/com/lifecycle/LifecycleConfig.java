package com.lifecycle;

import com.lifecycle.dao.DaoAnnotation;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;

@Configuration
@ComponentScan(value = "com.lifecycle",
      includeFilters = {
            @ComponentScan.Filter(
                    type = FilterType.REGEX,
                    pattern="com.lifecycle.dao.*")
      }
//      ,
//      excludeFilters = @ComponentScan.Filter(Repository.class)
)
public class LifecycleConfig {

}
