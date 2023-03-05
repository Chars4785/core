package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // 다른 appconfig는 컴포넌트에서 빼기 위해서
        // @Configuration 도 컴포넌트에서 뺴기
        // @component 붙은 놈들 다 등록 된다.
)
public class AutoAppConfig {

}
