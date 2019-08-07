package thinkInstance.map.containers;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-03 11:30
 */
public class Groundhog {

    protected int number;

    public Groundhog(){
        number = 1;
    }

    public Groundhog(int n){
        number = n;
    }
    public String toString(){
        return "Groundhog #" + number;
    }

}
