import java.util.ArrayList;
import java.util.List;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2018/1/18 下午6:38
 * @modified :
 **/
public class HelloWorld {

    private String name;

    public void setWords(String words) {
        this.words = words;
    }

    private String words;

    public void setName(String name){
        this.name = name;
    }

    public void doSalution(){
        System.out.println("Hello "+name +words);
    }


    public static void main(String[] args) {

        List<String> a = new ArrayList<>();


        a.add("a");
        a.add("b");
        a.add("c");
        a.add("d");
        a.add("e");
        a.add("f");
        a.add("a");
        a.add("f");


        System.out.println(a.subList(a.indexOf("a"),a.lastIndexOf("a") + 1));

        System.out.println(a.indexOf("a"));
        System.out.println(a.lastIndexOf("a"));

    }
}
