CREATE OR REPLACE PROCEDURE PA_INSERT_LOGINUSUARIO_PK(P_LOGINUSUARIO IN NVARCHAR2,P_CLAVE IN VARCHAR2,P_MSG_ERROR OUT VARCHAR2) IS

BEGIN

   INSERT INTO usuario(loginusuario_pk, clave)
   VALUES(P_LOGINUSUARIO,P_CLAVE);
   COMMIT;
   
     
    exception 
    when no_data_found then
    dbms_output.put_line('no_data_found');

    when zero_divide then
    dbms_output.put_line('zero_divide');

    when others then
    DBMS_OUTPUT.PUT_LINE('Error: '||SQLCODE||' = '||SQLERRM);
    P_MSG_ERROR:='Error: '||SQLCODE||' = '||SQLERRM;

END;

-------EXE--------------




DECLARE
  P_LOGINUSUARIO    NVARCHAR2(15):='JQUISPE';
  P_CLAVE           VARCHAR2(15):='ROOT';
  P_MSG_ERROR VARCHAR2(500);

BEGIN 

  PA_INSERT_LOGINUSUARIO_PK(P_LOGINUSUARIO,P_CLAVE,P_MSG_ERROR);
   DBMS_OUTPUT.PUT_LINE('P_MSG_ERROR= '||P_MSG_ERROR); 

END;


 
----------------------