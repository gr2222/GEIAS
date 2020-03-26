create table tb_college
(
    college_id  int(10) AUTO_INCREMENT,
    name        varchar(100) not null,
    create_time datetime default null,
    admin_id    int(10),
    primary key (college_id),
    CONSTRAINT `tb_college_tb_person_info` FOREIGN KEY (`admin_id`) REFERENCES `tb_person_info` (`person_id`)
) engine = innoDB
  auto_increment = 1
  default charset = utf8;

create table tb_specialty
(
    specialty_id int(10) auto_increment,
    name         varchar(100) not null,
    college_id   int(10)      not null,
    create_time  datetime default null,
    primary key (`specialty_id`),
    CONSTRAINT `tb_specialty_tb_college` FOREIGN KEY (`college_id`) REFERENCES `tb_college` (`college_id`)
) engine = innoDB
  auto_increment = 1
  default charset = utf8;

create table tb_class_grade
(
    class_id     int(10) AUTO_INCREMENT,
    name         varchar(100) not null,
    specialty_id int(10),
    admin_id     int(10),
    create_time  datetime default null,
    primary key (`class_id`),
    CONSTRAINT `tb_class_grade_tb_specialty` FOREIGN KEY (`specialty_id`) REFERENCES `tb_specialty` (`specialty_id`),
    CONSTRAINT `tb_class_grade_tb_person_info` FOREIGN KEY (`admin_id`) REFERENCES `tb_person_info` (`person_id`)
) engine = innoDB
  AUTO_INCREMENT = 1
  default charset = utf8;


create table tb_area
(
    area_id     int(10) auto_increment,
    name        varchar(100) not null,
    parent_id   int(10)  default '0',
    create_time datetime default null,
    primary key (`area_id`),
    constraint `tb_area_parent` foreign key (`parent_id`) references `tb_area` (`area_id`)
) engine = innoDb
  auto_increment = 1
  default charset = utf8;


create table tb_unit_kind
(
    unit_id     int(10) auto_increment,
    name        varchar(100) not null,
    create_time datetime default null,
    primary key (`unit_id`)
) engine = innoDB
  auto_increment = 1
  default charset = utf8;

create table tb_employment_way
(
    employment_way_id int(10) auto_increment,
    name              varchar(100) not null,
    create_time       datetime default null,
    primary key (`employment_way_id`)
) engine = innoDB
  auto_increment = 1
  default charset = utf8;


create table tb_employment_information
(
    information_id    int(10) auto_increment,
    student_num       int(10)      not null,
    name              varchar(100) not null,
    class_id          int(10)      not null,
    area_id           int(10)      not null,
    unit_id           int(10)      not null,
    salary            varchar(10)  not null,
    employment_way_id int(10)      not null,
    msg               varchar(10000),
    create_time       datetime default null,
    primary key (`information_id`),
    constraint `tb_employment_information_tb_class_grade` foreign key (`class_id`) references `tb_class_grade` (`class_id`),
    constraint `tb_employment_information_tb_area` foreign key (`area_id`) references `tb_area` (`area_id`),
    constraint `tb_employment_information_tb_unit_kind` foreign key (`unit_id`) references `tb_unit_kind` (`unit_id`),
    constraint `tb_employment_information_tb_employment_way` foreign key (`employment_way_id`) references `tb_employment_way` (`employment_way_id`),
    constraint `tb_employment_information_tb_college` foreign key (`college_id`) references `tb_college` (`college_id`)
) engine = innoDB
  auto_increment = 1
  default charset = utf8;

create table tb_organization_num
(
    num_id     int(10) auto_increment,
    sum        int(10) not null,
    class_id   int(10),
    college_id int(10),
    primary key (`num_id`),
    constraint `tb_organization_num_tb_class_grade` foreign key (`class_id`) references `tb_class_grade` (`class_id`),
    constraint `tb_organization_num_tb_college` foreign key (`college_id`) references `tb_college` (`college_id`)
) engine = innoDB
  auto_increment = 1
  default charset = utf8