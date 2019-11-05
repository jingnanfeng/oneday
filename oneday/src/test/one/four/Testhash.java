package test.one.four;

import java.util.Objects;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-02 15:51
 */
public class Testhash {
    private String a;
    private String b;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
    public Testhash(String a, String b){
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Testhash testhash = (Testhash) o;
        return Objects.equals(a, testhash.a) &&
                Objects.equals(b, testhash.b);
    }

    @Override
    public int hashCode() {
        return a.hashCode();
    }

    public static void main(String[] args) {
        Testhash testhash = new Testhash("aa","bb");
        int hash = testhash.hashCode();
        System.out.println(hash);
    }
    //1265210847
    //961
    //3104
}
