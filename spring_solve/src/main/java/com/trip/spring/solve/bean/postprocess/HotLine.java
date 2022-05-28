package com.trip.spring.solve.bean.postprocess;

public class HotLine {
    private String name;
    private Integer hot;

    public HotLine() {
        System.out.println("this.getHot()");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    @Override
    public String toString() {
        return "HotLine{" +
                "name='" + name + '\'' +
                ", hot=" + hot +
                '}';
    }
}
