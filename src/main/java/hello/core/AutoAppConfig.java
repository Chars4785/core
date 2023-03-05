package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
// member만 스캔 대상이 된다. default는 @ComponentScan 이 붙은 설정 정보 클래스의 패키지가 시작 위치가 된다.
//        basePackages = "hello.core.member",
//        basePackageClasses = AutoAppConfig.class, // 이 페키지만 찾는다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // 다른 appconfig는 컴포넌트에서 빼기 위해서
        // @Configuration 도 컴포넌트에서 뺴기
        // @component 붙은 놈들 다 등록 된다.
)
public class AutoAppConfig {

}
