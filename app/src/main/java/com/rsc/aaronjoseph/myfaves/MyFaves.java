package com.rsc.aaronjoseph.myfaves;

public class MyFaves {


    private int _id;
    private String _category;
    private String _title;
    private String _details;
    private String _url;

    public MyFaves(String _category, String _title, String _details, String _url) {
        this._category = _category;
        this._title = _title;
        this._details = _details;
        this._url = _url;
    }

    public MyFaves (String _category) {
        this._category = _category;
    }

    public MyFaves() {

    }


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_category() {
        return _category;
    }

    public void set_category(String _category) {
        this._category = _category;
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public String get_details() {
        return _details;
    }

    public void set_details(String _details) {
        this._details = _details;
    }

    public String get_url() {
        return _url;
    }

    public void set_url(String _url) {
        this._url = _url;
    }
}
