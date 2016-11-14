select * from docDocumento;



SELECT SUBSTR('ALU0000001',1,3) FROM DUAL; 


SELECT TO_NUMBER('0000001','9999999') FROM DUAL;

SELECT TO_NUMBER(SUBSTR('ALU0000001',4,7),'9999999')+1  FROM DUAL;

SELECT TO_CHAR(1,VARCHAR2(1)) FROM DUAL;

SELECT CONCAT('000000',TO_CHAR(1)) FROM DUAL;


select NOMBDOCUM from docDocumento;
select MAX(NOMBDOCUM) from docDocumento;


SELECT ROWID, A.* FROM alumno A;

SELECT ROWID, A.* FROM usuario A;

SELECT MAX(CODIGOALUMNO_PK) FROM alumno; 

SELECT MIN(CODIGOALUMNO_PK) FROM alumno;
------------------------



DECLARE
  e_sinreg EXCEPTION;
  a number(10) := 25;
  b number(10) := 0;
  c number(10);
BEGIN
  Select count(*) INTO a FROM Articulos;
  If a < 10 THEN
    RAISE e_sinreg;
  END IF;
  c := a / b;
  DBMS_OUTPUT.PUT_LINE(' Esto nunca llegará a mostrarse. ');
EXCEPTION
  WHEN ZERO_DIVIDE THEN DBMS_OUTPUT.PUT_LINE('No se puede dividir por 0');
  WHEN e_sinreg THEN DBMS_OUTPUT.PUT_LINE('Hay menos de 10 articulos.');
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('Se ha producido otra excepción.');
END;
--------------------------------
SET SERVEROUTPUT ON;
DECLARE
  err_num NUMBER;
  err_msg VARCHAR2(255);
  result NUMBER;
  msg VARCHAR2(255);
BEGIN
  msg := SQLERRM(-1403);
  DBMS_OUTPUT.put_line(MSG);
  SELECT 1/0 INTO result FROM DUAL;
EXCEPTION
  WHEN OTHERS THEN
    err_num := SQLCODE;
    err_msg := SQLERRM;
    DBMS_OUTPUT.put_line('Error:'||TO_CHAR(err_num));
    DBMS_OUTPUT.put_line(err_msg);
END;
--------------------------------