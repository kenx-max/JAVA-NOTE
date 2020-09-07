package cn.soboys.kenx;

import io.github.yangyouwang.annotion.Wrapper;
import io.github.yangyouwang.consts.ConfigConsts;

public class Student {
    @Wrapper(dictData = {"0:男","1:女"},dictType = ConfigConsts.WRAPPER_TYPE_ARRAY, name = "sex")
    private int sex;
    private String name;

    private int age;
    @Wrapper(dictData = {"0:正常","1:锁定"},dictType = ConfigConsts.WRAPPER_TYPE_ARRAY, name = "status")
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
