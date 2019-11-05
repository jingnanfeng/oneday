package test.one.two.clone;

import javax.swing.*;
import java.util.Arrays;
import java.util.Date;


/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-26 15:54
 */
public class LambdaTest {

    public static void main(String[] args) {
        String[] planets = new String[]{"one","two","three","four"};

        System.out.println(Arrays.toString(planets));

        System.out.println("Sorted in dictionary order");

        Arrays.sort(planets);

        System.out.println(Arrays.toString(planets));

        System.out.println("Sorted by length");

        Arrays.sort(planets,(first,second) -> first.length()-second.length());
        System.out.println(Arrays.toString(planets));

        Timer t = new Timer(1000, event ->
                System.out.println("the time is"+new Date()));
        t.start();

        JOptionPane.showMessageDialog(null,"Quit");
        System.exit(0);
    }
}
