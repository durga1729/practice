package tesco;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Colleague {
    private String name;
    private String department;
    private List<Shift> shifts;

    public Colleague(String name, String department) {
        this.name = name;
        this.department = department;
        this.shifts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public List<Shift> getShifts() {
        return shifts;
    }

    public void addShift(Shift shift) {
        this.shifts.add(shift);
    }

    // Merge overlapping shifts for a colleague
    public void mergeShifts() {
        if (shifts.size() <= 1) return;

        shifts.sort(Comparator.comparing(Shift::getStartTime));
        List<Shift> mergedShifts = new ArrayList<>();
        Shift currentShift = shifts.get(0);

        for (int i = 1; i < shifts.size(); i++) {
            Shift nextShift = shifts.get(i);
            if (currentShift.overlaps(nextShift)) {
                currentShift = currentShift.merge(nextShift);
            } else {
                mergedShifts.add(currentShift);
                currentShift = nextShift;
            }
        }
        mergedShifts.add(currentShift);
        this.shifts = mergedShifts;
    }

    @Override
    public String toString() {
        return "Colleague{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", shifts=" + shifts +
                '}';
    }
}