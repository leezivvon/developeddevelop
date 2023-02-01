
SELECT * FROM MEMBER m ;

SELECT DISTINCT e.mgr code, m.ename val
FROM emp100 e, emp100 m
WHERE e.mgr = m.EMPNO
ORDER BY code;

SELECT deptno code, dname val
FROM dept100
ORDER BY code;

SELECT * FROM emp100;
SELECT * FROM dept100;

