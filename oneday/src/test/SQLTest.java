package test;

import org.junit.jupiter.api.Test;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-13 14:25
 */
public class SQLTest {

    @Test
    public void deleteTest(){
        String deleteSQL = "delete from tableA where id = 1";
        String deleteSQLRegex = "(delete(|[\\\\s+]from))(.*(|[\\\\s]+)(where)(|[\\\\s]+)).*(?-i)";
        String matches = matches(deleteSQLRegex, deleteSQL);
        System.out.println("delete"+matches);
        System.out.println("-------------------------------------------");
    }

    @Test
    public void dropTest(){
        String deleteSQL = "drop table where id = 1";
        String deleteSQLRegex = "(?i).*(drop(|[\\\\s+]from))(.*(|[\\\\s]+)(where)(|[\\\\s]+)).*(?-i)";
        String matches = matches(deleteSQLRegex, deleteSQL);
        System.out.println("delete"+matches);
        System.out.println("-------------------------------------------");
    }


    public static String matches(String regex, String content) {
        boolean rel = content.matches(regex);
        if(rel){
            return "符合规则";
        }else{
            return "不符合规则";
        }
    }
}
