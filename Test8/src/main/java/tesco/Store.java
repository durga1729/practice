package tesco;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private int storeId;
    private List<Colleague> colleagues;

    public Store(int storeId) {
        this.storeId = storeId;
        this.colleagues = new ArrayList<>();
    }

    public int getStoreId() {
        return storeId;
    }

    public List<Colleague> getColleagues() {
        return colleagues;
    }

    public void addColleague(Colleague colleague) {
        this.colleagues.add(colleague);
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeId=" + storeId +
                ", colleagues=" + colleagues +
                '}';
    }
}

