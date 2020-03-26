# 基于SpringBoot Mybatis  的毕业生就业分析系统

---

## 用到的技术：

---

- 使用maven构建项目。

- 使用Springboot mybatsi mysql5.7 搭建系统。

- 前后端通过ajax传输信息。

- 前端使用Layui和X-admin搭建整体UI，使用ECharts做数据可视化。

- 使用阿里巴巴的开源组件easyexcel 操作Excel。

- 使用MySQL 5.7 存储数据。

  

## 项目模块：

---

- **毕业生就业数据：** 毕业生就业数据的展示。

- **毕业生就业数据可视化展示:** 将就业数字可视化展示。

- **学校组织架构管理：** 为了适配不同学校情况，可以灵活配置学校架构。

- **添加修改用户：** 对不同权限的用户进行添加修改删除。 

  

## 怎么启动项目：

---

1. 新建数据库GraduateEmploymentInfo   运行src/main/resources/GraduateEmploymentInfo.sql；
2. 在src/main/resources/application.yml中配置数据库信息；
3. 启动 GeiasApplication 的main方法；
4. 访问http://localhost:8080/page/login 管理员 admin 密码 admin1；

## 功能展示：

----

- 用户登录 

  ![image-20200326110252591](https://github.com/gr2222/image/blob/master/geias/登录.png)

- 毕业生信息管理

  ![image-20200326110252591](https://github.com/gr2222/image/blob/master/geias/首页.png)

  ![image-20200326110252591](https://github.com/gr2222/image/blob/master/geias/工作性质.png)

  ![image-20200326110252591](https://github.com/gr2222/image/blob/master/geias/就业渠道分布.png)

  ![image-20200326110252591](https://github.com/gr2222/image/blob/master/geias/就业地区.png)

  ![image-20200326110252591](https://github.com/gr2222/image/blob/master/geias/就业信息导出.png)

  ![image-20200326110252591](https://github.com/gr2222/image/blob/master/geias/导出Excel信息展示.png)

- 学校架构管理

  ![image-20200326110252591](https://github.com/gr2222/image/blob/master/geias/组织架构.png)

  ![image-20200326110252591](https://github.com/gr2222/image/blob/master/geias/学院列表.png)

  ![image-20200326110252591](https://github.com/gr2222/image/blob/master/geias/专业列表.png)

  ![image-20200326110252591](https://github.com/gr2222/image/blob/master/geias/班级列表.png)

- 人员管理

  ![image-20200326110252591](https://github.com/gr2222/image/blob/master/geias/学院管理员列表.png)

  ![image-20200326110252591](https://github.com/gr2222/image/blob/master/geias/各个学院辅导员列表.png)

