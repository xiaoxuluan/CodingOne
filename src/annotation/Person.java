package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @Author: luanyanxu
 * @Date: 2019/10/20 2:11
 * @Version 1.0
 */
public class Person {
    @Name("¹þ¶ûÎ÷")
    private String name;

    @Gender(gender =Gender.GenderType.Male)
    private String gender;

    @Profile(id = 1001,height = 179,nativePlace = "USA")
    private String profile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
