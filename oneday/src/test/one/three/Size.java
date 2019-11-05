package test.one.three;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-10 18:21
 */
public enum Size {

    /**
     * 小的尺寸
     */
    SMALL("small"),

    /**
     * 一般的尺寸
     */
    NORMAL("normal"),
    /**
     * 大的尺寸
     */
    BIG("big"),
    /**
     * 更大的尺寸
     */
    MORE("more");


    private final String name;

    private Size(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
class Tests{
    public static void main(String[] args) {
        System.out.println(Size.BIG.getName());
    }
}