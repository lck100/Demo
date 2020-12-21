create table tab_category
(
   cid                  int not null auto_increment,
   cname                varchar(100) not null,
   primary key (cid),
   unique key AK_nq_categoryname (cname)
);
insert  into `tab_category`(`cid`,`cname`) values (8,'全球自由行'),(5,'国内游'),(4,'处境游'),(7,'抱团定制'),(6,'港澳游'),(2,'酒店'),(1,'门票'),(3,'香港车票');