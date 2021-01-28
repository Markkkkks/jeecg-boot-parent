<template>
  <a-card :bordered="false">
    <!-- 查询区域 -->
    <div class="table-page-search-wrapper">
      <a-form layout="inline" @keyup.enter.native="searchQuery">
        <a-row :gutter="24">
          <a-col :xl="6" :lg="7" :md="8" :sm="24">
            <a-form-item label="名字">
              <a-input placeholder="请输入名字" v-model="queryParam.name"></a-input>
            </a-form-item>
          </a-col>
          <a-col :xl="6" :lg="7" :md="8" :sm="24">
            <a-form-item label="生日">
              <j-date placeholder="请选择生日" v-model="queryParam.birth"></j-date>
            </a-form-item>
          </a-col>
          <template v-if="toggleSearchStatus">
            <a-col :xl="6" :lg="7" :md="8" :sm="24">
              <a-form-item label="性别:男,女">
                <a-input placeholder="请输入性别:男,女" v-model="queryParam.gender"></a-input>
              </a-form-item>
            </a-col>
            <a-col :xl="6" :lg="7" :md="8" :sm="24">
              <a-form-item label="政治面貌:党员,团员,群众">
                <a-input placeholder="请输入政治面貌:党员,团员,群众" v-model="queryParam.politicalStatus"></a-input>
              </a-form-item>
            </a-col>
            <a-col :xl="6" :lg="7" :md="8" :sm="24">
              <a-form-item label="镇街">
                <a-input placeholder="请输入镇街" v-model="queryParam.registrationTown"></a-input>
              </a-form-item>
            </a-col>
            <a-col :xl="6" :lg="7" :md="8" :sm="24">
              <a-form-item label="高中学校">
                <a-input placeholder="请输入高中学校" v-model="queryParam.highSchool"></a-input>
              </a-form-item>
            </a-col>
            <a-col :xl="6" :lg="7" :md="8" :sm="24">
              <a-form-item label="大学就读高校">
                <a-input placeholder="请输入大学就读高校" v-model="queryParam.college"></a-input>
              </a-form-item>
            </a-col>
            <a-col :xl="6" :lg="7" :md="8" :sm="24">
              <a-form-item label="大学省份（直辖市）">
                <a-input placeholder="请输入大学省份（直辖市）" v-model="queryParam.province"></a-input>
              </a-form-item>
            </a-col>
            <a-col :xl="6" :lg="7" :md="8" :sm="24">
              <a-form-item label="城市（区）">
                <a-input placeholder="请输入城市（区）" v-model="queryParam.city"></a-input>
              </a-form-item>
            </a-col>
            <a-col :xl="6" :lg="7" :md="8" :sm="24">
              <a-form-item label="毕业时间">
                <j-date placeholder="请选择毕业时间" v-model="queryParam.graduateTime"></j-date>
              </a-form-item>
            </a-col>
            <a-col :xl="6" :lg="7" :md="8" :sm="24">
              <a-form-item label="专业">
                <a-input placeholder="请输入专业" v-model="queryParam.major"></a-input>
              </a-form-item>
            </a-col>
            <a-col :xl="6" :lg="7" :md="8" :sm="24">
              <a-form-item label="就业意向">
                <a-input placeholder="请输入就业意向" v-model="queryParam.employmentPrefer"></a-input>
              </a-form-item>
            </a-col>
            <a-col :xl="6" :lg="7" :md="8" :sm="24">
              <a-form-item label="是否大联会会员">
                <a-input placeholder="请输入是否大联会会员" v-model="queryParam.isUnionMember"></a-input>
              </a-form-item>
            </a-col>
          </template>
          <a-col :xl="6" :lg="7" :md="8" :sm="24">
            <span style="float: left;overflow: hidden;" class="table-page-search-submitButtons">
              <a-button type="primary" @click="searchQuery" icon="search">查询</a-button>
              <a-button type="primary" @click="searchReset" icon="reload" style="margin-left: 8px">重置</a-button>
              <a @click="handleToggleSearch" style="margin-left: 8px">
                {{ toggleSearchStatus ? '收起' : '展开' }}
                <a-icon :type="toggleSearchStatus ? 'up' : 'down'"/>
              </a>
            </span>
          </a-col>
        </a-row>
      </a-form>
    </div>
    <!-- 查询区域-END -->

    <!-- 操作按钮区域 -->
    <div class="table-operator">
      <a-button @click="handleAdd" type="primary" icon="plus">新增</a-button>
      <a-button type="primary" icon="download" @click="handleExportXls('学生表')">导出</a-button>
      <a-upload name="file" :showUploadList="false" :multiple="false" :headers="tokenHeader" :action="importExcelUrl" @change="handleImportExcel">
        <a-button type="primary" icon="import">导入</a-button>
      </a-upload>
      <!-- 高级查询区域 -->
      <j-super-query :fieldList="superFieldList" ref="superQueryModal" @handleSuperQuery="handleSuperQuery"></j-super-query>
      <a-dropdown v-if="selectedRowKeys.length > 0">
        <a-menu slot="overlay">
          <a-menu-item key="1" @click="batchDel"><a-icon type="delete"/>删除</a-menu-item>
        </a-menu>
        <a-button style="margin-left: 8px"> 批量操作 <a-icon type="down" /></a-button>
      </a-dropdown>
    </div>

    <!-- table区域-begin -->
    <div>
      <div class="ant-alert ant-alert-info" style="margin-bottom: 16px;">
        <i class="anticon anticon-info-circle ant-alert-icon"></i> 已选择 <a style="font-weight: 600">{{ selectedRowKeys.length }}</a>项
        <a style="margin-left: 24px" @click="onClearSelected">清空</a>
      </div>

      <a-table
        ref="table"
        size="middle"
        :scroll="{x:true}"
        bordered
        rowKey="id"
        :columns="columns"
        :dataSource="dataSource"
        :pagination="ipagination"
        :loading="loading"
        :rowSelection="{selectedRowKeys: selectedRowKeys, onChange: onSelectChange}"
        class="j-table-force-nowrap"
        @change="handleTableChange">

        <template slot="htmlSlot" slot-scope="text">
          <div v-html="text"></div>
        </template>
        <template slot="imgSlot" slot-scope="text">
          <span v-if="!text" style="font-size: 12px;font-style: italic;">无图片</span>
          <img v-else :src="getImgView(text)" height="25px" alt="" style="max-width:80px;font-size: 12px;font-style: italic;"/>
        </template>
        <template slot="fileSlot" slot-scope="text">
          <span v-if="!text" style="font-size: 12px;font-style: italic;">无文件</span>
          <a-button
            v-else
            :ghost="true"
            type="primary"
            icon="download"
            size="small"
            @click="downloadFile(text)">
            下载
          </a-button>
        </template>

        <span slot="action" slot-scope="text, record">
          <a @click="handleEdit(record)">编辑</a>

          <a-divider type="vertical" />
          <a-dropdown>
            <a class="ant-dropdown-link">更多 <a-icon type="down" /></a>
            <a-menu slot="overlay">
              <a-menu-item>
                <a @click="handleDetail(record)">详情</a>
              </a-menu-item>
              <a-menu-item>
                <a-popconfirm title="确定删除吗?" @confirm="() => handleDelete(record.id)">
                  <a>删除</a>
                </a-popconfirm>
              </a-menu-item>
            </a-menu>
          </a-dropdown>
        </span>

      </a-table>
    </div>

    <sys-student-modal ref="modalForm" @ok="modalFormOk"></sys-student-modal>
  </a-card>
</template>

<script>

  import '@/assets/less/TableExpand.less'
  import { mixinDevice } from '@/utils/mixin'
  import { JeecgListMixin } from '@/mixins/JeecgListMixin'
  import SysStudentModal from './modules/SysStudentModal'
  import JDate from '@/components/jeecg/JDate.vue'
  import JSuperQuery from '@/components/jeecg/JSuperQuery.vue'

  export default {
    name: 'SysStudentList',
    mixins:[JeecgListMixin, mixinDevice],
    components: {
      JDate,
      SysStudentModal,
      JSuperQuery,
    },
    data () {
      return {
        description: '学生表管理页面',
        // 表头
        columns: [
          {
            title: '#',
            dataIndex: '',
            key:'rowIndex',
            width:60,
            align:"center",
            customRender:function (t,r,index) {
              return parseInt(index)+1;
            }
          },
          {
            title:'名字',
            align:"center",
            dataIndex: 'name'
          },
          {
            title:'生日',
            align:"center",
            dataIndex: 'birth',
            customRender:function (text) {
              return !text?"":(text.length>10?text.substr(0,10):text)
            }
          },
          {
            title:'性别:男,女',
            align:"center",
            dataIndex: 'gender'
          },
          {
            title:'身份证',
            align:"center",
            dataIndex: 'identity'
          },
          {
            title:'政治面貌:党员,团员,群众',
            align:"center",
            dataIndex: 'politicalStatus'
          },
          {
            title:'联系电话',
            align:"center",
            dataIndex: 'tel'
          },
          {
            title:'通讯地址',
            align:"center",
            dataIndex: 'location'
          },
          {
            title:'户籍（区）',
            align:"center",
            dataIndex: 'registration'
          },
          {
            title:'镇街',
            align:"center",
            dataIndex: 'registrationTown'
          },
          {
            title:'高中学校',
            align:"center",
            dataIndex: 'highSchool'
          },
          {
            title:'大学就读高校',
            align:"center",
            dataIndex: 'college'
          },
          {
            title:'大学省份（直辖市）',
            align:"center",
            dataIndex: 'province'
          },
          {
            title:'城市（区）',
            align:"center",
            dataIndex: 'city'
          },
          {
            title:'毕业时间',
            align:"center",
            dataIndex: 'graduateTime',
            customRender:function (text) {
              return !text?"":(text.length>10?text.substr(0,10):text)
            }
          },
          {
            title:'专业',
            align:"center",
            dataIndex: 'major'
          },
          {
            title:'资格证书',
            align:"center",
            dataIndex: 'credentials'
          },
          {
            title:'获奖荣誉',
            align:"center",
            dataIndex: 'awards'
          },
          {
            title:'爱好特长',
            align:"center",
            dataIndex: 'specialty'
          },
          {
            title:'就业状态',
            align:"center",
            dataIndex: 'employmentStatus'
          },
          {
            title:'就业单位',
            align:"center",
            dataIndex: 'employmentUnit'
          },
          {
            title:'就业意向',
            align:"center",
            dataIndex: 'employmentPrefer'
          },
          {
            title:'期待薪酬',
            align:"center",
            dataIndex: 'preferPay'
          },
          {
            title:'简历',
            align:"center",
            dataIndex: 'resume'
          },
          {
            title:'备注',
            align:"center",
            dataIndex: 'remark'
          },
          {
            title:'是否大联会会员',
            align:"center",
            dataIndex: 'isUnionMember'
          },
          {
            title: '操作',
            dataIndex: 'action',
            align:"center",
            fixed:"right",
            width:147,
            scopedSlots: { customRender: 'action' }
          }
        ],
        url: {
          list: "/student/sysStudent/list",
          delete: "/student/sysStudent/delete",
          deleteBatch: "/student/sysStudent/deleteBatch",
          exportXlsUrl: "/student/sysStudent/exportXls",
          importExcelUrl: "student/sysStudent/importExcel",
          
        },
        dictOptions:{},
        superFieldList:[],
      }
    },
    created() {
    this.getSuperFieldList();
    },
    computed: {
      importExcelUrl: function(){
        return `${window._CONFIG['domianURL']}/${this.url.importExcelUrl}`;
      },
    },
    methods: {
      initDictConfig(){
      },
      getSuperFieldList(){
        let fieldList=[];
        fieldList.push({type:'string',value:'name',text:'名字',dictCode:''})
        fieldList.push({type:'date',value:'birth',text:'生日'})
        fieldList.push({type:'string',value:'gender',text:'性别:男,女',dictCode:''})
        fieldList.push({type:'string',value:'identity',text:'身份证',dictCode:''})
        fieldList.push({type:'string',value:'politicalStatus',text:'政治面貌:党员,团员,群众',dictCode:''})
        fieldList.push({type:'string',value:'tel',text:'联系电话',dictCode:''})
        fieldList.push({type:'string',value:'location',text:'通讯地址',dictCode:''})
        fieldList.push({type:'string',value:'registration',text:'户籍（区）',dictCode:''})
        fieldList.push({type:'string',value:'registrationTown',text:'镇街',dictCode:''})
        fieldList.push({type:'string',value:'highSchool',text:'高中学校',dictCode:''})
        fieldList.push({type:'string',value:'college',text:'大学就读高校',dictCode:''})
        fieldList.push({type:'string',value:'province',text:'大学省份（直辖市）',dictCode:''})
        fieldList.push({type:'string',value:'city',text:'城市（区）',dictCode:''})
        fieldList.push({type:'date',value:'graduateTime',text:'毕业时间'})
        fieldList.push({type:'string',value:'major',text:'专业',dictCode:''})
        fieldList.push({type:'string',value:'credentials',text:'资格证书',dictCode:''})
        fieldList.push({type:'string',value:'awards',text:'获奖荣誉',dictCode:''})
        fieldList.push({type:'string',value:'specialty',text:'爱好特长',dictCode:''})
        fieldList.push({type:'string',value:'employmentStatus',text:'就业状态',dictCode:''})
        fieldList.push({type:'string',value:'employmentUnit',text:'就业单位',dictCode:''})
        fieldList.push({type:'string',value:'employmentPrefer',text:'就业意向',dictCode:''})
        fieldList.push({type:'BigDecimal',value:'preferPay',text:'期待薪酬',dictCode:''})
        fieldList.push({type:'string',value:'resume',text:'简历',dictCode:''})
        fieldList.push({type:'string',value:'remark',text:'备注',dictCode:''})
        fieldList.push({type:'int',value:'isUnionMember',text:'是否大联会会员',dictCode:''})
        this.superFieldList = fieldList
      }
    }
  }
</script>
<style scoped>
  @import '~@assets/less/common.less';
</style>