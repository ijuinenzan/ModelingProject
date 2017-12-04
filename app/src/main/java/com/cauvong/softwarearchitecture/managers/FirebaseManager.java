package com.cauvong.softwarearchitecture.managers;

import com.cauvong.softwarearchitecture.interfaces.FirebaseCallbacks;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ijuin on 12/4/2017.
 */

public class FirebaseManager implements ChildEventListener {
    private static FirebaseManager _firebaseManager;
    private FirebaseDatabase _database;
    private DatabaseReference _messageReference;
    private FirebaseCallbacks _callbacks;

    public static FirebaseManager getInstance() {
        if(_firebaseManager == null)
        {
            _firebaseManager = new FirebaseManager();
        }
        return _firebaseManager;
    }

    private FirebaseManager()
    {
        _database = FirebaseDatabase.getInstance();
        _messageReference = _database.getReference("messages");
    }

    public void addMessageListeners()
    {
        _messageReference.addChildEventListener(this);
    }

    public void removeListeners(){

        _messageReference.removeEventListener(this);
    }

    public void setCallback(FirebaseCallbacks callback)
    {
        _callbacks = callback;
    }

    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        HashMap<String, Object> object = (HashMap<String, Object>) dataSnapshot.getValue();
        String content = object.get("content").toString();
        String messageKey = object.get("messageKey").toString();
        String senderName = object.get("senderName").toString();
        long timeStamp = Long.parseLong(object.get("timeStamp").toString());
        _callbacks.onNewMessage(messageKey, timeStamp, content, senderName);
    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {

    }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }

    public void sendMessageToFirebase(String message, String senderName) {
        Map<String,Object> map=new HashMap<>();

        String key = _messageReference.push().getKey();

        map.put("content",message);
        map.put("messageKey",key);
        map.put("senderName",senderName);
        map.put("timeStamp",System.currentTimeMillis());
        _messageReference.child(key).setValue(map);
    }

    public void destroy() {
        _callbacks =null;
    }

}
