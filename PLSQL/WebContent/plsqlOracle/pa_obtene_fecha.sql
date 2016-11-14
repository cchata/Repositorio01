CREATE OR REPLACE PROCEDURE OBTENER_FECHA(P_TEXTO OUT VARCHAR2)

IS

BEGIN

  P_TEXTO := 'La fecha actual es ' || TO_CHAR(SYSDATE,'DD/MM/YYYY');

END;

-------EXE--------------
DECLARE
  V_FECHA    VARCHAR2(200);
BEGIN
  -- Pasamos la variable V_FECHA a la función HR.OBTENER_FECHA.

  -- V_FECHA estará referenciada al parámetro P_TEXTO, cualquier cambio

  -- en P_TEXTO se verá reflejado en V_FECHA posteriormente.

  OBTENER_FECHA(V_FECHA);
  DBMS_OUTPUT.PUT_LINE('Valor de V_FECHA: ' || V_FECHA);
END;
----------------------