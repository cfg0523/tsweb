<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.jsp"%>

<div class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span>&times;</span>
				</button>
				<h4>用户授权</h4>
			</div>
			<div class="modal-body">
				<ul id="treeDemo" class="ztree"></ul>
			</div>
			<div class="modal-footer">
				<button class="btn btn-primary" class="close" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
    var setting = {
        check: {
            enable: true,
            chkStyle: 'checkbox'
        },
        data: {
            key: {
                name: 'label'
            },
            simpleData: {
                enable: true,
                idKey: 'name',
                pIdKey: 'group',
                rootPId: null
            }
        }
    };
    
    var zNodes =[
        {group:null, name:"tsweb", label: 'TSWEB', open:true},
        {group:'tsweb', name:"sys", label: '系统管理', open:true},
        {group:'tsweb', name:"qareport", label: 'QAReport', open:true},
        {group:'tsweb', name:"module", label: '模块管理', open:true},
        {group:'sys', name:"user", label: '用户管理'},
        {group:'sys', name:"role", label: '角色管理'},
        {group:'sys', name:"menu", label: '菜单管理'},
        {group:'qareport', name:"daily", label: 'Daily'},
        {group:'qareport', name:"master", label: 'Master'},
        {group:'qareport', name:"report", label: 'Report'},
        {group:'module', name:"csm", label: 'CSM'},
        {group:'module', name:"ehr", label: 'EHR'},
    ];
    
    /* var setting = {
        check: {
            enable: true
        },
        data: {
            key: {
                name: 'label'
            },
            simpleData: {
                enable: true,
                idKey: 'name',
                pIdKey: 'group',
                rootPId: null
            }
        }
    }; */

    $(document).ready(function(){
        $.fn.zTree.init($("#treeDemo"), setting, zNodes);
    });
</script>