package com.multi.algo.day02.a_collection;


public class C_Generic {
    public static void main(String[] args) {
        Truck<String, Integer> truck1 = new Truck<>();// weight, distance

        truck1.setWeight("55.5");
        truck1.setDistance(30);
        System.out.println(truck1);

        Truck<Double, Double> truck2 = new Truck<>();// weight, distance
        truck2.setWeight(55.5);
        truck2.setDistance(30.3);

        System.out.println(truck2);


    }
}
