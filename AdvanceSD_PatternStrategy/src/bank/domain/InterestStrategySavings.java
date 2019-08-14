package bank.domain;

public class InterestStrategySavings implements IInterestStrategy {

	@Override
	public double computeInterest(double balance) {
		// TODO Auto-generated method stub
		if (balance > 5000) {
			return balance * 0.04;
		}
		else if (balance > 2000) {
			return balance * 0.02;
		}else {
			return balance * 0.01;
		}
	}

}
