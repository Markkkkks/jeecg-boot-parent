package org.jeecg.modules.demo.student.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 学生表
 * @Author: jeecg-boot
 * @Date:   2021-01-13
 * @Version: V1.0
 */
@Data
@TableName("sys_student")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="sys_student对象", description="学生表")
public class SysStudent implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**名字*/
	@Excel(name = "名字", width = 15)
    @ApiModelProperty(value = "名字")
    private java.lang.String name;
	/**生日*/
	@Excel(name = "生日", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "生日")
    private java.util.Date birth;
	/**性别:男,女*/
	@Excel(name = "性别:男,女", width = 15)
    @ApiModelProperty(value = "性别:男,女")
    private java.lang.String gender;
	/**政治面貌:党员,团员,群众*/
	@Excel(name = "政治面貌:党员,团员,群众", width = 15)
    @ApiModelProperty(value = "政治面貌:党员,团员,群众")
    private java.lang.String politicalStatus;
	/**学校*/
	@Excel(name = "学校", width = 15)
    @ApiModelProperty(value = "学校")
    private java.lang.String school;
	/**专业*/
	@Excel(name = "专业", width = 15)
    @ApiModelProperty(value = "专业")
    private java.lang.String major;
	/**年级*/
	@Excel(name = "年级", width = 15)
    @ApiModelProperty(value = "年级")
    private java.lang.String grade;
	/**邮箱*/
	@Excel(name = "邮箱", width = 15)
    @ApiModelProperty(value = "邮箱")
    private java.lang.String mail;
	/**电话*/
	@Excel(name = "电话", width = 15)
    @ApiModelProperty(value = "电话")
    private java.lang.String tel;
	/**特长*/
	@Excel(name = "特长", width = 15)
    @ApiModelProperty(value = "特长")
    private java.lang.String speciality;
	/**就业意向*/
	@Excel(name = "就业意向", width = 15)
    @ApiModelProperty(value = "就业意向")
    private java.lang.String prefer;
	/**实践经历*/
	@Excel(name = "实践经历", width = 15)
    private transient java.lang.String experienceString;

    private byte[] experience;

    public byte[] getExperience(){
        if(experienceString==null){
            return null;
        }
        try {
            return experienceString.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getExperienceString(){
        if(experience==null || experience.length==0){
            return "";
        }
        try {
            return new String(experience,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
	/**简历*/
	@Excel(name = "简历", width = 15)
    @ApiModelProperty(value = "简历")
    private java.lang.String resume;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private java.util.Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private java.util.Date updateTime;
}
