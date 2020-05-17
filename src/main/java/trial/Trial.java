package trial;

@FunctionalInterface
public interface Trial {
    public void next(TrialStatus currentStatus);
}
