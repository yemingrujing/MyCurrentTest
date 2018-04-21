package com.ustcInfo.importNew.Clone;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 小汽车类
 * @author guang.wei
 * @datetime 2018年4月20日 下午5:18:04
 */
@Getter
@Setter
@AllArgsConstructor //自动生成全参数构造函数。
@NoArgsConstructor //自动生成无参数构造函数。
public class Car implements Serializable{

	private static final long serialVersionUID = 8921344084464668653L;
	
	private String brand; //品牌
	private int maxSpeed; //最高时速
	
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", maxSpeed=" + maxSpeed + "]";
	}
}
