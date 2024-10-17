package tesco;

import java.time.LocalTime;
import java.util.Objects;

public class Shift {
    private LocalTime startTime;
    private LocalTime endTime;

    public Shift(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    // Check if two shifts overlap
    public boolean overlaps(Shift other) {
        return this.startTime.isBefore(other.endTime) && this.endTime.isAfter(other.startTime);
    }

    // Merge two overlapping shifts into one
    public Shift merge(Shift other) {
        LocalTime mergedStartTime = this.startTime.isBefore(other.startTime) ? this.startTime : other.startTime;
        LocalTime mergedEndTime = this.endTime.isAfter(other.endTime) ? this.endTime : other.endTime;
        return new Shift(mergedStartTime, mergedEndTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shift shift = (Shift) o;
        return Objects.equals(startTime, shift.startTime) && Objects.equals(endTime, shift.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, endTime);
    }

    @Override
    public String toString() {
        return "Shift{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}

