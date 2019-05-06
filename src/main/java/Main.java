import com.hello.actions.ChHello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2018/1/18 下午6:38
 * @modified :
 **/
public class Main {
    public static void main(String[] args){

        ApplicationContext actx = new ClassPathXmlApplicationContext("spring-config.xml");
//        HelloWorld helloWorld = new HelloWorld();
        ChHello helloWorld = (ChHello)actx.getBean("HelloWorld");
//        helloWorld.setName("chou sha bi");
        System.out.println(helloWorld.doSlution());

        String s = "asdfasdflocalptddate=2017-01-01,adfasdf";
        Matcher matcher = Pattern.compile("localptddate=(.*),").matcher(s);
        if (matcher.find()) {
            System.out.println(matcher.group(1));
        }

        System.out.println("2018-03-07".compareTo("2018-03-07"));
        System.out.println("2018-03-07".compareTo("2018-03-06"));
        System.out.println("2018-03-06".compareTo("2018-03-07"));
        System.out.println("2017-03-07".compareTo("2018-03-07"));



        for (int i = 0 ;i <= 2 ;i++)
            System.out.println(i);


        HashMap map = new HashMap();

        map.put("a","a");


        Hashtable hashtable = new Hashtable();
        hashtable.put(null,null);


        List<String> list = new ArrayList<>();
        list.add("A");
        list.add(1,"A");

    }


}
