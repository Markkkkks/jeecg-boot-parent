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
            <a-form-item label="政治面貌:党员,团员,群众" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['politicalStatus', validatorRules.politicalStatus]" placeholder="请输入政治面貌:党员,团员,群众"  ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="学校" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['school', validatorRules.school]" placeholder="请输入学校"  ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="专业" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['major', validatorRules.major]" placeholder="请输入专业"  ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="年级" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['grade', validatorRules.grade]" placeholder="请输入年级"  ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="邮箱" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['mail']" placeholder="请输入邮箱"  ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="电话" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['tel']" placeholder="请输入电话"  ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="特长" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['speciality']" placeholder="请输入特长"  ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="就业意向" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['prefer']" placeholder="请输入就业意向"  ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="实践经历" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['experienceString']" placeholder="请输入实践经历" ></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="简历" :labelCol="labelCol" :wrapperCol="wrapperCol">
              <a-input v-decorator="['resume']" placeholder="请输入简历"  ></a-input>
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
          politicalStatus: {
            rules: [
              { required: true, message: '请输入政治面貌:党员,团员,群众!'},
            ]
          },
          school: {
            rules: [
              { required: true, message: '请输入学校!'},
            ]
          },
          major: {
            rules: [
              { required: true, message: '请输入专业!'},
            ]
          },
          grade: {
            rules: [
              { required: true, message: '请输入年级!'},
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
          this.form.setFieldsValue(pick(this.model,'name','birth','gender','politicalStatus','school','major','grade','mail','tel','speciality','prefer','experienceString','resume'))
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
        this.form.setFieldsValue(pick(row,'name','birth','gender','politicalStatus','school','major','grade','mail','tel','speciality','prefer','experienceString','resume'))
      },
    }
  }
</script>