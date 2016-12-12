package com.tyler.pojo;

import java.util.List;

/**
 * Created by tyler on 2016/12/12.
 */
public class Father {
    private int fid;
    private String fname;
    private List<Son> sons;
    public Father(){}

    public Father(String fname){
        this.fname = fname;
    }
    public Father(String fname, List<Son> sons) {
        this.fname = fname;
        this.sons = sons;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public List<Son> getSons() {
        return sons;
    }

    public void setSons(List<Son> sons) {
        this.sons = sons;
    }
}
