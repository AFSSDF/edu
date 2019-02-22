package com.bdqn.edu.condition;

/**
 * <p>
 * 职员信息 条件
 * </p>
 *
 * @author Li
 * @since 2019-02-21
 */
public class TeacherCondition {

    private String name;

    private String email;

    private Boolean isDelete;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}
