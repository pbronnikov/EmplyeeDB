use EmployerDB_Test;

INSERT INTO `employee`
(`firstName`,
`middleName`,
`lastName`,
`skype`,
`tel`,
`email`,
`lastUpdateDate`,
`isArchieved`)
VALUES
(
'John',
'V',
'Smith',
'John.Smith',
'+12345678',
'johnSmith@bostontechnologies.com',
NOW(),
0
);

INSERT INTO `dayoff`
(`employee_id`,
`from`,
`to`,
`Description`,
`DayOffType`)
VALUES
(
1,
'2013-01-01',
'2013-01-21',
'RegularVacation',
1
);

INSERT INTO `dayoff`
(`employee_id`,
`from`,
`to`,
`Description`,
`DayOffType`)
VALUES
(
1,
'2013-04-01',
'2013-04-02',
'exceptional',
2
);

INSERT INTO `projecthistory`
(
`employee_id`,
`from`,
`to`,
`projectName`,
`role`)
VALUES
(
1,
'2013-02-15',
NULL,
'Tiger',
1
);


INSERT INTO `employee`
(`firstName`,
`middleName`,
`lastName`,
`skype`,
`tel`,
`email`,
`lastUpdateDate`,
`isArchieved`)
VALUES
(
'Jenny',
'V',
'Smith',
'Jenny.Smith',
'n/a',
'jennySmith@bostontechnologies.com',
NOW(),
0
);

