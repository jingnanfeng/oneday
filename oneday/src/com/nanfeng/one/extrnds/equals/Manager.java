package com.nanfeng.one.extrnds.equals;

import java.util.Objects;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-24 13:42
 */
public class Manager extends Employee{

    private double bouns;

    public Manager(String name,double salary,int year,int month,int day){
        super(name,salary,year,month,day);
        this.bouns = 0;
    }

    @Override
    public double getSalary(){
        double baseSalary = super.getSalary();
        return  baseSalary + bouns;
    }
    public void setBouns(double bouns){
        this.bouns = bouns;
    }

    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject){
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()){
            return false;
        }
        if (!super.equals(otherObject)){
            return false;
        }
        Manager other = (Manager)otherObject;
        return bouns == other.bouns;
    }

    @Override
    public int hashCode(){
        return super.hashCode() + 17* new Double(bouns).hashCode();
    }
    @Override
    public String toString(){
        return super.toString() + "[bound=]"+bouns+"]";
    }

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Double.compare(manager.bouns, bouns) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bouns);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "bouns=" + bouns +
                '}';
    }*/
}
