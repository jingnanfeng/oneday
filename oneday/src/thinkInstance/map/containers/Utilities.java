package thinkInstance.map.containers;

import java.util.*;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-14 8:43
 */
public class Utilities {

    static List<String> list = Arrays.asList("one Two three Four five six one".split(" "));
    static List<String> strings = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(list);
        //当两个集合中没有相同的元素返回false
        //Collections.singletonList 产生不可变的List<T> 它只包含给定参数内容而形成的单一项
        System.out.println(" 'list' disjoint(Four)?: " + Collections.disjoint(list,Collections.singletonList("Four")));
        //返回参数Collection中最大或者最小的元素，采用Collection内置的自然排序发
        System.out.println("max: " + Collections.max(list));
        System.out.println("min: " + Collections.min(list));
        //返回参数Collection中最大或者最小的元素，采用Comparator进行比较
        System.out.println("max w/ comparator: " + Collections.max(list,String.CASE_INSENSITIVE_ORDER));
        System.out.println("min w/ comparator: " + Collections.min(list,String.CASE_INSENSITIVE_ORDER));

        List<String> sublist = Arrays.asList("Four five six".split(" "));
        //返回后面一个集合在前面一个集合中第一次（最后一次）出现的位置，没有则返回-1;
        System.out.println("indexOfSubList: "+ Collections.indexOfSubList(list,sublist));
        System.out.println("lastOfSubList: " + Collections.lastIndexOfSubList(list,sublist));
        //使用新值取代所有的旧值
        Collections.replaceAll(list,"one","Yo");
        System.out.println(list);
        //反转所有的值
        Collections.reverse(list);
        System.out.println(list);
        ///所有的元素向后移动int为，将末尾的值循环到前面去
        Collections.rotate(list,3);
        System.out.println(list);

        List<String> source = Arrays.asList("in the matrix".split(" "));
        //将source中的值拷贝到list中，替换从头开始
        Collections.copy(list,source);
        System.out.println(list);
        //交换第一位和最后一位发位置
        Collections.swap(list,0,list.size() - 1);
        System.out.println(list);
        //随机改变list的顺序
        Collections.shuffle(list,new Random(47));
        System.out.println(list);

        //将集合中所有的元素全部替换为pop
        Collections.fill(list,"pop");
        System.out.println(list);
        //返回集合中pop的个数
        System.out.println(Collections.frequency(list,"pop"));
        //返回大小为n的集合，不可变，指向snap
        List<String> dups = Collections.nCopies(3,"snap");
        System.out.println(dups);
        //当两个集合没有相同元素时返回true
        System.out.println(Collections.disjoint(list,dups));

        Enumeration<String> e = Collections.enumeration(dups);
        Vector<String> v = new Vector<>();
        while (e.hasMoreElements()){
            v.add(e.nextElement());
        }
        ArrayList<String> stringList = Collections.list(v.elements());
        System.out.println(stringList);




    }
}
