insert into student(STUDENTID,firstName,lastName) values(11,'Jack','Peterson');
insert into student(STUDENTID,firstName,lastName) values(12,'Peter','Hamilton');

insert into subject(subjectId,name) values(1,'Mathematics');
insert into subject(subjectId,name) values(2,'Computer');

insert into student_subject(STUDENT_ID,SUBJECT_ID) values(11,1);
insert into student_subject(STUDENT_ID,SUBJECT_ID) values(11,2);
insert into student_subject(STUDENT_ID,SUBJECT_ID) values(12,1);
insert into student_subject(STUDENT_ID,SUBJECT_ID) values(12,2);
