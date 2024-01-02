public class RateLimitStatus {
    public long lastRefillTime;
    public int currentTokenCount;

    public RateLimitStatus(long lastRefillTime, int currentTokenCount) {
        this.lastRefillTime = lastRefillTime;
        this.currentTokenCount = currentTokenCount;
    }
}
