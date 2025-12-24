-- 插入导航菜单：基础信息管理
INSERT INTO `sys_menu` (`code`, `name`, `type`, `parent_code`, `page_url`, `status`)
VALUES ('d7533537-e0df-11f0-837a-00ffb645ec1b', '基础信息管理', 'NAVIGATION', NULL, NULL, 'ACTIVE');
-- 插入子菜单：权限管理
INSERT INTO `sys_menu` ( `code`, `name`, `type`, `parent_code`, `page_url`, `status`)
VALUES ('dd878a8b-e0df-11f0-837a-00ffb645ec1b', '权限管理', 'MENU', 'd7533537-e0df-11f0-837a-00ffb645ec1b', 'right.html', 'ACTIVE');
-- 菜单权限
INSERT INTO `baseframework`.`sys_role_menu` (`role_id`, `menu_id`) VALUES (1, 1);
INSERT INTO `baseframework`.`sys_role_menu` (`role_id`, `menu_id`) VALUES (1, 2);
INSERT INTO `baseframework`.`sys_user_role` (`user_id`, `role_id`) VALUES (1, 1);
-- 用户角色
INSERT INTO `baseframework`.`sys_user` (`id`, `username`, `password`, `display_name`, `email`, `status`, `create_time`, `update_time`) VALUES (1, 'admin', '12345678', '管理员', NULL, 'ACTIVE', '2025-12-24 22:54:40', '2025-12-24 22:54:43');
INSERT INTO `baseframework`.`sys_role` (`id`, `role_name`, `description`, `status`, `create_time`, `update_time`) VALUES (1, '管理员', '管理员', 'ACTIVE', '2025-12-24 23:54:37', '2025-12-24 23:54:37');
