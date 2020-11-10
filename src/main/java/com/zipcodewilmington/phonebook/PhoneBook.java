package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {

        this.phonebook = map;
    }

    public PhoneBook() {
        this.phonebook =  new HashMap<String, List<String>>();
    }

    public void add(String name, String phoneNumber) {
        ArrayList<String> phonenumbersList = new ArrayList<String>();
        phonenumbersList.add(phoneNumber);
        this.phonebook.put(name,phonenumbersList);
    }

    public void addAll(String name, String... phoneNumbers) {
        List<String> phonenumbers = new ArrayList<String>(Arrays.asList(phoneNumbers));
        this.phonebook.put(name,phonenumbers);
    }

    public void remove(String name) {
        this.phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        if(this.phonebook.containsKey(name)){
            return true;
        }
        return false;
    }

    public List<String> lookup(String name) {
        if(this.phonebook.containsKey(name)){
            return this.phonebook.get(name);
        }
        else {return null;}
    }

    public String reverseLookup(String phoneNumber)  {
        Iterator it = this.phonebook.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            it.remove();
            return (String) pair.getKey();
        }
        return "not found";
    }

    public List<String> getAllContactNames() {
       List<String> names = new ArrayList<>();
       for(String key:this.phonebook.keySet()){
           names.add(key);
       }
       return names;
    }

    public Map<String, List<String>> getMap() {
        return this.phonebook;
    }
    public boolean hasEntry(String key, String value){
        if(this.phonebook.containsKey(key)){
           if( this.phonebook.get(key).contains(value)){
               return true;
           }
        }
        return false;
    }
}
