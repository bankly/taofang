package com.taofang.webapi.model;

import java.util.Date;

public class Dtsbkmusic {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dtsbkmusic.ID
     *
     * @mbggenerated Sat May 07 18:19:12 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dtsbkmusic.Music
     *
     * @mbggenerated Sat May 07 18:19:12 CST 2016
     */
    private String music;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dtsbkmusic.CreateBy
     *
     * @mbggenerated Sat May 07 18:19:12 CST 2016
     */
    private String createby;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dtsbkmusic.CreateDate
     *
     * @mbggenerated Sat May 07 18:19:12 CST 2016
     */
    private Date createdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dtsbkmusic.LastModify
     *
     * @mbggenerated Sat May 07 18:19:12 CST 2016
     */
    private String lastmodify;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dtsbkmusic.LastModifyDate
     *
     * @mbggenerated Sat May 07 18:19:12 CST 2016
     */
    private Date lastmodifydate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dtsbkmusic.ID
     *
     * @return the value of dtsbkmusic.ID
     *
     * @mbggenerated Sat May 07 18:19:12 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dtsbkmusic.ID
     *
     * @param id the value for dtsbkmusic.ID
     *
     * @mbggenerated Sat May 07 18:19:12 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dtsbkmusic.Music
     *
     * @return the value of dtsbkmusic.Music
     *
     * @mbggenerated Sat May 07 18:19:12 CST 2016
     */
    public String getMusic() {
        return music;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dtsbkmusic.Music
     *
     * @param music the value for dtsbkmusic.Music
     *
     * @mbggenerated Sat May 07 18:19:12 CST 2016
     */
    public void setMusic(String music) {
        this.music = music == null ? null : music.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dtsbkmusic.CreateBy
     *
     * @return the value of dtsbkmusic.CreateBy
     *
     * @mbggenerated Sat May 07 18:19:12 CST 2016
     */
    public String getCreateby() {
        return createby;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dtsbkmusic.CreateBy
     *
     * @param createby the value for dtsbkmusic.CreateBy
     *
     * @mbggenerated Sat May 07 18:19:12 CST 2016
     */
    public void setCreateby(String createby) {
        this.createby = createby == null ? null : createby.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dtsbkmusic.CreateDate
     *
     * @return the value of dtsbkmusic.CreateDate
     *
     * @mbggenerated Sat May 07 18:19:12 CST 2016
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dtsbkmusic.CreateDate
     *
     * @param createdate the value for dtsbkmusic.CreateDate
     *
     * @mbggenerated Sat May 07 18:19:12 CST 2016
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dtsbkmusic.LastModify
     *
     * @return the value of dtsbkmusic.LastModify
     *
     * @mbggenerated Sat May 07 18:19:12 CST 2016
     */
    public String getLastmodify() {
        return lastmodify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dtsbkmusic.LastModify
     *
     * @param lastmodify the value for dtsbkmusic.LastModify
     *
     * @mbggenerated Sat May 07 18:19:12 CST 2016
     */
    public void setLastmodify(String lastmodify) {
        this.lastmodify = lastmodify == null ? null : lastmodify.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dtsbkmusic.LastModifyDate
     *
     * @return the value of dtsbkmusic.LastModifyDate
     *
     * @mbggenerated Sat May 07 18:19:12 CST 2016
     */
    public Date getLastmodifydate() {
        return lastmodifydate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dtsbkmusic.LastModifyDate
     *
     * @param lastmodifydate the value for dtsbkmusic.LastModifyDate
     *
     * @mbggenerated Sat May 07 18:19:12 CST 2016
     */
    public void setLastmodifydate(Date lastmodifydate) {
        this.lastmodifydate = lastmodifydate;
    }
}