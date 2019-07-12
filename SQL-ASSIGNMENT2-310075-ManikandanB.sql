

SELECT subjectid,SUBTITLE,DURATIONINHOURS
FROM fse.subject
INNER JOIN fse.book
ON fse.subject.REFERENCE = fse.book.title;


select * from fse.subject 
where PUBLISHDATE between '2012-01-01' and '2015-12-12' 
order by PUBLISHDATE desc;

select * from fse.book where title =(select REFERENCE from fse.subject where SUBTITLE like 'J%') ;


select * from fse.subject;

select * from fse.book;


update fse.subject set DURATIONINHOURS=150 where SUBJECTID=2;