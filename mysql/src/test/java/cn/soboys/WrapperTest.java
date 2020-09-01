package cn.soboys;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.dialect.console.ConsoleLog;
import cn.soboys.kenx.Student;
import io.github.yangyouwang.core.ControllerWrapper;
import org.junit.Test;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WrapperTest {

    @Test
    public void test() {

        Student s = new Student();
        s.setAge(23);
        s.setName("kenx");
        s.setSex(0);
        s.setStatus(0);

        Student s1 = new Student();
        s1.setAge(22);
        s1.setName("judy");
        s1.setSex(1);
        s1.setStatus(1);

        List<Student> list = new ArrayList<>();
        list.add(s);
        list.add(s1);
       for (int i = 0; i <= 1000000; i++) {
            Student s2 = new Student();
            s2.setAge(25);
            s2.setName("Tom");
            s2.setSex(0);
            s2.setStatus(1);
            list.add(s2);

        }

        long startTime = System.currentTimeMillis();
        String json=JSONUtil.toJsonStr(ControllerWrapper.getInstance().wrap(list));

        //List<Map<String, Object>> m = ControllerWrapper.getInstance().wrap(list);
        long endTime = System.currentTimeMillis();
        System.out.println(DateUtil.formatBetween( endTime-startTime));
       // System.out.println(m.toString());

    }
}
