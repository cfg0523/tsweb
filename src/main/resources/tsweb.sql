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
 * sys_userrole_det
 */
drop table if exists sys_userrole_det;
create table sys_userrole_det (
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
insert into sys_userrole_det values ('UR01', 'U01', 'R01', '', null, '', null, '');
insert into sys_userrole_det values ('UR02', 'U01', 'R03', '', null, '', null, '');
insert into sys_userrole_det values ('UR03', 'U02', 'R01', '', null, '', null, '');
insert into sys_userrole_det values ('UR04', 'U02', 'R03', '', null, '', null, '');
insert into sys_userrole_det values ('UR05', 'U03', 'R02', '', null, '', null, '');
insert into sys_userrole_det values ('UR06', 'U04', 'R03', '', null, '', null, '');
insert into sys_userrole_det values ('UR07', 'U05', 'R03', '', null, '', null, '');

/**
 * sys_menu_mstr
 */
drop table if exists sys_menu_mstr;
create table sys_menu_mstr (
    menu_id varchar(32) comment '菜单ID',
    menu_name varchar(32) not null comment '菜单名称',
    menu_label varchar(32) comment '菜单描述',
    menu_path varchar(32) comment '菜单路径',
    menu_auth_group varchar(32) comment '授权权限分组',
    menu_auth_index int unsigned comment '授权权限组内索引',
    menu_parent_id varchar(32) comment '父级菜单ID',
    menu_create_by varchar(32) comment '创建人ID',
    menu_create_date datetime comment '创建时间',
    menu_update_by varchar(32) comment '修改人ID',
    menu_update_date datetime comment '修改时间',
    menu_remark varchar(256) comment '备注',
    primary key(menu_id),
    unique key(menu_name),
    unique key(menu_auth_group, menu_auth_index)
) comment '菜单表';
insert into sys_menu_mstr values ('M00', 'tsweb', 'TSWEB', '/', 'root', 1, null, '', null, '', null, '');

insert into sys_menu_mstr values ('M01', 'sys', '系统管理', '/sys', 'tsweb', 1, 'M00', '', null, '', null, '');
insert into sys_menu_mstr values ('M02', 'qareport', 'QAReport', '/qareport', 'tsweb', 2, 'M00', '', null, '', null, '');
insert into sys_menu_mstr values ('M03', 'module', '模块管理', '', 'tsweb', 3, 'M00', '', null, '', null, '');

insert into sys_menu_mstr values ('M04', 'csm', 'CSM', '/csm', 'module', 1, 'M03', '', null, '', null, '');
insert into sys_menu_mstr values ('M05', 'ehr', 'EHR', '/ehr', 'module', 2, 'M03', '', null, '', null, '');

insert into sys_menu_mstr values ('M06', 'user', '用户管理', '/sys/user', 'sys', 1, 'M01', '', null, '', null, '');
insert into sys_menu_mstr values ('M07', 'role', '角色管理', '/sys/role', 'sys', 2, 'M01', '', null, '', null, '');
insert into sys_menu_mstr values ('M08', 'menu', '菜单管理', '/sys/menu', 'sys', 3, 'M01', '', null, '', null, '');

insert into sys_menu_mstr values ('M09', 'daily', 'Daily', '/qareport/daily', 'qareport', 1, 'M02', '', null, '', null, '');
insert into sys_menu_mstr values ('M10', 'detail', 'Detail', '', 'qareport', 2, 'M02', '', null, '', null, '');
insert into sys_menu_mstr values ('M11', 'master', 'Master', '', 'qareport', 3, 'M02', '', null, '', null, '');

insert into sys_menu_mstr values ('M12', 'podetail', 'PO Detail', '/qareport/podetail', 'detail', 1, 'M10', '', null, '', null, '');
insert into sys_menu_mstr values ('M13', 'aqldetail', 'AQL Detail', '/qareport/aqldetail', 'detail', 2, 'M10', '', null, '', null, '');
insert into sys_menu_mstr values ('M14', 'dftdetail', 'DFT Detail', '/qareport/dftdetail', 'detail', 3, 'M10', '', null, '', null, '');
insert into sys_menu_mstr values ('M15', 'pkgdetail', 'PKG Detail', '/qareport/pkgdetail', 'detail', 4, 'M10', '', null, '', null, '');
insert into sys_menu_mstr values ('M16', 'techdetail', 'TECH Detail', '/qareport/techdetail', 'detail', 5, 'M10', '', null, '', null, '');

insert into sys_menu_mstr values ('M17', 'aqlmaster', 'AQL Master', '/qareport/aqlmaster', 'master', 1, 'M11', '', null, '', null, '');
insert into sys_menu_mstr values ('M18', 'codemaster', 'Code Master', '/qareport/codemaster', 'master', 2, 'M11', '', null, '', null, '');

/**
 * sys_auth_det
 */
drop table if exists sys_auth_det;
create table sys_auth_det (
    auth_id varchar(32) comment '授权ID',
    auth_principal_type varchar(32) not null comment '授权主体类型',
    auth_principal_id varchar(32) not null comment '授权主体ID',
    auth_group varchar(32) not null comment '授权权限组名',
    auth_code int unsigned comment '授权码',
    auth_create_by varchar(32) comment '创建人ID',
    auth_create_date datetime comment '创建时间',
    auth_update_by varchar(32) comment '修改人ID',
    auth_update_date datetime comment '修改时间',
    auth_remark varchar(256) comment '备注',
    primary key(auth_id),
    unique key(auth_principal_type, auth_principal_id, auth_group, auth_code)
) comment '授权表';
insert into sys_auth_det values ('A01', 'ROLE', 'R01', 'root', 0xffffffff, '', null, '', null, '');
insert into sys_auth_det values ('A02', 'ROLE', 'R01', 'tsweb', 0xffffffff, '', null, '', null, '');
insert into sys_auth_det values ('A03', 'ROLE', 'R01', 'module', 0xffffffff, '', null, '', null, '');
insert into sys_auth_det values ('A04', 'ROLE', 'R01', 'sys', 0xffffffff, '', null, '', null, '');
insert into sys_auth_det values ('A05', 'ROLE', 'R01', 'qareport', 0xffffffff, '', null, '', null, '');
insert into sys_auth_det values ('A06', 'ROLE', 'R01', 'detail', 0xffffffff, '', null, '', null, '');
insert into sys_auth_det values ('A07', 'ROLE', 'R01', 'master', 0xffffffff, '', null, '', null, '');

insert into sys_auth_det values ('A08', 'ROLE', 'R02', 'root', 0xffffffff, '', null, '', null, '');
insert into sys_auth_det values ('A09', 'ROLE', 'R02', 'tsweb', 0xffffffff, '', null, '', null, '');
insert into sys_auth_det values ('A10', 'ROLE', 'R02', 'module', 0xffffffff, '', null, '', null, '');
insert into sys_auth_det values ('A11', 'ROLE', 'R02', 'sys', 0xffffffff, '', null, '', null, '');
insert into sys_auth_det values ('A12', 'ROLE', 'R02', 'qareport', 0xffffffff, '', null, '', null, '');
insert into sys_auth_det values ('A13', 'ROLE', 'R02', 'detail', 0xffffffff, '', null, '', null, '');
insert into sys_auth_det values ('A14', 'ROLE', 'R02', 'master', 0xffffffff, '', null, '', null, '');

insert into sys_auth_det values ('A15', 'ROLE', 'R03', 'root', 0xffffffff, '', null, '', null, '');
insert into sys_auth_det values ('A16', 'ROLE', 'R03', 'tsweb', 0xffffffff, '', null, '', null, '');
insert into sys_auth_det values ('A17', 'ROLE', 'R03', 'module', 0xffffffff, '', null, '', null, '');
insert into sys_auth_det values ('A18', 'ROLE', 'R03', 'sys', 0xffffffff, '', null, '', null, '');
insert into sys_auth_det values ('A19', 'ROLE', 'R03', 'qareport', 0xffffffff, '', null, '', null, '');
insert into sys_auth_det values ('A20', 'ROLE', 'R03', 'detail', 0xffffffff, '', null, '', null, '');
insert into sys_auth_det values ('A21', 'ROLE', 'R03', 'master', 0xffffffff, '', null, '', null, '');

insert into sys_auth_det values ('A22', 'USER', 'R01', 'sys', 0xffffffff, '', null, '', null, '');
