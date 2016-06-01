package io.dateteam.vkdt.util;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.subscriptions.Subscriptions;

public final class RxFirebase {
    private final DatabaseReference firebase;

    private RxFirebase(DatabaseReference firebase) {
        this.firebase = firebase;
    }

    public static RxFirebase with(final DatabaseReference firebase) {
        return new RxFirebase(firebase);
    }

    public final Observable<Boolean> setValue(final Object value) {
        return setValue(value, null);
    }

    public final Observable<Boolean> setValue(final Object value, final Object priority) {
        return Observable.create(new Observable.OnSubscribe<Boolean>() {
            @Override
            public void call(final Subscriber<? super Boolean> subscriber) {
                firebase.setValue(value, priority, (databaseError, databaseReference) -> {
                    if (databaseError == null) {
                        subscriber.onNext(true);
                        subscriber.onCompleted();
                    } else {
                        subscriber.onError(databaseError.toException());
                    }
                });
            }
        });
    }

    public final Observable<DataSnapshot> onValueEvent(final String path) {
        return Observable.create(new Observable.OnSubscribe<DataSnapshot>() {
            @Override
            public void call(final Subscriber<? super DataSnapshot> subscriber) {
                final ValueEventListener valueEventListener = firebase.child(path).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(final DataSnapshot dataSnapshot) {
                        subscriber.onNext(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        subscriber.onError(databaseError.toException());
                    }

                });

                subscriber.add(Subscriptions.create(new Action0() {

                    @Override
                    public void call() {
                        firebase.child(path).removeEventListener(valueEventListener);
                    }
                }));
            }
        });
    }

    public Observable<DataSnapshot> onSingleValueEvent(final String path) {
        return Observable.create(new Observable.OnSubscribe<DataSnapshot>() {
            @Override
            public void call(final Subscriber<? super DataSnapshot> subscriber) {
                final ValueEventListener valueEventListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(final DataSnapshot dataSnapshot) {
                        subscriber.onNext(dataSnapshot);
                        subscriber.onCompleted();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        subscriber.onError(databaseError.toException());
                    }
                };

                firebase.child(path).addListenerForSingleValueEvent(valueEventListener);
            }
        });
    }

    public final Observable<RxFirebaseChildEvent> onChildEvent(final String path) {
        return Observable.create(new Observable.OnSubscribe<RxFirebaseChildEvent>() {
            @Override
            public void call(final Subscriber<? super RxFirebaseChildEvent> subscriber) {
                firebase.child(path).addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(final DataSnapshot dataSnapshot, final String previousChildName) {
                        subscriber.onNext(RxFirebaseChildEvent.create(dataSnapshot, RxFirebaseChildEvent.ChildEventType.ADDED, previousChildName));
                    }

                    @Override
                    public void onChildChanged(final DataSnapshot dataSnapshot, final String previousChildName) {
                        subscriber.onNext(RxFirebaseChildEvent.create(dataSnapshot, RxFirebaseChildEvent.ChildEventType.CHANGED, previousChildName));
                    }

                    @Override
                    public void onChildRemoved(final DataSnapshot dataSnapshot) {
                        subscriber.onNext(RxFirebaseChildEvent.create(dataSnapshot, RxFirebaseChildEvent.ChildEventType.REMOVED));
                    }

                    @Override
                    public void onChildMoved(final DataSnapshot dataSnapshot, final String previousChildName) {
                        subscriber.onNext(RxFirebaseChildEvent.create(dataSnapshot, RxFirebaseChildEvent.ChildEventType.MOVED, previousChildName));
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        subscriber.onError(databaseError.toException());
                    }
                });
            }
        });
    }

    public final Observable<RxFirebaseChildEvent> onChildAdded(final String path) {
        return onChildEvent(path).filter(new Func1<RxFirebaseChildEvent, Boolean>() {
            @Override
            public Boolean call(final RxFirebaseChildEvent rxFirebaseChildEvent) {
                return rxFirebaseChildEvent.getEventType().equals(RxFirebaseChildEvent.ChildEventType.ADDED);
            }
        });
    }

    public final Observable<RxFirebaseChildEvent> onChildChanged(final String path) {
        return onChildEvent(path).filter(new Func1<RxFirebaseChildEvent, Boolean>() {
            @Override
            public Boolean call(final RxFirebaseChildEvent rxFirebaseChildEvent) {
                return rxFirebaseChildEvent.getEventType().equals(RxFirebaseChildEvent.ChildEventType.CHANGED);
            }
        });
    }

    public final Observable<RxFirebaseChildEvent> onChildRemoved(final String path) {
        return onChildEvent(path).filter(new Func1<RxFirebaseChildEvent, Boolean>() {
            @Override
            public Boolean call(final RxFirebaseChildEvent rxFirebaseChildEvent) {
                return rxFirebaseChildEvent.getEventType().equals(RxFirebaseChildEvent.ChildEventType.REMOVED);
            }
        });
    }

    public final Observable<RxFirebaseChildEvent> onChildMoved(final String path) {
        return onChildEvent(path).filter(new Func1<RxFirebaseChildEvent, Boolean>() {
            @Override
            public Boolean call(final RxFirebaseChildEvent rxFirebaseChildEvent) {
                return rxFirebaseChildEvent.getEventType().equals(RxFirebaseChildEvent.ChildEventType.MOVED);
            }
        });
    }


}