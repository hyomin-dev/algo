package com.multi.algo.day02.a_collection;
//객체 생성시 타입을 정할 수 있음. 형변환 불필요

public class Truck<T1, T2> {
	private  T1 weight;
	private T2 distance;
	public T2 getDistance() {
		return distance;
	}

	public void setDistance(T2 distance) {
		this.distance = distance;
	}



	public T1 getWeight() {
		return weight;
	}

	public void setWeight(T1 weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Truck [weight=" + weight + ", distance=" + distance + "]";
	}
}
