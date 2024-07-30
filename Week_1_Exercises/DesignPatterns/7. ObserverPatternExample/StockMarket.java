import java.util.ArrayList;
import java.util.List;
public class StockMarket implements Stock {
    private List<Observer> observers;
    private double price;
    public StockMarket() {
        this.observers = new ArrayList<>();
    }
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(price);
        }
    }
    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }
}
