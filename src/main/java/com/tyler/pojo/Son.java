package com.tyler.pojo;

/**
 * Created by tyler on 2016/12/12.
 */
public class Son {
    private int sid;
    private int fid;
    private String sname;

    public Son(){}

    public Son(int fid, String sname) {
        this.fid = fid;
        this.sname = sname;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
