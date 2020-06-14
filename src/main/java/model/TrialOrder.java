package model;

public class TrialOrder {
    private final int order;

    public TrialOrder(final int order) {
        this.order = order;
    }

    public int getOrder() {
        return this.order;
    }

    public TrialOrder next(){
        return new TrialOrder(order + 1);
    }

    public boolean isSecondTrial(){
        return order == 2;
    }
}
