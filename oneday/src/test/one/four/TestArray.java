package test.one.four;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-18 15:35
 */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 数组的测试
 */
public class TestArray {

    @Test
    public void test(){
        int[] ints = {1,2,3,4,5};
        int[] b = ints;
        int c = b[3];
        b[3] = 100;
        int d = ints[3];
        System.out.println(d);
    }

    /**
     * 数组的复制
     */
    @Test
    public void copyOf(){
        int[] a = {1,2,3,4};
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]+" ");
        }
    }

    /**
     * 它产生一个抽彩游戏中的随机数值组合。 假如抽彩
     * 是从 49 个数值中抽取 6 个
     */
    @Test
    public void sortOf(){
        int n = 50;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }
        int[] result = new int[6];
        for (int i = 0; i <result.length; i++){
            int random = (int)(Math.random()*nums.length);
            result[i] = nums[random];
            nums[random] = nums[n-1];
            n--;
        }
        Arrays.sort(result);
        /*for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }*/
        String s = Arrays.toString(result);
        System.out.println(s);
    }

    @Test
    public void listOf(){
        List<String> stringList = new ArrayList<>();
        stringList.add("aa");
        stringList.add("bb");
        System.out.println(stringList.toString());
    }

    @Test
    public void ArraysTest(){
        String[] strings = {"1s","22","33"};
        String[] s =  Arrays.copyOf(strings,2);
        System.out.println(Arrays.toString(s));

        System.out.println("---------------------------------------------------");
        int[] a = {1,2,3,11};
        int binary = Arrays.binarySearch(a,11);
        System.out.println(binary);
        //包左不包右
        int binarySearch = Arrays.binarySearch(a,1,3,11);
        System.out.println(binarySearch);

        System.out.println("-----------------------------------------------------");

        Arrays.fill(a,5555);
        System.out.println(Arrays.toString(a));

        int[] b = {1,2,3};
        int[] c = {1,2,3};
        boolean res = Arrays.equals(b,c);
        System.out.println(res);
    }

    @Test
    public void testArray(){
        int [][] a = new int[10][5];
        for (int i = 0; i<a.length; i++){
            for (int j = 0; j<a[i].length; j++){

            }
        }

    }
    @Test
    public void test3(){
        List<Integer> list = new ArrayList<>();
        for (int i= 0; i<5;i++) {
            list.add(i);
        }
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addFirst("aa");
    }
}
