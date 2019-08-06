package com.nanfeng.one.three.pair;

import java.time.LocalDate;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-02 16:29
 */
public class DateInterval extends Pair<LocalDate>{

    public void setSecond(LocalDate second){
        if (second.compareTo(getFirst()) >= 0){
            super.setSecond(second);
        }
    }

    public DateInterval() {
        super();
    }

    public DateInterval(LocalDate first, LocalDate second) {
        super(first, second);
    }

    @Override
    public LocalDate getFirst() {
        return super.getFirst();
    }

    @Override
    public LocalDate getSecond() {
        return super.getSecond();
    }

    @Override
    public void setFirst(LocalDate first) {
        super.setFirst(first);
    }
}
