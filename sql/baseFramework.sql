-- 用户表
CREATE TABLE `sys_user` (
  `id` BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '用户ID',
  `username` VARCHAR(50) NOT NULL UNIQUE COMMENT '用户名',
  `password` VARCHAR(255) NOT NULL COMMENT '密码',
  `user_name` VARCHAR(50) NOT NULL UNIQUE COMMENT '用户名称',
  `email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
  `status` ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE' COMMENT '状态（激活/未激活）',
  `create_time` DATE DEFAULT (CURRENT_DATE) COMMENT '创建时间',
  `update_time` DATE DEFAULT (CURRENT_DATE)  COMMENT '更新时间',
  `deleted` TINYINT DEFAULT 0 COMMENT '删除标志'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';
-- 角色表
CREATE TABLE `sys_role` (
  `id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '角色ID',
  `role_name` VARCHAR(50) NOT NULL UNIQUE COMMENT '角色名称',
  `description` TEXT DEFAULT NULL COMMENT '角色描述',
  `status` ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE' COMMENT '角色状态',
  `create_time` DATE DEFAULT (CURRENT_DATE) COMMENT '创建时间',
  `update_time` DATE DEFAULT (CURRENT_DATE)  COMMENT '更新时间',
  `deleted` TINYINT DEFAULT 0 COMMENT '删除标志'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';
-- 菜单表
CREATE TABLE `sys_menu` (
                        `id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '菜单ID',
                        `code` VARCHAR(50) NOT NULL UNIQUE COMMENT '菜单唯一标识',
                        `name` VARCHAR(100) NOT NULL COMMENT '菜单名称',
                        `type` ENUM('NAVIGATION', 'MENU') NOT NULL COMMENT '菜单类型（NAVIGATION为导航，MENU为普通菜单）',
                        `parent_code` VARCHAR(50) DEFAULT NULL COMMENT '父级菜单标识',
                        `page_url` VARCHAR(255) DEFAULT NULL COMMENT '菜单页面URL',
                        `status` ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE' COMMENT '菜单状态',
                        `create_time` DATE DEFAULT (CURRENT_DATE) COMMENT '创建时间',
                        `update_time` DATE DEFAULT (CURRENT_DATE)  COMMENT '更新时间',
                        `deleted` TINYINT DEFAULT 0 COMMENT '删除标志'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='菜单表';
-- 用户角色关系表
CREATE TABLE `sys_user_role` (
                             `user_id` INT UNSIGNED NOT NULL COMMENT '用户ID',
                             `role_id` INT UNSIGNED NOT NULL COMMENT '角色ID',
                             PRIMARY KEY (`user_id`, `role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色关联表';
-- 角色菜单关联表
CREATE TABLE `sys_role_menu` (
                             `role_id` INT UNSIGNED NOT NULL COMMENT '角色ID',
                             `menu_id` INT UNSIGNED NOT NULL COMMENT '菜单ID',
                             PRIMARY KEY (`role_id`, `menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色菜单关联表';
-- 按钮权限表
CREATE TABLE `sys_button_permission` (
  `id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  `button_code` VARCHAR(100) NOT NULL UNIQUE COMMENT '按钮代码',
  `button_name` VARCHAR(100) NOT NULL COMMENT '按钮名称',
  `menu_code` VARCHAR(50) DEFAULT NULL COMMENT '所属菜单',
  `description` TEXT DEFAULT NULL COMMENT '按钮描述',
  `status` ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE',
  `create_time` DATE DEFAULT (CURRENT_DATE) COMMENT '创建时间',
  `update_time` DATE DEFAULT (CURRENT_DATE) COMMENT '更新时间',
  `deleted` TINYINT DEFAULT 0 COMMENT '删除标志'
) COMMENT='按钮权限表';

-- 资源权限表
CREATE TABLE `sys_resource_permission` (
  `id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  `resource_code` VARCHAR(100) NOT NULL UNIQUE COMMENT '资源代码',
  `resource_name` VARCHAR(100) NOT NULL COMMENT '资源名称',
  `resource_type` ENUM('API', 'DATA', 'FILE') DEFAULT NULL COMMENT '资源类型',
  `resource_path` VARCHAR(255) DEFAULT NULL COMMENT '资源路径',
  `description` TEXT DEFAULT NULL COMMENT '资源描述',
  `status` ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE',
  `create_time` DATE DEFAULT (CURRENT_DATE) COMMENT '创建时间',
  `update_time` DATE DEFAULT (CURRENT_DATE) COMMENT '更新时间',
  `deleted` TINYINT DEFAULT 0 COMMENT '删除标志'
) COMMENT='资源权限表';
-- 角色按钮权限关联表
CREATE TABLE `sys_role_button_permission` (
  `role_id` INT UNSIGNED NOT NULL,
  `button_permission_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`role_id`, `button_permission_id`)
) COMMENT='角色按钮权限关联表';

-- 角色资源权限关联表
CREATE TABLE `sys_role_resource_permission` (
  `role_id` INT UNSIGNED NOT NULL,
  `resource_permission_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`role_id`, `resource_permission_id`)
) COMMENT='角色资源权限关联表';
