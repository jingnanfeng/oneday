package test.one.extrnds.menu;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-25 15:41
 */
public class EmnuTest {
    public static void main(String[] args) {
        System.out.println("Enter a size:(SMALL,MEDIUM,LARGE,EXTRA_LARGE)");
        Size size = Size.valueOf(Size.class,"EXTRA_LARGE");

        System.out.println("size="+size);

        System.out.println("abbreviation="+size.getAbbreviation());

        if (size == Size.EXTRA_LARGE){
            System.out.println("Good job--you paid attention to the _.");
        }
    }

}

enum Size{
    /**
     *
     */
    SMALL("S"),MEDIUM("M"),LARGE("L"),EXTRA_LARGE("XL");

    private Size(String abbreviation){
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation(){
        return abbreviation;
    }

    private String abbreviation;
}
