package it.unibo.nestedenum;

import java.util.Comparator;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {
    public enum Months {
        GENNAIO(31,"Gennaio"),
        FEBBRAIO(29,"Febbraio"),
        MARZO(31,"Marzo"),
        APRILE(30,"Aprile"),
        MAGGIO(31,"Maggio"),
        GIUGNO(30,"Giugno"),
        LUGLIO(31,"Luglio"),
        AGOSTO(31,"Agosto"),
        SETTEMBRE(30,"Settembre"),
        OTTOBRE(31,"Ottobre"),
        NOVEMBRE(30,"Novembre"),
        DICEMBRE(31,"Dicembre");
        private int duration;
        private String monthString;
        private Months(int duration, String monthName){
            this.duration = duration;
            this.monthString = monthName;
        }
        public int getDuration() {
            return this.duration;
        }
        public String getName() {
            return this.monthString;
        }
        public static Months fromString(String monthName) {
            return Months.valueOf(monthName.toUpperCase());
        }
    }
    
    @Override
    public Comparator<String> sortByDays() {
        return new Comparator<String>() {
            @Override
            public int compare(String arg0, String arg1) {
                Months m1 = Months.valueOf(arg0);
                Months m2 = Months.valueOf(arg1);
                return Integer.compare(m1.getDuration(), m2.getDuration());
            }
        };
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new Comparator<String>() {
            @Override
            public int compare(String arg0, String arg1) {
                Months m1 = Months.valueOf(arg0);
                Months m2 = Months.valueOf(arg1);
                return Integer.compare(m1.ordinal(), m2.ordinal());
            }
        };
    }
}
