package tgrady4_u2_parkingapp;

public enum CheckOutStrategyFactorySingleton implements CheckOutFactory{

    INSTANCE;
    
    private CheckOutStrategyFactorySingleton() 
    {
        try {
            // Simulate a long-running constructor, maybe a network or database call?
            Thread.currentThread().sleep(500);
        } catch (InterruptedException ex) {
        }
    }
    
    
    @Override
    public CheckOutStrategy getStrategy(String strategyType) {
        switch (strategyType.toLowerCase()) {
            case "withticket":
                return new CheckOutWithTicket();
            case "withoutticket":
                return new CheckOutWithoutTicket();
            case "specialevent":
                return new CheckOutSpecialEvent();
            default:
                return null;
        }
    }
    
}
