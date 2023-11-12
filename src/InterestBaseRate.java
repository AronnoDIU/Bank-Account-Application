public interface InterestBaseRate {
    // Return the base rate
    default double getBaseRate() {
        return 2.5;
    }
}
