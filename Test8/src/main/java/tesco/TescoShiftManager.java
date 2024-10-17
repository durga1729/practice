package tesco;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TescoShiftManager {

    public static void main(String[] args) {
        // Simulate the process of creating stores and assigning shifts
        List<Store> stores = createStores();

        // Merge shifts for each colleague and display the results
        for (Store store : stores) {
            System.out.println("Store ID: " + store.getStoreId());
            for (Colleague colleague : store.getColleagues()) {
                colleague.mergeShifts();
                System.out.println(colleague);
            }
            System.out.println();
        }
    }

    // Create a sample list of stores with colleagues and shifts
    private static List<Store> createStores() {
        List<Store> stores = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {  // 320 stores (10% of 3200)
            Store store = new Store(i);

            for (int j = 1; j <= 5; j++) {  // 800 colleagues per store
                String name = "Colleague_" + j;
                String department = getDepartment(j);
                Colleague colleague = new Colleague(name, department);

                // Assign shifts based on department
                if (department.equals("Bakery")) {
                    colleague.addShift(new Shift(LocalTime.of(8, 0), LocalTime.of(10, 0)));
                } else if (department.equals("Checkout")) {
                    colleague.addShift(new Shift(LocalTime.of(10, 0), LocalTime.of(12, 0)));
                } else if (department.equals("Diary")) {
                    colleague.addShift(new Shift(LocalTime.of(12, 0), LocalTime.of(19, 0)));
                }

                // Add split shifts
                colleague.addShift(new Shift(LocalTime.of(8, 0), LocalTime.of(10, 0)));
                colleague.addShift(new Shift(LocalTime.of(10, 0), LocalTime.of(12, 0)));
                colleague.addShift(new Shift(LocalTime.of(14, 0), LocalTime.of(19, 0)));

                store.addColleague(colleague);
            }

            stores.add(store);
        }
        return stores;
    }

    // Determine department based on colleague index
    private static String getDepartment(int index) {
        if (index % 3 == 1) return "Bakery";
        else if (index % 3 == 2) return "Checkout";
        else return "Diary";
    }
}

