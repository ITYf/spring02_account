package top.ityf.domain;

import java.io.Serializable;

/**
 * ClassName:Account
 * Package: top.ityf.domain
 * Description: 账户的实体类
 *
 * @Date: 2020/2/4 19:52
 * @Author: YanFei
 */
public class Account implements Serializable {
    private Integer id;
    private String name;
    private Float money;

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

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
