package model;

import static frame.impl.NormalFrame.NORMAL_FRAME;

public final class TrialResult {
    private final int alivePins;
    private final String frameName;
    private final int order;

    public TrialResult(final int alivePins, final String frameName, final int order){
        this.alivePins = alivePins;
        this.frameName = frameName;
        this.order = order;
    }

    public boolean isNormalTrial(){
        return NORMAL_FRAME.equals(frameName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrialResult that = (TrialResult) o;

        if (alivePins != that.alivePins) return false;
        if (order != that.order) return false;
        return frameName.equals(that.frameName);
    }

    @Override
    public int hashCode() {
        int result = alivePins;
        result = 31 * result + frameName.hashCode();
        result = 31 * result + order;
        return result;
    }
}
