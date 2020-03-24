package annotation;

import java.lang.annotation.*;

/**
 * @Author: alenlyx
 * @Date: 2019/10/20 2:14
 * @Version 1.0
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Profile {
    /**
     * Id
     * @return
     */
    public int id() default -1;

    /**
     * ���
     * @return
     */
    public  int height() default 0;

    /**
     * ����
     * @return
     */
    public String nativePlace() default "";
}
