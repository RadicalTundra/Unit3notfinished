package tgrady4_u2_parkingapp;

public interface CheckOutFactory {

    CheckOutStrategy getStrategy(String strategyType);
}
