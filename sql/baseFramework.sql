-- 用户表
CREATE TABLE `sys_user` (
  `id` BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '用户ID',
  `username` VARCHAR(50) NOT NULL UNIQUE COMMENT '用户名',
  `password` VARCHAR(255) NOT NULL COMMENT '密码',
  `user_name` VARCHAR(50) NOT NULL UNIQUE COMMENT '用户名称',
  `email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
  `status` ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE' COMMENT '状态（激活/未激活）',
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';
-- 角色表
CREATE TABLE `sys_role` (
  `id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '角色ID',
  `role_name` VARCHAR(50) NOT NULL UNIQUE COMMENT '角色名称',
  `description` TEXT DEFAULT NULL COMMENT '角色描述',
  `status` ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE' COMMENT '角色状态',
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
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
                        `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='菜单表';
-- 用户角色关系表
CREATE TABLE `sys_user_role` (
                             `user_id` INT UNSIGNED NOT NULL COMMENT '用户ID',
                             `role_id` INT UNSIGNED NOT NULL COMMENT '角色ID',
                             PRIMARY KEY (`user_id`, `role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色关联表';
-- 权限表
CREATE TABLE `sys_permission` (
                              `id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '权限ID',
                              `permission_code` VARCHAR(100) NOT NULL UNIQUE COMMENT '权限代码',
                              `permission_name` VARCHAR(100) NOT NULL COMMENT '权限名称',
                              `description` TEXT DEFAULT NULL COMMENT '权限描述',
                              `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                              `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限表';
-- 角色权限关系表
CREATE TABLE `sys_role_permission` (
                                   `role_id` INT UNSIGNED NOT NULL COMMENT '角色ID',
                                   `permission_id` INT UNSIGNED NOT NULL COMMENT '权限ID',
                                   PRIMARY KEY (`role_id`, `permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色权限关联表';
-- 角色菜单关联表
CREATE TABLE `sys_role_menu` (
                             `role_id` INT UNSIGNED NOT NULL COMMENT '角色ID',
                             `menu_id` INT UNSIGNED NOT NULL COMMENT '菜单ID',
                             PRIMARY KEY (`role_id`, `menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色菜单关联表';