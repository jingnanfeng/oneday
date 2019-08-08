package thinkInstance.map.containers;

import java.util.List;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-08 9:11
 */
public class Testter<C> {
     public static int fieldWidth = 8;
     public static TestParam[] defaultParams = TestParam.array(10,5000,
             100,5000,1000,5000,10000,500);
     protected C initialsize(int size){
         return container;
     }
     protected C container;

     private String headLine = "";

     private List<Test<C>> tests;

     private static String stringField(){
         return "%" + fieldWidth +"d";
     }
     private static String numberField(){
         return "%" +fieldWidth +"d";
     }

     private static int sizeWidth = 5;

     private static String sizeField = "%" + sizeWidth + "s";

     private TestParam[] paramList = defaultParams;

     public Testter(C container,List<Test<C>> tests){
         this.container = container;
         this.tests = tests;
         if (container != null){
             headLine = container.getClass().getSimpleName();
         }
     }
     public Testter(C container,List<Test<C>> tests, TestParam[] paramList){
         this(container,tests);
         this.paramList = paramList;
     }
     public void setHeadLine(String newHeadLine){
         headLine = newHeadLine;
     }
     public static <C> void run(C cntnr,List<Test<C>> tests){
         new Testter<C>(cntnr,tests);
     }

}
