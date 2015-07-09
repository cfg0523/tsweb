/**
 * sys_user_mstr
 */
drop table if exists sys_user_mstr;
create table sys_user_mstr (
    user_id varchar(32),
    user_name varchar(32) not null comment '用户英文名',
    user_password varchar(32) not null comment '密码',
    user_index_menu varchar(32) not null comment '用户登录成功默认跳转的页面ID',
    user_create_by varchar(32) comment '创建人ID',
    user_create_date datetime comment '创建时间',
    user_update_by varchar(32) comment '修改人ID',
    user_update_date datetime comment '修改时间',
    user_remark varchar(256) comment '备注',
    primary key(user_id),
    unique key(user_name)
) comment '用户表';
insert into sys_user_mstr values ('U01', 'hayden', 'hayden', 'M01', '', null, '', null, '');
insert into sys_user_mstr values ('U02', 'fantasy', 'fantasy', 'M04', '', null, '', null, '');
insert into sys_user_mstr values ('U03', 'giny', 'giny', 'M01', '', null, '', null, '');
insert into sys_user_mstr values ('U04', 'yilia', 'yilia', 'M02', '', null, '', null, '');
insert into sys_user_mstr values ('U05', 'tracy', 'tracy', 'M02', '', null, '', null, '');

/**
 * sys_role_mstr
 */
drop table if exists sys_role_mstr;
create table sys_role_mstr (
    role_id varchar(32),
    role_name varchar(32) not null comment '角色名',
    role_label varchar(32) comment '角色描述',
    role_create_by varchar(32) comment '创建人ID',
    role_create_date datetime comment '创建时间',
    role_update_by varchar(32) comment '修改人ID',
    role_update_date datetime comment '修改时间',
    role_remark varchar(256) comment '备注',
    primary key(role_id),
    unique key(role_name)
) comment '角色表';
insert into sys_role_mstr values ('R01', 'programmer', '程序员', '', null, '', null, '');
insert into sys_role_mstr values ('R02', 'manager', '经理', '', null, '', null, '');
insert into sys_role_mstr values ('R03', 'staff', '职员', '', null, '', null, '');

/**
 * sys_userrole_mstr
 */
drop table if exists sys_userrole_mstr;
create table sys_userrole_mstr (
    userrole_id varchar(32) comment '用户角色ID',
    userrole_user_id varchar(32) not null comment '用户ID',
    userrole_role_id varchar(32) not null comment '角色ID',
    userrole_create_by varchar(32) comment '创建人ID',
    userrole_create_date datetime comment '创建时间',
    userrole_update_by varchar(32) comment '修改人ID',
    userrole_update_date datetime comment '修改时间',
    userrole_remark varchar(256) comment '备注',
    primary key(userrole_id),
    unique key(userrole_user_id, userrole_role_id)
) comment '用户角色表';
insert into sys_userrole_mstr values ('UR01', 'U01', 'R01', '', null, '', null, '');
insert into sys_userrole_mstr values ('UR02', 'U01', 'R03', '', null, '', null, '');
insert into sys_userrole_mstr values ('UR03', 'U02', 'R01', '', null, '', null, '');
insert into sys_userrole_mstr values ('UR04', 'U02', 'R03', '', null, '', null, '');
insert into sys_userrole_mstr values ('UR05', 'U03', 'R02', '', null, '', null, '');
insert into sys_userrole_mstr values ('UR06', 'U04', 'R03', '', null, '', null, '');
insert into sys_userrole_mstr values ('UR07', 'U05', 'R03', '', null, '', null, '');

/**
 * sys_menu_mstr
 */
drop table if exists sys_menu_mstr;
create table sys_menu_mstr (
    menu_id varchar(32) comment '菜单ID',
    menu_name varchar(32) not null comment '菜单名称',
    menu_label varchar(32) comment '菜单描述',
    menu_path varchar(32) comment '菜单路径',
    menu_type varchar(32) comment '菜单类型',
    menu_auth_name varchar(32) comment '菜单权限标识名',
    menu_parent_id varchar(32) comment '父级菜单ID',
    menu_create_by varchar(32) comment '创建人ID',
    menu_create_date datetime comment '创建时间',
    menu_update_by varchar(32) comment '修改人ID',
    menu_update_date datetime comment '修改时间',
    menu_remark varchar(256) comment '备注',
    primary key(menu_id),
    unique key(menu_name)
) comment '菜单表';
insert into sys_menu_mstr values ('M00', '/', 'TSWEB', '/', 'BRAND', '*', null, '', null, '', null, '');

insert into sys_menu_mstr values ('M01', 'sys', '系统管理', '/sys', 'TOP_MODULE', 'sys', 'M00', '', null, '', null, '');
insert into sys_menu_mstr values ('M02', 'qareport', 'QAReport', '/qareport', 'TOP_MODULE', 'qareport', 'M00', '', null, '', null, '');
insert into sys_menu_mstr values ('M03', 'module', '模块管理', '', 'TOP_MODULE', 'module', 'M00', '', null, '', null, '');

insert into sys_menu_mstr values ('M04', 'csm', 'CSM', '/csm', 'SUB_MODULE', 'csm', 'M03', '', null, '', null, '');
insert into sys_menu_mstr values ('M05', 'ehr', 'EHR', '/ehr', 'SUB_MODULE', 'ehr', 'M03', '', null, '', null, '');

insert into sys_menu_mstr values ('M06', 'user', '用户管理', '/sys/user', 'TOP_NAV', 'sys:user', 'M01', '', null, '', null, '');
insert into sys_menu_mstr values ('M07', 'role', '角色管理', '/sys/role', 'TOP_NAV', 'sys:role', 'M01', '', null, '', null, '');
insert into sys_menu_mstr values ('M08', 'menu', '菜单管理', '/sys/menu', 'TOP_NAV', 'sys:menu', 'M01', '', null, '', null, '');

insert into sys_menu_mstr values ('M09', 'daily', 'Daily', '/qareport/daily', 'TOP_NAV', 'qareport:daily', 'M02', '', null, '', null, '');
insert into sys_menu_mstr values ('M10', 'detail', 'Detail', '', 'TOP_NAV', 'qareport:detail', 'M02', '', null, '', null, '');
insert into sys_menu_mstr values ('M11', 'master', 'Master', '', 'TOP_NAV', 'qareport:master', 'M02', '', null, '', null, '');

insert into sys_menu_mstr values ('M12', 'podetail', 'PO Detail', '/qareport/podetail', 'SUB_NAV', 'qareport:podetail', 'M10', '', null, '', null, '');
insert into sys_menu_mstr values ('M13', 'aqldetail', 'AQL Detail', '/qareport/aqldetail', 'SUB_NAV', 'qareport:aqldetail', 'M10', '', null, '', null, '');
insert into sys_menu_mstr values ('M14', 'dftdetail', 'DFT Detail', '/qareport/dftdetail', 'SUB_NAV', 'qareport:dftdetail', 'M10', '', null, '', null, '');
insert into sys_menu_mstr values ('M15', 'pkgdetail', 'PKG Detail', '/qareport/pkgdetail', 'SUB_NAV', 'qareport:pkgdetail', 'M10', '', null, '', null, '');
insert into sys_menu_mstr values ('M16', 'techdetail', 'TECH Detail', '/qareport/techdetail', 'SUB_NAV', 'qareport:techdetail', 'M10', '', null, '', null, '');

insert into sys_menu_mstr values ('M17', 'aqlmaster', 'AQL Master', '/qareport/aqlmaster', 'SUB_NAV', 'qareport:aqlmaster', 'M11', '', null, '', null, '');
insert into sys_menu_mstr values ('M18', 'codemaster', 'Code Master', '/qareport/codemaster', 'SUB_NAV', 'qareport:codemaster', 'M11', '', null, '', null, '');
