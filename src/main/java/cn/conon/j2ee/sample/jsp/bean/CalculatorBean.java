package cn.conon.j2ee.sample.jsp.bean;

import java.math.BigDecimal;

public class CalculatorBean {

	private double firstNum;
	private double secondNum;
	private char operator = '+'; // + - * /
	private double result;

	public double getFirstNum() {
		return firstNum;
	}
	public void setFirstNum(double firstNum) {
		this.firstNum = firstNum;
	}
	public double getSecondNum() {
		return secondNum;
	}
	public void setSecondNum(double secondNum) {
		this.secondNum = secondNum;
	}

	public char getOperator() {
		return operator;
	}
	public void setOperator(char operator) {
		this.operator = operator;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}

	public void calculate() {

		switch (this.operator) { // int char
			case '+' : {
				this.result = this.firstNum + this.secondNum;
				break;
			}

			case '-' : {
				this.result = this.firstNum - this.secondNum;
				break;
			}

			case '*' : {
				this.result = this.firstNum * this.secondNum;
				break;
			}

			case '/' : {
				if (this.secondNum == 0) {
					throw new RuntimeException("被除数不能为0");
				}
				double temp = this.firstNum / this.secondNum;
				// 对数据进行四舍五入
				this.result = new BigDecimal(temp).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

				break;
			}

			default : {
				throw new RuntimeException("对不起，运算符非法！！！");
			}
		}

	}

}
