package com.experiment;

public class Laptop {
    private String name;
    private Integer ram;
    private Integer memory;

    public Laptop(String name, Integer ram, Integer memory) {
        this.name = name;
        this.ram = ram;
        this.memory = memory;
    }

    public String getName() {
        return this.name;
    }
    public Integer getRam() {
        return this.ram;
    }
    public Integer getMemory() {
        return this.memory;
    }

//    @Override
//    public int compareTo(Laptop l) {
//        if(this.getRam() > l.getRam()) {
//            return 1;
//        }
//        return -1;
//    }
}
