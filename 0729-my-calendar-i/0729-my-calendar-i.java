class MyCalendar {

    private java.util.List<int[]> events;

    public MyCalendar() {
        events = new java.util.ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
        for (int[] event : events) {
            if (startTime < event[1] && endTime > event[0])
                return false;
        }

        events.add(new int[]{startTime, endTime});
        return true;
    }
}