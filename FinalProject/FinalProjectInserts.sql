INSERT INTO `cycles` (`id`,`date_end`,`date_init`,`status`,`year`) VALUES (1,'2022-07-17','2021-08-15','CLOSE','21-22');
INSERT INTO `cycles` (`id`,`date_end`,`date_init`,`status`,`year`) VALUES (2,'2023-07-17','2022-08-15','CLOSE','22-23');
INSERT INTO `cycles` (`id`,`date_end`,`date_init`,`status`,`year`) VALUES (3,'2024-07-17','2023-08-15','ACTUAL','23-24');
INSERT INTO `cycles` (`id`,`date_end`,`date_init`,`status`,`year`) VALUES (4,'2025-07-17','2024-08-15','NEXT','24-25');

INSERT INTO `cat_campus_grades` (`id`,`grade_name`,`short_name`) VALUES (1,'Pre 1','1º');
INSERT INTO `cat_campus_grades` (`id`,`grade_name`,`short_name`) VALUES (2,'Pre 2','2º');
INSERT INTO `cat_campus_grades` (`id`,`grade_name`,`short_name`) VALUES (3,'Pre 3','3º');
INSERT INTO `cat_campus_grades` (`id`,`grade_name`,`short_name`) VALUES (4,'Primero','1º');
INSERT INTO `cat_campus_grades` (`id`,`grade_name`,`short_name`) VALUES (5,'Segundo','2º');
INSERT INTO `cat_campus_grades` (`id`,`grade_name`,`short_name`) VALUES (6,'Tercero','3º');
INSERT INTO `cat_campus_grades` (`id`,`grade_name`,`short_name`) VALUES (7,'Cuarto','4º');
INSERT INTO `cat_campus_grades` (`id`,`grade_name`,`short_name`) VALUES (8,'Quinto','5º');
INSERT INTO `cat_campus_grades` (`id`,`grade_name`,`short_name`) VALUES (9,'Sexto','6º');
INSERT INTO `cat_campus_grades` (`id`,`grade_name`,`short_name`) VALUES (10,'Semestre 1','S1');
INSERT INTO `cat_campus_grades` (`id`,`grade_name`,`short_name`) VALUES (11,'Semestre 2','S2');
INSERT INTO `cat_campus_grades` (`id`,`grade_name`,`short_name`) VALUES (12,'Semestre 3','S3');
INSERT INTO `cat_campus_grades` (`id`,`grade_name`,`short_name`) VALUES (13,'Semestre 4 A','S4A');
INSERT INTO `cat_campus_grades` (`id`,`grade_name`,`short_name`) VALUES (14,'Semestre 4 B','S4B');
INSERT INTO `cat_campus_grades` (`id`,`grade_name`,`short_name`) VALUES (15,'Semestre 5 A','S5A');
INSERT INTO `cat_campus_grades` (`id`,`grade_name`,`short_name`) VALUES (16,'Semestre 5 B','S5B');
INSERT INTO `cat_campus_grades` (`id`,`grade_name`,`short_name`) VALUES (17,'Semestre 6 A','S6A');
INSERT INTO `cat_campus_grades` (`id`,`grade_name`,`short_name`) VALUES (18,'Semestre 6 B','S6B');

INSERT INTO `cat_campus_levels` (`id`,`level_name`) VALUES (1,'Preescolar');
INSERT INTO `cat_campus_levels` (`id`,`level_name`) VALUES (2,'Primaria');
INSERT INTO `cat_campus_levels` (`id`,`level_name`) VALUES (3,'Secundaria');
INSERT INTO `cat_campus_levels` (`id`,`level_name`) VALUES (4,'Preparatoria');

INSERT INTO `cat_people_type` (`id`,`description`) VALUES (1,'Administrador');
INSERT INTO `cat_people_type` (`id`,`description`) VALUES (2,'Directivo');
INSERT INTO `cat_people_type` (`id`,`description`) VALUES (3,'Ejecutivo');
INSERT INTO `cat_people_type` (`id`,`description`) VALUES (4,'Vendedor');
INSERT INTO `cat_people_type` (`id`,`description`) VALUES (5,'Docente');

INSERT INTO `campus` (`id`,`campus_key`,`name`,`register_date`,`cycle_id`) VALUES (1,'SAT001','Campus Satelite','2020-08-01',3);
INSERT INTO `campus` (`id`,`campus_key`,`name`,`register_date`,`cycle_id`) VALUES (2,'CEN001','Campus Centro','2020-06-01',3);

INSERT INTO `people` (`id`,`active`,`first_name`,`last_name`,`campus_id`,`people_type_id`) VALUES (1,1,'Héctor','Flores',1,1);
INSERT INTO `people` (`id`,`active`,`first_name`,`last_name`,`campus_id`,`people_type_id`) VALUES (2,1,'Alama Delia','Garcia',1,2);
INSERT INTO `people` (`id`,`active`,`first_name`,`last_name`,`campus_id`,`people_type_id`) VALUES (3,1,'Leonel','Vicario',2,1);

INSERT INTO `students` (`id`,`active`,`first_name`,`group_char`,`last_name`,`campus_id`,`grade_id`,`level_id`) VALUES (1,1,'Juana','A','De Arco',1,4,2);
INSERT INTO `students` (`id`,`active`,`first_name`,`group_char`,`last_name`,`campus_id`,`grade_id`,`level_id`) VALUES (2,1,'Guillermo','A','Prieto',1,4,2);
INSERT INTO `students` (`id`,`active`,`first_name`,`group_char`,`last_name`,`campus_id`,`grade_id`,`level_id`) VALUES (3,1,'Gabriel','A','Mancera',1,4,2);
INSERT INTO `students` (`id`,`active`,`first_name`,`group_char`,`last_name`,`campus_id`,`grade_id`,`level_id`) VALUES (4,1,'Gabriela','B','Parra',1,4,2);
INSERT INTO `students` (`id`,`active`,`first_name`,`group_char`,`last_name`,`campus_id`,`grade_id`,`level_id`) VALUES (5,1,'Josue','B','Pérez',1,4,2);
INSERT INTO `students` (`id`,`active`,`first_name`,`group_char`,`last_name`,`campus_id`,`grade_id`,`level_id`) VALUES (6,1,'Josefa','B','Ortiz',1,4,2);
INSERT INTO `students` (`id`,`active`,`first_name`,`group_char`,`last_name`,`campus_id`,`grade_id`,`level_id`) VALUES (7,1,'Ana','A','Guevara',2,4,3);
INSERT INTO `students` (`id`,`active`,`first_name`,`group_char`,`last_name`,`campus_id`,`grade_id`,`level_id`) VALUES (8,1,'Lorena','A','Asunza',2,4,3);
INSERT INTO `students` (`id`,`active`,`first_name`,`group_char`,`last_name`,`campus_id`,`grade_id`,`level_id`) VALUES (9,1,'Sara','A','Cuevas',2,4,3);
INSERT INTO `students` (`id`,`active`,`first_name`,`group_char`,`last_name`,`campus_id`,`grade_id`,`level_id`) VALUES (10,1,'Edgar','B','Gallardo',2,4,3);
INSERT INTO `students` (`id`,`active`,`first_name`,`group_char`,`last_name`,`campus_id`,`grade_id`,`level_id`) VALUES (11,1,'Pedro','B','Paramo',2,4,3);
INSERT INTO `students` (`id`,`active`,`first_name`,`group_char`,`last_name`,`campus_id`,`grade_id`,`level_id`) VALUES (12,1,'Ermilo','B','Arbreu',2,4,3);