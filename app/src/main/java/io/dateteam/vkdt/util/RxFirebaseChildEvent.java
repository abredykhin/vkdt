package io.dateteam.vkdt.util;

import com.google.firebase.database.DataSnapshot;

final class RxFirebaseChildEvent {

    public enum ChildEventType {
        ADDED, CHANGED, REMOVED, MOVED
    }

    private final DataSnapshot dataSnapshot;
    private final ChildEventType eventType;
    private final String previousChildName;

    private RxFirebaseChildEvent(final DataSnapshot dataSnapshot, final ChildEventType eventType, final String previousChildName) {
        this.dataSnapshot = dataSnapshot;
        this.eventType = eventType;
        this.previousChildName = previousChildName;
    }

    public static RxFirebaseChildEvent create(final DataSnapshot dataSnapshot, final ChildEventType eventType) {
        return new RxFirebaseChildEvent(dataSnapshot, eventType, null);
    }

    public static RxFirebaseChildEvent create(final DataSnapshot dataSnapshot, final ChildEventType eventType, final String previousChildName) {
        return new RxFirebaseChildEvent(dataSnapshot, eventType, previousChildName);
    }

    public final DataSnapshot getDataSnapshot() {
        return dataSnapshot;
    }

    public final ChildEventType getEventType() {
        return eventType;
    }

    public final String getPreviousChildName() {
        return previousChildName;
    }


}