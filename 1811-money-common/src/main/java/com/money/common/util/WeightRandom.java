package com.money.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeightRandom {

	public static List<Integer> wangzhe(String rate,int number) {
		Double _rate=Double.parseDouble(rate);
		// 准备一个list集合存储product的权重值和购买数量
		List<WeightCategory> categorys = new ArrayList<WeightCategory>();
		// 准备一个随机数对象
		Random random = new Random();
		// 将a个product权重值和数量存入list集合
		for (int i = 0; i < number; i++) {
			WeightCategory wc = new WeightCategory((int) (Math.random() * 4 + 1));
			categorys.add(wc);
		}
		// 权重值的和
		Integer weightSum = 0;
		for (WeightCategory wc : categorys) {
			weightSum += wc.getWeight();
		}
		// 判断权重值有效
		if (weightSum <= 0) {
			System.err.println("Error: weightSum=" + weightSum.toString());
			return null;
		}
		//商品占比转换为数量
		_rate=_rate*10;
		//计算每个商品的份数
		for (int i = 0; i < _rate; i++) {
			Integer n = random.nextInt(weightSum); // n in [0, weightSum)
			Integer m = 0;
			for (WeightCategory wc : categorys) {
				if (m <= n && n < m + wc.getWeight()) {
					// System.out.println("This Random Category is
					// "+wc.getCategory());
					wc.setSum(wc.getSum() + 1);
					// System.out.println(wc.getSum());
					break;
				}
				m += wc.getWeight();
			}
		}
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<number;i++){
			list.add(categorys.get(i).getSum());
		}
		return list;

	}

}

class WeightCategory {
	private Integer weight;
	private int sum = 0;

	public WeightCategory() {
		super();
	}

	public WeightCategory(Integer weight) {
		super();
		this.setWeight(weight);
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

}
