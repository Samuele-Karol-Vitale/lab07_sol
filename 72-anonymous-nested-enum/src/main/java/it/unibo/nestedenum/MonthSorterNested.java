package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {
    public enum Months {
        JANUARY(31),
        FEBRUARY(29),
        MARCH(31),
        APRIL(30),
        MAY(31),
        JUNE(30),
        JULY(31),
        AUGUST(31),
        SEPTEMBER(30),
        OCTOBER(31),
        NOVEMBER(30),
        DECEMBER(31);
        public static int NUM_MONTHS = 12;
        private int duration;
        private Months(int duration){
            this.duration = duration;
        }
        public int getDuration() {
            return this.duration;
        }
        public static Months fromString(String name) {
            String monthToSearch = name.toUpperCase();
            Set<String> monthNameSet = new HashSet<>();
            for(var monthName: Months.values()) {
                monthNameSet.add(monthName.name());
            }
            for(int i = 0;  i < monthToSearch.length() && monthNameSet.size() != 0; i++) {
                var monthIterator = monthNameSet.iterator();
                while(monthIterator.hasNext()) {
                    if(!monthIterator.next().contains(monthToSearch.substring(0, i+1))) {
                        monthIterator.remove();
                    }
                }
            }
            if(monthNameSet.size() == 1){
                var monthIterator = monthNameSet.iterator();
                return Months.valueOf(monthIterator.next());
            }
            throw new IllegalArgumentException();
            
        }
    }
    
    @Override
    public Comparator<String> sortByDays() {
        return new Comparator<String>() {
            @Override
            public int compare(String arg0, String arg1) {
                Months m1 = Months.fromString(arg0);
                Months m2 = Months.fromString(arg1);
                return Integer.compare(m1.getDuration(), m2.getDuration());
            }
        };
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new Comparator<String>() {
            @Override
            public int compare(String arg0, String arg1) {
                Months m2 = Months.fromString(arg1);
                Months m1 = Months.fromString(arg0);
                return Integer.compare(m1.ordinal(), m2.ordinal());
            }
        };
    }
}
