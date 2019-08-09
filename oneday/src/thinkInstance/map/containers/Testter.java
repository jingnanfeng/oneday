package thinkInstance.map.containers;

import java.util.List;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-09 8:49
 */
public class Testter<C> {
    public static int fieldWidth = 8;

    public static TestParam[] defaultParams = TestParam.array(
            10,500,100,1000,5000,10000,500
    );
    protected C initialsize(int size){
        return container;
    }
    protected C container;

    private String headline = "";

    private List<Test<C>> tests;

    private static String stringField(){
        return "%" + fieldWidth + "s";
    }
    private static String numberField(){
        return "%" +fieldWidth + "d";
    }

    private static int sizeWidth = 5;

    private static String sizeField = "%" + sizeWidth + "s";

    private TestParam[] paramList = defaultParams;

    public Testter(C container, List<Test<C>> tests){
        this.container = container;
        this.tests = tests;
        if (container != null){
            headline = container.getClass().getSimpleName();
        }
    }
    public Testter(C container,List<Test<C>> tests,TestParam[] paramList){
        this(container,tests);
        this.paramList = paramList;
    }
    public void setHeadline(String newHeadline){
        headline = newHeadline;
    }

    public static <C> void run(C cntnr,List<Test<C>> tests){
        new Testter<C>(cntnr,tests).timedTest();
    }
    public static <C> void run(C cntnr,List<Test<C>> tests,TestParam[] paramList){
        new Testter<C>(cntnr,tests,paramList).timedTest();
    }

    private void displayHeader(){
        int width = fieldWidth * tests.size() +sizeWidth;
        int dashLength = width - headline.length() - 1;
        StringBuffer head = new StringBuffer(width);
        for (int i = 0; i < dashLength/2; i++){
            head.append('-');
        }
        head.append(' ');
        head.append(headline);
        head.append(' ');
        for (int i = 0; i < dashLength/2; i++){
            head.append('-');
        }
        System.out.println(head);
        System.out.format(sizeField,"size");
        for (Test<C> test : tests) {
            System.out.format(stringField(),test.name);
        }
        System.out.println();
    }
    public void timedTest(){
        displayHeader();
        for (TestParam param : paramList) {
            System.out.format(sizeField,param.size);
            for (Test<C> test : tests){
                C kontainer = initialsize(param.size);
                long start = System.nanoTime();
                int reps = test.test(kontainer,param);
                long duration = System.nanoTime() - start;
                long timePerReo = duration / reps;
                System.out.format(numberField(),timePerReo);
            }
            System.out.println();
        }
    }
}
