<template>
  <a-spin :spinning="confirmLoading">
    <j-form-container :disabled="formDisabled">
      <a-form :form="form" slot="detail">
        <a-row>
          <a-col :span="24">
            <a-form-item label="名字" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['name', validatorRules.name]" placeholder="请输入名字"  ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="生日" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <j-date placeholder="请选择生日" v-decorator="['birth', validatorRules.birth]" :trigger-change="true" style="width: 100%" />
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="性别:男,女" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['gender', validatorRules.gender]" placeholder="请输入性别:男,女"  ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="身份证" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['identity', validatorRules.identity]" placeholder="请输入身份证"  ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="政治面貌:党员,团员,群众" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['politicalStatus', validatorRules.politicalStatus]" placeholder="请输入政治面貌:党员,团员,群众"  ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="联系电话" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['tel', validatorRules.tel]" placeholder="请输入联系电话"  ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="通讯地址" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['location', validatorRules.location]" placeholder="请输入通讯地址"  ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="户籍（区）" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['registration', validatorRules.registration]" placeholder="请输入户籍（区）"  ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="镇街" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['registrationTown']" placeholder="请输入镇街"  ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="高中学校" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['highSchool', validatorRules.highSchool]" placeholder="请输入高中学校"  ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="大学就读高校" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['college']" placeholder="请输入大学就读高校"  ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="大学省份（直辖市）" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['province']" placeholder="请输入大学省份（直辖市）"  ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="城市（区）" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['city']" placeholder="请输入城市（区）"  ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="毕业时间" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <j-date placeholder="请选择毕业时间" v-decorator="['graduateTime', validatorRules.graduateTime]" :trigger-change="true" style="width: 100%" />
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="专业" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['major']" placeholder="请输入专业"  ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="资格证书" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['credentials']" placeholder="请输入资格证书"  ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="获奖荣誉" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['awards']" placeholder="请输入获奖荣誉"  ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="爱好特长" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['specialty']" placeholder="请输入爱好特长"  ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="就业状态" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['employmentStatus']" placeholder="请输入就业状态"  ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="就业单位" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['employmentUnit']" placeholder="请输入就业单位"  ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="就业意向" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['employmentPrefer']" placeholder="请输入就业意向"  ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="期待薪酬" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input-number v-decorator="['preferPay']" placeholder="请输入期待薪酬" style="width: 100%" />
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="简历" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['resume']" placeholder="请输入简历"  ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="备注" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['remark']" placeholder="请输入备注"  ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="是否大联会会员" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input-number v-decorator="['isUnionMember']" placeholder="请输入是否大联会会员" style="width: 100%" />
            </a-form-item>
          </a-col>
          <a-col v-if="showFlowSubmitButton" :span="24" style="text-align: center">
            <a-button @click="submitForm">提 交</a-button>
          </a-col>
        </a-row>
      </a-form>
    </j-form-container>
  </a-spin>
</template>

<script>

  import { httpAction, getAction } from '@/api/manage'
  import pick from 'lodash.pick'
  import { validateDuplicateValue } from '@/utils/util'
  import JFormContainer from '@/components/jeecg/JFormContainer'
  import JDate from '@/components/jeecg/JDate'  

  export default {
    name: 'SysStudentForm',
    components: {
      JFormContainer,
      JDate,
    },
    props: {
      //流程表单data
      formData: {
        type: Object,
        default: ()=>{},
        required: false
      },
      //表单模式：true流程表单 false普通表单
      formBpm: {
        type: Boolean,
        default: false,
        required: false
      },
      //表单禁用
      disabled: {
        type: Boolean,
        default: false,
        required: false
      }
    },
    data () {
      return {
        form: this.$form.createForm(this),
        model: {},
        labelCol: {
          xs: { span: 24 },
          sm: { span: 5 },
        },
        wrapperCol: {
          xs: { span: 24 },
          sm: { span: 16 },
        },
        confirmLoading: false,
        validatorRules: {
          name: {
            rules: [
              { required: true, message: '请输入名字!'},
            ]
          },
          birth: {
            rules: [
              { required: true, message: '请输入生日!'},
            ]
          },
          gender: {
            rules: [
              { required: true, message: '请输入性别:男,女!'},
            ]
          },
          identity: {
            rules: [
              { required: true, message: '请输入身份证!'},
            ]
          },
          politicalStatus: {
            rules: [
              { required: true, message: '请输入政治面貌:党员,团员,群众!'},
            ]
          },
          tel: {
            rules: [
              { required: true, message: '请输入联系电话!'},
            ]
          },
          location: {
            rules: [
              { required: true, message: '请输入通讯地址!'},
            ]
          },
          registration: {
            rules: [
              { required: true, message: '请输入户籍（区）!'},
            ]
          },
          highSchool: {
            rules: [
              { required: true, message: '请输入高中学校!'},
            ]
          },
          graduateTime: {
            rules: [
              { required: true, message: '请输入毕业时间!'},
            ]
          },
        },
        url: {
          add: "/student/sysStudent/add",
          edit: "/student/sysStudent/edit",
          queryById: "/student/sysStudent/queryById"
        }
      }
    },
    computed: {
      formDisabled(){
        if(this.formBpm===true){
          if(this.formData.disabled===false){
            return false
          }
          return true
        }
        return this.disabled
      },
      showFlowSubmitButton(){
        if(this.formBpm===true){
          if(this.formData.disabled===false){
            return true
          }
        }
        return false
      }
    },
    created () {
      //如果是流程中表单，则需要加载流程表单data
      this.showFlowData();
    },
    methods: {
      add () {
        this.edit({});
      },
      edit (record) {
        this.form.resetFields();
        this.model = Object.assign({}, record);
        this.visible = true;
        this.$nextTick(() => {
          this.form.setFieldsValue(pick(this.model,'name','birth','gender','identity','politicalStatus','tel','location','registration','registrationTown','highSchool','college','province','city','graduateTime','major','credentials','awards','specialty','employmentStatus','employmentUnit','employmentPrefer','preferPay','resume','remark','isUnionMember'))
        })
      },
      //渲染流程表单数据
      showFlowData(){
        if(this.formBpm === true){
          let params = {id:this.formData.dataId};
          getAction(this.url.queryById,params).then((res)=>{
            if(res.success){
              this.edit (res.result);
            }
          });
        }
      },
      submitForm () {
        const that = this;
        // 触发表单验证
        this.form.validateFields((err, values) => {
          if (!err) {
            that.confirmLoading = true;
            let httpurl = '';
            let method = '';
            if(!this.model.id){
              httpurl+=this.url.add;
              method = 'post';
            }else{
              httpurl+=this.url.edit;
               method = 'put';
            }
            let formData = Object.assign(this.model, values);
            console.log("表单提交数据",formData)
            httpAction(httpurl,formData,method).then((res)=>{
              if(res.success){
                that.$message.success(res.message);
                that.$emit('ok');
              }else{
                that.$message.warning(res.message);
              }
            }).finally(() => {
              that.confirmLoading = false;
            })
          }
         
        })
      },
      popupCallback(row){
        this.form.setFieldsValue(pick(row,'name','birth','gender','identity','politicalStatus','tel','location','registration','registrationTown','highSchool','college','province','city','graduateTime','major','credentials','awards','specialty','employmentStatus','employmentUnit','employmentPrefer','preferPay','resume','remark','isUnionMember'))
      },
    }
  }
</script>