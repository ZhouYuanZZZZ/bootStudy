package com.zy.study.bootstudy.myBatisPlus;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author will
 * @since 2018-02-06
 */
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;
    @TableField("Name")
    private String Name;
    @TableField("CountryCode")
    private String CountryCode;
    @TableField("District")
    private String District;
    @TableField("Population")
    private Integer Population;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String CountryCode) {
        this.CountryCode = CountryCode;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String District) {
        this.District = District;
    }

    public Integer getPopulation() {
        return Population;
    }

    public void setPopulation(Integer Population) {
        this.Population = Population;
    }

    @Override
    public String toString() {
        return "City{" +
        ", id=" + id +
        ", Name=" + Name +
        ", CountryCode=" + CountryCode +
        ", District=" + District +
        ", Population=" + Population +
        "}";
    }
}
