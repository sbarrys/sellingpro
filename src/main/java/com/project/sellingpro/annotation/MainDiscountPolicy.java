package com.project.sellingpro.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("MainDiscountPolicy") // 이제 @MainDiscountPolicy 어노테이션 을 사용하면  Quailifer 처럼 작동하고 MainDiscountpoliy가 작동
public @interface MainDiscountPolicy {
    //Qualifer 의 기본 코드를 복붙해온것이다.
    //@interface 는 어노테이션으로 사용할 수 있도록 만들어주는 클래스 정의자이다.


}
