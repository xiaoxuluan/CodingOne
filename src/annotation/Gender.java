package annotation;

import java.lang.annotation.*;

/**
 * @Author: luanyanxu
 * @Date: 2019/10/20 2:14
 * @Version 1.0
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Gender {

    public enum GenderType{
        /**
         * ����
         */
        Male("��"),
        /**
         * Ů��
         */
        Female("Ů"),
        /**
         * ����
         */
        Other("����");

        private String genderStr;
        GenderType(String arg0){
            this.genderStr = arg0;
        }

        @Override
        public String toString() {
            return "GenderType{" +
                    "genderStr='" + genderStr + '\'' +
                    '}';
        }
    }

    GenderType gender() default GenderType.Male;
}
