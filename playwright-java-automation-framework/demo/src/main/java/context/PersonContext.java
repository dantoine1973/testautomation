package context;

public class PersonContext {
    private final ThreadLocal<String> randomFirstName = ThreadLocal.withInitial(() -> null);
    private final ThreadLocal<String> randomLastName = ThreadLocal.withInitial(() -> null);
    private final ThreadLocal<String> randomEmailAddress = ThreadLocal.withInitial(() -> null);
    private final ThreadLocal<String> randomComment = ThreadLocal.withInitial(() -> null);

    public void setRandomFirstName(String randomFirstName) {
        this.randomFirstName.set(randomFirstName);
    }

    public void setRandomLastName(String randomLastName) {
        this.randomLastName.set(randomLastName);
    }

    public void setRandomEmailAddress(String randomEmailAddress) {
        this.randomEmailAddress.set(randomEmailAddress);
    }

    public void setRandomComment(String randomComment) {
        this.randomComment.set(randomComment);
    }

    public String getRandomFirstName() {
        return randomFirstName.get();
    }

    public String getRandomLastName() {
        return randomLastName.get();
    }

    public String getRandomComment() {
        return randomComment.get();
    }
}
