package Eksamen2017;

import javafx.scene.control.Tab;

public class Group {

        private  int guestCount;
        private Table table;

        public Group(final int guestCount) {
              setGuestCount(guestCount);
        }

    public void setGuestCount(int guestCount) {
        this.guestCount = guestCount;
    }

    public int getGuestCount() {
        return this.guestCount;
    }
}
