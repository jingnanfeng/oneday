package test.one.three;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-05 9:51
 */

/**
 * 创建一个乐器的父类
 */
class Instrument {

    public void play(Note note){
        System.out.println("Instrument");
    }
}

/**
 * 创建一个子类
 */
class Wind extends Instrument {

    @Override
    public void play(Note note){
        System.out.println("Wind");
    }
}

public class Music{

    public static void turn(Instrument instrument){
        instrument.play(Note.C_SHAPR);
    }

    public static void main(String[] args) {
        Wind wind = new Wind();
        turn(wind);
    }

}