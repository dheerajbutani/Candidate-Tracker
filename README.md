# Candidate-Tracker


create table login (id number(10,0) not null,email varchar2(255 char),password varchar2(255 char), role varchar2(255 char), account_status varchar2(255 char), creation_date date,last_ip_address varchar2(255 char) , last_login varchar2(255 char), primary key (id))


create sequence loginseq start from 1 increment by 1;


//create table UserProfile(id ,
//			firstName varchar2(255),
//			lastName varchar2(255),
//			mobile number,
//			address varchar2(255),
//			add constraint foriegn key(id) constraint userprofilefk references login(id));

create table user_manager(parentId,
			childId,
			add constraint foriegn key(parentId) constraint userprofilefk1 references login(id),
                        add constraint foriegn key(parentId) constraint userprofilefk2 references login(id))
