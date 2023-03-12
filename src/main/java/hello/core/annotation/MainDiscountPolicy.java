package hello.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

// annotation 만들기
// 그냥 Qualifier 로 만들면 문자기 때문에 컴파일 오류 못잡는데
// 아래와 같이 어노테이션 만들어 주면 @MainDiscountPolicy 라고 했을때 오류 발생 한다.
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {


}
