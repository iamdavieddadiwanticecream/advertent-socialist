public class GameState {
    private int resources;
    private double money;
    private double taxRate;
    private int resourcesPerClick;

    public GameState() {
        this.resources = 0;
        this.money = 0;
        this.taxRate = 0.5; // 50% tax payout
        this.resourcesPerClick = 1;
    }

    public void produce() {
        resources += resourcesPerClick;
        money += resourcesPerClick * taxRate;
    }

    // Getters and setters...
    public int getResources() { return resources; }
    public double getMoney() { return money; }
    public void upgradeClick() {
        resourcesPerClick += 1;
    }

    public void reset() {
        resources = 0;
        money = 0;
        resourcesPerClick = 1;
    }

    public String saveString() {
        return resources + "," + money + "," + resourcesPerClick;
    }

    public void loadFromString(String data) {
        String[] parts = data.split(",");
        resources = Integer.parseInt(parts[0]);
        money = Double.parseDouble(parts[1]);
        resourcesPerClick = Integer.parseInt(parts[2]);
    }
}
