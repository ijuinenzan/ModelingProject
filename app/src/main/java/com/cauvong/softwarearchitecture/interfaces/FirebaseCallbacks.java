package com.cauvong.softwarearchitecture.interfaces;

import com.google.firebase.database.DataSnapshot;

/**
 * Created by ijuin on 12/4/2017.
 */

public interface FirebaseCallbacks {
    void onNewMessage(DataSnapshot dataSnapshot);
}
