package com.haogrgr.unit.hsf.client;

import java.io.Serializable;
import java.util.Date;

public class TestDTO implements Serializable {

    private static final long serialVersionUID = -1L;

    /** id : 主键 **/
    private Integer id;
    /** name : 名字 **/
    private String name;
    /** age : 年龄 **/
    private Integer age;
    /** modify_time : 修改时间 **/
    private Date modifyTime;
    /** create_time : 创建时间 **/
    private Date createTime;

    public TestDTO() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", age=").append(age);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}
