package bank.domain;

public class InterestStrategyChecking implements IInterestStrategy {

	@Override
	public double computeInterest(double balance) {
		// TODO Auto-generated method stub
		if (balance > 1000) {
			return balance * 0.025;
		}else {
			return balance * 0.015;
		}
	}

}
