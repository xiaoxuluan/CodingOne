package annotation;

import java.lang.annotation.*;

/**
 * @Author: luanyanxu
 * @Date: 2019/10/20 2:10
 * @Version 1.0
 */

@Target(ElementType.FIELD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Name {

    String value() default "";
}
