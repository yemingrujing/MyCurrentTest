package com.ustcInfo.testone;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SumToSum {

	//算法： 求1至19这些自然数数中,所有相加为20的组合
    public static void main(String[] args) {
    	List<Double> list = new ArrayList<Double>();
			
		list.add(26437.60);
		list.add(39300.00);
		list.add(185190.00);
		list.add(218952.00);
		list.add(507936.00);
		list.add(578731.00);
		list.add(647755.00);
		list.add(685416.82);
		list.add(719452.00);
		list.add(740948.00);
		
		list.add(765186.00);
		list.add(842796.00);
		list.add(883748.00);
		list.add(900767.10);
		list.add(931359.00);
		list.add(954041.00);
		list.add(956264.00);
		list.add(960748.00);
		list.add(1006199.00);
		list.add(1017432.14);
		
		list.add(1023048.00);
		list.add(1027595.00);
		list.add(1027800.00);
		list.add(1055985.00);
		list.add(1064350.00);
		list.add(1076674.00);
		list.add(1095590.00);
		list.add(1100000.00);
		list.add(1101000.00);
		list.add(1101000.00);

		list.add(1101000.00);
		list.add(1105000.00);
		list.add(1106100.00);
		list.add(1107050.00);
		list.add(1107050.00);
		list.add(1109673.00);
		list.add(1111140.00);
		list.add(1111500.00);
		list.add(1111500.00);
		list.add(1123500.00);
		
		list.add(1138240.00);
		list.add(1139042.00);
		list.add(1141000.00);
		list.add(1158898.00);
		list.add(1169998.83);
		list.add(1169998.83);
		list.add(1169998.83);
		list.add(1169998.83);
		list.add(1169998.83);
		list.add(1169998.83);
		
		list.add(1169998.83);
		list.add(1169998.83);
		list.add(1169998.83);
		list.add(1169998.83);
		list.add(1169998.83);
		list.add(1169998.83);
		list.add(1169998.83);
		
		// 目标数据
		Double num = 1689035.54;
        combinateDataOfRange(list, num);
    }
    public static void combinateDataOfRange(List<Double> list,Double target){
        combinateData(0.0, list, target, new Stack<Double>());
    }
    public static void combinateData(Double sum,List<Double> list,Double target,Stack<Double> stack){
        for(int i = (int) (stack.isEmpty() ? 0 : stack.lastElement() + 1);i < list.size();++i){
        	Double tempSum = sum + list.get(i);
            stack.push((double) i);
            if((tempSum < target+500 && tempSum > target-500)){
            	for(int j = 0; j < stack.size(); j++) {
            		System.out.print(list.get(DoubleToInteger(stack.get(j)))+" ");
            	}
                System.out.println(stack+"="+tempSum);
            }else if(tempSum >= target+500){
            	stack.pop();
                break;
            }else {
            	combinateData(tempSum,list, target, stack);
            }
            stack.pop();
        }
    }
    public static Integer DoubleToInteger(Double d) {
    	String s1 = String.valueOf(d);	
    	String s2 = s1.substring(0, s1.indexOf("."));
    	Integer i = Integer.parseInt(s2);
    	return i;
    }
}
