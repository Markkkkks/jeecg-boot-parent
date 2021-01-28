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
 * @Date:   2021-01-29
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
	/**身份证*/
	@Excel(name = "身份证", width = 15)
    @ApiModelProperty(value = "身份证")
    private java.lang.String identity;
	/**政治面貌:党员,团员,群众*/
	@Excel(name = "政治面貌:党员,团员,群众", width = 15)
    @ApiModelProperty(value = "政治面貌:党员,团员,群众")
    private java.lang.String politicalStatus;
	/**联系电话*/
	@Excel(name = "联系电话", width = 15)
    @ApiModelProperty(value = "联系电话")
    private java.lang.String tel;
	/**通讯地址*/
	@Excel(name = "通讯地址", width = 15)
    @ApiModelProperty(value = "通讯地址")
    private java.lang.String location;
	/**户籍（区）*/
	@Excel(name = "户籍（区）", width = 15)
    @ApiModelProperty(value = "户籍（区）")
    private java.lang.String registration;
	/**镇街*/
	@Excel(name = "镇街", width = 15)
    @ApiModelProperty(value = "镇街")
    private java.lang.String registrationTown;
	/**高中学校*/
	@Excel(name = "高中学校", width = 15)
    @ApiModelProperty(value = "高中学校")
    private java.lang.String highSchool;
	/**大学就读高校*/
	@Excel(name = "大学就读高校", width = 15)
    @ApiModelProperty(value = "大学就读高校")
    private java.lang.String college;
	/**大学省份（直辖市）*/
	@Excel(name = "大学省份（直辖市）", width = 15)
    @ApiModelProperty(value = "大学省份（直辖市）")
    private java.lang.String province;
	/**城市（区）*/
	@Excel(name = "城市（区）", width = 15)
    @ApiModelProperty(value = "城市（区）")
    private java.lang.String city;
	/**毕业时间*/
	@Excel(name = "毕业时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "毕业时间")
    private java.util.Date graduateTime;
	/**专业*/
	@Excel(name = "专业", width = 15)
    @ApiModelProperty(value = "专业")
    private java.lang.String major;
	/**资格证书*/
	@Excel(name = "资格证书", width = 15)
    @ApiModelProperty(value = "资格证书")
    private java.lang.String credentials;
	/**获奖荣誉*/
	@Excel(name = "获奖荣誉", width = 15)
    @ApiModelProperty(value = "获奖荣誉")
    private java.lang.String awards;
	/**爱好特长*/
	@Excel(name = "爱好特长", width = 15)
    @ApiModelProperty(value = "爱好特长")
    private java.lang.String specialty;
	/**就业状态*/
	@Excel(name = "就业状态", width = 15)
    @ApiModelProperty(value = "就业状态")
    private java.lang.String employmentStatus;
	/**就业单位*/
	@Excel(name = "就业单位", width = 15)
    @ApiModelProperty(value = "就业单位")
    private java.lang.String employmentUnit;
	/**就业意向*/
	@Excel(name = "就业意向", width = 15)
    @ApiModelProperty(value = "就业意向")
    private java.lang.String employmentPrefer;
	/**期待薪酬*/
	@Excel(name = "期待薪酬", width = 15)
    @ApiModelProperty(value = "期待薪酬")
    private java.math.BigDecimal preferPay;
	/**简历*/
	@Excel(name = "简历", width = 15)
    @ApiModelProperty(value = "简历")
    private java.lang.String resume;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private java.lang.String remark;
	/**是否大联会会员*/
	@Excel(name = "是否大联会会员", width = 15)
    @ApiModelProperty(value = "是否大联会会员")
    private java.lang.Integer isUnionMember;
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
